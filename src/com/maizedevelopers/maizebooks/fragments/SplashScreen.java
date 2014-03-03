package com.maizedevelopers.maizebooks.fragments;

import com.maizedevelopers.maizebooks.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SplashScreen extends Fragment {
	
	private static final boolean D = false;
	private static final String TAG = "MaizeBooks";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		String DEBUG_TAG = "Fragments.SplashScreen.onCreateView()";
		if(D) Log.d(TAG, DEBUG_TAG);
		
		ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.splash_screen, container, false);
		return rootView;
	}
}