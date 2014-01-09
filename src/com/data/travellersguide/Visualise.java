package com.data.travellersguide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

public class Visualise extends Activity{

	ImageButton visbtn1,visbtn2,visbtn3,visbtn4;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.visualise);
		
		visbtn1=(ImageButton)findViewById(R.id.vbtn1);
		visbtn2=(ImageButton)findViewById(R.id.vbtn2);
		visbtn3=(ImageButton)findViewById(R.id.vbtn3);
		visbtn4=(ImageButton)findViewById(R.id.vbtn4);
		
		visbtn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent myIntent=new Intent(Visualise.this,Ftag.class);
				startActivity(myIntent);
			}
		});
		
		visbtn2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent myIntent=new Intent(Visualise.this,Ftvg.class);
				startActivity(myIntent);
			}
		});
		
		visbtn3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent myIntent=new Intent(Visualise.this,Feec.class);
				startActivity(myIntent);	
			}
		});
		
		
		visbtn4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent myIntent=new Intent(Visualise.this,Feeu.class);
				startActivity(myIntent);
			}
		});
	}
	
	

}
