package com.maizedevelopers.maizebooks.fragments;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.maizedevelopers.maizebooks.R;

public class MyProfileFragment extends Fragment {
	
	Button btnSave;
	EditText etFullName;
	EditText etEmailAddress;
	
	SharedPreferences mPreferences;
	
	public MyProfileFragment() { }
	
	@Override
	@SuppressLint("CommitPrefEdits")
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) { 
        View rootView = inflater.inflate(R.layout.my_profile, container, false);    
        
        btnSave = (Button) rootView.findViewById(R.id.btn_save);
        etFullName = (EditText) rootView.findViewById(R.id.et_full_name);
        etEmailAddress = (EditText) rootView.findViewById(R.id.et_email_id);
        
        mPreferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        
        String fullName = mPreferences.getString("fullName", null);
        String emailAddress = mPreferences.getString("email", null);
        
        if(fullName != null && emailAddress != null) {
        	etFullName.setText(fullName);
        	etEmailAddress.setText(emailAddress);
        }
        
        btnSave.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				SharedPreferences.Editor editor = mPreferences.edit();	
				
				editor.putString("fullName", etFullName.getText().toString());
				editor.putString("email", etEmailAddress.getText().toString());
				
				editor.commit();
			}
		});
        
        return rootView;
    }
}
