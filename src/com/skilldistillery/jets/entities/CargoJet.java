package com.skilldistillery.jets.entities;

public class CargoJet extends Jet implements CargoCarrier {
	public CargoJet(String name, String model, int topSpeedMph, int rangeInMiles, double priceInDollars) {
		super(name, model, topSpeedMph, rangeInMiles, priceInDollars);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void fly() {
		int flightTime;
		flightTime = topSpeedMph /rangeInMiles;
		System.out.println("BRRRRRhhhhhhhhsssss!! " + name +" Time In Air: " + flightTime);
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub
		System.out.println("loading cargo....");
	}
	

}
