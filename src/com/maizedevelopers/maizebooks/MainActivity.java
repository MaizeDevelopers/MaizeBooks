package com.maizedevelopers.maizebooks;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.maizedevelopers.maizebooks.adapters.NavDrawerItem;
import com.maizedevelopers.maizebooks.adapters.NavDrawerListAdapter;
import com.maizedevelopers.maizebooks.fragments.Home;
import com.maizedevelopers.maizebooks.fragments.MyProfile;
import com.maizedevelopers.maizebooks.fragments.PurchaseHistory;
import com.maizedevelopers.maizebooks.fragments.Selling;
import com.maizedevelopers.maizebooks.fragments.WishList;

public class MainActivity extends Activity {
	
	private static final boolean D = true;
	private static final String TAG = "MaizeBooks";
	
	private ListView mDrawerList;
	private DrawerLayout mDrawerLayout;
	private ActionBarDrawerToggle mDrawerToggle;
	
	private CharSequence mTitle;
	private CharSequence mDrawerTitle;
	
	private String[] navMenuTitles;
	private TypedArray navMenuIcons;
	
	private NavDrawerListAdapter adapter;
	private ArrayList<NavDrawerItem> navDrawerItems;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		String DEBUG_TAG = "MainActivity.onCreate()";		
		if(D) Log.d(TAG, DEBUG_TAG);
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		if(D) Log.d(TAG, DEBUG_TAG + ": Setting up Fragments...");
		
		setupControl(savedInstanceState);
	}
	
	private void setupControl(Bundle savedInstanceState) {
		
		String DEBUG_TAG = "MainActivity.setupControl()";		
		if(D) Log.d(TAG, DEBUG_TAG);
		
		mTitle = mDrawerTitle = getTitle();
		
		navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);
		
		navMenuIcons = getResources().obtainTypedArray(R.array.nav_drawer_icons);

		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.lm_drawer);

		navDrawerItems = new ArrayList<NavDrawerItem>();

		navDrawerItems.add(new NavDrawerItem(navMenuTitles[0], navMenuIcons.getResourceId(0, -1)));
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[1], navMenuIcons.getResourceId(1, -1)));
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[2], navMenuIcons.getResourceId(2, -1)));
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[3], navMenuIcons.getResourceId(3, -1), true, "22"));
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[4], navMenuIcons.getResourceId(4, -1)));	

		navMenuIcons.recycle();
		
		if(D) Log.d(TAG, DEBUG_TAG + ": Fragments Setup Complete");
		
		if(D) Log.d(TAG, DEBUG_TAG + ": Setting up the Navigation Drawer");
		
		mDrawerList.setOnItemClickListener(new SlideMenuClickListener());

		adapter = new NavDrawerListAdapter(getApplicationContext(), navDrawerItems);
		mDrawerList.setAdapter(adapter);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);

		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_go,
				R.string.app_name,
				R.string.app_name
		) {
			public void onDrawerClosed(View view) {
				super.onDrawerClosed(view);
				getActionBar().setTitle(mTitle);
			}

			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
				getActionBar().setTitle(mDrawerTitle);
			}
		};
		mDrawerLayout.setDrawerListener(mDrawerToggle);
		
		if(D) Log.d(TAG, DEBUG_TAG + ": Navigation Drawer Setup Complete");

		if (savedInstanceState == null) {
			displayView(0);
		}
	}

	private class SlideMenuClickListener implements ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			displayView(position);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		if(D) Log.d(TAG, "MainActivity.onCreateOptionsMenu()");
		
		getMenuInflater().inflate(R.menu.main, menu);		
		return true;
	}

	private void displayView(int position) {
		Fragment fragment = null;
		
		switch (position) {
		case 0:
			fragment = new Home();
			break;
		case 1:
			fragment = new MyProfile();
			break;
		case 2:
			fragment = new WishList();
			break;
		case 3:
			fragment = new Selling();
			break;
		case 4:
			fragment = new PurchaseHistory();
			break;

		default:
			break;
		}

		if (fragment != null) {
			FragmentManager fragmentManager = getFragmentManager();
			fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();

			mDrawerList.setItemChecked(position, true);
			mDrawerList.setSelection(position);
			setTitle(navMenuTitles[position]);
			mDrawerLayout.closeDrawer(mDrawerList);
		}
	}

	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getActionBar().setTitle(mTitle);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		if(D) Log.d(TAG, "MainActivity.onPostCreate()");
		
		super.onPostCreate(savedInstanceState);
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		if(D) Log.d(TAG, "MainActivity.onConfigurationChanged()");
		
		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
          return true;
        }
        
        return super.onOptionsItemSelected(item);
    }
}
