package com.androidexample.httpgetexample;

import android.app.*;
import android.content.*;
import android.os.*;
import android.util.*;
import org.apache.http.client.*;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.*;

public class MyService extends Service {

	final String LOG_TAG = "myLogs";

	private MyTask mt;

	public void onCreate() {
		super.onCreate();
		mt = new MyTask();
		
		Log.d(LOG_TAG, "onCreate");
	}

	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.d(LOG_TAG, "onStartCommand");
		someTask();
		return super.onStartCommand(intent, flags, startId);
	}

	public void onDestroy() {
		super.onDestroy();
		Log.d(LOG_TAG, "onDestroy");
	}

	public IBinder onBind(Intent intent) {
		Log.d(LOG_TAG, "onBind");
		return null;
	}

	void someTask() {
        mt.execute();
	}
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
		catch(Exception ex)
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
