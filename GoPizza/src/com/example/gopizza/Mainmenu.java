package com.example.gopizza;

import android.app.Activity;
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

	public void buttonTopClick(View view) {

		startActivity(new Intent(Mainmenu.this, Pizzamenu.class));
		finish();

	}

}