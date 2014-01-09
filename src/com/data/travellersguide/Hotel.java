package com.data.travellersguide;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class Hotel extends Fragment{
	
	Spinner spinner1;
	ImageButton myButton;
	
	
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
			
			if (container==null){
				return null;
			
			}
			LinearLayout mLinearLayout=(LinearLayout) inflater.inflate(R.layout.hotel, container,false);
			myButton=(ImageButton) mLinearLayout.findViewById(R.id.findbtn1);
			spinner1=(Spinner) mLinearLayout.findViewById(R.id.spinner1);
			
		return mLinearLayout;
		}
		
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		myButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				MainActivity.reqType="hotel";
				new GetData("hotel",String.valueOf(spinner1.getSelectedItem()),getActivity()).execute();
			}
		});
		
	}
}


	

	