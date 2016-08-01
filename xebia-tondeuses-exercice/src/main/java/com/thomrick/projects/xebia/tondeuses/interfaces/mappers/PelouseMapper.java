package com.thomrick.projects.xebia.tondeuses.interfaces.mappers;

import java.util.Arrays;
import java.util.List;

import com.thomrick.projects.xebia.tondeuses.models.Pelouse;

public class PelouseMapper {
	
	private static final int X_MAX_DESCRIPTION_INDEX = 0;
	private static final int Y_MAX_DESCRIPTION_INDEX = 1;

	public Pelouse mappFrom(String description) {
		List<String> donnees = extraireDonneesFrom(description);
		int xMax = extraireXMax(donnees);
		int yMax = extraireYMax(donnees);
		return new Pelouse(xMax, yMax);
	}
	
	private List<String> extraireDonneesFrom(String description) {
		return Arrays.asList(description.split(" "));
	}
	
	private int extraireXMax(List<String> donnees) {
		return Integer.parseInt(donnees.get(X_MAX_DESCRIPTION_INDEX));
	}
	
	private int extraireYMax(List<String> donnees) {
		return Integer.parseInt(donnees.get(Y_MAX_DESCRIPTION_INDEX));
	}
}
