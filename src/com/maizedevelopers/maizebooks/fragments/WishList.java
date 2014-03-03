package com.maizedevelopers.maizebooks.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maizedevelopers.maizebooks.R;

public class WishList extends Fragment {
	
	private static final boolean D = false;
	private static final String TAG = "MaizeBooks";
	
	public WishList() { }
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) { 
		
		String DEBUG_TAG = "Fragments.WishList.onCreateView()";
		if(D) Log.d(TAG, DEBUG_TAG);
		
        View rootView = inflater.inflate(R.layout.wish_list, container, false);         
        return rootView;
    }
}
