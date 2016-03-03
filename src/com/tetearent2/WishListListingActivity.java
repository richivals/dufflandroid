package com.tetearent2;

import org.json.JSONArray;
import org.json.JSONException;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;

import com.adodis.httputil.HttpUtils;
import com.tetearent.adapter.ProductListAdapter;
import com.tetearent.util.APIConstants;
import com.tetearent.util.Util;

public class WishListListingActivity extends FragmentActivity {
	
	@Override
	protected void onCreate(@Nullable Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.activity_listing);
		
		new GetProducts().execute();
	}

	private void setupRecyclerView(JSONArray array) {
		GridView gridView = (GridView)findViewById(R.id.gridview);
		gridView.setAdapter(new ProductListAdapter(
				WishListListingActivity.this, array));
		
		gridView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(WishListListingActivity.this, ProductDetailActivity.class);
				Bundle bund = new Bundle();
				bund.putString("pid", ((ImageView)view.findViewById(R.id.favorite)).getTag().toString());
				intent.putExtras(bund);
				startActivity(intent);
			}
		});
	}
	
	class GetProducts extends AsyncTask<String, Void, String> {
		
		ProgressDialog pd;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pd = new ProgressDialog(WishListListingActivity.this);
			pd.setMessage("Getting products");
			pd.setCancelable(false);
			pd.show();
		}
		
		@Override
		protected String doInBackground(String... params) {
			
			String result = "";
			try {
				String url = APIConstants.GET_WISHLIST_API;
				result = HttpUtils.doGet(url);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
		
		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			Log.e("TAG", "res-"+result);
			try {
				JSONArray array = new JSONArray(result);
				setupRecyclerView(array);
			} catch (JSONException e) {
				// TODO: handle exception
				Util.toaster(WishListListingActivity.this, "No data found. Please try again later");
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				if (pd != null)
					pd.dismiss();
			}
		}
	}
}