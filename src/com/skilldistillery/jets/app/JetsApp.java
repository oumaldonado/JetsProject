package com.skilldistillery.jets.app;


import java.util.ArrayList;
import java.util.List;


import com.skilldistillery.jets.entities.Airfield;
import com.skilldistillery.jets.entities.Jet;

public class JetsApp {
	private Airfield af = new Airfield();
	public static void main(String[] args) {
		JetsApp app = new JetsApp();
		app.launch();

	}

	public void launch() {
		af.readJets();
		af.displayMenu();

	}


}
