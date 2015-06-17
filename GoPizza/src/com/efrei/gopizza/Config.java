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
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

public class Config extends Activity {

	EditText login, password, nameSurname, street, city, postalCode, phoneNumber, email;
	Spinner spin1, spin2, spin3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		// Enlever la title bar de l'application
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		super.onCreate(savedInstanceState);

		setContentView(R.layout.config_fullscreen);
		
		login = (EditText)findViewById(R.id.editTextLogin);
		password = (EditText)findViewById(R.id.editTextPassword);
		nameSurname = (EditText)findViewById(R.id.editTextNameSurname);
		street = (EditText)findViewById(R.id.editTextStreet); 
		city = (EditText)findViewById(R.id.editTextCity); 
		postalCode = (EditText)findViewById(R.id.editTextPostalCode);
		phoneNumber = (EditText)findViewById(R.id.editTextPhoneNumber);
		email = (EditText)findViewById(R.id.editTextEmail);

		spin1 = (Spinner)findViewById(R.id.spinner1);
		spin2 = (Spinner)findViewById(R.id.spinner2);
		spin3 = (Spinner)findViewById(R.id.spinner3);
		
	}

	@Override
	public void onBackPressed() {

		startActivity(new Intent(Config.this, Mainmenu.class));
		finish();
		
	}

	public void login(View view) {
		
		if("Neocat".equals(login.getText().toString())  && "gopizza01".equals(password.getText().toString())) {
			
			Log.d("Mainmenu", "Successful login");
			
			nameSurname.setText("Romain COURTIEUX");
			street.setText("7 Rue des charmes");
			city.setText("Thiais");
			postalCode.setText("94320");
			phoneNumber.setText("06 20 33 25 53");
			email.setText("romaincourtieux@hotmail.com");
			spin1.setSelection(((ArrayAdapter<String>)spin1.getAdapter()).getPosition("Favorite pizza 1st : Savoyarde"));
			spin2.setSelection(((ArrayAdapter<String>)spin1.getAdapter()).getPosition("Favorite pizza 1st : Cannibale"));
			spin3.setSelection(((ArrayAdapter<String>)spin1.getAdapter()).getPosition("Favorite pizza 1st : Orientale"));
			
		} else {
			
			Log.d("Mainmenu", "Unsuccessful login");
			
		}
		
	}
	
	public void logout(View view) {
		
		login.setText("Login");
		password.setText("password");
		nameSurname.setText("Name & Surname");
		street.setText("Street ...");
		city.setText("City ...");
		postalCode.setText("Postal code ...");
		phoneNumber.setText("Email");
		email.setText("Phone number");
		spin1.setSelection(((ArrayAdapter<String>)spin1.getAdapter()).getPosition("Favorite pizza 1st : Reine"));
		spin2.setSelection(((ArrayAdapter<String>)spin1.getAdapter()).getPosition("Favorite pizza 1st : Reine"));
		spin3.setSelection(((ArrayAdapter<String>)spin1.getAdapter()).getPosition("Favorite pizza 1st : Reine"));
		
	}
	
	public void localisation(View view) {

		GPSTracker gps = new GPSTracker(Config.this);

		if (gps.canGetLocation()) {

			double latitude = gps.getLatitude();
			double longitude = gps.getLongitude();

			Log.d("Mainmenu", "Latitude : " + latitude + " longitude : " + longitude);

			Geocoder geocoder;
			List<Address> addresses;
			geocoder = new Geocoder(this, Locale.getDefault());

			try {

				//REAL
				//addresses = geocoder.getFromLocation(latitude, longitude, 1);
				//AVD
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
