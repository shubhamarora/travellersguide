package com.data.travellersguide;



import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class Graph extends Fragment {
	
	
	
	
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
			
			if (container==null){
				return null;
			
			}
			LinearLayout mLinearLayout=(LinearLayout) inflater.inflate(R.layout.graph, container,false);
			ImageButton myButton=(ImageButton) mLinearLayout.findViewById(R.id.visbtn);
			myButton.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent myIntent=new Intent(getActivity(),Visualise.class);
					getActivity().startActivity(myIntent);
					
				}
			});
		return mLinearLayout;
		
		
		
	}

}
