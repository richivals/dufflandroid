package com.tetearent.fragment;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;

import com.lsjwzh.widget.materialloadingprogressbar.CircleProgressBar;
import com.tetearent.adapter.ProductListAdapter;
import com.tetearent.util.APIConstants;
import com.tetearent.util.HttpRequest;
import com.tetearent.util.SessionManager;
import com.tetearent2.ProductDetailActivity;
import com.tetearent2.R;
import com.teterent.interphase.OnResponseListener;

public class WishListFragment extends Fragment {
	
	View view;
	FragmentActivity activity;
	
	CircleProgressBar pb;

	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.fragment_explore, container, false);
		
		activity = getActivity();
		
		pb = ((CircleProgressBar)view.findViewById(R.id.progress));

		HttpRequest httpRequest = new HttpRequest();
		SessionManager sessionManager = new SessionManager(activity);
		HashMap<String, String> pairs =  new HashMap<String, String>();
		pairs.put("task", "getWishlistProducts");
		pairs.put("custId", sessionManager.getUserId());
		httpRequest.setOnResponseListener(new OnResponseListener() {
			@Override
			public void onResponse(String result) {
				// TODO Auto-generated method stub
				if (result.length() > 0) {
					try {
						setupRecyclerView(new JSONArray(result));
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
}
