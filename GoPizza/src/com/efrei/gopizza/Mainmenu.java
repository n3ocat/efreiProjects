package com.efrei.gopizza;

import com.example.gopizza.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class Mainmenu extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		// Enlever la title bar de l'application
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		super.onCreate(savedInstanceState);

		setContentView(R.layout.mainmenu_fullscreen);

	}

	public void fastPizza(View pressed) {
		
		if (!Config.connected) {
			
			new AlertDialog.Builder(this)
			.setTitle("Mainmenu")
		    .setMessage("You have to be connected =(")
		    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) { 
		            // continue with delete
		        }
		     })
		    .setIcon(android.R.drawable.ic_dialog_alert)
		    .show();
			
		} else {

			Payment.fastMode = true;
			startActivity(new Intent(Mainmenu.this, Payment.class));
			finish();
		
		}
		
	}
	
	public void buttonTopClick(View view) {

		if (!Config.connected) {
			
			new AlertDialog.Builder(this)
			.setTitle("Mainmenu")
		    .setMessage("You have to be connected =(")
		    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) { 
		            // continue with delete
		        }
		     })
		    .setIcon(android.R.drawable.ic_dialog_alert)
		    .show();
			
		} else {
			
			startActivity(new Intent(Mainmenu.this, Pizzamenu.class));
			finish();
			
		}

	}
	
	public void buttonBottomRightClick(View view) {

		startActivity(new Intent(Mainmenu.this, Info.class));
		finish();

	}
	
	public void buttonBottomLeftClick(View view) {

		startActivity(new Intent(Mainmenu.this, Config.class));
		finish();

	}

}
