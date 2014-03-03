package com.maizedevelopers.maizebooks.fragments;

import com.maizedevelopers.maizebooks.R;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Selling extends Fragment {
	private static final boolean D = false;
	private static final String TAG = "MaizeBooks";
	
	public Selling() { }
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) { 
		
		String DEBUG_TAG = "Fragments.Selling.onCreateView()";
		if(D) Log.d(TAG, DEBUG_TAG);
		
        View rootView = inflater.inflate(R.layout.selling, container, false);         
        return rootView;
    }
}
