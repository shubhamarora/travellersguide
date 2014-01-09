package com.data.travellersguide;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
public class HotelList extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listview);
		setTitle("Hotels");
		HotelListAdapter hla= new HotelListAdapter(this);
		ListView list = (ListView)findViewById(R.id.list);
		list.setAdapter(hla);
	}
	
	
}
