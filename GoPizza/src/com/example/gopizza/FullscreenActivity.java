package com.example.gopizza;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

public class FullscreenActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		// Enlever la title bar de l'application
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_fullscreen);

		int secondsDelayed = 5;
		new Handler().postDelayed(new Runnable() {
			public void run() {
				startActivity(new Intent(FullscreenActivity.this, Mainmenu.class));
				finish();
			}
		}, secondsDelayed * 1000);

	}

}
