package com.tetearent2;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.lsjwzh.widget.materialloadingprogressbar.CircleProgressBar;
import com.tetearent.util.APIConstants;
import com.tetearent.util.HttpRequest;
import com.tetearent.util.SessionManager;
import com.teterent.interphase.OnResponseListener;

public class ProfileActivity extends AppCompatActivity {
	
	Toolbar toolbar;
	
	CircleProgressBar pb;
	
	@Override
	protected void onCreate(@Nullable Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.activity_profile);

		toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        pb = ((CircleProgressBar)findViewById(R.id.progress));
        
        setUpListener();
        
        HttpRequest httpRequest = new HttpRequest();
		SessionManager sessionManager = new SessionManager(ProfileActivity.this);
		HashMap<String, String> pairs =  new HashMap<String, String>();
		pairs.put("task", "get_profile");
		pairs.put("customer_id", sessionManager.getUserId());
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
		httpRequest.httpPost(ProfileActivity.this, pairs, APIConstants.ONLY_API, pb, true);
	}
	
	private void setUpListener() {
		
		((Button)findViewById(R.id.addNew)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(ProfileActivity.this, AddProductActivity.class));
			}
		});
	}
	
	private void setUpDetails(JSONObject jb) {
		
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
