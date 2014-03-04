package com.maizedevelopers.maizebooks;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.maizedevelopers.maizebooks.fragments.Tutorial;
import com.maizedevelopers.maizebooks.fragments.SplashScreen;

public class SplashActivity extends FragmentActivity {
	
	private static final boolean D = false;
	private static final String TAG = "MaizeBooks";

    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;
    
    private static final int NUM_PAGES = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
    	String DEBUG_TAG = "SplashActivity.onCreate()";
    	if(D) Log.d(TAG, DEBUG_TAG);
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        
        if(D) Log.d(TAG, DEBUG_TAG + ": Initializing Fragments...");

        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new SplashScreenAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        
        if(D) Log.d(TAG, DEBUG_TAG + ": Fragments Initialized...");
      }
        

    @Override
    public void onBackPressed() {
    	String DEBUG_TAG = "SplashActivity.onBackPressed()";
    	if(D) Log.d(TAG, DEBUG_TAG);
    	
        if (mPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } 
        else {
        	if(D) Log.d(TAG, DEBUG_TAG + ": Going Back...");
        	
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    private class SplashScreenAdapter extends FragmentStatePagerAdapter {
    	private static final String DEBUG_TAG = "SplashActivity.SplashScreenAdapter";
    	
        public SplashScreenAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {        	
        	if(position == 0) {
        		if(D) Log.d(TAG, DEBUG_TAG + ".getItem(): Creating Splash Screen...");        		
        		return new SplashScreen();
        	}
        	else {
        		if(D) Log.d(TAG, DEBUG_TAG + ".getItem(): Creating App Tutorial...");
        		return new Tutorial();
        	}
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}