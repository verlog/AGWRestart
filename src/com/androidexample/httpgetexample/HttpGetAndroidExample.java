package com.androidexample.httpgetexample;

import android.app.*;
import android.os.*;
import android.util.*;
import android.view.*;
import android.widget.*;
import java.io.*;
import java.net.*;
import org.apache.http.client.*;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.*;
import com.androidexample.httpgetexample.HttpGetAndroidExample.*;

public class HttpGetAndroidExample extends Activity {

	TextView content;
	EditText fname,email,login,pass;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_http_get_android_example);
		
		content = (TextView)findViewById(R.id.content);
        fname	= (EditText)findViewById(R.id.name);
        email	= (EditText)findViewById(R.id.email);
        login	= (EditText)findViewById(R.id.loginname);
        pass	= (EditText)findViewById(R.id.password);
        Button saveme=(Button)findViewById(R.id.save);
		
		
		saveme.setOnClickListener(new Button.OnClickListener(){

				private HttpGetAndroidExample.MyTask mt;
        	public void onClick(View v)
        	{	
				mt = new MyTask();
				mt.execute();
        		//ALERT MESSAGE
				Toast.makeText(getBaseContext(),
						"Please wait, connecting to server.",
						Toast.LENGTH_LONG).show();
			
        	}
        });  
	}

	class MyTask extends AsyncTask<Void, Void, Void>
	{
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			//tvInfo.setText("Begin");
		}
		@Override
		protected Void doInBackground(Void[] p1)
		{
			// TODO: Implement this method
			String LOGTAG="MyLog";
			try{	

				String loginValue = URLEncoder.encode(login.getText().toString(), "UTF-8");
				String fnameValue = URLEncoder.encode(fname.getText().toString(), "UTF-8");
				String emailValue = URLEncoder.encode(email.getText().toString(), "UTF-8");
				String passValue  = URLEncoder.encode(pass.getText().toString(), "UTF-8");

				HttpClient Client = new DefaultHttpClient();
				String URL = "http://google.com";

				Log.d(LOGTAG, URL);
				try
				{
					HttpGet httpget = new HttpGet(URL);
					ResponseHandler<String> responseHandler = new BasicResponseHandler();

					String SetServerString = "";
					SetServerString = Client.execute(httpget, responseHandler);
					//content.setText(SetServerString);
					Log.d(LOGTAG,SetServerString);
				}
				catch(Exception ex)
				{
					//content.setText("Fail! "+ex.getMessage());
					
					Log.e("MainLogger.Run.Exception", "" + ex);
				}
			}
			catch(UnsupportedEncodingException ex)
			{
				//content.setText("Fail111");
				Log.e("MainLogger.Run.Exception", "" + ex);
			}  	 	
			return null;
		}
		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			//tvInfo.setText("End");
		}
		
		
	}
}
