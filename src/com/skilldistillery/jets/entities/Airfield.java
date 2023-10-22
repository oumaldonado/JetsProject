package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Airfield {
	String filename = "jets.txt";
	private List<Jet> jetsArraylist = new ArrayList<>();
	public Airfield() {
		readJets();
	}

	public List<Jet> readJets() {
		try (BufferedReader bufIn = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = bufIn.readLine()) != null) {
				Jet jets;
				String[] numberOfJets = line.split(", ");
				String name = numberOfJets[0];
				String model = (numberOfJets[1]);
				int topSpeedMph = Integer.parseInt(numberOfJets[2]);
				int rangeInMiles = Integer.parseInt(numberOfJets[3]);
				double priceInDollars = Double.parseDouble(numberOfJets[4]);
				if (name.equalsIgnoreCase("CargoJet")) {
					jets = new CargoJet(name, model, topSpeedMph, rangeInMiles, priceInDollars);

				} else if (name.equalsIgnoreCase("FighterJet")) {

					jets = new FighterJet(name, model, topSpeedMph, rangeInMiles, priceInDollars);
				} else {
					jets = new PassengerJet(name, model, topSpeedMph, rangeInMiles, priceInDollars);

				}
				// System.out.println(p);
				jetsArraylist.add(jets);
			}
		} catch (IOException e) {
			System.err.println(e);
		}
		return jetsArraylist;
	}

	public void flyAllJets() {
		for (Jet jet : jetsArraylist) {
			jet.fly();
		}
	}

	public void loadCargo() {
		for (Jet jet : jetsArraylist) {
			if (jet instanceof CargoJet) {
				((CargoJet) jet).load();
				
			}
		}

	}
	public void fight() {
		for (Jet jet : jetsArraylist) {
			if (jet instanceof FighterJet) {
				((FighterJet) jet).fight();
			}
			
		}
	}

	public List<Jet> getJetsArraylist() {
		return jetsArraylist;
	}

	public void setJetsArraylist(List<Jet> jetsArraylist) {
		this.jetsArraylist = jetsArraylist;
	}

}
