package com.maizedevelopers.maizebooks.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maizedevelopers.maizebooks.R;

public class HomeFragment extends Fragment {
	
	public HomeFragment() { }
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) { 		
        View rootView = inflater.inflate(R.layout.home, container, false);     
        return rootView;
    }
}