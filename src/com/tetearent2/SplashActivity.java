package com.tetearent2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;

import com.tetearent.util.SessionManager;

public class SplashActivity extends Activity {
	
	private static int SPLASH_TIME_OUT = 1000 * 2/*second*/;
	
	Handler handler;
	Runnable runn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		handler = new Handler();
		runn = new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				moveOn();
			}
		};
		
		handler.postDelayed(runn, SPLASH_TIME_OUT);
		
		((ImageView)findViewById(R.id.backImage)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				moveOn();
				if (handler != null) handler.removeCallbacks(runn);
			}
		});
	}
	
	private void moveOn() {
		Intent i = null;
		SessionManager sessionManager = new SessionManager(SplashActivity.this);
		if (sessionManager.isLoggedIn()) {
			i = new Intent(SplashActivity.this, HomeFragmentActivity.class);
		} else {
			i = new Intent(SplashActivity.this, LoginActivity.class);
		}
		startActivity(i);
		finish();
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		if (handler != null) handler.removeCallbacks(runn);
	}
}
