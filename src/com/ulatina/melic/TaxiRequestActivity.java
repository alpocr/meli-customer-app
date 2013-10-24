package com.ulatina.melic;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class TaxiRequestActivity extends Activity {
	GPSTracker gps;
	double latitude;
	double longitude;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_taxi_request);
		
		final Button btnGetCab = (Button)findViewById(R.id.btnGetCab);
		
		btnGetCab.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// create class object
			    gps = new GPSTracker(TaxiRequestActivity.this);

			    // check if GPS enabled     
			    if(gps.canGetLocation()){
			          latitude = gps.getLatitude();
			          longitude = gps.getLongitude();   
			    }else{
			         // can't get location
			         // GPS or Network is not enabled
			         // Ask user to enable GPS/network in settings
			         gps.showSettingsAlert();
			    }
			    
			    Toast.makeText(TaxiRequestActivity.this, 
			    		"Latitude: " + latitude + "\nLongitude: " + longitude, 
			    		Toast.LENGTH_LONG);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.taxi_request, menu);
		return true;
	}

}
