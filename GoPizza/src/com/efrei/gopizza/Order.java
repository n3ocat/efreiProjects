package com.efrei.gopizza;

import com.example.gopizza.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;

public class Order extends Activity {
	
	private ImageButton bin1, bin2, bin3, bin4, bin5, bin6, bin7, bin8, bin9, buttonNext;
	private EditText pizza1, pizza2, pizza3, pizza4, pizza5, pizza6, pizza7, pizza8, pizza9, total;
	
	private int pizzasOrdered, totalOrder;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		// Enlever la title bar de l'application
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		super.onCreate(savedInstanceState);

		setContentView(R.layout.order_fullscreen);
		
		pizzasOrdered = Pizzamenu.pizzaOrderedList.size();
		
		buttonNext = (ImageButton)findViewById(R.id.next);
		buttonNext.setOnClickListener(nextButtonHandler);
		
		for (int i = 0; i < Pizzamenu.pizzaOrderedList.size(); i++) {
			totalOrder += Pizzamenu.pizzaOrderedList.get(i).getPrice();
		}
		
		pizza1 = (EditText)findViewById(R.id.EditPizza1);
		pizza2 = (EditText)findViewById(R.id.EditPizza2);
		pizza3 = (EditText)findViewById(R.id.EditPizza3);
		pizza4 = (EditText)findViewById(R.id.EditPizza4);
		pizza5 = (EditText)findViewById(R.id.EditPizza5);
		pizza6 = (EditText)findViewById(R.id.EditPizza6);
		pizza7 = (EditText)findViewById(R.id.EditPizza7);
		pizza8 = (EditText)findViewById(R.id.EditPizza8);
		pizza9 = (EditText)findViewById(R.id.EditPizza9);
		
		bin1 = (ImageButton)findViewById(R.id.bin1);
		bin2 = (ImageButton)findViewById(R.id.bin2);
		bin3 = (ImageButton)findViewById(R.id.bin3);
		bin4 = (ImageButton)findViewById(R.id.bin4);
		bin5 = (ImageButton)findViewById(R.id.bin5);
		bin6 = (ImageButton)findViewById(R.id.bin6);
		bin7 = (ImageButton)findViewById(R.id.bin7);
		bin8 = (ImageButton)findViewById(R.id.bin8);
		bin9 = (ImageButton)findViewById(R.id.bin9);
		
		total = (EditText)findViewById(R.id.total);
		total.setText(totalOrder + " €");
		
