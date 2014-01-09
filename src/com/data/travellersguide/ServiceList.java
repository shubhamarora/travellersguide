package com.data.travellersguide;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
public class ServiceList extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.listview);
		ServiceListAdapter hla= new ServiceListAdapter();
		ListView list = (ListView)findViewById(R.id.list);
		list.setAdapter(hla);
	}
	
	
}
