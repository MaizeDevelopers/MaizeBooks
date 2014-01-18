package com.maizedevelopers.maizebooks.adapters;

public class NavDrawerItem {
	
	private int icon;
	private String title;
	private String count;
	
	private boolean isCounterVisible = false;
	
	public NavDrawerItem() { }

	public NavDrawerItem(String title, int icon) {
		this.icon = icon;
		this.title = title;
	}
	
	public NavDrawerItem(String title, int icon, boolean isCounterVisible, String count) {
		this.icon = icon;
		this.title = title;
		this.count = count;
		
		this.isCounterVisible = isCounterVisible;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public int getIcon() {
		return this.icon;
	}
	
	public String getCount() {
		return this.count;
	}
	
	public boolean getCounterVisibility() {
		return this.isCounterVisible;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setIcon(int icon) {
		this.icon = icon;
	}
	
	public void setCount(String count) {
		this.count = count;
	}
	
	public void setCounterVisibility(boolean isCounterVisible) {
		this.isCounterVisible = isCounterVisible;
	}
}
