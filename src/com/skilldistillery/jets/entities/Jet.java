package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Jet {
	
	protected String name;
	private String model;
	protected int  topSpeedMph;
	protected int rangeInMiles;
	protected double priceInDollars;
	
	
	public Jet(String name, String model, int topSpeedMph, int rangeInMiles, double priceInDollars) {
		this.name = name;
		this.model = model;
		this.topSpeedMph = topSpeedMph;
		this.rangeInMiles = rangeInMiles;
		this.priceInDollars = priceInDollars;
		
		
	}
	
	public abstract void  fly (); 
			
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getTopSpeed() {
		return topSpeedMph;
	}

	public void setTopSpeed(int topSpeedMph) {
		this.topSpeedMph = topSpeedMph;
	}

	public int getRange() {
		return rangeInMiles;
	}

	public void setRange(int rangeInMiles) {
		this.rangeInMiles = rangeInMiles;
	}

	public double getPrice() {
		return priceInDollars;
	}

	public void setPrice(double priceInDollars) {
		this.priceInDollars = priceInDollars;
	}

	@Override
	public String toString() {
		return "Jet [name: " + name + ", model: " + model + ", topSpeedMph: " + topSpeedMph + ", rangeInMiles: "
				+ rangeInMiles + ", priceInDollars: " + priceInDollars + " ]";
	}
	
	

}

