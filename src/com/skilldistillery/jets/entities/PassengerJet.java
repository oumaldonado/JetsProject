package com.skilldistillery.jets.entities;

public class PassengerJet extends Jet {

	public PassengerJet(String name, String model, int topSpeedMph, int rangeInMiles, double priceInDollars) {
		super(name, model, topSpeedMph, rangeInMiles, priceInDollars);
	}

	@Override
	public void fly() {
		int flightTime;
		flightTime = rangeInMiles/topSpeedMph ;
		System.out.println("GGGHHHHERRRRRhhsssss!! " + name +" Time In Air: " + flightTime + "Hrs");
	}

}
