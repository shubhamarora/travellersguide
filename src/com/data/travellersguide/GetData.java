package com.data.travellersguide; 
  
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import android.os.AsyncTask;
import android.util.Log;
  
public class GetData extends AsyncTask<Void, Void, String> { 
      
    HttpPost httppost; 
    StringBuffer buffer; 
    HttpResponse response1; 
    HttpClient httpclient; 
    List<NameValuePair> nameValuePairs; 
    public static String response; 
    String[] temp; 
    public Object ss; 
    String state;
    String tempp[];
    String condition;  
      
      
  
        public GetData(String condition,String city,Object obj) { 
             state = city; 
             ss = obj; 
             this.condition = condition;
    } 
  
  
        protected void onPreExecute() { 
              
        } 
  
  
        @Override
        protected String doInBackground(Void... params) { 
              
              
    try { 
        if(condition.equals("hotel")==true)
        httppost= new HttpPost("URL_HERE"); 
        else
        	httppost= new HttpPost("URL_HERE"); 
          
        HttpParams httpParameters = new BasicHttpParams(); 
        // Set the timeout in milliseconds until a connection is established. 
        // The default value is zero, that means the timeout is not used.  
        int timeoutConnection = 12000; 
        HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection); 
        // Set the default socket timeout (SO_TIMEOUT)  
        // in milliseconds which is the timeout for waiting for data. 
        int timeoutSocket = 12000; 
        HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket); 
          
        httpclient=new DefaultHttpClient(httpParameters);    
          
        //add your data 
        nameValuePairs = new ArrayList<NameValuePair>(1); 
          
        nameValuePairs.add(new BasicNameValuePair("state",state));
          
        Log.d("state = ",state); 
          
        try { 
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs)); 
        } catch (UnsupportedEncodingException e1) { 
            // TODO Auto-generated catch block 
            e1.printStackTrace(); 
        } 
          
        //Execute HTTP Post Request 
          
        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        String resp;
            resp = httpclient.execute(httppost, responseHandler);
            tempp = resp.split("check");
            response = tempp[1];
         /*HttpConnectionParams.setConnectionTimeout(httpclient.getParams(), 2); 
         int timeoutSocket = 2; 
         HttpConnectionParams.setSoTimeout(httpclient.getParams(), timeoutSocket); 
         System.out.println("timeout socket"+timeoutSocket); */
         Log.e("Response", response); 
    } 
     catch(ConnectTimeoutException e){ 
         Log.d("doInBackground", "caught ConnectTimeoutException "); 
        return "Connection Time Out."; 
     } 
    catch (ClientProtocolException e) { 
        Log.d("doInBackground", "caught ClientProtocolException "); 
        return "Unable to fetch data.."; 
    } catch (IOException e) { 
        Log.d("doInBackground", "IOException"); 
        return "Unable to fetch data."; 
    } 
           
          
          
  
        return "noerror"; 
        } 
          
        protected void onPostExecute(String result)  { 
            Log.d("result Value == >", result); 
              
            // check error 
            if(result.equals("Connection Time Out.")==true || result.equals("Unable to fetch data..")==true || result.equals("Unable to fetch data.")==true) { 
                  ((MainActivity)ss).prompt(result); 
            } 
              
            //no error 
            else { 
                if(response.equals("No Data Found")==true){ 
                        ((MainActivity)ss).invalidmsg(); 
                } 
                else { 
                    	Log.d("heeree","heeree");
                        ((MainActivity)ss).callList(); 
                } 
            }           
        } 
} 
  
