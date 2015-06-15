package com.efrei.gopizza;

import java.util.ArrayList;

import com.efrei.gopizza.services.Pizzas;
import com.example.gopizza.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;

public class Pizzamenu extends Activity {
	
	ImageButton buttonDispoFilter, buttonPriceFilter, buttonQualityFilter, buttonSwipeLeft, buttonSwipeRight, buttonPizzaSwipe, buttonSmallPizza, buttonMediumPizza, buttonLargePizza, buttonBin, buttonNext, buttonOrder;
	Boolean buttonDispoFilterOn = true, buttonPriceFilterOn = false, buttonQualityFilterOn = false, buttonSmallPizzaOn = false, buttonMediumPizzaOn = true, buttonLargePizzaOn = false;
	boolean forestiereVerbose = false, margheritaVerbose = false, quatrefromagesVerbose = false, reineVerbose = false, saumonetaVerbose = false, indienneVerbose = false, savoyardeVerbose = false, cannibaleVerbose = false, orientaleVerbose = false;
	EditText textPizzaName, textProximity, textPrice, textQuality, textOrderedPizza;
	ArrayList<Pizzas> pizzaList = new ArrayList<Pizzas>();
	ArrayList<Pizzas> pizzaOrderedList = new ArrayList<Pizzas>();
	int actualPizza = 0;
	int maxPizza = 8;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		// Enlever la title bar de l'application
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		super.onCreate(savedInstanceState);

		setContentView(R.layout.pizzamenu_fullscreen);
		
		Pizzas forestiere = new Pizzas(R.drawable.forestiere, "forestiere", 5, 8, 4);
		Pizzas margherita = new Pizzas(R.drawable.margherita, "margherita", 5, 7, 2);
		Pizzas quatrefromage = new Pizzas(R.drawable.quatrefromages, "quatrefromages", 6, 9, 4);
		Pizzas reine = new Pizzas(R.drawable.reine, "reine", 6, 9, 5);
		Pizzas saumoneta = new Pizzas(R.drawable.saumoneta, "saumoneta", 7, 11, 3);
		Pizzas indienne = new Pizzas(R.drawable.indienne, "indienne", 7, 9, 3);
		Pizzas savoyarde = new Pizzas(R.drawable.savoyarde, "savoyarde", 8, 12, 4);
		Pizzas cannibale = new Pizzas(R.drawable.cannibale, "cannibale", 10, 11, 3);
		Pizzas orientale = new Pizzas(R.drawable.orientale, "orientale", 12, 10, 2);
		
		pizzaList.add(forestiere);
		pizzaList.add(margherita);
		pizzaList.add(quatrefromage);
		pizzaList.add(reine);
		pizzaList.add(saumoneta);
		pizzaList.add(indienne);
		pizzaList.add(savoyarde);
		pizzaList.add(cannibale);
		pizzaList.add(orientale);	
		
		buttonDispoFilter = (ImageButton)findViewById(R.id.dispoFilter);
		buttonDispoFilter.setOnClickListener(dispoButtonHandler);
		
		buttonPriceFilter = (ImageButton)findViewById(R.id.priceFiter);
		buttonPriceFilter.setOnClickListener(priceButtonHandler);
		
		buttonQualityFilter = (ImageButton)findViewById(R.id.qualityFilter);
		buttonQualityFilter.setOnClickListener(qualityButtonHandler);
		
		buttonSwipeLeft = (ImageButton)findViewById(R.id.swipeLeft);
		buttonSwipeLeft.setOnClickListener(swipeLeftButtonHandler);
		
		buttonSwipeRight = (ImageButton)findViewById(R.id.swipeRight);
		buttonSwipeRight.setOnClickListener(swipeRightButtonHandler);
		
		buttonPizzaSwipe = (ImageButton)findViewById(R.id.pizzaSwap);
		buttonPizzaSwipe.setBackgroundResource(pizzaList.get(actualPizza).getId());
		buttonPizzaSwipe.setOnClickListener(pizzaSwipeButtonHandler);
		
