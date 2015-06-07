package com.efrei.gopizza;

import com.example.gopizza.R;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnDragListener;
import android.view.View.OnTouchListener;
import android.view.Window;

public class Pizzamenu extends Activity implements OnTouchListener,	OnDragListener {

	private Boolean containsDragable = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		// Enlever la title bar de l'application
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		super.onCreate(savedInstanceState);

		setContentView(R.layout.pizzamenu_fullscreen);

		findViewById(R.id.pizzaSwap).setOnTouchListener(this);
		// findViewById(R.id.top_container).setOnDragListener(this);

	}

	public boolean onTouch(View view, MotionEvent motionEvent) {
		
		if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
			ClipData clipData = ClipData.newPlainText("", "");
			View.DragShadowBuilder dsb = new View.DragShadowBuilder(view);
			view.startDrag(clipData, dsb, view, 0);
			view.setVisibility(View.INVISIBLE);
			return true;
		} else {
			return false;
		}
		
	}

	@Override
	public boolean onDrag(View view, DragEvent dragEvent) {
		
		int dragAction = dragEvent.getAction();
		View dragView = (View) dragEvent.getLocalState();
		
		if (dragAction == DragEvent.ACTION_DRAG_EXITED) {
			containsDragable = false;
			
		} else if (dragAction == DragEvent.ACTION_DRAG_ENTERED) {
			containsDragable = true;
			
		} else if (dragAction == DragEvent.ACTION_DRAG_ENDED) {
			
			//if (dropEventNotHandled(dragEvent)) {
				dragView.setVisibility(View.VISIBLE);
			//}
			
		} else if (dragAction == DragEvent.ACTION_DROP && containsDragable) {
			//checkForValidMove((ChessBoardSquareLayoutView) view, dragView);
			dragView.setVisibility(View.VISIBLE);
		}
		
		return true;
		
	}

	private boolean dropEventNotHandled(DragEvent dragEvent) {
		return !dragEvent.getResult();
	}

	@Override
	public void onBackPressed() {

		startActivity(new Intent(Pizzamenu.this, Mainmenu.class));
		finish();

	}

}
