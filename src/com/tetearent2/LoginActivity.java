package com.tetearent2;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.adodis.httputil.HttpUtils;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.tetearent.util.APIConstants;
import com.tetearent.util.SessionManager;
import com.tetearent.util.Util;

public class LoginActivity extends Activity {

	private LoginButton loginButton;
	private CallbackManager callbackManager;

	EditText email, password;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setupFB();
		setContentView(R.layout.activity_login);

		email = (EditText) findViewById(R.id.emailaddress);
		password = (EditText) findViewById(R.id.password);

		setListener();
	}

	private void setupFB() {

		FacebookSdk.sdkInitialize(LoginActivity.this);
		callbackManager = CallbackManager.Factory.create();
		loginButton = new LoginButton(LoginActivity.this);

		loginButton.registerCallback(callbackManager,
				new FacebookCallback<LoginResult>() {
					@Override
					public void onSuccess(LoginResult loginResult) {
						Log.e("TAG", "User ID: "
								+ loginResult.getAccessToken().getUserId());
						Log.e("TAG", "Auth Token: "
								+ loginResult.getAccessToken().getToken());
					}

					@Override
					public void onCancel() {
					}

					@Override
					public void onError(FacebookException e) {
					}
				});
	}

	private void setListener() {

		((Button) findViewById(R.id.loginbtn))
				.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						if (isValid()) {
							Util.hideSoftKeyboard(LoginActivity.this);
							new Login().execute();
						}
					}
				});

		((Button) findViewById(R.id.registerbtn))
				.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						Util.hideSoftKeyboard(LoginActivity.this);
						startActivity(new Intent(LoginActivity.this,
								RegisterActivity.class));
					}
				});

		((Button) findViewById(R.id.fblogin))
				.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						loginButton.performClick();
					}
				});
	}

	private boolean isValid() {

		boolean ret = true;

		if (email.getText().toString().trim().length() == 0) {
			TextInputLayout wrapEmail = (TextInputLayout) findViewById(R.id.wrapEmail);
			wrapEmail.setError("Enter email address");
			setTextWatcher(email, wrapEmail);
			ret = false;
		} else if (!Util.isEmailAddressValid(email.getText().toString().trim())) {
			TextInputLayout wrapEmail = (TextInputLayout) findViewById(R.id.wrapEmail);
			wrapEmail.setError("Enter a valid email address");
			setTextWatcher(email, wrapEmail);
			ret = false;
		}

		if (password.getText().toString().trim().length() == 0) {
			TextInputLayout wrapPassword = (TextInputLayout) findViewById(R.id.wrapPassword);
			wrapPassword.setError("Enter password");
			setTextWatcher(password, wrapPassword);
			ret = false;
		}

		return ret;
	}

	private void setTextWatcher(final EditText edittext,
			final TextInputLayout inputLayout) {
		edittext.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub
				inputLayout.setError(null);
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}

			@Override
			public void afterTextChanged(Editable s) {
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (callbackManager != null)
			callbackManager.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	protected void onResume() {
		super.onResume();
		AppEventsLogger.activateApp(this);
	}
	
	private class Login extends AsyncTask<String, Void, String> {
		
		ProgressDialog pd;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pd = new ProgressDialog(LoginActivity.this);
			pd.setMessage("Loading...");
			pd.setCancelable(false);
			pd.show();
		}
		
		@Override
		protected String doInBackground(String... params) {
			
			String result = "";
			try {
				
				String url = APIConstants.ONLY_API;
				HashMap<String, String> pairs = new HashMap<String, String>();
				pairs.put("task", "doLogin");
				pairs.put("username", email.getText().toString().trim());
				pairs.put("password", password.getText().toString().trim());
				
				result = HttpUtils.doPost(pairs, url);
				Log.e("TAG", "res-"+url);
           
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
				JSONObject jb = new JSONObject(result);
				String userId = jb.getString("id");
				
				if(!userId.equals("")){
					Util.toaster(LoginActivity.this, "Logged in");
					SessionManager sessionManager = new SessionManager(LoginActivity.this);
					sessionManager.createLoginSession(userId, jb.getString("name"), jb.getString("email"), password.getText().toString().trim());
					startActivity(new Intent(LoginActivity.this, HomeFragmentActivity.class));
					finish();
				} else {
					Util.toaster(LoginActivity.this, "Invalid logiin credentials");
				}
			} catch (JSONException e) {
				// TODO: handle exception
				Util.toaster(LoginActivity.this, "Problem signing in. Please try again later.");
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				if (pd != null)
					pd.dismiss();
			}
		}
	}
}