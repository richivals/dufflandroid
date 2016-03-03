package com.tetearent.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

public class Util {

	public static void toaster(Context context, String text) {
		Toast toast = Toast.makeText(context, text, Toast.LENGTH_LONG);
		toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
		toast.show();
	}
	
	public static void hideSoftKeyboard(Activity activity) {
	    InputMethodManager inputMethodManager = (InputMethodManager)  activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
	    inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
	} 
	
	public static boolean isEmailAddressValid(String emailAddress) {
		String regExpn = "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
				+ "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
				+ "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
				+ "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
				+ "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
				+ "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";

		Pattern patternObj = Pattern.compile(regExpn);

		Matcher matcherObj = patternObj.matcher(emailAddress);
		if (matcherObj.matches()) {
			return true;
		} else {
			return false;
		}
	}
}
