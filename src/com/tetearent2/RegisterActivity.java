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
import android.widget.Button;
import android.widget.EditText;

import com.adodis.httputil.HttpUtils;
import com.tetearent.util.APIConstants;
import com.tetearent.util.Util;

public class RegisterActivity extends Activity {
	
	Button submit;
	EditText fname, lname, email, password, mobileno;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		
		submit =(Button)findViewById(R.id.submit);
		
		fname =(EditText)findViewById(R.id.editText1);
		lname =(EditText)findViewById(R.id.EditText01);
		email = (EditText)findViewById(R.id.editText2);
		password = (EditText)findViewById(R.id.editText3);
		mobileno = (EditText)findViewById(R.id.editMobile);
		
		submit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				if (isValid()) {
					Util.hideSoftKeyboard(RegisterActivity.this);
					new Registration().execute();
				}
			}
		});
	}
	
	private boolean isValid() {

		boolean ret = true;

		String fn = fname.getText().toString().trim();
		String ln = lname.getText().toString().trim();
		String mail = email.getText().toString().trim();
		String mobile = mobileno.getText().toString().trim();
		String pwd = password.getText().toString().trim();
		
		if(fn.length() == 0) {
			TextInputLayout wrapFname = (TextInputLayout) findViewById(R.id.wrapFname);
			wrapFname.setError("Enter first name");
			setTextWatcher(fname, wrapFname);
			ret = false;
		}
		
		if (ln.length() == 0)	{
			TextInputLayout wrapLname = (TextInputLayout) findViewById(R.id.wrapLname);
			wrapLname.setError("Enter last name");
			setTextWatcher(lname, wrapLname);
			ret = false;
		} 
		
		if(mail.length() == 0) {
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
		
		if(mobile.length() == 0) {
			TextInputLayout wrapMobile = (TextInputLayout) findViewById(R.id.wrapMobile);
			wrapMobile.setError("Enter mobile number");
			setTextWatcher(mobileno, wrapMobile);
			ret = false;
		} else if(mobile.length() != 10) {
			TextInputLayout wrapMobile = (TextInputLayout) findViewById(R.id.wrapMobile);
			wrapMobile.setError("Enter a valid mobile number");
			setTextWatcher(mobileno, wrapMobile);
			ret = false;
		} 

		if(pwd.length() == 0) {
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
	
	class Registration extends AsyncTask<String, Void, String> {
		
		ProgressDialog pd;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pd = new ProgressDialog(RegisterActivity.this);
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
				pairs.put("task", "doRegister");
				pairs.put("fname", fname.getText().toString().trim());
				pairs.put("lname", lname.getText().toString().trim());
				pairs.put("email", email.getText().toString().trim());
				pairs.put("mobile", mobileno.getText().toString().trim());
				pairs.put("pwd", password.getText().toString().trim());
				
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
				String regStatus = jb.getString("regStatus");
				
				if(regStatus.equals("0")){
					Util.toaster(RegisterActivity.this, "Registration Failed Please Try Again");
				} else if(regStatus.equals("-1")) {
					Util.toaster(RegisterActivity.this, "Email Already Exits");
				} else if(regStatus.equals("null")) {
					Util.toaster(RegisterActivity.this, "Invaild Data");
				} else if(regStatus.equals("1")) {
					Util.toaster(RegisterActivity.this, "Registration Success");
					startActivity(new Intent(RegisterActivity.this, ProductListingActivity.class));
					finish();
				} else {
					Util.toaster(RegisterActivity.this, "Sorry Registration Failed");
				}
			} catch (JSONException e) {
				// TODO: handle exception
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				if (pd != null)
					pd.dismiss();
			}
		}
	}
}