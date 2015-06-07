package com.efrei.gopizza.services;

public class Pizzas {
	
	private int id, disponibility, price, quality;
	private String name;
	
	public Pizzas(int i, String n, int d, int p, int q) {
		
		id = i;
		name = n;
		disponibility = d;
		price = p;
		quality = q;
		
	}

	public int getId() {
		return id;
	}

	public int getDisponibility() {
		return disponibility;
	}

	public int getPrice() {
		return price;
	}

	public int getQuality() {
		return quality;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Pizza [id=" + id + ", disponibility=" + disponibility	+ ", price=" + price + ", quality=" + quality + ", name=" + name + "]";
	}

}
