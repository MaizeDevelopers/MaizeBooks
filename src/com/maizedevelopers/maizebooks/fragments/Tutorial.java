package com.maizedevelopers.maizebooks.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;
import com.facebook.model.GraphUser;
import com.facebook.widget.LoginButton;
import com.maizedevelopers.maizebooks.MainActivity;
import com.maizedevelopers.maizebooks.R;

public class Tutorial extends Fragment {
	private static final boolean D = true;
	private static final String TAG = "MaizeBooks";
	
	private UiLifecycleHelper uiHelper;
	
	private Session.StatusCallback callback = new Session.StatusCallback() {
	    @Override
	    public void call(Session session, SessionState state, Exception exception) {
	        onSessionStateChange(session, state, exception);
	    }
	};
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		String DEBUG_TAG = "Fragments.AppTutorial.onCreateView()";
		if(D) Log.d(TAG, DEBUG_TAG);
		
		ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.tutorial, container, false);
		
		LoginButton authButton = (LoginButton) rootView.findViewById(R.id.authButton);
	    authButton.setFragment(this);
	    
		return rootView;
	}

	private void onSessionStateChange(Session session, SessionState state, Exception exception) {
		
		final String DEBUG_TAG = "Fragments.Tutorial.onSessionStateChanged()";
		if(D) Log.d(TAG, DEBUG_TAG);
		
	    if (state.isOpened()) {
	    	if(D) Log.d(TAG, DEBUG_TAG + ": Logged In");

	        Request.newMeRequest(session, new Request.GraphUserCallback() {
	            @Override
	            public void onCompleted(GraphUser user, Response response) {
	                if (user != null) {                
	                    if(D) {
	                    	Log.d(TAG, DEBUG_TAG + ".newMeRequest.onCompleted(): " 
	                    			+ user.getName() + " ***** " + user.getBirthday());
	                    }
	                    
	                    Toast.makeText(getActivity(), "Logged In", Toast.LENGTH_LONG).show();
	                    
	                    Intent intent = new Intent(getActivity().getApplicationContext(), MainActivity.class);
	                    startActivity(intent);
	                }
	            }
	        }).executeAsync();
	    } 
	    else if (state.isClosed()) {
	        if(D) Log.d(TAG, DEBUG_TAG + ": Logged Out");
	    }
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		String DEBUG_TAG = "Fragments.Tutorial.onCreate()";
		if(D) Log.d(TAG, DEBUG_TAG);
		
	    super.onCreate(savedInstanceState);
	    
	    uiHelper = new UiLifecycleHelper(getActivity(), callback);
	    uiHelper.onCreate(savedInstanceState);
	}

	@Override
	public void onResume() {
		
		String DEBUG_TAG = "Fragments.Tutorial.onResume()";
		if(D) Log.d(TAG, DEBUG_TAG);
		
	    super.onResume();

	    Session session = Session.getActiveSession();	    
	    if (session != null && (session.isOpened() || session.isClosed()) ) {
	        onSessionStateChange(session, session.getState(), null);
	    }

	    uiHelper.onResume();
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		
		String DEBUG_TAG = "Fragments.Tutorial.onActivityResult()";
		if(D) Log.d(TAG, DEBUG_TAG);
		
	    super.onActivityResult(requestCode, resultCode, data);
	    uiHelper.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public void onPause() {
		
		String DEBUG_TAG = "Fragments.Tutorial.onPause()";
		if(D) Log.d(TAG, DEBUG_TAG);
		
	    super.onPause();
	    uiHelper.onPause();
	}

	@Override
	public void onDestroy() {
		
		String DEBUG_TAG = "Fragments.Tutorial.onDestroy()";
		if(D) Log.d(TAG, DEBUG_TAG);
		
	    super.onDestroy();
	    uiHelper.onDestroy();
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		
		String DEBUG_TAG = "Fragments.Tutorial.onSaveInstanceState()";
		if(D) Log.d(TAG, DEBUG_TAG);
		
	    super.onSaveInstanceState(outState);
	    uiHelper.onSaveInstanceState(outState);
	}

}