package com.efrei.gopizza;

import java.util.ArrayList;

import com.example.gopizza.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;

public class Mainmenu extends Activity implements LocationListener {

	private LocationManager lManager;
    private Location location;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		// Enlever la title bar de l'application
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		super.onCreate(savedInstanceState);

		setContentView(R.layout.mainmenu_fullscreen);

	}

	public void buttonTopClick(View view) {

		startActivity(new Intent(Mainmenu.this, Pizzamenu.class));
		finish();

	}
	
	public void buttonBottomRightClick(View view) {

		startActivity(new Intent(Mainmenu.this, Info.class));
		finish();

	}
	
	public void Localisation(View view) {

		
	}

	@Override
	public void onLocationChanged(Location location) {
		
		//Save new position
		SharedPreferences settings = getSharedPreferences("GoPizzaConf", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putFloat("Longitude",(float)location.getLongitude());
        editor.putFloat("Latitude",(float)location.getLatitude());
        editor.commit();
		
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}

}