		buttonSmallPizza = (ImageButton)findViewById(R.id.smallPizza);
		buttonSmallPizza.setOnClickListener(smallPizzaButtonHandler);
		
		buttonMediumPizza = (ImageButton)findViewById(R.id.mediumPizza);
		buttonMediumPizza.setOnClickListener(mediumPizzaButtonHandler);
		
		buttonLargePizza = (ImageButton)findViewById(R.id.largePizza);
		buttonLargePizza.setOnClickListener(largePizzaButtonHandler);
		
		buttonBin = (ImageButton)findViewById(R.id.bin);
		buttonBin.setOnClickListener(binButtonHandler);
		
		buttonNext = (ImageButton)findViewById(R.id.next);
		buttonNext.setOnClickListener(nextButtonHandler);
		
		buttonOrder = (ImageButton)findViewById(R.id.order);
		buttonOrder.setOnClickListener(orderButtonHandler);
		
		textPizzaName = (EditText)findViewById(R.id.EditTextPizzaName);
		textProximity = (EditText)findViewById(R.id.EditTextProximity);
		textPrice = (EditText)findViewById(R.id.EditTextPrice);
		textQuality = (EditText)findViewById(R.id.EditTextQuality);
		textOrderedPizza = (EditText)findViewById(R.id.EditTextOrderedPizza);
		
