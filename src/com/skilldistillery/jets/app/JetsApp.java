package com.skilldistillery.jets.app;

import java.util.Scanner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.io.InputStreamReader;

import com.skilldistillery.jets.entities.Airfield;
import com.skilldistillery.jets.entities.Jet;

public class JetsApp {
	private Scanner kb = new Scanner(System.in);
	private Airfield af = new Airfield();

	public static void main(String[] args) {
		JetsApp app = new JetsApp();
		app.launch();

	}

	public void launch() {
		displayMenu();

	}

	public void displayMenu() {
		boolean status = true;
		while (status) {
			System.out.println();
			System.out.println("choose from the following ");
			System.out.println("0) List the fleet");
			System.out.println("1) Fly all Jets  ");
			System.out.println("2) View the fastest Jet ");
			System.out.println("3) View Jet with longest range ");
			System.out.println("4) Load all Cargo Jets");
			System.out.println("5) Dogfight! ");
			System.out.println("6) Add a Jet to the fleet");
			System.out.println("7) Remove a Jet from fleet");
			System.out.println("8) Quit");
			System.out.println();
			int userChoice = kb.nextInt();
			kb.nextLine();
			switch (userChoice) {
			case 0:
				for (Jet jets : af.getJetsArraylist()) {
					if (jets != null) {
						System.out.println(jets.toString());

					}

				}
				break;

			case 1:
				for (Jet jets : af.getJetsArraylist()) {
					if (jets != null) {
						af.flyAllJets();
						break;
					}
				}

				break;
			case 2:
				String fastJetMake = null;
				String fastJetModel = null;
				int fastJet = 0;
				Jet fastestJet = null;
				int currentHigh = 0;
				for (Jet jets : af.getJetsArraylist()) {
					if (jets != null) {
						if (jets.getTopSpeed() > currentHigh) {
							currentHigh = jets.getTopSpeed();
							fastJet = currentHigh;
							fastJetModel = jets.getModel();
							fastJetMake = jets.getName();

						}

					}

				}
				System.out.println(
						"The fastest Jet is: " + fastJetMake + " " + fastJetModel + " Speed: " + fastJet + " Mph");
				break;
			case 3:
				String longestRName = null;
				String longestRModel = null;
				int longestRange = 0;
				Jet rangeJet = null;
				int currentLongest = 0;
				for (Jet jets : af.getJetsArraylist()) {
					if (jets != null) {
						if (jets.getRange() > currentLongest) {
							currentLongest = jets.getRange();
							longestRange = currentLongest;
							longestRName = jets.getName();
							longestRModel = jets.getModel();

						}
					}
				}
				System.out.println("The Jet with the longest range is: " + longestRName + " " + longestRModel
						+ " Range: " + longestRange + " Miles");
				break;

			case 4:
				for (Jet jets : af.getJetsArraylist()) {
					if (jets != null) {
						af.loadCargo();
						break;
					}
				}
				break;
			case 5:
				for (Jet jets : af.getJetsArraylist()) {
					if (jets != null) {
						af.fight();
						break;
					}
				}
				break;
//			case 6:
//				for (Jet jets : af.getJetsArraylist()) {
//					af.writeJets();
//				}
//				break;

//				
//
//			case 7:
//				//remove
			case 8:
				System.out.println("Have a great day! ");
				status = false;
				break;

			default:
				System.out.println("Invaid selection");
				break;
			}
		}

	}

}
