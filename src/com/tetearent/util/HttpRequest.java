package com.tetearent.util;

import java.util.HashMap;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;

import com.adodis.httputil.HttpUtils;
import com.lsjwzh.widget.materialloadingprogressbar.CircleProgressBar;
import com.teterent.interphase.OnConnectedListener;
import com.teterent.interphase.OnResponseListener;

public class HttpRequest {
	
	private final int RETRY_COUNT = 2;
	int intial = 0;
	
	OnResponseListener onResponseListener;

	public synchronized void httpPost(final Activity act, final HashMap<String, String> pairs, final String url, final CircleProgressBar pb, final boolean showDialog) {
		
		NetworkConnection network = new NetworkConnection();
		network.setOnConnectedListener(new OnConnectedListener() {
			@Override
			public void httpConnect() {
				new GetData(act, pairs, url, pb, showDialog).execute();
			}
		});
		network.isOnline(act);
	}
	
	class GetData extends AsyncTask<String, Void, String> {
		
		Activity act;
		HashMap<String, String> pairs;
		String url;
		CircleProgressBar pb;
		boolean showDialog;
		
		public GetData(Activity act, HashMap<String, String> pairs, String url, CircleProgressBar pb, boolean showDialog) {
			// TODO Auto-generated constructor stub
			this.act = act;
			this.pairs = pairs;
			this.url = url;
			this.pb = pb;
			this.showDialog = showDialog;
		}
		
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			if (showDialog && pb != null) {
				pb.setVisibility(View.VISIBLE);
			}
		}
		
		@Override
		protected String doInBackground(String... params) {
			
			String result = "";
			try {
				intial++;
				result = HttpUtils.doPost(pairs, url);
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
				if (result.length() <= 0 && intial < RETRY_COUNT) {
					new GetData(act, pairs, url, pb, showDialog).execute();
				} else {
					if (onResponseListener != null) 
						onResponseListener.onResponse(result);
				}
			} catch (Exception e) {
				// TODO: handle exception
				if (intial < RETRY_COUNT) {
					new GetData(act, pairs, url, pb, showDialog).execute();
				}
			} finally {
				if (pb != null)
					pb.setVisibility(View.GONE);
			}
		}
	}
	
	public void setOnResponseListener(OnResponseListener onResponseListener) {
		
		this.onResponseListener = onResponseListener;
	}
}
