package com.tetearent2;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
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

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ParseException;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.adodis.httputil.HttpUtils;
import com.android.camera.CropImageIntentBuilder;
import com.tetearent.util.APIConstants;
import com.tetearent.util.StaticVal;
import com.tetearent.util.Util;

@SuppressWarnings("deprecation")
public class AddProductActivity extends AppCompatActivity {

	final int PROFILE_PHOTO_CAMERA = 100;
	final int PROFILE_PHOTO_GALLERY = 200;
	final int PIC_CROP = 251;

	Uri outputFileUri;

	int photoSelection = -1;

	String[] photoUri = new String[4];

	HttpEntity resEntity;

	Toolbar toolbar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_add_product);
		
		toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		StaticVal.init();
		setAdapters();
		setListener();
	}

	private void setListener() {

		((RelativeLayout) findViewById(R.id.relativeColor))
				.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						((Spinner) findViewById(R.id.spinColor)).performClick();
					}
				});

		((RelativeLayout) findViewById(R.id.relativeItemType))
				.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						((Spinner) findViewById(R.id.spinItemType))
								.performClick();
					}
				});

		((RelativeLayout) findViewById(R.id.relativeStyle))
				.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						((Spinner) findViewById(R.id.spinStyle)).performClick();
					}
				});

		((ImageButton) findViewById(R.id.add1))
				.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						photoSelection = 0;
						if (photoUri[photoSelection] != null) {
							Bitmap b = BitmapFactory
									.decodeFile(photoUri[photoSelection]);
							((ImageView) findViewById(R.id.pickedImage))
									.setImageBitmap(b);
						} else {
							loadPhoto();
						}
					}
				});

		((ImageButton) findViewById(R.id.add2))
				.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						photoSelection = 1;
						if (photoUri[photoSelection] != null) {
							Bitmap b = BitmapFactory
									.decodeFile(photoUri[photoSelection]);
							((ImageView) findViewById(R.id.pickedImage))
									.setImageBitmap(b);
						} else {
							loadPhoto();
						}
					}
				});

		((ImageButton) findViewById(R.id.add3))
				.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						photoSelection = 2;
						if (photoUri[photoSelection] != null) {
							Bitmap b = BitmapFactory
									.decodeFile(photoUri[photoSelection]);
							((ImageView) findViewById(R.id.pickedImage))
									.setImageBitmap(b);
						} else {
							loadPhoto();
						}
					}
				});

		((ImageButton) findViewById(R.id.add4))
				.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						photoSelection = 3;
						if (photoUri[photoSelection] != null) {
							Bitmap b = BitmapFactory
									.decodeFile(photoUri[photoSelection]);
							((ImageView) findViewById(R.id.pickedImage))
									.setImageBitmap(b);
						} else {
							loadPhoto();
						}
					}
				});

		((Button) findViewById(R.id.submit))
				.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						formSubmit();
					}
				});

		((Spinner) findViewById(R.id.spinColor))
				.setOnItemSelectedListener(new OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> parent,
							View view, int position, long id) {
						// TODO Auto-generated method stub
						((TextView) findViewById(R.id.txtColor)).setText(parent
								.getItemAtPosition(position).toString().trim());
					}

					@Override
					public void onNothingSelected(AdapterView<?> parent) {
					}
				});

		((Spinner) findViewById(R.id.spinItemType))
				.setOnItemSelectedListener(new OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> parent,
							View view, int position, long id) {
						// TODO Auto-generated method stub
						((TextView) findViewById(R.id.txtItemType))
								.setText(parent.getItemAtPosition(position)
										.toString().trim());
						int selectedItemId = ((RadioGroup) findViewById(R.id.radioCategory))
								.getCheckedRadioButtonId();
						int selectedStyleId = ((RadioGroup) findViewById(R.id.radioGender))
								.getCheckedRadioButtonId();
						if (selectedStyleId == R.id.buttMale) {
							if (selectedItemId == R.id.buttApparel) {
								setStyleSpinner(StaticVal.APPAREL_MEN_STYLE_LIST
										.get(position));
							} else if (selectedItemId == R.id.buttFootwear) {
								setStyleSpinner(StaticVal.FOOTWEAR_MEN_STYLE_LIST
										.get(position));
							} else if (selectedItemId == R.id.buttWedding) {
								setStyleSpinner(StaticVal.WEDDING_MEN_STYLE_LIST
										.get(position));
							}
						} else if (selectedStyleId == R.id.buttFMale) {
							if (selectedItemId == R.id.buttApparel) {
								setStyleSpinner(StaticVal.APPAREL_WOMEN_STYLE_LIST
										.get(position));
							} else if (selectedItemId == R.id.buttFootwear) {
								setStyleSpinner(StaticVal.FOOTWEAR_WOMEN_STYLE_LIST
										.get(position));
							} else if (selectedItemId == R.id.buttWedding) {
								setStyleSpinner(StaticVal.WEDDING_WOMEN_STYLE_LIST
										.get(position));
							}
						}
					}

					@Override
					public void onNothingSelected(AdapterView<?> parent) {
					}
				});

		((Spinner) findViewById(R.id.spinStyle))
				.setOnItemSelectedListener(new OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> parent,
							View view, int position, long id) {
						// TODO Auto-generated method stub
						((TextView) findViewById(R.id.txtStyle)).setText(parent
								.getItemAtPosition(position).toString().trim());
					}

					@Override
					public void onNothingSelected(AdapterView<?> parent) {
					}
				});

		((RadioGroup) findViewById(R.id.radioGender))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(RadioGroup group, int checkedId) {
						// TODO Auto-generated method stub
						((RadioButton) findViewById(R.id.buttApparel))
								.setChecked(false);
						((RadioButton) findViewById(R.id.buttFootwear))
								.setChecked(false);
						((RadioButton) findViewById(R.id.buttWedding))
								.setChecked(false);
					}
				});

		((RadioGroup) findViewById(R.id.radioSellLend))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(RadioGroup group, int checkedId) {
						// TODO Auto-generated method stub
						if (checkedId == R.id.buttSell) {
							((LinearLayout) findViewById(R.id.sellFrame))
									.setVisibility(View.VISIBLE);
							((LinearLayout) findViewById(R.id.lendFrame))
									.setVisibility(View.GONE);
						} else if (checkedId == R.id.buttLend) {
							((LinearLayout) findViewById(R.id.lendFrame))
									.setVisibility(View.VISIBLE);
							((LinearLayout) findViewById(R.id.sellFrame))
									.setVisibility(View.GONE);
						}
					}
				});

		((RadioGroup) findViewById(R.id.radioCategory))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(RadioGroup group, int checkedId) {
						// TODO Auto-generated method stub
						int selectedStyleId = ((RadioGroup) findViewById(R.id.radioGender))
								.getCheckedRadioButtonId();
						if (selectedStyleId == R.id.buttMale) {
							switch (checkedId) {
							case R.id.buttApparel:
								setItemSpinner(StaticVal.APPAREL_TYPE_MEN);
								break;

							case R.id.buttFootwear:
								setItemSpinner(StaticVal.FOOTWEAR_TYPE);
								break;

							case R.id.buttWedding:
								setItemSpinner(StaticVal.WEDDING_TYPE_MEN);
								break;

							default:
								break;
							}
						} else if (selectedStyleId == R.id.buttFMale) {
							switch (checkedId) {
							case R.id.buttApparel:
								setItemSpinner(StaticVal.APPAREL_WOMEN_TYPE);
								break;

							case R.id.buttFootwear:
								setItemSpinner(StaticVal.FOOTWEAR_WOMEN_TYPE);
								break;

							case R.id.buttWedding:
								setItemSpinner(StaticVal.WEDDING_WOMEN_TYPE);
								break;

							default:
								break;
							}
						}
					}
				});
	}

	private void setAdapters() {

		// COLOR SPINNER
		Spinner colorSpinner = ((Spinner) findViewById(R.id.spinColor));
		colorSpinner
				.setAdapter(new ArrayAdapter<String>(AddProductActivity.this,
						R.layout.spinner_item, StaticVal.COLOR));
	}

	private void setItemSpinner(String[] array) {

		Spinner colorSpinner = ((Spinner) findViewById(R.id.spinItemType));
		colorSpinner.setAdapter(new ArrayAdapter<String>(
				AddProductActivity.this, R.layout.spinner_item, array));
	}

	private void setStyleSpinner(String[] array) {

		Spinner styleSpinner = ((Spinner) findViewById(R.id.spinStyle));
		styleSpinner.setAdapter(new ArrayAdapter<String>(
				AddProductActivity.this, R.layout.spinner_item, array));
	}

	private void formSubmit() {

		if (isValid()) {
			new UploadProduct().execute();
		}
	}

	private boolean isValid() {

		boolean isValid = false;

		isValid = true;

		return isValid;
	}

	private String addProduct() {

		String str = "";

		try {
			HashMap<String, String> pairs = new HashMap<String, String>();

			pairs.put("category0",
					((RadioGroup) findViewById(R.id.radioGender))
							.getCheckedRadioButtonId() == R.id.buttMale ? "185"
							: "186");
			int selectedStyleId = ((RadioGroup) findViewById(R.id.radioGender))
					.getCheckedRadioButtonId();
			if (selectedStyleId == R.id.buttMale) {
				pairs.put(
						"category1",
						StaticVal.ITEM_CATEGORY_MAP_MEN
								.get(((RadioButton) findViewById(((RadioGroup) findViewById(R.id.radioCategory))
										.getCheckedRadioButtonId())).getText()));
			} else if (selectedStyleId == R.id.buttFMale) {
				pairs.put(
						"category1",
						StaticVal.ITEM_CATEGORY_MAP_WOMEN
								.get(((RadioButton) findViewById(((RadioGroup) findViewById(R.id.radioCategory))
										.getCheckedRadioButtonId())).getText()));
			}

			pairs.put("category2", getItemId());
			pairs.put("category3", getStyleId());
			pairs.put("designer", ((EditText) findViewById(R.id.editDesigner))
					.getText().toString());
			pairs.put("color", StaticVal.COLOR_MAP
					.get(((TextView) findViewById(R.id.txtColor)).getText()
							.toString()));
			pairs.put("year", ((EditText) findViewById(R.id.editPurchaseYear))
					.getText().toString());
			int selectedConditionId = ((RadioGroup) findViewById(R.id.radioCondition))
					.getCheckedRadioButtonId();
			if (selectedConditionId == R.id.butGentleUse) {
				pairs.put("condition", "18");
			} else if (selectedConditionId == R.id.buttLikeNew) {
				pairs.put("condition", "19");
			} else if (selectedConditionId == R.id.buttNeverWorn) {
				pairs.put("condition", "113");
			} else if (selectedConditionId == R.id.buttNewRetail) {
				pairs.put("condition", "20");
			}
			pairs.put("is_sign_wear",
					((RadioGroup) findViewById(R.id.radioWearSign))
							.getCheckedRadioButtonId() == R.id.buttYes ? "1"
							: "0");
			pairs.put("name", ((EditText) findViewById(R.id.editTitle))
					.getText().toString());
			pairs.put("product_tags", ((EditText) findViewById(R.id.editTags))
					.getText().toString());
			pairs.put("description",
					((EditText) findViewById(R.id.editDescription)).getText()
							.toString());
			pairs.put(
					"type-of-rent",
					((RadioGroup) findViewById(R.id.radioSellLend))
							.getCheckedRadioButtonId() == R.id.buttSell ? "sell"
							: "lend");
			int selectedSellTypeId = ((RadioGroup) findViewById(R.id.radioSellLend))
					.getCheckedRadioButtonId();
			if (selectedSellTypeId == R.id.buttSell) {
				pairs.put("price",
						((EditText) findViewById(R.id.editSellPrice)).getText()
								.toString());
				pairs.put("original_price",
						((EditText) findViewById(R.id.editOGPrice)).getText()
								.toString());
			} else if (selectedSellTypeId == R.id.buttLend) {
				pairs.put("price",
						((EditText) findViewById(R.id.editPricePerWeek))
								.getText().toString());
				pairs.put("security_deposit_comments",
						((EditText) findViewById(R.id.editSecDepositComment))
								.getText().toString());
				pairs.put("security_deposit",
						((EditText) findViewById(R.id.editSecureAmt)).getText()
								.toString());
			}
			pairs.put("stock", ((EditText) findViewById(R.id.editHowMany))
					.getText().toString());
			pairs.put("weight", ((EditText) findViewById(R.id.editWeight))
					.getText().toString());
			pairs.put("cancellation_returns_terms",
					((EditText) findViewById(R.id.editCancellation)).getText()
							.toString());
			pairs.put("size", "9");

			pairs.put("task", "addProduct");

			Log.e("TAG", "res-" + pairs.toString());

			str = HttpUtils.doPost(pairs, APIConstants.ONLY_API);

		} catch (Exception e) {
			// TODO: handle exception
		}

		return str;
	}

	class UploadProduct extends AsyncTask<String, Void, String> {

		ProgressDialog pd;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pd = new ProgressDialog(AddProductActivity.this);
			pd.setMessage("Uploading product");
			pd.setCancelable(false);
			pd.show();
		}

		@Override
		protected String doInBackground(String... params) {

			String result = "";
			try {
				result = addProduct();
				Log.e("TAG", "res-" + result);
				if (result != null && result.length() > 0) {
					/*result = multipartRequestTest(
							APIConstants.ONLY_API + "?task=add_images&pid="
									+ result.replaceAll("[^0-9]", ""),
							photoUri, "image", result, AddProductActivity.this);*/
					result = doFileUpload(APIConstants.ONLY_API
							+ "?task=add_images&pid="
							+ result.replaceAll("[^0-9]", ""));
				} else {
					result = addProduct();
					Log.e("TAG", "res-" + result);
					if (result != null && result.length() > 0) {
						/*result = multipartRequestTest(
								APIConstants.ONLY_API + "?task=add_images&pid="
										+ result.replaceAll("[^0-9]", ""),
								photoUri, "image", result,
								AddProductActivity.this);*/
						result = doFileUpload(APIConstants.ONLY_API
								+ "?task=add_images&pid="
								+ result.replaceAll("[^0-9]", ""));
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);

			Log.e("TAG", "res-" + result);

			pd.dismiss();
		}
	}

	private String getItemId() {

		String itemId = "";

		int selectedStyleId = ((RadioGroup) findViewById(R.id.radioGender))
				.getCheckedRadioButtonId();
		int selectedItemId = ((RadioGroup) findViewById(R.id.radioCategory))
				.getCheckedRadioButtonId();
		String selectedItemName = ((TextView) findViewById(R.id.txtItemType))
				.getText().toString();

		if (selectedStyleId == R.id.buttMale) {
			switch (selectedItemId) {
			case R.id.buttApparel:
				itemId = StaticVal.APPAREL_TYPE_MEN_MAP.get(selectedItemName);
				break;

			case R.id.buttFootwear:
				itemId = StaticVal.FOOTWEAR_TYPE_MAP.get(selectedItemName);
				break;

			case R.id.buttWedding:
				itemId = StaticVal.WEDDING_TYPE_MEN_MAP.get(selectedItemName);
				break;

			default:
				break;
			}
		} else if (selectedStyleId == R.id.buttFMale) {
			switch (selectedItemId) {
			case R.id.buttApparel:
				itemId = StaticVal.APPAREL_WOMEN_TYPE_MAP.get(selectedItemName);
				break;

			case R.id.buttFootwear:
				itemId = StaticVal.FOOTWEAR_WOMEN_TYPE_MAP
						.get(selectedItemName);
				break;

			case R.id.buttWedding:
				itemId = StaticVal.WEDDING_WOMEN_TYPE_MAP.get(selectedItemName);
				break;

			default:
				break;
			}
		}

		return itemId;
	}

	private String getStyleId() {

		String styleId = "";

		int selectedItemId = ((RadioGroup) findViewById(R.id.radioCategory))
				.getCheckedRadioButtonId();
		int selectedStyleId = ((RadioGroup) findViewById(R.id.radioGender))
				.getCheckedRadioButtonId();
		int selectedPosition = ((Spinner) findViewById(R.id.spinItemType))
				.getSelectedItemPosition();
		String selectedItemName = ((TextView) findViewById(R.id.txtStyle))
				.getText().toString();

		if (selectedStyleId == R.id.buttMale) {
			if (selectedItemId == R.id.buttApparel) {
				styleId = StaticVal.APPAREL_MEN_STYLE_LIST_MAP.get(
						selectedPosition).get(selectedItemName);
			} else if (selectedItemId == R.id.buttFootwear) {
				styleId = StaticVal.FOOTWEAR_MEN_STYLE_LIST_MAP.get(
						selectedPosition).get(selectedItemName);
			} else if (selectedItemId == R.id.buttWedding) {
				styleId = StaticVal.WEDDING_MEN_STYLE_LIST_MAP.get(
						selectedPosition).get(selectedItemName);
			}
		} else if (selectedStyleId == R.id.buttFMale) {
			if (selectedItemId == R.id.buttApparel) {
				styleId = StaticVal.APPAREL_WOMEN_STYLE_LIST_MAP.get(
						selectedPosition).get(selectedItemName);
			} else if (selectedItemId == R.id.buttFootwear) {
				styleId = StaticVal.FOOTWEAR_WOMEN_STYLE_LIST_MAP.get(
						selectedPosition).get(selectedItemName);
			} else if (selectedItemId == R.id.buttWedding) {
				styleId = StaticVal.WEDDING_WOMEN_STYLE_LIST_MAP.get(
						selectedPosition).get(selectedItemName);
			}
		}

		return styleId;
	}

	private void loadPhoto() {

		String[] addPhoto = new String[] { "Camera", "Gallery" };
		AlertDialog.Builder dialog = new AlertDialog.Builder(this);
		dialog.setTitle("Change Profile Photo");

		dialog.setItems(addPhoto, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int id) {

				if (id == 0) {

					final File root = new File(Environment
							.getExternalStorageDirectory()
							+ File.separator
							+ "TeteARent" + File.separator);
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
				} else if (id == 1) {

					getPhotoFromGallery();
				}
			}
		});

		dialog.setNeutralButton("cancel",
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
		try {
			File croppedImageFile = new File(
					AddProductActivity.this.getFilesDir(), "testing.jpg");
			if (resultCode == Activity.RESULT_OK) {

				switch (requestCode) {
				case PROFILE_PHOTO_CAMERA: {

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

					Uri selectedImageUri;
					if (isCamera) {
						selectedImageUri = outputFileUri;
					} else {
						selectedImageUri = data == null ? null : data.getData();
					}

					CropImageIntentBuilder cropImage = new CropImageIntentBuilder(
							1000, 300, Uri.fromFile(croppedImageFile));
					cropImage.setSourceImage(selectedImageUri);
					cropImage.setDoFaceDetection(true);
					startActivityForResult(
							cropImage.getIntent(AddProductActivity.this),
							PIC_CROP);

					break;
				}
				case PROFILE_PHOTO_GALLERY: {
					if (data != null) {

						Uri uri = data.getData();

						CropImageIntentBuilder cropImage = new CropImageIntentBuilder(
								1000, 300, Uri.fromFile(croppedImageFile));
						cropImage.setDoFaceDetection(true);
						cropImage.setSourceImage(uri);

						Intent intent = cropImage
								.getIntent(AddProductActivity.this);

						intent.putExtra("aspectX", 4);
						intent.putExtra("aspectY", 2);

						startActivityForResult(intent, PIC_CROP);
					}
					break;
				}
				case PIC_CROP:
					// /data/data/com.android.camera.example/files/test.jpg
					final String pathName = croppedImageFile.getAbsolutePath();
					Bitmap b = BitmapFactory.decodeFile(pathName);
					if (b != null) {
						((ImageView) findViewById(R.id.pickedImage))
								.setImageBitmap(b);
						photoUri[photoSelection] = pathName;
						if (photoSelection == 0) {
							((ImageButton) findViewById(R.id.add1))
									.setImageBitmap(b);
						} else if (photoSelection == 1) {
							((ImageButton) findViewById(R.id.add2))
									.setImageBitmap(b);
						} else if (photoSelection == 2) {
							((ImageButton) findViewById(R.id.add3))
									.setImageBitmap(b);
						} else if (photoSelection == 3) {
							((ImageButton) findViewById(R.id.add4))
									.setImageBitmap(b);
						}
					} else {
						Util.toaster(AddProductActivity.this,
								"Problem in adding your image. Please try again.");
					}
					break;

				default:
					break;
				}
			}
		} catch (Exception e) {
			Util.toaster(AddProductActivity.this, "Error in Getting Image");
			e.printStackTrace();
		}
	}

	
	@SuppressWarnings("unused")
	private String multipartRequestTest(String urlTo, String[] filepaths,
			String filefield, String id, Context context)
			throws ParseException, IOException {

		HttpURLConnection connection = null;
		DataOutputStream outputStream = null;
		InputStream inputStream = null;

		String twoHyphens = "--";
		String boundary = "*****" + Long.toString(System.currentTimeMillis())
				+ "*****";
		String lineEnd = "\r\n";

		String result = "";

		int bytesRead, bytesAvailable, bufferSize;
		byte[] buffer;
		int maxBufferSize = 1 * 1024 * 1024;

		try {

			URL url = new URL(urlTo);
			connection = (HttpURLConnection) url.openConnection();

			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setUseCaches(false);

			connection.setRequestMethod("POST");
			connection.setRequestProperty("Connection", "Keep-Alive");
			connection.setRequestProperty("User-Agent",
					"Android Multipart HTTP Client 1.0");
			connection.setRequestProperty("Content-Type",
					"multipart/form-data; boundary=" + boundary);

			outputStream = new DataOutputStream(connection.getOutputStream());

			for (byte i = 0; i < filepaths.length; i++) {

				String filepath = filepaths[i];

				String[] q = filepath.split("/");
				int idx = q.length - 1;

				File file = new File(filepath);
				FileInputStream fileInputStream = new FileInputStream(file);

				StringBuilder sbmultiPart = new StringBuilder();
				sbmultiPart.append(twoHyphens).append(boundary).append(lineEnd);

				sbmultiPart.append("Content-Disposition: form-data; name=\"")
						.append(filefield).append("\"; filename=\"")
						.append(q[idx]).append("\"").append(lineEnd);

				sbmultiPart.append("Content-Type: image/jpeg").append(lineEnd);
				sbmultiPart.append("Content-Transfer-Encoding: binary").append(
						lineEnd);
				sbmultiPart.append(lineEnd);

				outputStream.writeBytes(sbmultiPart.toString());

				bytesAvailable = fileInputStream.available();
				bufferSize = Math.min(bytesAvailable, maxBufferSize);
				buffer = new byte[bufferSize];

				bytesRead = fileInputStream.read(buffer, 0, bufferSize);
				while (bytesRead > 0) {
					outputStream.write(buffer, 0, bufferSize);
					bytesAvailable = fileInputStream.available();
					bufferSize = Math.min(bytesAvailable, maxBufferSize);
					bytesRead = fileInputStream.read(buffer, 0, bufferSize);
				}

				outputStream.writeBytes(lineEnd);

				fileInputStream.close();
				// file.delete();
			}

			inputStream = connection.getInputStream();
			result = convertStreamToString(inputStream);
			Log.e("MultipartRequest", "Multipart--" + result);

			inputStream.close();
			outputStream.flush();
			outputStream.close();

			return result;
		} catch (Exception e) {
			Log.e("MultipartRequest", "Multipart Form Upload Error");
			e.printStackTrace();
			return "error";
		}
	}

	private String doFileUpload(String urlString) {

		String response_str = "";
		
		try {
			HttpClient client = new DefaultHttpClient();
			HttpPost post = new HttpPost(urlString);

			MultipartEntity reqEntity = new MultipartEntity();
			int i = 1;
			for (String uri : photoUri) {
				if (uri != null) {
					File file = new File(uri);
					FileBody bin = new FileBody(file);
					reqEntity.addPart("uploadedfile"+i, bin);
					i++;
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

	private static String convertStreamToString(InputStream is) {

		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();

		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case android.R.id.home:
			onBackPressed();
			break;

		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}