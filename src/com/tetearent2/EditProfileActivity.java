package com.tetearent2;

import java.util.HashMap;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import com.lsjwzh.widget.materialloadingprogressbar.CircleProgressBar;
import com.tetearent.util.APIConstants;
import com.tetearent.util.HttpRequest;
import com.tetearent.util.SessionManager;
import com.tetearent.util.Util;
import com.teterent.interphase.OnResponseListener;

public class EditProfileActivity extends AppCompatActivity {

	Button submit;
	EditText fname, lname, locality, styleBio;
	
	Toolbar toolbar;
	
	CircleProgressBar pb;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_profile);
		
		toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		submit = (Button) findViewById(R.id.submit);
		pb = ((CircleProgressBar)findViewById(R.id.progress));

		fname = (EditText) findViewById(R.id.editText1);
		lname = (EditText) findViewById(R.id.EditText01);
		locality = (EditText) findViewById(R.id.editLocality);
		styleBio = (EditText) findViewById(R.id.editBio);
		
		submit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				if (isValid()) {
					Util.hideSoftKeyboard(EditProfileActivity.this);
					HttpRequest httpRequest = new HttpRequest();
					SessionManager sessionManager = new SessionManager(EditProfileActivity.this);
					HashMap<String, String> pairs =  new HashMap<String, String>();
					pairs.put("task", "edit_profile");
					pairs.put("custid", sessionManager.getUserId());
					pairs.put("complocality", locality.getText().toString().trim());
					pairs.put("shoptitle", fname.getText().toString().trim() + lname.getText().toString().trim());
					pairs.put("compdesi", styleBio.getText().toString().trim());
				
					httpRequest.setOnResponseListener(new OnResponseListener() {
						@Override
						public void onResponse(String result) {
							// TODO Auto-generated method stub
							if (result.length() > 0) {
								finish();
							} else {
								Util.toaster(EditProfileActivity.this, "Unable to save profile. Please try again later");
							}
						}
					});
					httpRequest.httpPost(EditProfileActivity.this, pairs, APIConstants.ONLY_API, pb, true);
				}
			}
		});
	}
	
	private boolean isValid() {

		boolean ret = true;

		String fn = fname.getText().toString().trim();
		String ln = lname.getText().toString().trim();
		String local = locality.getText().toString().trim();
		String bio = styleBio.getText().toString().trim();
		
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
		
		if(local.length() == 0) {
			TextInputLayout wrapLocality = (TextInputLayout) findViewById(R.id.wrapLocality);
			wrapLocality.setError("Enter your locality");
			setTextWatcher(locality, wrapLocality);
			ret = false;
		} 
		
		if(bio.length() == 0) {
			TextInputLayout wrapBio = (TextInputLayout) findViewById(R.id.wrapBio);
			wrapBio.setError("Enter your style BIO");
			setTextWatcher(styleBio, wrapBio);
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
