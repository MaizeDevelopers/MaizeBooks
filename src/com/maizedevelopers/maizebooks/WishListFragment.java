package com.maizedevelopers.maizebooks;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class WishListFragment extends Fragment {
	public WishListFragment() { }
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) { 
        View rootView = inflater.inflate(R.layout.wish_list, container, false);         
        return rootView;
    }
}
