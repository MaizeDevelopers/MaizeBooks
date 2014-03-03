package com.maizedevelopers.maizebooks.fragments;

import com.maizedevelopers.maizebooks.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Tutorial extends Fragment {
	
	private static final boolean D = false;
	private static final String TAG = "MaizeBooks";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		String DEBUG_TAG = "Fragments.AppTutorial.onCreateView()";
		if(D) Log.d(TAG, DEBUG_TAG);
		
		ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.tutorial, container, false);
		return rootView;
	}
}