package com.maizedevelopers.maizebooks.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.maizedevelopers.maizebooks.R;

public class HomeFragment extends Fragment {
	
	Spinner spnTag;
	Button btnSearch;
	EditText etSearch;
	TextView txtResults;
	
	public HomeFragment() { }
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) { 
        View rootView = inflater.inflate(R.layout.home, container, false);
        
        spnTag = (Spinner) rootView.findViewById(R.id.spn_tag);
        btnSearch = (Button) rootView.findViewById(R.id.btn_search);
        etSearch = (EditText) rootView.findViewById(R.id.et_search);
        txtResults = (TextView) rootView.findViewById(R.id.textView1);
        
        return rootView;
    }
}
