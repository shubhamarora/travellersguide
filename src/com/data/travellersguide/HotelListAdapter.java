package com.data.travellersguide; 
  
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
   
public class HotelListAdapter extends BaseAdapter { 
   
	public Activity activity; 
    public LayoutInflater inflater; 
    public String data ; 
    public String[] parts,hotelName,hotelAddress,hotelType;
   
    public HotelListAdapter(Activity a) { 
    	activity = a;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        parts = GetData.response.split("`");
        hotelName = parts[0].split("-s-");
        hotelAddress = parts[1].split("-s-");
        hotelType = parts[2].split("-s-");
    } 
   
    public int getCount() { 
        return hotelName.length ; 
    } 
   
    public Object getItem(int position) { 
        return position; 
    } 
   
    public long getItemId(int position) { 
        return position; 
    } 
   
    public View getView(int position, View convertView, ViewGroup parent) { 
        View vi=convertView; 
        if(convertView==null) 
            vi = inflater.inflate(R.layout.list, null); 
   
        TextView name = (TextView)vi.findViewById(R.id.name); 
        TextView address = (TextView)vi.findViewById(R.id.address);  
        TextView type = (TextView)vi.findViewById(R.id.type); 
        ImageView img = (ImageView)vi.findViewById(R.id.list_image);
        name.setText(hotelName[position]); 
        address.setText(hotelAddress[position]); 
        if(MainActivity.reqType.equals("hotel")==true) {
        	img.setBackgroundResource(R.drawable.hotelicon);
            type.setText(hotelType[position]); 
        }
        	
        else {
        	img.setBackgroundResource(R.drawable.serviceicon);
            type.setText(""); 
        }
        	
        return vi; 
    } 
}