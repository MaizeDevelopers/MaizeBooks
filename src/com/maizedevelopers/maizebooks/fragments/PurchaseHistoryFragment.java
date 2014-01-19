package com.maizedevelopers.maizebooks.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maizedevelopers.maizebooks.R;

public class PurchaseHistoryFragment extends Fragment {
public PurchaseHistoryFragment() { }
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) { 
        View rootView = inflater.inflate(R.layout.purchase_history, container, false);         
        return rootView;
    }
}
