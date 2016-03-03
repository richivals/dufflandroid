package com.tetearent.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SessionManager {

	private final int PRIVATE_MODE = 0;

	private final String USER_ID = "user_id";
	private final String USER_NAME = "user_name";
	private final String USER_PASSWORD = "user_password";
	private final String USER_EMAIL = "user_password";
	
	private final String IS_LOGGED_IN = "is_loggedin";

	private Editor editor;

	SharedPreferences pref;

	private String SHARED_PREFERENCE_NAME = "mobileappexpertsrideler";

	public SessionManager(Context context) {
		// TODO Initiate Session - Context
		pref = context.getSharedPreferences(SHARED_PREFERENCE_NAME,
				PRIVATE_MODE);
		editor = pref.edit();
	}

	public void createLoginSession(String userId, String userName,
			String email, String userPassword) {
		// TODO Create a Login Session
		try {
			editor.putString(USER_ID, userId);
			editor.putString(USER_NAME, userName);
			editor.putString(USER_EMAIL, email);
			editor.putString(USER_PASSWORD, userPassword);
			editor.putBoolean(IS_LOGGED_IN, true);
			editor.commit();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
	
	public String getUserId() {

		String s = "";
		try {

			s = pref.getString(USER_ID, "");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return s;
	}
	
	public String getUserName() {

		String s = "";
		try {

			s = pref.getString(USER_NAME, "");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return s;
	}
	
	public String getEmail() {

		String s = "";
		try {

			s = pref.getString(USER_EMAIL, "");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return s;
	}
	
	public String getPassWord() {

		String s = "";
		try {

			s = pref.getString(USER_PASSWORD, "");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return s;
	}

	public boolean isLoggedIn() {

		return pref.getBoolean(IS_LOGGED_IN, false);
	}

	public void logOut() {
		try {
			editor.clear();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// commit changes
		editor.commit();
	}
}
