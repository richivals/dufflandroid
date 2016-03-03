package com.tetearent.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tetearent2.R;

public class SellFragment extends Fragment {
	
	View view;
	FragmentActivity activity;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.fragment_sell, container, false);
		
		activity = getActivity();
		
		return view;
	}
}


/*
Camera and gallery selector and function
slider

*/