package com.tetearent2;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.adodis.httputil.HttpUtils;
import com.tetearent.adapter.ViewPagerAdapter;
import com.tetearent.util.APIConstants;
import com.tetearent.util.Util;

public class ProductDetailActivity extends AppCompatActivity {

	String pid;
	
	Toolbar toolbar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_product_detail);
		
		toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle("Product description");

		Bundle incomming = getIntent().getExtras();
		if (incomming != null) {
			if (incomming.containsKey("pid")) {
				pid = incomming.getString("pid");
				new GetProductDetail().execute(incomming.getString("pid"));
			}
		}
		
		((ImageView)findViewById(R.id.addToWishlist)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	class GetProductDetail extends AsyncTask<String, Void, String> {

		ProgressDialog pd;

		// @Override
		protected void onPreExecute() {
			super.onPreExecute();
			pd = new ProgressDialog(ProductDetailActivity.this);
			pd.setMessage("Getting details");
			pd.setCancelable(false);
			pd.show();
		}

		@Override
		protected String doInBackground(String... params) {

			String result = "";
			try {
				String url = APIConstants.GET_PRODUCT_DETAIL_API
						+ "185";
				result = HttpUtils.doGet(url);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			Log.e("TAG", "res-" + result);
			try {
				JSONObject jb = new JSONObject(result);
				setDetail(jb);
			} catch (JSONException e) {
				// TODO: handle exception
				finish();
				Util.toaster(ProductDetailActivity.this,
						"No data found. Please try again later");
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				if (pd != null)
					pd.dismiss();
			}
		}
	}

	private void setDetail(JSONObject jb) {

		try {
			if (jb != null && jb.length() > 0) {
				((TextView) findViewById(R.id.product_name)).setText(jb
						.optString("name"));
				CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);
		        collapsingToolbar.setTitle(jb
						.optString("name"));
				if (!jb.isNull("price")) {
					JSONObject price = jb.getJSONObject("price");
					((TextView) findViewById(R.id.price)).setText(price
							.optString("regular_price"));

				}

				TextView originalPrice = (TextView) findViewById(R.id.originalPrice);
				originalPrice.setPaintFlags(originalPrice.getPaintFlags()
						| Paint.STRIKE_THRU_TEXT_FLAG);
				originalPrice.setText(jb.optString("original_price"));

				((TextView) findViewById(R.id.descriptionText)).setText(jb
						.optString("desc"));

				if (!jb.isNull("image_gallary")) {
					JSONArray images = jb.getJSONArray("image_gallary");
					setProductImage(images);
				}
			}
		} catch (JSONException e) {
			// TODO: handle exception
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void setProductImage(JSONArray images) {

		try {
			if (images != null && images.length() > 0) {
				ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
				PagerAdapter adapter = new ViewPagerAdapter(ProductDetailActivity.this, images);
				viewPager.setAdapter(adapter);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
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
