package com.data.travellersguide;



import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

public class Serviceproviders extends Fragment {
	
	Spinner spinner2;
	ImageButton myButton;

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		
			if (container==null){
				return null;
			
			}
			LinearLayout mLinearLayout=(LinearLayout) inflater.inflate(R.layout.serviceproviders, container,false);
			myButton=(ImageButton) mLinearLayout.findViewById(R.id.findbtn2);
			spinner2=(Spinner) mLinearLayout.findViewById(R.id.spinner2);
			
		return mLinearLayout;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		myButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				MainActivity.reqType="service";
				new GetData("serviceprovider",String.valueOf(spinner2.getSelectedItem()),getActivity()).execute();
			}
		});
		
	}
}
