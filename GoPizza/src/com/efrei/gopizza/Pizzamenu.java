package com.efrei.gopizza;

import com.example.gopizza.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

public class Pizzamenu extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		// Enlever la title bar de l'application
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		super.onCreate(savedInstanceState);

		setContentView(R.layout.pizzamenu_fullscreen);

	}
	
	@Override
	public void onBackPressed() {
	   
		startActivity(new Intent(Pizzamenu.this, Mainmenu.class));
		finish();
		
	}

}
