package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Jet {
	
	protected String name;
	protected String model;
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
		return "Jet [ Name: " + name + ", Model: " + model + ", TopSpeed Mph: " + topSpeedMph + ", Range in Miles: "
				+ rangeInMiles + ", Price in Dollars: " + priceInDollars + " ]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(model, name, priceInDollars, rangeInMiles, topSpeedMph);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jet other = (Jet) obj;
		return Objects.equals(model, other.model) && Objects.equals(name, other.name)
				&& Double.doubleToLongBits(priceInDollars) == Double.doubleToLongBits(other.priceInDollars)
				&& rangeInMiles == other.rangeInMiles && topSpeedMph == other.topSpeedMph;
	}
	
	

}