		proximityPriceQualitySynchronize();

	}

	View.OnClickListener dispoButtonHandler = new View.OnClickListener() {

	    public void onClick(View v) {
	    	
	    	buttonDispoFilterOn = !buttonDispoFilterOn;
	    	
	    	if (buttonDispoFilterOn) {
	    		buttonDispoFilter.setBackgroundResource(R.drawable.proximityon);
	    		buttonPriceFilter.setBackgroundResource(R.drawable.euro);
	    		buttonQualityFilter.setBackgroundResource(R.drawable.quality);
			} 
	    	
	    	pizzaList.removeAll(pizzaList);
	    	
			Pizzas forestiere = new Pizzas(R.drawable.forestiere, "forestiere", 5, 8, 4);
			Pizzas margherita = new Pizzas(R.drawable.margherita, "margherita", 5, 7, 2);
			Pizzas quatrefromage = new Pizzas(R.drawable.quatrefromages, "quatrefromages", 6, 9, 4);
			Pizzas reine = new Pizzas(R.drawable.reine, "reine", 6, 9, 5);
			Pizzas saumoneta = new Pizzas(R.drawable.saumoneta, "saumoneta", 7, 11, 3);
			Pizzas indienne = new Pizzas(R.drawable.indienne, "indienne", 7, 9, 3);
			Pizzas savoyarde = new Pizzas(R.drawable.savoyarde, "savoyarde", 8, 12, 4);
			Pizzas cannibale = new Pizzas(R.drawable.cannibale, "cannibale", 10, 11, 3);
			Pizzas orientale = new Pizzas(R.drawable.orientale, "orientale", 12, 10, 2);
			
			pizzaList.add(forestiere);
			pizzaList.add(margherita);
			pizzaList.add(quatrefromage);
			pizzaList.add(reine);
			pizzaList.add(saumoneta);
			pizzaList.add(indienne);
			pizzaList.add(savoyarde);
			pizzaList.add(cannibale);
			pizzaList.add(orientale);	
			
			actualPizza = 0;
			
			buttonPizzaSwipe = (ImageButton)findViewById(R.id.pizzaSwap);
			buttonPizzaSwipe.setBackgroundResource(pizzaList.get(actualPizza).getId());
			
			proximityPriceQualitySynchronize();
			
	    }
	    
	};
	
	View.OnClickListener priceButtonHandler = new View.OnClickListener() {

	    public void onClick(View v) {
	    	
	    	buttonPriceFilterOn = !buttonPriceFilterOn;
	    	
	    	if (buttonPriceFilterOn) {
	    		buttonDispoFilter.setBackgroundResource(R.drawable.proximity);
	    		buttonPriceFilter.setBackgroundResource(R.drawable.euroon);
	    		buttonQualityFilter.setBackgroundResource(R.drawable.quality);
			}
	    	
	    	pizzaList.removeAll(pizzaList);
	    	
			Pizzas margherita = new Pizzas(R.drawable.margherita, "margherita", 5, 7, 2);
			Pizzas forestiere = new Pizzas(R.drawable.forestiere, "forestiere", 5, 8, 4);
			Pizzas quatrefromage = new Pizzas(R.drawable.quatrefromages, "quatrefromages", 6, 9, 4);
			Pizzas reine = new Pizzas(R.drawable.reine, "reine", 6, 9, 5);
			Pizzas indienne = new Pizzas(R.drawable.indienne, "indienne", 7, 9, 3);
			Pizzas orientale = new Pizzas(R.drawable.orientale, "orientale", 12, 10, 2);
			Pizzas saumoneta = new Pizzas(R.drawable.saumoneta, "saumoneta", 7, 11, 3);
			Pizzas cannibale = new Pizzas(R.drawable.cannibale, "cannibale", 10, 11, 3);
			Pizzas savoyarde = new Pizzas(R.drawable.savoyarde, "savoyarde", 8, 12, 4);
	    	
			pizzaList.add(margherita);
			pizzaList.add(forestiere);
			pizzaList.add(quatrefromage);
			pizzaList.add(reine);
			pizzaList.add(indienne);
			pizzaList.add(orientale);
			pizzaList.add(saumoneta);
			pizzaList.add(cannibale);
			pizzaList.add(savoyarde);
			
			actualPizza = 0;
			
			buttonPizzaSwipe = (ImageButton)findViewById(R.id.pizzaSwap);
			buttonPizzaSwipe.setBackgroundResource(pizzaList.get(actualPizza).getId());
			
			proximityPriceQualitySynchronize();
	    	
	    }
	    
	};

	View.OnClickListener qualityButtonHandler = new View.OnClickListener() {

	    public void onClick(View v) {
	    	
	    	buttonQualityFilterOn = !buttonQualityFilterOn;
	    	
	    	if (buttonQualityFilterOn) {
	    		buttonDispoFilter.setBackgroundResource(R.drawable.proximity);
	    		buttonPriceFilter.setBackgroundResource(R.drawable.euro);
	    		buttonQualityFilter.setBackgroundResource(R.drawable.qualityon);
			} 
	    	
	    	pizzaList.removeAll(pizzaList);
	    	
			Pizzas reine = new Pizzas(R.drawable.reine, "reine", 6, 9, 5);
			Pizzas quatrefromage = new Pizzas(R.drawable.quatrefromages, "quatrefromages", 6, 9, 4);
			Pizzas forestiere = new Pizzas(R.drawable.forestiere, "forestiere", 5, 8, 4);
			Pizzas savoyarde = new Pizzas(R.drawable.savoyarde, "savoyarde", 8, 12, 4);
			Pizzas saumoneta = new Pizzas(R.drawable.saumoneta, "saumoneta", 7, 11, 3);
			Pizzas indienne = new Pizzas(R.drawable.indienne, "indienne", 7, 9, 3);
			Pizzas cannibale = new Pizzas(R.drawable.cannibale, "cannibale", 10, 11, 3);
			Pizzas orientale = new Pizzas(R.drawable.orientale, "orientale", 12, 10, 2);
			Pizzas margherita = new Pizzas(R.drawable.margherita, "margherita", 5, 7, 2);
		    
			pizzaList.add(reine);
			pizzaList.add(quatrefromage);
			pizzaList.add(forestiere);
			pizzaList.add(savoyarde);
			pizzaList.add(saumoneta);
			pizzaList.add(indienne);
			pizzaList.add(cannibale);
			pizzaList.add(orientale);
			pizzaList.add(margherita);
			
			actualPizza = 0;
			
			buttonPizzaSwipe = (ImageButton)findViewById(R.id.pizzaSwap);
			buttonPizzaSwipe.setBackgroundResource(pizzaList.get(actualPizza).getId());
			
			proximityPriceQualitySynchronize();
			 	
	    }
	    
	};

	View.OnClickListener swipeLeftButtonHandler = new View.OnClickListener() {

	    public void onClick(View v) {
	    	
	    	actualPizza--;
			if(actualPizza <= 0) {
				actualPizza = maxPizza;
			}
			
	    	buttonPizzaSwipe.setBackgroundResource(pizzaList.get(actualPizza).getId());
	    	proximityPriceQualitySynchronize();

		} 
	    
	};
	
	View.OnClickListener swipeRightButtonHandler = new View.OnClickListener() {

		public void onClick(View v) {
	    	
			actualPizza++;
			if(actualPizza > maxPizza) {
				actualPizza = 0;
			}
			
			buttonPizzaSwipe.setBackgroundResource(pizzaList.get(actualPizza).getId());
			proximityPriceQualitySynchronize();
			
		} 
    
	};
	
	View.OnClickListener smallPizzaButtonHandler = new View.OnClickListener() {

	    public void onClick(View v) {
	    	
	    	buttonSmallPizzaOn = true;
	    	buttonMediumPizzaOn = false;
	    	buttonLargePizzaOn = false;
	    	
	    	if (buttonSmallPizzaOn) {
	    		buttonSmallPizza.setBackgroundResource(R.drawable.pizzaon);
	    		buttonMediumPizza.setBackgroundResource(R.drawable.pizza);
	    		buttonLargePizza.setBackgroundResource(R.drawable.pizza);
			} 
	    	
	    	proximityPriceQualitySynchronize();
	    	
	    }
	    
	};
	
	View.OnClickListener mediumPizzaButtonHandler = new View.OnClickListener() {

	    public void onClick(View v) {
	    	
	    	buttonSmallPizzaOn = false;
	    	buttonMediumPizzaOn = true;
	    	buttonLargePizzaOn = false;
	    	
	    	if (buttonMediumPizzaOn) {
	    		buttonSmallPizza.setBackgroundResource(R.drawable.pizza);
	    		buttonMediumPizza.setBackgroundResource(R.drawable.pizzaon);
	    		buttonLargePizza.setBackgroundResource(R.drawable.pizza);
			} 
	    	
	    	proximityPriceQualitySynchronize();
	    	
	    }
	    
	};
	
	View.OnClickListener largePizzaButtonHandler = new View.OnClickListener() {

	    public void onClick(View v) {
	    	
	    	buttonSmallPizzaOn = false;
	    	buttonMediumPizzaOn = false;
	    	buttonLargePizzaOn = true;
	    	
	    	if (buttonLargePizzaOn) {
	    		buttonSmallPizza.setBackgroundResource(R.drawable.pizza);
	    		buttonMediumPizza.setBackgroundResource(R.drawable.pizza);
	    		buttonLargePizza.setBackgroundResource(R.drawable.pizzaon);
			} 
	    	
	    	proximityPriceQualitySynchronize();
	    	
	    }
	    
	};
	
	View.OnClickListener binButtonHandler = new View.OnClickListener() {

	    public void onClick(View v) {
	    	
	    	if (maxPizza - 1 == 0) {
				
			} else {
				
		    	pizzaList.remove(actualPizza);
		    	
		    	maxPizza--;
		    	
				if(actualPizza > maxPizza) {
					actualPizza = 0;
				}
		    	
		    	buttonPizzaSwipe.setBackgroundResource(pizzaList.get(actualPizza).getId());
				proximityPriceQualitySynchronize();
				
			}
			
	    }
	    
	};
	
	View.OnClickListener nextButtonHandler = new View.OnClickListener() {

	    public void onClick(View v) {
	    	
	    	
	    	
	    }
	    
	};
	
	View.OnClickListener orderButtonHandler = new View.OnClickListener() {

	    public void onClick(View v) {
	  
	    	if(pizzaOrderedList.size() > 8){
	    		
	    	} else {
	    		
		    	pizzaOrderedList.add(pizzaList.get(actualPizza));
		    	textOrderedPizza.setText("" + pizzaOrderedList.size());
	    		
	    	}
	    	
	    }
	    
	};
	
	View.OnClickListener pizzaSwipeButtonHandler = new View.OnClickListener() {

	    public void onClick(View v) {
	    	
	    	switch (pizzaList.get(actualPizza).getName()) {
	    	
			case "forestiere":
				
				forestiereVerbose = !forestiereVerbose;
				if (forestiereVerbose) {
					buttonPizzaSwipe.setBackgroundResource(R.drawable.forestiere_m);
				} else {
					buttonPizzaSwipe.setBackgroundResource(R.drawable.forestiere);
				}
				
				break;
	    	
		    case "margherita":
				
		    	margheritaVerbose = !margheritaVerbose;
				if (margheritaVerbose) {
					buttonPizzaSwipe.setBackgroundResource(R.drawable.margherita_m);
				} else {
					buttonPizzaSwipe.setBackgroundResource(R.drawable.margherita);
				}
				
				break;

			case "quatrefromages":
				
				quatrefromagesVerbose = !quatrefromagesVerbose;
				if (quatrefromagesVerbose) {
					buttonPizzaSwipe.setBackgroundResource(R.drawable.quatrefromages_m);
				} else {
					buttonPizzaSwipe.setBackgroundResource(R.drawable.quatrefromages);
				}
				
				break;
	
			case "reine":
				
				reineVerbose = !reineVerbose;
				if (reineVerbose) {
					buttonPizzaSwipe.setBackgroundResource(R.drawable.reine_m);
				} else {
					buttonPizzaSwipe.setBackgroundResource(R.drawable.reine);
				}
				
				break;
			
			case "saumoneta":
				
				saumonetaVerbose = !saumonetaVerbose;
				if (saumonetaVerbose) {
					buttonPizzaSwipe.setBackgroundResource(R.drawable.saumoneta_m);
				} else {
					buttonPizzaSwipe.setBackgroundResource(R.drawable.saumoneta);
				}
				
				break;
			
			case "indienne":
							
				indienneVerbose = !indienneVerbose;
				if (indienneVerbose) {
					buttonPizzaSwipe.setBackgroundResource(R.drawable.indienne_m);
				} else {
					buttonPizzaSwipe.setBackgroundResource(R.drawable.indienne);
				}
				
				break;
					
			case "savoyarde":
				
				savoyardeVerbose = !savoyardeVerbose;
				if (savoyardeVerbose) {
					buttonPizzaSwipe.setBackgroundResource(R.drawable.savoyarde_m);
				} else {
					buttonPizzaSwipe.setBackgroundResource(R.drawable.savoyarde);
				}
				
				break;
						
			case "cannibale":
				
				cannibaleVerbose = !cannibaleVerbose;
				if (cannibaleVerbose) {
					buttonPizzaSwipe.setBackgroundResource(R.drawable.cannibale_m);
				} else {
					buttonPizzaSwipe.setBackgroundResource(R.drawable.cannibale);
				}
				
				break;
						
			case "orientale":
				
				orientaleVerbose = !orientaleVerbose;
				if (orientaleVerbose) {
					buttonPizzaSwipe.setBackgroundResource(R.drawable.orientale_m);
				} else {
					buttonPizzaSwipe.setBackgroundResource(R.drawable.orientale);
				}
				
				break;
				
			}
	    	
	    }
	    
	    public void verboseMode(String drawable) {
	    	
	    }
	    
	};
	
	public void proximityPriceQualitySynchronize() {
		
		textPizzaName.setText("" + pizzaList.get(actualPizza).getName());
		textProximity.setText("" + pizzaList.get(actualPizza).getDisponibility());
		int price = pizzaList.get(actualPizza).getPrice();
		if (buttonLargePizzaOn) {
			price += 2;
			textPrice.setText("" + price);
		} else if (buttonSmallPizzaOn) {
			price -=1;
			textPrice.setText("" + price);
		} else if (buttonMediumPizzaOn){
			textPrice.setText("" + price);
		}
		textQuality.setText("" + pizzaList.get(actualPizza).getQuality());
		
	}
	
	@Override
	public void onBackPressed() {

		startActivity(new Intent(Pizzamenu.this, Mainmenu.class));
		finish();

	}

}
