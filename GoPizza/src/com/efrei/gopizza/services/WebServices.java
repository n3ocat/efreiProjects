package com.efrei.gopizza.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

@SuppressWarnings("deprecation")
public class WebServices {
	
	public static void main(String args[]) {
		
		WebServices ws = new WebServices();
		String result = ws.requestContent("48.7991088, 2.3649322");
		
		if (result!=null) {
			System.out.println("RESULT WS OK : " + result);
		} else {
			System.out.println("ERREUR WS KO !");
		}
		
		JSONParser jp = new JSONParser();
		if(jp.JSONParserPizzas(result)) {
			System.out.println("PARSEUR JSON OK");
		} else {
			System.out.println("PARSEUR JSON KO");
		}
		
		System.out.println("Liste disponibilite : ");

		for(int i = 0; i < PizzasHandler.disponibilityPizzaList.size(); i++) {
		  System.out.println(PizzasHandler.disponibilityPizzaList.get(i));
		}
		
		System.out.println("Liste prix : ");
		
		for(int i = 0; i < PizzasHandler.pricePizzaList.size(); i++) {
			  System.out.println(PizzasHandler.pricePizzaList.get(i));
		}
		
		System.out.println("Liste qualite : ");
		
		for(int i = 0; i < PizzasHandler.qualityPizzaList.size(); i++) {
			  System.out.println(PizzasHandler.qualityPizzaList.get(i));
		}
		
	}

	public String requestContent(String url) {
		
		HttpClient httpclient = new DefaultHttpClient();
		String result = null;
		HttpGet httpget = new HttpGet(url);
		HttpResponse response = null;
		InputStream instream = null;

		try {
			
			response = httpclient.execute(httpget);
			HttpEntity entity = response.getEntity();

			if (entity != null) {
				instream = entity.getContent();
				result = convertStreamToString(instream);
			}

		} catch (Exception e) {
			
			System.out.println(e);
			
		} finally {
			
			if (instream != null) {
				
				try {
					
					instream.close();
					
				} catch (Exception exc) {

				}
			}
		}

		return result;
	}

	public String convertStreamToString(InputStream is) {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();
		String line = null;

		try {
			
			while ((line = reader.readLine()) != null) {
				
				sb.append(line + "\n");
				
			}
			
		} catch (IOException e) {
			
		} finally {
			
			try {
				
				is.close();
				
			} catch (IOException e) {
				
			}
		}

		return sb.toString();
	}

}
