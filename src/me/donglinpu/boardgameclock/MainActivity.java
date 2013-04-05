package me.donglinpu.boardgameclock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Get
        Button button = (Button) findViewById(R.id.button_login);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	// Send data
            	HttpClient httpclient = new DefaultHttpClient();
            	// TODO change IP address
//                HttpPost httppost = new HttpPost("http://152.78.157.91:3000/ft");
                HttpGet httpGet= new HttpGet("http://152.78.157.91:3000/user/1/ac");
                try {
                    // Execute HTTP Post Request
                    HttpResponse response = httpclient.execute(httpGet);

                    Log.v("resp", String.valueOf(response.getStatusLine().getStatusCode()));
                } catch (ClientProtocolException e) {
                    // TODO Auto-generated catch block
                	Log.v("ClientProtocolException", e.getMessage());
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                	Log.v("IOException", e.getMessage());
                }
            }
        });
        
        
        
        
        
        // Post
        Button postButton = (Button) findViewById(R.id.button_post);
        postButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	// Send data
            	HttpClient httpclient = new DefaultHttpClient();
            	// TODO change IP address
//                HttpPost httppost = new HttpPost("http://152.78.157.91:3000/ft");
                HttpPost httpPost= new HttpPost("http://152.78.157.91:3000/hello");
                
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
                nameValuePairs.add(new BasicNameValuePair("id", "1"));
                nameValuePairs.add(new BasicNameValuePair("appToken", "ASSASDA"));
                
                try {
                    // Execute HTTP Post Request
                	httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                    HttpResponse response = httpclient.execute(httpPost);
                    
                    HttpEntity entity = response.getEntity();
                   
                    String logStr = "";
                    String inputLine;
                    BufferedReader in = new BufferedReader(new InputStreamReader(entity.getContent()));
                    try {
                        while ((inputLine = in.readLine()) != null) {
                        	logStr += inputLine;
                        }
                        in.close();
                   } catch (IOException e) {
                        e.printStackTrace();
                   }
                    
                    Log.v("resp post", logStr);
                } catch (ClientProtocolException e) {
                    // TODO Auto-generated catch block
                	Log.v("ClientProtocolException", e.getMessage());
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                	Log.v("IOException", e.getMessage());
                }
            }
        });
        
        
        
        // Put
        Button putButton = (Button) findViewById(R.id.button_put);
        putButton.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
            	// Send data
            	HttpClient httpclient = new DefaultHttpClient();
            	// TODO change IP address
                HttpPut httpPut= new HttpPut("http://152.78.157.91:3000/ft");
                
                ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

                nameValuePairs.add(new BasicNameValuePair("username", "donginatorrrr")); 
                nameValuePairs.add(new BasicNameValuePair("loginMethod", "Facebook")); 
                nameValuePairs.add(new BasicNameValuePair("socialNetworkID", "1234567890")); 
                nameValuePairs.add(new BasicNameValuePair("appToken", getString(R.string.postgres_pw))); 
                
                try {
                    // Execute HTTP Post Request

                	httpPut.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                    HttpResponse response = httpclient.execute(httpPut);
                    
                    HttpEntity entity = response.getEntity();
                   
                    String logStr = "";
                    String inputLine;
                    BufferedReader in = new BufferedReader(new InputStreamReader(entity.getContent()));
                    try {
                    	while ((inputLine = in.readLine()) != null) {
                    		logStr += inputLine;
                    	}
                    	in.close();
                    } catch (IOException e) {
                    	e.printStackTrace();
                    }

                    Log.v("resp put code", String.valueOf(response.getStatusLine().getStatusCode()));
                    Log.v("resp put", logStr);
                } catch (ClientProtocolException e) {
                    // TODO Auto-generated catch block
                	Log.v("ClientProtocolException", e.getMessage());
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                	Log.v("IOException", e.getMessage());
                }
            }
        });
        
        
        
        
//        // Delete
//        Button deleteButton = (Button) findViewById(R.id.button_delete);
//        deleteButton.setOnClickListener(new View.OnClickListener() {
//        	public void onClick(View v) {
//            	// Send data
//            	HttpClient httpclient = new DefaultHttpClient();
//            	// TODO change IP address
////                HttpPost httppost = new HttpPost("http://152.78.157.91:3000/ft");
//                HttpPost httpPost= new HttpPost("http://152.78.157.91:3000/dl");
//                
//                ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
//                nameValuePairs.add(new BasicNameValuePair("appToken", "apptoneabc")); 
//                
//                try {
//                    // Execute HTTP Post Request
//
//                	httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
//                    HttpResponse response = httpclient.execute(httpPost);
//                    
//                    HttpEntity entity = response.getEntity();
//                   
//                    String logStr = "";
//                    String inputLine;
//                    BufferedReader in = new BufferedReader(new InputStreamReader(entity.getContent()));
//                    try {
//                        while ((inputLine = in.readLine()) != null) {
//                        	logStr += inputLine;
//                        }
//                        in.close();
//                   } catch (IOException e) {
//                        e.printStackTrace();
//                   }
//                    
//                    Log.v("resp", logStr);
//                } catch (ClientProtocolException e) {
//                    // TODO Auto-generated catch block
//                	Log.v("ClientProtocolException", e.getMessage());
//                } catch (IOException e) {
//                    // TODO Auto-generated catch block
//                	Log.v("IOException", e.getMessage());
//                }
//            }
//        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