		switch (pizzasOrdered) {
    	
		case 1:
			
			pizza1.setText(Pizzamenu.pizzaOrderedList.get(0).getName() + " : " + Pizzamenu.pizzaOrderedList.get(0).getPrice() + " €");  
			
			pizza2.setVisibility(View.GONE);
			pizza3.setVisibility(View.GONE);
			pizza4.setVisibility(View.GONE);
			pizza5.setVisibility(View.GONE);
			pizza6.setVisibility(View.GONE);
			pizza7.setVisibility(View.GONE);
			pizza8.setVisibility(View.GONE);
			pizza9.setVisibility(View.GONE);
			
			bin2.setVisibility(View.GONE);
			bin3.setVisibility(View.GONE);
			bin4.setVisibility(View.GONE);
			bin5.setVisibility(View.GONE);
			bin6.setVisibility(View.GONE);
			bin7.setVisibility(View.GONE);
			bin8.setVisibility(View.GONE);
			bin9.setVisibility(View.GONE);
		
			bin1.setOnClickListener(bin1ButtonHandler);
			
			break;
    	
	    case 2:
	    	
			pizza1.setText(Pizzamenu.pizzaOrderedList.get(0).getName() + " : " + Pizzamenu.pizzaOrderedList.get(0).getPrice() + " €"); 
			pizza2.setText(Pizzamenu.pizzaOrderedList.get(1).getName() + " : " + Pizzamenu.pizzaOrderedList.get(1).getPrice() + " €");  
	    	
	    	pizza3.setVisibility(View.GONE);
			pizza4.setVisibility(View.GONE);
			pizza5.setVisibility(View.GONE);
			pizza6.setVisibility(View.GONE);
			pizza7.setVisibility(View.GONE);
			pizza8.setVisibility(View.GONE);
			pizza9.setVisibility(View.GONE);
			
			bin3.setVisibility(View.GONE);
			bin4.setVisibility(View.GONE);
			bin5.setVisibility(View.GONE);
			bin6.setVisibility(View.GONE);
			bin7.setVisibility(View.GONE);
			bin8.setVisibility(View.GONE);
			bin9.setVisibility(View.GONE);
			
			bin1.setOnClickListener(bin1ButtonHandler);
			bin2.setOnClickListener(bin2ButtonHandler);
			
			break;

		case 3:
			
			pizza1.setText(Pizzamenu.pizzaOrderedList.get(0).getName() + " : " + Pizzamenu.pizzaOrderedList.get(0).getPrice() + " €"); 
			pizza2.setText(Pizzamenu.pizzaOrderedList.get(1).getName() + " : " + Pizzamenu.pizzaOrderedList.get(1).getPrice() + " €");  
			pizza3.setText(Pizzamenu.pizzaOrderedList.get(2).getName() + " : " + Pizzamenu.pizzaOrderedList.get(2).getPrice() + " €");  
			
			pizza4.setVisibility(View.GONE);
			pizza5.setVisibility(View.GONE);
			pizza6.setVisibility(View.GONE);
			pizza7.setVisibility(View.GONE);
			pizza8.setVisibility(View.GONE);
			pizza9.setVisibility(View.GONE);
			
			bin4.setVisibility(View.GONE);
			bin5.setVisibility(View.GONE);
			bin6.setVisibility(View.GONE);
			bin7.setVisibility(View.GONE);
			bin8.setVisibility(View.GONE);
			bin9.setVisibility(View.GONE);
			
			bin1.setOnClickListener(bin1ButtonHandler);
			bin2.setOnClickListener(bin2ButtonHandler);
			bin3.setOnClickListener(bin3ButtonHandler);
			
			break;

		case 4:
			
			pizza1.setText(Pizzamenu.pizzaOrderedList.get(0).getName() + " : " + Pizzamenu.pizzaOrderedList.get(0).getPrice() + " €"); 
			pizza2.setText(Pizzamenu.pizzaOrderedList.get(1).getName() + " : " + Pizzamenu.pizzaOrderedList.get(1).getPrice() + " €");  
			pizza3.setText(Pizzamenu.pizzaOrderedList.get(2).getName() + " : " + Pizzamenu.pizzaOrderedList.get(2).getPrice() + " €");  
			pizza4.setText(Pizzamenu.pizzaOrderedList.get(3).getName() + " : " + Pizzamenu.pizzaOrderedList.get(3).getPrice() + " €");   
			
			pizza5.setVisibility(View.GONE);
			pizza6.setVisibility(View.GONE);
			pizza7.setVisibility(View.GONE);
			pizza8.setVisibility(View.GONE);
			pizza9.setVisibility(View.GONE);
			
			bin5.setVisibility(View.GONE);
			bin6.setVisibility(View.GONE);
			bin7.setVisibility(View.GONE);
			bin8.setVisibility(View.GONE);
			bin9.setVisibility(View.GONE);
			
			bin1.setOnClickListener(bin1ButtonHandler);
			bin2.setOnClickListener(bin2ButtonHandler);
			bin3.setOnClickListener(bin3ButtonHandler);
			bin4.setOnClickListener(bin4ButtonHandler);
			
			break;
		
		case 5:
			
			pizza1.setText(Pizzamenu.pizzaOrderedList.get(0).getName() + " : " + Pizzamenu.pizzaOrderedList.get(0).getPrice() + " €"); 
			pizza2.setText(Pizzamenu.pizzaOrderedList.get(1).getName() + " : " + Pizzamenu.pizzaOrderedList.get(1).getPrice() + " €");  
			pizza3.setText(Pizzamenu.pizzaOrderedList.get(2).getName() + " : " + Pizzamenu.pizzaOrderedList.get(2).getPrice() + " €");  
			pizza4.setText(Pizzamenu.pizzaOrderedList.get(3).getName() + " : " + Pizzamenu.pizzaOrderedList.get(3).getPrice() + " €");  
			pizza5.setText(Pizzamenu.pizzaOrderedList.get(4).getName() + " : " + Pizzamenu.pizzaOrderedList.get(4).getPrice() + " €");  
			
			pizza6.setVisibility(View.GONE);
			pizza7.setVisibility(View.GONE);
			pizza8.setVisibility(View.GONE);
			pizza9.setVisibility(View.GONE);
			
			bin6.setVisibility(View.GONE);
			bin7.setVisibility(View.GONE);
			bin8.setVisibility(View.GONE);
			bin9.setVisibility(View.GONE);
			
			bin1.setOnClickListener(bin1ButtonHandler);
			bin2.setOnClickListener(bin2ButtonHandler);
			bin3.setOnClickListener(bin3ButtonHandler);
			bin4.setOnClickListener(bin4ButtonHandler);
			bin5.setOnClickListener(bin5ButtonHandler);
			
			break;
		
		case 6:
			
			pizza1.setText(Pizzamenu.pizzaOrderedList.get(0).getName() + " : " + Pizzamenu.pizzaOrderedList.get(0).getPrice() + " €"); 
			pizza2.setText(Pizzamenu.pizzaOrderedList.get(1).getName() + " : " + Pizzamenu.pizzaOrderedList.get(1).getPrice() + " €");  
			pizza3.setText(Pizzamenu.pizzaOrderedList.get(2).getName() + " : " + Pizzamenu.pizzaOrderedList.get(2).getPrice() + " €");  
			pizza4.setText(Pizzamenu.pizzaOrderedList.get(3).getName() + " : " + Pizzamenu.pizzaOrderedList.get(3).getPrice() + " €");  
			pizza5.setText(Pizzamenu.pizzaOrderedList.get(4).getName() + " : " + Pizzamenu.pizzaOrderedList.get(4).getPrice() + " €");  
			pizza6.setText(Pizzamenu.pizzaOrderedList.get(5).getName() + " : " + Pizzamenu.pizzaOrderedList.get(5).getPrice() + " €");  

			pizza7.setVisibility(View.GONE);
			pizza8.setVisibility(View.GONE);
			pizza9.setVisibility(View.GONE);
			
			bin7.setVisibility(View.GONE);
			bin8.setVisibility(View.GONE);
			bin9.setVisibility(View.GONE);
			
			bin1.setOnClickListener(bin1ButtonHandler);
			bin2.setOnClickListener(bin2ButtonHandler);
			bin3.setOnClickListener(bin3ButtonHandler);
			bin4.setOnClickListener(bin4ButtonHandler);
			bin5.setOnClickListener(bin5ButtonHandler);
			bin6.setOnClickListener(bin6ButtonHandler);
			
			break;
				
		case 7:

			pizza1.setText(Pizzamenu.pizzaOrderedList.get(0).getName() + " : " + Pizzamenu.pizzaOrderedList.get(0).getPrice() + " €"); 
			pizza2.setText(Pizzamenu.pizzaOrderedList.get(1).getName() + " : " + Pizzamenu.pizzaOrderedList.get(1).getPrice() + " €");  
			pizza3.setText(Pizzamenu.pizzaOrderedList.get(2).getName() + " : " + Pizzamenu.pizzaOrderedList.get(2).getPrice() + " €");  
			pizza4.setText(Pizzamenu.pizzaOrderedList.get(3).getName() + " : " + Pizzamenu.pizzaOrderedList.get(3).getPrice() + " €");  
			pizza5.setText(Pizzamenu.pizzaOrderedList.get(4).getName() + " : " + Pizzamenu.pizzaOrderedList.get(4).getPrice() + " €");  
			pizza6.setText(Pizzamenu.pizzaOrderedList.get(5).getName() + " : " + Pizzamenu.pizzaOrderedList.get(5).getPrice() + " €");  
			pizza7.setText(Pizzamenu.pizzaOrderedList.get(6).getName() + " : " + Pizzamenu.pizzaOrderedList.get(6).getPrice() + " €");  
			
			pizza8.setVisibility(View.GONE);
			pizza9.setVisibility(View.GONE);
			
			bin8.setVisibility(View.GONE);
			bin9.setVisibility(View.GONE);
			
			bin1.setOnClickListener(bin1ButtonHandler);
			bin2.setOnClickListener(bin2ButtonHandler);
			bin3.setOnClickListener(bin3ButtonHandler);
			bin4.setOnClickListener(bin4ButtonHandler);
			bin5.setOnClickListener(bin5ButtonHandler);
			bin6.setOnClickListener(bin6ButtonHandler);
			bin7.setOnClickListener(bin7ButtonHandler);
			
			break;
					
		case 8:
			
			pizza1.setText(Pizzamenu.pizzaOrderedList.get(0).getName() + " : " + Pizzamenu.pizzaOrderedList.get(0).getPrice() + " €"); 
			pizza2.setText(Pizzamenu.pizzaOrderedList.get(1).getName() + " : " + Pizzamenu.pizzaOrderedList.get(1).getPrice() + " €");  
			pizza3.setText(Pizzamenu.pizzaOrderedList.get(2).getName() + " : " + Pizzamenu.pizzaOrderedList.get(2).getPrice() + " €");  
			pizza4.setText(Pizzamenu.pizzaOrderedList.get(3).getName() + " : " + Pizzamenu.pizzaOrderedList.get(3).getPrice() + " €");  
			pizza5.setText(Pizzamenu.pizzaOrderedList.get(4).getName() + " : " + Pizzamenu.pizzaOrderedList.get(4).getPrice() + " €");  
			pizza6.setText(Pizzamenu.pizzaOrderedList.get(5).getName() + " : " + Pizzamenu.pizzaOrderedList.get(5).getPrice() + " €");  
			pizza7.setText(Pizzamenu.pizzaOrderedList.get(6).getName() + " : " + Pizzamenu.pizzaOrderedList.get(6).getPrice() + " €");  
			pizza8.setText(Pizzamenu.pizzaOrderedList.get(7).getName() + " : " + Pizzamenu.pizzaOrderedList.get(7).getPrice() + " €");  
			
			pizza9.setVisibility(View.GONE);
			
			bin9.setVisibility(View.GONE);
			
			bin1.setOnClickListener(bin1ButtonHandler);
			bin2.setOnClickListener(bin2ButtonHandler);
			bin3.setOnClickListener(bin3ButtonHandler);
			bin4.setOnClickListener(bin4ButtonHandler);
			bin5.setOnClickListener(bin5ButtonHandler);
			bin6.setOnClickListener(bin6ButtonHandler);
			bin7.setOnClickListener(bin7ButtonHandler);
			bin8.setOnClickListener(bin8ButtonHandler);
			
			break;
					
		case 9:
			
			pizza1.setText(Pizzamenu.pizzaOrderedList.get(0).getName() + " : " + Pizzamenu.pizzaOrderedList.get(0).getPrice() + " €"); 
			pizza2.setText(Pizzamenu.pizzaOrderedList.get(1).getName() + " : " + Pizzamenu.pizzaOrderedList.get(1).getPrice() + " €");  
			pizza3.setText(Pizzamenu.pizzaOrderedList.get(2).getName() + " : " + Pizzamenu.pizzaOrderedList.get(2).getPrice() + " €");  
			pizza4.setText(Pizzamenu.pizzaOrderedList.get(3).getName() + " : " + Pizzamenu.pizzaOrderedList.get(3).getPrice() + " €");  
			pizza5.setText(Pizzamenu.pizzaOrderedList.get(4).getName() + " : " + Pizzamenu.pizzaOrderedList.get(4).getPrice() + " €");  
			pizza6.setText(Pizzamenu.pizzaOrderedList.get(5).getName() + " : " + Pizzamenu.pizzaOrderedList.get(5).getPrice() + " €");  
			pizza7.setText(Pizzamenu.pizzaOrderedList.get(6).getName() + " : " + Pizzamenu.pizzaOrderedList.get(6).getPrice() + " €");  
			pizza8.setText(Pizzamenu.pizzaOrderedList.get(7).getName() + " : " + Pizzamenu.pizzaOrderedList.get(7).getPrice() + " €");  
			pizza9.setText(Pizzamenu.pizzaOrderedList.get(8).getName() + " : " + Pizzamenu.pizzaOrderedList.get(8).getPrice() + " €");  
			
			bin1.setOnClickListener(bin1ButtonHandler);
			bin2.setOnClickListener(bin2ButtonHandler);
			bin3.setOnClickListener(bin3ButtonHandler);
			bin4.setOnClickListener(bin4ButtonHandler);
			bin5.setOnClickListener(bin5ButtonHandler);
			bin6.setOnClickListener(bin6ButtonHandler);
			bin7.setOnClickListener(bin7ButtonHandler);
			bin8.setOnClickListener(bin8ButtonHandler);
			bin9.setOnClickListener(bin9ButtonHandler);
			
			break;
			
		}

	}
	
	View.OnClickListener bin1ButtonHandler = new View.OnClickListener() {

	    public void onClick(View v) {
	    	
	    	Pizzamenu.pizzaOrderedList.remove(0);
	    	startActivity(new Intent(Order.this, Order.class));
	    	finish();
			
	    }
	    
	};
	
	View.OnClickListener bin2ButtonHandler = new View.OnClickListener() {

	    public void onClick(View v) {
	    	
	    	Pizzamenu.pizzaOrderedList.remove(1);
	    	startActivity(new Intent(Order.this, Order.class));
	    	finish();
	    	
	    }
	    
	};
	
	View.OnClickListener bin3ButtonHandler = new View.OnClickListener() {

	    public void onClick(View v) {
	    	
	    	Pizzamenu.pizzaOrderedList.remove(2);
	    	startActivity(new Intent(Order.this, Order.class));
	    	finish();
	    	
	    }
	    
	};
	
	View.OnClickListener bin4ButtonHandler = new View.OnClickListener() {

	    public void onClick(View v) {
	    	
	    	Pizzamenu.pizzaOrderedList.remove(3);
	    	startActivity(new Intent(Order.this, Order.class));
	    	finish();
	    	
	    }
	    
	};
	
	View.OnClickListener bin5ButtonHandler = new View.OnClickListener() {

	    public void onClick(View v) {
	    	
	    	Pizzamenu.pizzaOrderedList.remove(4);
	    	startActivity(new Intent(Order.this, Order.class));
	    	finish();
	    	
	    }
	    
	};
	
	View.OnClickListener bin6ButtonHandler = new View.OnClickListener() {

	    public void onClick(View v) {
	    	
	    	Pizzamenu.pizzaOrderedList.remove(5);
	    	startActivity(new Intent(Order.this, Order.class));
	    	finish();
	    	
	    }
	    
	};
	
	View.OnClickListener bin7ButtonHandler = new View.OnClickListener() {

	    public void onClick(View v) {
	    	
	    	Pizzamenu.pizzaOrderedList.remove(6);
	    	startActivity(new Intent(Order.this, Order.class));
	    	finish();
	    	
	    }
	    
	};
	
	View.OnClickListener bin8ButtonHandler = new View.OnClickListener() {

	    public void onClick(View v) {
	    	
	    	Pizzamenu.pizzaOrderedList.remove(7);
	    	startActivity(new Intent(Order.this, Order.class));
	    	finish();
	    	
	    }
	    
	};
	
	View.OnClickListener bin9ButtonHandler = new View.OnClickListener() {

	    public void onClick(View v) {
	    	
	    	Pizzamenu.pizzaOrderedList.remove(8);
	    	startActivity(new Intent(Order.this, Order.class));
	    	finish();
	    	
	    }
	    
	};
	
	View.OnClickListener nextButtonHandler = new View.OnClickListener() {

	    public void onClick(View v) {
	    	
	    	if (Pizzamenu.pizzaOrderedList.isEmpty()) {
				
			} else {
				
		    	startActivity(new Intent(Order.this, Payment.class));
				
			}

	    }
	    
	};

	
	@Override
	public void onBackPressed() {

		startActivity(new Intent(Order.this, Pizzamenu.class));
		finish();

	}

}
