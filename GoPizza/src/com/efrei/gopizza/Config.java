package com.efrei.gopizza;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import com.efrei.gopizza.services.GPSTracker;
import com.example.gopizza.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.preference.PreferenceManager;
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
	
	public static Boolean connected = false;
	
	private static final String loginSaved = "";
	private static final String passwordSaved = "";
	private static final String nameSurnameSaved = "";
	private static final String streetSaved = "";
	private static final String citySaved = "";
	private static final String postalCodeSaved = "";
	private static final String phoneNumberSaved = "";
	private static final String emailSaved = "";
	private static final String spin1Saved = "";
	private static final String spin2Saved = "";
	private static final String spin3Saved = "";
	
	SharedPreferences sharedPreferences;
	SharedPreferences.Editor editor;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		// Enlever la title bar de l'application
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		super.onCreate(savedInstanceState);

		setContentView(R.layout.config_fullscreen);
		
		sharedPreferences = getSharedPreferences("My_pref", Activity.MODE_PRIVATE);
		
		login = (EditText)findViewById(R.id.editTextLogin);
		login.setText(sharedPreferences.getString("loginSaved", "Login"));
		
		password = (EditText)findViewById(R.id.editTextPassword);
		password.setText("Password");
		
		nameSurname = (EditText)findViewById(R.id.editTextNameSurname);
		street = (EditText)findViewById(R.id.editTextStreet); 
		city = (EditText)findViewById(R.id.editTextCity); 
		postalCode = (EditText)findViewById(R.id.editTextPostalCode);
		phoneNumber = (EditText)findViewById(R.id.editTextPhoneNumber);
		email = (EditText)findViewById(R.id.editTextEmail);
		spin1 = (Spinner)findViewById(R.id.spinner1);
		spin2 = (Spinner)findViewById(R.id.spinner2);	
		spin3 = (Spinner)findViewById(R.id.spinner3);
		
		if (connected) {
			
			nameSurname.setText(sharedPreferences.getString("nameSurnameSaved", "Name & Surname"));
			street.setText(sharedPreferences.getString("streetSaved", "Street ..."));
			city.setText(sharedPreferences.getString("citySaved", "City ..."));
			postalCode.setText(sharedPreferences.getString("postalCodeSaved", "Postal code ..."));
			phoneNumber.setText(sharedPreferences.getString("phoneNumberSaved", "Email"));
			email.setText(sharedPreferences.getString("emailSaved", "Phone number"));
			spin1.setSelection(((ArrayAdapter<String>)spin1.getAdapter()).getPosition(sharedPreferences.getString("spin1Saved", "Favorite pizza 1st : Reine")));
			spin2.setSelection(((ArrayAdapter<String>)spin1.getAdapter()).getPosition(sharedPreferences.getString("spin2Saved", "Favorite pizza 1st : Reine")));
			spin3.setSelection(((ArrayAdapter<String>)spin1.getAdapter()).getPosition(sharedPreferences.getString("spin3Saved", "Favorite pizza 1st : Reine")));
			
		} else {
			
			nameSurname.setClickable(false);
			nameSurname.setEnabled(false);
			
			street.setClickable(false);
			street.setEnabled(false);
			
			city.setClickable(false);
			city.setEnabled(false);
			
			postalCode.setClickable(false);
			postalCode.setEnabled(false);
			
			phoneNumber.setClickable(false);
			phoneNumber.setEnabled(false);
			
			email.setClickable(false);
			email.setEnabled(false);
			
			spin1.setClickable(false);
			spin1.setEnabled(false);
			
			spin2.setClickable(false);
			spin2.setEnabled(false);
			
			spin3.setClickable(false);
			spin3.setEnabled(false);
			
		}
		
	}

	@Override
	public void onBackPressed() {

		startActivity(new Intent(Config.this, Mainmenu.class));
		finish();
		
	}
	
	public void addUser(View view) {
		
		if (login.getText().toString().equals("Login") || password.getText().toString().equals("Password")) {
			
				new AlertDialog.Builder(this)
				.setTitle("Connexion")
			    .setMessage("You cannot create an user with Login or Password entries =(")
			    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
			        public void onClick(DialogInterface dialog, int which) { 
			            // continue with delete
			        }
			     })
			    .setIcon(android.R.drawable.ic_dialog_alert)
			    .show();
				
		} else if(connected) {
			
			new AlertDialog.Builder(this)
			.setTitle("Connexion")
		    .setMessage("You cannot add an user when connected =(")
		    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) { 
		            // continue with delete
		        }
		     })
		    .setIcon(android.R.drawable.ic_dialog_alert)
		    .show();
		
		} else {
		
			sharedPreferences = getSharedPreferences("My_pref", Activity.MODE_PRIVATE);
			editor = sharedPreferences.edit();
			editor.putString("loginSaved", login.getText().toString());
			editor.putString("passwordSaved", password.getText().toString());
			editor.putString("nameSurnameSaved", "Name & Surname");
			editor.putString("streetSaved", "Street ...");
			editor.putString("citySaved", "City ...");
			editor.putString("postalCodeSaved", "Postal code ...");
			editor.putString("phoneNumberSaved", "Phone number");
			editor.putString("emailSaved", "Email");
			editor.putString("spin1Saved", "Favorite pizza 1st : Reine");
			editor.putString("spin2Saved", "Favorite pizza 2nd : Reine");
			editor.putString("spin3Saved", "Favorite pizza 3th : Reine");
			
			editor.commit();
			
			nameSurname.setText("Name & Surname");
			street.setText("Street ...");
			city.setText("City ...");
			postalCode.setText("Postal code ...");
			phoneNumber.setText("Phone number");
			email.setText("Email");
			spin1.setSelection(((ArrayAdapter<String>)spin1.getAdapter()).getPosition("Favorite pizza 1st : Reine"));
			spin2.setSelection(((ArrayAdapter<String>)spin1.getAdapter()).getPosition("Favorite pizza 1st : Reine"));
			spin3.setSelection(((ArrayAdapter<String>)spin1.getAdapter()).getPosition("Favorite pizza 1st : Reine"));
			
			Log.d("Mainmenu", "User added");
			
			new AlertDialog.Builder(this)
			.setTitle("Connexion")
		    .setMessage("Successful user creation =)")
		    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) { 
		            // continue with delete
		        }
		     })
		    .setIcon(android.R.drawable.ic_dialog_alert)
		    .show();
		
		}
		
	}

	public void login(View view) {
		
		if (connected) {
			
			new AlertDialog.Builder(this)
			.setTitle("Connexion")
		    .setMessage("You are already connected =)")
		    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) { 
		            // continue with delete
		        }
		     })
		    .setIcon(android.R.drawable.ic_dialog_alert)
		    .show();
			
		} else if(sharedPreferences.getString("loginSaved", "Login").equals(login.getText().toString())  && sharedPreferences.getString("passwordSaved", "Password").equals(password.getText().toString())) {
			
			Log.d("Mainmenu", "Successful login");
			
			connected = true;
			
			new AlertDialog.Builder(this)
			.setTitle("Connexion")
		    .setMessage("Successful login =)")
		    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) { 
		            // continue with delete
		        }
		     })
		    .setIcon(android.R.drawable.ic_dialog_alert)
		    .show();
			
			nameSurname.setClickable(true);
			nameSurname.setEnabled(true);
			
			street.setClickable(true);
			street.setEnabled(true);
			
			city.setClickable(true);
			city.setEnabled(true);
			
			postalCode.setClickable(true);
			postalCode.setEnabled(true);
			
			phoneNumber.setClickable(true);
			phoneNumber.setEnabled(true);
			
			email.setClickable(true);
			email.setEnabled(true);
			
			spin1.setClickable(true);
			spin1.setEnabled(true);
			
			spin2.setClickable(true);
			spin2.setEnabled(true);
			
			spin3.setClickable(true);
			spin3.setEnabled(true);
			
			nameSurname.setText(sharedPreferences.getString("nameSurnameSaved", "Name & Surname"));
			street.setText(sharedPreferences.getString("streetSaved", "Street ..."));
			city.setText(sharedPreferences.getString("citySaved", "City ..."));
			postalCode.setText(sharedPreferences.getString("postalCodeSaved", "Postal code ..."));
			phoneNumber.setText(sharedPreferences.getString("phoneNumberSaved", "Email"));
			email.setText(sharedPreferences.getString("emailSaved", "Phone number"));
			spin1.setSelection(((ArrayAdapter<String>)spin1.getAdapter()).getPosition(sharedPreferences.getString("spin1Saved", "Favorite pizza 1st : Reine")));
			spin2.setSelection(((ArrayAdapter<String>)spin1.getAdapter()).getPosition(sharedPreferences.getString("spin2Saved", "Favorite pizza 1st : Reine")));
			spin3.setSelection(((ArrayAdapter<String>)spin1.getAdapter()).getPosition(sharedPreferences.getString("spin3Saved", "Favorite pizza 1st : Reine")));
			
		} else {
			
			Log.d("Mainmenu", "Unsuccessful login");
			
			new AlertDialog.Builder(this)
			.setTitle("Connexion")
		    .setMessage("Unsuccessful login =(")
		    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) { 
		            // continue with delete
		        }
		     })
		    .setIcon(android.R.drawable.ic_dialog_alert)
		    .show();
			
		}
		
	}
	
	public void save(View view) {
		
		if (!connected) {
			
			new AlertDialog.Builder(this)
			.setTitle("Connexion")
		    .setMessage("You cannot save when you are not connected =(")
		    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) { 
		            // continue with delete
		        }
		     })
		    .setIcon(android.R.drawable.ic_dialog_alert)
		    .show();
			
		} else {
		
			sharedPreferences = getSharedPreferences("My_pref", Activity.MODE_PRIVATE);
			editor = sharedPreferences.edit();
			
			editor.putString("nameSurnameSaved", nameSurname.getText().toString());
			editor.putString("streetSaved", street.getText().toString());
			editor.putString("citySaved", city.getText().toString());
			editor.putString("postalCodeSaved", postalCode.getText().toString());
			editor.putString("phoneNumberSaved", phoneNumber.getText().toString());
			editor.putString("emailSaved", email.getText().toString());
			editor.putString("spin1Saved", spin1.getSelectedItem().toString());
			editor.putString("spin2Saved", spin2.getSelectedItem().toString());
			editor.putString("spin3Saved", spin3.getSelectedItem().toString());
			
			editor.commit();
			
			new AlertDialog.Builder(this)
			.setTitle("Backup")
		    .setMessage("Your datas are saved =)")
		    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) { 
		            // continue with delete
		        }
		     })
		    .setIcon(android.R.drawable.ic_dialog_alert)
		    .show();
		
		}
		
	}
	
	public void logout(View view) {
		
		connected = false;
		
		login.setText("Login");
		password.setText("password");
		nameSurname.setText("Name & Surname");
		street.setText("Street ...");
		city.setText("City ...");
		postalCode.setText("Postal code ...");
		phoneNumber.setText("Phone number");
		email.setText("Email");
		spin1.setSelection(((ArrayAdapter<String>)spin1.getAdapter()).getPosition("Favorite pizza 1st : Reine"));
		spin2.setSelection(((ArrayAdapter<String>)spin1.getAdapter()).getPosition("Favorite pizza 2nd : Reine"));
		spin3.setSelection(((ArrayAdapter<String>)spin1.getAdapter()).getPosition("Favorite pizza 3th : Reine"));
		
		nameSurname.setClickable(false);
		nameSurname.setEnabled(false);
		
		street.setClickable(false);
		street.setEnabled(false);
		
		city.setClickable(false);
		city.setEnabled(false);
		
		postalCode.setClickable(false);
		postalCode.setEnabled(false);
		
		phoneNumber.setClickable(false);
		phoneNumber.setEnabled(false);
		
		email.setClickable(false);
		email.setEnabled(false);
		
		spin1.setClickable(false);
		spin1.setEnabled(false);
		
		spin2.setClickable(false);
		spin2.setEnabled(false);
		
		spin3.setClickable(false);
		spin3.setEnabled(false);
		
	}
	
	public void localisation(View view) {
		
		if (!connected) {
			
			new AlertDialog.Builder(this)
			.setTitle("Connexion")
		    .setMessage("You cannot locate yourself when you are not connected =(")
		    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) { 
		            // continue with delete
		        }
		     })
		    .setIcon(android.R.drawable.ic_dialog_alert)
		    .show();
			
		} else {

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

}
