package com.efrei.gopizza;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import com.efrei.gopizza.services.GPSTracker;
import com.example.gopizza.R;

import android.app.Activity;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;

public class Config extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		// Enlever la title bar de l'application
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		super.onCreate(savedInstanceState);

		setContentView(R.layout.config_fullscreen);

	}

	@Override
	public void onBackPressed() {

		startActivity(new Intent(Config.this, Mainmenu.class));
		finish();

	}

	public void localisation(View view) {

		GPSTracker gps = new GPSTracker(Config.this);

		if (gps.canGetLocation()) {

			double latitude = gps.getLatitude();
			double longitude = gps.getLongitude();

			Log.d("Mainmenu", "Latitude : " + latitude + " longitude : "
					+ longitude);

			Geocoder geocoder;
			List<Address> addresses;
			geocoder = new Geocoder(this, Locale.getDefault());

			try {

				// addresses = geocoder.getFromLocation(latitude, longitude, 1);
				addresses = geocoder.getFromLocation(longitude, latitude, 1);

				String address = addresses.get(0).getAddressLine(0);
				String city = addresses.get(0).getLocality();
				String postalCode = addresses.get(0).getPostalCode();

				Log.d("Mainmenu", "Adress : " + address + " City : " + city
						+ " Postal Code : " + postalCode);

				EditText editTextStreet = (EditText) findViewById(R.id.editTextStreet);
				editTextStreet.setText(address);

				EditText editTextCity = (EditText) findViewById(R.id.editTextCity);
				editTextCity.setText(city);

				EditText editTextCityCode = (EditText) findViewById(R.id.editTextPostalCode);
				editTextCityCode.setText(postalCode);

			} catch (IOException e) {
				e.printStackTrace();
			}

			gps.stopUsingGPS();

		} else {

			gps.showSettingsAlert();

		}

	}

}
