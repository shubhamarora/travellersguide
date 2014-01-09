package com.data.travellersguide; 
  
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
   
public class ServiceListAdapter extends BaseAdapter { 
   
    private Activity activity; 
    private static LayoutInflater inflater=null; 
    public String data ; 
    public String[] parts;public String[] temp;public static String time; 
   
    public ServiceListAdapter() { 
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE); 
        parts = GetData.response.split("%");
    } 
   
    public int getCount() { 
        Log.d("list size == >",  "value" + parts.length); 
        return parts.length - 1; 
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
        temp = parts[position].split("#"); 
        name.setText(temp[0]); 
        address.setText(temp[1]); 
        type.setText(temp[2]); 
       
          
        return vi; 
    } 
}