package com.efrei.gopizza;

import com.example.gopizza.R;

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
	
	public void buttonBottomRightClick(View view) {

		startActivity(new Intent(Mainmenu.this, Info.class));
		finish();

	}
	
	public void buttonBottomLeftClick(View view) {

		startActivity(new Intent(Mainmenu.this, Config.class));
		finish();

	}

}
