package com.tetearent.fragment;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.MediaStore.Images;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.camera.CropImageIntentBuilder;
import com.lsjwzh.widget.materialloadingprogressbar.CircleProgressBar;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.tetearent.adapter.ProductListAdapter;
import com.tetearent.util.APIConstants;
import com.tetearent.util.HttpRequest;
import com.tetearent.util.NetworkConnection;
import com.tetearent.util.SessionManager;
import com.tetearent.util.Util;
import com.tetearent2.AddProductActivity;
import com.tetearent2.ProductDetailActivity;
import com.tetearent2.R;
import com.teterent.interphase.OnConnectedListener;
import com.teterent.interphase.OnResponseListener;

@SuppressWarnings("deprecation")
public class MyProfileFragment extends Fragment {

	View view;
	FragmentActivity activity;
	
	CircleProgressBar pb;
	
	int selection = 0;
	final int PROFILE_PHOTO_CAMERA = 100;
	final int PROFILE_PHOTO_GALLERY = 200;
	final int PIC_CROP = 251;
	
	Uri outputFileUri;
	
	HttpEntity resEntity;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.fragment_profile, container, false);
		
		activity = getActivity();
		
		pb = ((CircleProgressBar)view.findViewById(R.id.progress));
        
        setUpListener();
        
        HttpRequest httpRequest = new HttpRequest();
		SessionManager sessionManager = new SessionManager(activity);
		HashMap<String, String> pairs =  new HashMap<String, String>();
		pairs.put("task", "get_profile");
		pairs.put("custid", sessionManager.getUserId());
		pairs.put("custid", "2");
		httpRequest.setOnResponseListener(new OnResponseListener() {
			@Override
			public void onResponse(String result) {
				// TODO Auto-generated method stub
				if (result.length() > 0) {
					try {
						setUpDetails(new JSONObject(result));
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		httpRequest.httpPost(activity, pairs, APIConstants.ONLY_API, pb, true);
		
		return view;
	}
	
	private void loadPhoto() {

		String[] addPhoto = new String[] { "Camera", "Gallery" };
		AlertDialog.Builder dialog = new AlertDialog.Builder(activity);
		dialog.setTitle("Change Profile Photo");

		dialog.setItems(addPhoto, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int id) {

				if (id == 0) {
					/*if (Build.VERSION.SDK_INT >= 21) {
						final File root = new File(Environment
								.getExternalStorageDirectory()
								+ File.separator
								+ "Rideler" + File.separator);
						root.mkdirs();
						final String fname = getUniqueImageFilename();
						final File sdImageMainDirectory = new File(root, fname);
						outputFileUri = Uri.fromFile(sdImageMainDirectory);

						Intent pictureActionIntent = new Intent(
								android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
						pictureActionIntent.putExtra(MediaStore.EXTRA_OUTPUT,
								outputFileUri);
						startActivityForResult(pictureActionIntent,
								PROFILE_PHOTO_CAMERA);
					} else {*/
						Intent pictureActionIntent = new Intent(
								android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
						startActivityForResult(pictureActionIntent,
								PROFILE_PHOTO_CAMERA);
//					}

				} else if (id == 1) {

					getPhotoFromGallery();
				}
			}
		});

		dialog.setNeutralButton("Cancel",
				new android.content.DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();
					}
				});
		dialog.show();
	}

	@SuppressLint("InlinedApi")
	private void getPhotoFromGallery() {

		Intent photoPickerIntent = new Intent(Intent.ACTION_GET_CONTENT);
		photoPickerIntent.setType("image/*");
		startActivityForResult(photoPickerIntent, PROFILE_PHOTO_GALLERY);
	}

	@SuppressLint("SimpleDateFormat")
	private String getUniqueImageFilename() {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Date now = new Date();
		String fileName = formatter.format(now);
		return fileName;
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);

		if (resultCode == Activity.RESULT_OK) {

			try {
				File croppedImageFile = new File(activity.getFilesDir(),
						"profilepic.jpg");

				switch (requestCode) {
				case PROFILE_PHOTO_CAMERA: {

					Uri selectedImageUri;

					if (Build.VERSION.SDK_INT >= 21) {
						final boolean isCamera;
						if (data == null) {
							isCamera = true;
						} else {
							final String action = data.getAction();
							if (action == null) {
								isCamera = false;
							} else {
								isCamera = action
										.equals(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
							}
						}

						if (isCamera) {
							selectedImageUri = outputFileUri;
						} else {
							selectedImageUri = data == null ? null : data
									.getData();
						}
						if (selectedImageUri == null) {
							
							final ContentResolver cr = activity.getContentResolver();     
							final String[] p1 = new String[] {
							    MediaStore.Images.ImageColumns._ID,
							    MediaStore.Images.ImageColumns.DATE_TAKEN
							}; 
							Cursor c1 = cr.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, p1, null, null, p1[1] + " DESC");      
							if ( c1.moveToFirst() ) {
							    String uristringpic = "content://media/external/images/media/" +c1.getInt(0);
							    
							    selectedImageUri = Uri.parse(uristringpic);
							} 
							c1.close();
							
							/*if (data.getExtras().containsKey("data")) {
								Bitmap bitmapImage = (Bitmap) data.getExtras().get("data");
								String path = Images.Media.insertImage(getContentResolver(), bitmapImage, "ProfilePic", null);
								selectedImageUri = Uri.parse(path);
							} else {
								selectedImageUri = data.getData();
							}*/
						}
					} else {
						selectedImageUri = data.getData();
						if (selectedImageUri == null) {
							Bitmap bitmapImage = (Bitmap) data.getExtras().get("data");
//							ByteArrayOutputStream bytes = new ByteArrayOutputStream();
//							bitmapImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
							String path = Images.Media.insertImage(activity.getContentResolver(), bitmapImage, "ProfilePic", null);
							selectedImageUri = Uri.parse(path);
						}
					}
					CropImageIntentBuilder cropImage = null;
					if (selection == 1) {
						cropImage = new CropImageIntentBuilder(
								300, 300, Uri.fromFile(croppedImageFile));
					} else {
						cropImage = new CropImageIntentBuilder(
								1000, 300, Uri.fromFile(croppedImageFile));
					}
					cropImage.setSourceImage(selectedImageUri);
					startActivityForResult(
							cropImage.getIntent(activity), PIC_CROP);
					
					break;
				}
				case PROFILE_PHOTO_GALLERY: {
					if (data != null) {

						Uri uri = data.getData();

						CropImageIntentBuilder cropImage = null;
						if (selection == 1) {
							cropImage = new CropImageIntentBuilder(
									300, 300, Uri.fromFile(croppedImageFile));
						} else {
							cropImage = new CropImageIntentBuilder(
									1000, 300, Uri.fromFile(croppedImageFile));
						}
						cropImage.setSourceImage(uri);

						startActivityForResult(
								cropImage.getIntent(activity),
								PIC_CROP);
					}
					break;
				}
				case PIC_CROP:
					// /data/data/com.android.camera.example/files/test.jpg
					final String pathName = croppedImageFile.getAbsolutePath();
					Bitmap b = BitmapFactory.decodeFile(pathName);

					if (b != null) {

						if (selection == 1) {
							((ImageView)view.findViewById(R.id.profileImage)).setImageBitmap(b);
						} else if (selection == 2) {
							((ImageView)view.findViewById(R.id.coverPic)).setImageBitmap(b);
						}
						
						NetworkConnection network = new NetworkConnection();
						network.setOnConnectedListener(new OnConnectedListener() {
							@Override
							public void httpConnect() {
								// TODO Auto-generated method stub
								new UploadImage().execute(pathName);
							}
						});
						network.isOnline(activity);
					}
					break;

				default:
					break;
				}
			} catch (Exception e) {
				Util.toaster(activity, "Error in Getting Image");
				e.printStackTrace();
			}
		}
	}
	
	private class UploadImage extends AsyncTask<String, Void, String> {

		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			SessionManager sessionManager = new SessionManager(activity);
			String res = doFileUpload(APIConstants.ONLY_API+ "?task=edit_profile_image&custid="+ sessionManager.getUserId(), params[0]);
			return res;
		}

		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			Util.toaster(activity, result);
		}
	}
	
	private void setUpListener() {
		
		((Button)view.findViewById(R.id.addNew)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(activity, AddProductActivity.class));
			}
		});
		
		((ImageView)view.findViewById(R.id.profileImage)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				selection = 1;
				loadPhoto();
			}
		});
		
		((ImageView)view.findViewById(R.id.coverPic)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				selection = 2;
				loadPhoto();
			}
		});
	}
	
	private void setUpDetails(JSONObject jb) {
		
		try {
			setImage(((ImageView)view.findViewById(R.id.profileImage)), jb.optString("profilimage"));
			setImage(((ImageView)view.findViewById(R.id.coverPic)), jb.optString("coverimage"));
			((TextView)view.findViewById(R.id.itemsCount)).setText(jb.optString("count"));
			((TextView)view.findViewById(R.id.userName)).setText(jb.optString("name"));
			((TextView)view.findViewById(R.id.userLocation)).setText(jb.optString("locality")+" "+jb.optString("state"));
			if (!jb.isNull("closetProduct")) setupRecyclerView(jb.getJSONArray("closetProduct"));
		} catch (JSONException e) {
			// TODO: handle exception
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private void setupRecyclerView(JSONArray array) {
		GridView gridView = (GridView)view.findViewById(R.id.gridview);
		gridView.setAdapter(new ProductListAdapter(
				activity, array));
		
		gridView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(activity, ProductDetailActivity.class);
				Bundle bund = new Bundle();
				bund.putString("pid", ((ImageView)view.findViewById(R.id.favorite)).getTag().toString());
				intent.putExtras(bund);
				startActivity(intent);
			}
		});
	}
	
	private String doFileUpload(String urlString, String photoUri) {

		String response_str = "";
		
		try {
			HttpClient client = new DefaultHttpClient();
			HttpPost post = new HttpPost(urlString);

			MultipartEntity reqEntity = new MultipartEntity();
			if (photoUri != null) {
				File file = new File(photoUri);
				FileBody bin = new FileBody(file);
				if (selection == 1) {
					reqEntity.addPart("logopic", bin);
				} else {
					reqEntity.addPart("bannerpic", bin);
				}
			}
			reqEntity.addPart("user", new StringBody("User"));
			post.setEntity(reqEntity);
			HttpResponse response = client.execute(post);
			resEntity = response.getEntity();
			response_str = EntityUtils.toString(resEntity);
			if (resEntity != null) {
				Log.i("RESPONSE", response_str);
			}
		} catch (Exception ex) {
			Log.e("Debug", "error: " + ex.getMessage(), ex);
		}
		
		return response_str;
	}
	
	private void setImage(ImageView profilepic, String uri) {

		ImageLoader imageloader = ImageLoader.getInstance();
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
				activity).build();
		imageloader.init(config);
		DisplayImageOptions options = new DisplayImageOptions.Builder()
				.showImageOnLoading(R.drawable.splash_logo)
				.showImageForEmptyUri(R.drawable.splash_logo)
				.showImageOnFail(R.drawable.splash_logo).cacheInMemory(true)
				.cacheOnDisk(true).considerExifParams(true)
				.bitmapConfig(Bitmap.Config.RGB_565).build();
		ImageLoader.getInstance().displayImage(uri, profilepic, options);
	}
}
