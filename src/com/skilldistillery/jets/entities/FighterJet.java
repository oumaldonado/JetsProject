package com.skilldistillery.jets.entities;

public class FighterJet extends Jet implements CombatReady{
	public FighterJet(String name, String model, int topSpeedMph, int rangeInMiles, double priceInDollars) {
		super(name, model, topSpeedMph, rangeInMiles, priceInDollars);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void fight() {
		System.out.println(" pew pew pew pew ");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fly() {
		int timeInAir ;
		timeInAir = rangeInMiles / topSpeedMph;
		System.out.println("zhhhhhhhhsssss!! " + name +" Time In Air: " + timeInAir);
	}

	
	
	

}
