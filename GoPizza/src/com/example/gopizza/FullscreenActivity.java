package com.example.gopizza;

import java.util.Timer;
import java.util.TimerTask;

import com.example.gopizza.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see SystemUiHider
 */
public class FullscreenActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		// Enlever la title bar de l'application
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_fullscreen);
		
		final View contentView = findViewById(R.id.fullscreen_content);
		
		int secondsDelayed = 5;
        new Handler().postDelayed(new Runnable() {
                public void run() {
                        startActivity(new Intent(FullscreenActivity.this, Mainmenu.class));
                        finish();
                }
        }, secondsDelayed * 1000);

	}
	
}
