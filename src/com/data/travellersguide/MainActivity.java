package com.data.travellersguide;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;

public class MainActivity extends SherlockFragmentActivity{
	
	private ViewPager mViewPager;
	private TabsAdapter mTabsAdapter;
	public static String reqType;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		mViewPager = new ViewPager(this);
		mViewPager.setId(R.id.pager);
		setContentView(mViewPager);
		
		final ActionBar bar=getSupportActionBar();
		bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		bar.setDisplayShowTitleEnabled(false);
		bar.setDisplayShowHomeEnabled(false);
		
		mTabsAdapter=new TabsAdapter(this,mViewPager);
		mTabsAdapter.addTab(bar.newTab().setText("Hotels"),Hotel.class,null);
		mTabsAdapter.addTab(bar.newTab().setText("Service Providers"),Serviceproviders.class,null);
		mTabsAdapter.addTab(bar.newTab().setText("Stats"),Graph.class,null);
		
	}	
	
	@Override
	public void onBackPressed() {
	    new AlertDialog.Builder(this)
	           .setMessage("Do you want to exit Traveller's Guide ?")
	           .setCancelable(false)
	           .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
	               public void onClick(DialogInterface dialog, int id) {
	            	   MainActivity.this.finish();
	               }
	           })
	           .setNegativeButton("No", null)
	           .show();
	    
	}
		
		public void callList()
		 {
			 Intent list=new Intent(MainActivity.this,HotelList.class);
			 startActivity(list);
		 }
		public void invalidmsg()
		{
			Toast.makeText(MainActivity.this, "No Data Found", Toast.LENGTH_SHORT).show();
			
		}
		public void prompt(String result) { 
	        AlertDialog.Builder builder = new AlertDialog.Builder(this); 
	        builder.setTitle("Error"); 
	        builder.setMessage(result)   
	               .setCancelable(false) 
	               .setPositiveButton("OK", null);                      
	        AlertDialog alert = builder.create(); 
	        alert.show();    
	          
	    }
					
				
			
		}
	

