package com.tetearent.adapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.tetearent2.R;

public class ViewPagerAdapter extends PagerAdapter {

	// Declare Variables
	Context context;
	JSONArray ViewpagerImages;
	LayoutInflater inflater;

	public ViewPagerAdapter(Context context, JSONArray ViewpagerImages) {
		this.context = context;
		this.ViewpagerImages = ViewpagerImages;
	}

	@Override
	public int getCount() {
		return ViewpagerImages.length();
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view == ((RelativeLayout) object);
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		ImageView view_img;

		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View itemView = inflater.inflate(R.layout.viewpage_item, container,
				false);

		// Locate the ImageView in viewpager_item.xml
		view_img = (ImageView) itemView.findViewById(R.id.View_Images);
		// Capture position and set to the ImageView
		try {
			JSONObject jb = ViewpagerImages.getJSONObject(position);
			String url = jb.optString("image");
			setImage(view_img, url);
		} catch (JSONException e) {
			// TODO: handle exception
		} catch (Exception e) {
			// TODO: handle exception
		}
		// Add viewpager_item.xml to ViewPager
		((ViewPager) container).addView(itemView);

		return itemView;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		// Remove viewpager_item.xml from ViewPager
		((ViewPager) container).removeView((RelativeLayout) object);
	}
	
	private void setImage(ImageView profilepic, String uri) {

		ImageLoader imageloader = ImageLoader.getInstance();
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
				context).build();
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
