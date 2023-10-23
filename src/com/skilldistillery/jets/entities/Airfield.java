package com.skilldistillery.jets.entities;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Airfield {
	private Scanner kb = new Scanner(System.in);
	String fileName = "jets.txt";
	private List<Jet> jetsArraylist = new ArrayList<>();

	public Airfield() {
		readJets();
		displayMenu();
	}

	public List<Jet> readJets() {
		try (BufferedReader bufIn = new BufferedReader(new FileReader(fileName))) {
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

				jetsArraylist.add(jets);
			}
		} catch (IOException e) {
			System.err.println(e);
		}
		return jetsArraylist;
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
				for (Jet jets : jetsArraylist) {
					if (jets != null) {
						System.out.println(jets.toString());

					}

				}
				break;

			case 1:
				for (Jet jets : jetsArraylist) {
					if (jets != null) {
						flyAllJets();
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
				for (Jet jets : jetsArraylist) {
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
				for (Jet jets : jetsArraylist) {
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
				for (Jet jets : jetsArraylist) {
					if (jets != null) {
						loadCargo();
						break;
					}
				}
				break;
			case 5:
				for (Jet jets : jetsArraylist) {
					if (jets != null) {
						fight();
						break;
					}
				}
				break;
			case 6:
				addJet(kb);
				break;

			case 7:
				removeJet(kb);

				break;
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

	public List<Jet> addJet(Scanner kb) {
		Jet newJetAdded = null;
		int userInput;
		String name;
		String model;
		int speed;
		int range;
		double price;
		System.out.println("What Type of Jet would you like ?");
		System.out.println(1 + ") CargoJet ");
		System.out.println(2 + ") PassengerJet ");
		System.out.println(3 + ") FighterJet");

		userInput = kb.nextInt();

		if (userInput == 1) {
			name = "CargoJet";
			System.out.println(" What model Cargo Jet is it? ");
			model = kb.next();
			System.out.println("How fast is your Jet? In Mph");
			speed = kb.nextInt();
			System.out.println("What range does your Jet have?");
			range = kb.nextInt();
			System.out.println("How much does your Jet cost?");
			price = kb.nextDouble();
			newJetAdded = new CargoJet(name, model, speed, range, price);
			jetsArraylist.add(newJetAdded);
		} else if (userInput == 2) {
			name = "PassengerJet";
			System.out.println(" What model Passenger Jet is it? ");
			model = kb.next();
			System.out.println("How fast is your Jet? In Mph");
			speed = kb.nextInt();
			System.out.println("What range does your Jet have?");
			range = kb.nextInt();
			System.out.println("How much does your Jet cost?");
			price = kb.nextDouble();
			newJetAdded = new PassengerJet(name, model, speed, range, price);
			jetsArraylist.add(newJetAdded);

		} else if (userInput == 3) {
			name = "FighterJet";
			System.out.println(" What model Fighter Jet is it? ");
			model = kb.next();
			System.out.println("How fast is your Jet? In Mph");
			speed = kb.nextInt();
			System.out.println("What range does your Jet have?");
			range = kb.nextInt();
			System.out.println("How much does your Jet cost?");
			price = kb.nextDouble();
			newJetAdded = new FighterJet(name, model, speed, range, price);
			jetsArraylist.add(newJetAdded);

		} else {
			System.out.println("Invaild input");
		}

		return jetsArraylist;
	}

	public void removeJet(Scanner kb) {
		int count = 1;
		int userInput = 0;
		boolean status = true;
		while (status) {
			System.out.println();
			System.out.println();
			System.out.println("What number Jet do you want to remove? ");
			System.out.println();
			System.out.println();
			for (Jet jet : jetsArraylist) {
				System.out.println(count + " " + jet);
				count++;

			}
			userInput = kb.nextInt();

			if (userInput >= 0) {
				System.out.println(userInput);
				System.out.println("removed: " + jetsArraylist.remove(userInput - 1));
				status = false;

			}
			if (jetsArraylist.isEmpty()) {
				System.out.println("Empty AirField");
				status = false;
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
