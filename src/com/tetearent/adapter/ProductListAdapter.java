package com.tetearent.adapter;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.tetearent.model.FavObj;
import com.tetearent.util.APIConstants;
import com.tetearent.util.HttpRequest;
import com.tetearent.util.SessionManager;
import com.tetearent.util.Util;
import com.tetearent2.R;
import com.teterent.interphase.OnResponseListener;

public class ProductListAdapter extends BaseAdapter {

	Activity act;
	JSONArray array;
	
	private static LayoutInflater inflater = null;

	public ProductListAdapter(Activity act, JSONArray array) {
		// TODO Auto-generated constructor stu
		this.act = act;
		this.array = array;
		inflater = (LayoutInflater) act.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		return array.length();
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@SuppressLint("InflateParams") @Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder  = null;
		try {
			JSONObject jbjb = array.getJSONObject(position);
			
			String productName = jbjb.optString("name");
			String productPrice = "";
			if (!jbjb.isNull("price")) {
				JSONObject price = jbjb.getJSONObject("price");
				productPrice = price.optString("regular_price");
			}
			
			String imagePath = "";
			
			if (!jbjb.isNull("image_gallary")) {
				JSONArray image_gallary = jbjb.getJSONArray("image_gallary");
				if (image_gallary.length() > 0) {
					JSONObject image = image_gallary.getJSONObject(0);
					imagePath = image.optString("image");
				}
			}
			
			String productId = jbjb.optString("pid");
			
			if (convertView == null) {
				convertView = inflater.inflate(R.layout.product_grid_item, null);
				viewHolder = new ViewHolder();
				
				viewHolder.txtProductName = (TextView)convertView.findViewById(R.id.prodName);
				viewHolder.txtPrice = (TextView)convertView.findViewById(R.id.prodPrice);
				viewHolder.imgProduct = (ImageView)convertView.findViewById(R.id.prodImage);
				viewHolder.imgFavorite = (ImageView)convertView.findViewById(R.id.favorite);
				
				convertView.setTag(viewHolder);
			} else {
				viewHolder = (ViewHolder) convertView.getTag();
			}

			viewHolder.txtProductName.setText(productName);
			viewHolder.txtPrice.setText("Price: "+productPrice);
			FavObj favObj = new FavObj();
			favObj.setFav(true);
			favObj.setpId(productId);
			viewHolder.imgFavorite.setTag(favObj);

			if (imagePath.length() > 0)
				setImage(viewHolder.imgProduct, imagePath);
			
			viewHolder.imgFavorite.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					FavObj favObj = (FavObj) v.getTag();
					((ImageView)v).setImageResource(R.drawable.fav_select);
					HttpRequest httpRequest = new HttpRequest();
					SessionManager sessionManager = new SessionManager(act);
					HashMap<String, String> pairs =  new HashMap<String, String>();
					if (favObj.isFav()) {
						pairs.put("task", "removeWishlistProduct");
					} else {
						pairs.put("task", "addWishlistProduct");
					}
					
					pairs.put("custId", sessionManager.getUserId());
					pairs.put("productId", favObj.getpId());
					Log.e("TAG", "tag--"+pairs.toString());
					httpRequest.setOnResponseListener(new OnResponseListener() {
						@Override
						public void onResponse(String result) {
							// TODO Auto-generated method stub
							Util.toaster(act, result);
							Log.e("TAG", "tag--"+result);
						}
					});
					httpRequest.httpPost(act, pairs, APIConstants.ONLY_API, null, false);
				}
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return convertView;
	}
	
	static class ViewHolder {

		TextView txtProductName;
		TextView txtPrice;
		ImageView imgProduct;
		ImageView imgFavorite;
	}
	
	private void setImage(ImageView profilepic, String uri) {

		ImageLoader imageloader = ImageLoader.getInstance();
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
				act).build();
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