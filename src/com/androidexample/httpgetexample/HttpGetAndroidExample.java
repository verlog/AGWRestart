package com.androidexample.httpgetexample;

import android.app.*;
import android.content.*;
import android.os.*;
import android.util.*;
import android.view.*;
import android.widget.*;
import java.io.*;
import java.net.*;
import org.apache.http.client.*;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.*;

public class HttpGetAndroidExample extends Activity {

	TextView content;
	EditText fname,email,login,pass;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_http_get_android_example);
		}
		public void onClickStart(View v){
			startService(new Intent(this, MyService.class));
		}
		
		//saveme.setOnClickListener(new Button.OnClickListener(){

				//private HttpGetAndroidExample.MyTask mt;
	
	
        	
	}

	
