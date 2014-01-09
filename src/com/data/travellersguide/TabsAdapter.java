package com.data.travellersguide;

import java.util.ArrayList;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.app.ActionBar.Tab;


public class TabsAdapter extends FragmentPagerAdapter implements ActionBar.TabListener,ViewPager.OnPageChangeListener {

	private final Context mContext;
	private final ActionBar mActionBar;
	private final ViewPager mViewPager;
	private final ArrayList<TabInfo> mTabs=new ArrayList<TabInfo>();
	private final static String TAG="21st Polling:";
	
	static final class TabInfo{
		private final Class<?> clss;
		private final Bundle args;
		
		TabInfo(Class<?> _class,Bundle _args){
			clss=_class;
			args=_args;
		}
	}
	
	public TabsAdapter(SherlockFragmentActivity fm,ViewPager pager) {
		super(fm.getSupportFragmentManager());
		mContext=fm;
		mActionBar=fm.getSupportActionBar();
		mViewPager=pager;
		mViewPager.setAdapter(this);
		mViewPager.setOnPageChangeListener(this);
		// TODO Auto-generated constructor stub
	}
	
	public void addTab(ActionBar.Tab tab,Class<?> clss,Bundle args){
		TabInfo info=new TabInfo(clss, args);
		tab.setTag(info);
		tab.setTabListener(this);
		mTabs.add(info);
		mActionBar.addTab(tab);
		notifyDataSetChanged();
	}
	
	
	@Override
	public void onPageScrollStateChanged(int state) {
	// TODO Auto-generated method stub
	
	}

	@Override
	public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onPageSelected(int position){
	mActionBar.setSelectedNavigationItem(position);
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		mViewPager.setCurrentItem(tab.getPosition());
		Log.v(TAG ,"Clicked");
		Object tag=tab.getTag();
		for(int i=0;i < mTabs.size();i++){
			if(mTabs.get(i)==tag){
				mViewPager.setCurrentItem(i);
			}
		}
		
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onTabReselected(Tab tab,FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Fragment getItem(int position) {
    	
    	TabInfo info=mTabs.get(position);
    	
		// TODO Auto-generated method stub
		return Fragment.instantiate(mContext, info.clss.getName(),info.args);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mTabs.size();
	}

}



