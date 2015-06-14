package com.efrei.gopizza.services;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONParser {

	public Boolean JSONParserPizzas(String resultToParse) {

		new PizzasHandler();
		
		try {

			JSONObject json = new JSONObject(resultToParse);
			JSONObject dataObject = json.getJSONObject("data");
			
			JSONArray itemsD = dataObject.getJSONArray("dList");
			JSONArray itemsP = dataObject.getJSONArray("pList");
			JSONArray itemsQ = dataObject.getJSONArray("qList");
			
			for (int i = 0; i < itemsD.length(); i++) {

				JSONObject pizzaObject = itemsD.getJSONObject(i);
				
				Pizzas pizza = new Pizzas(pizzaObject.getInt("id"),
						pizzaObject.getString("n"), 
						pizzaObject.getInt("d"),
						pizzaObject.getInt("p"),
						pizzaObject.getInt("q"));
			
				PizzasHandler.disponibilityPizzaList.add(pizza);
			
			}
			
			for (int i = 0; i < itemsD.length(); i++) {

				JSONObject pizzaObject = itemsP.getJSONObject(i);
				
				Pizzas pizza = new Pizzas(pizzaObject.getInt("id"),
						pizzaObject.getString("n"), 
						pizzaObject.getInt("d"),
						pizzaObject.getInt("p"),
						pizzaObject.getInt("q"));
							
				PizzasHandler.pricePizzaList.add(pizza);
			
			}
			
			for (int i = 0; i < itemsD.length(); i++) {

				JSONObject pizzaObject = itemsQ.getJSONObject(i);
				
				Pizzas pizza = new Pizzas(pizzaObject.getInt("id"),
						pizzaObject.getString("n"), 
						pizzaObject.getInt("d"),
						pizzaObject.getInt("p"),
						pizzaObject.getInt("q"));

				PizzasHandler.qualityPizzaList.add(pizza);	
				
			}
			
			return true;

		} catch (JSONException e) {
			
			System.out.println(e);
			return false;
			
		}

	}

}
