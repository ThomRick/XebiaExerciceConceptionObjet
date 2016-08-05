package com.thomrick.projects.xebia.tondeuses.interfaces.mappers;

import java.util.Arrays;
import java.util.List;

import com.thomrick.projects.xebia.tondeuses.models.Pelouse;

/**
 * PelouseMapper.java
 *
 * @author ThomRick
 * @date 2016-08-04
 *
 */
public class PelouseMapper {
	
	/** X_MAX_DESCRIPTION_INDEX */
	private static final int X_MAX_DESCRIPTION_INDEX = 0;
	/** Y_MAX_DESCRIPTION_INDEX */
	private static final int Y_MAX_DESCRIPTION_INDEX = 1;

	/**
	 * mappFrom
	 * 
	 * @param description
	 * @return une pelouse en fonction de la description donnee en parametre
	 */
	public Pelouse mappFrom(String description) {
		List<String> donnees = extraireDonneesFrom(description);
		int xMax = extraireXMax(donnees);
		int yMax = extraireYMax(donnees);
		return new Pelouse(xMax, yMax);
	}
	
	/**
	 * extraireDonneesFrom
	 * 
	 * @param description
	 * @return une liste de donnee depuis la description
	 */
	private List<String> extraireDonneesFrom(String description) {
		return Arrays.asList(description.split(" "));
	}
	
	/**
	 * extraireXMax
	 * 
	 * @param donnees
	 * @return la valeur xMax de la liste des donnees extraites de la description
	 */
	private int extraireXMax(List<String> donnees) {
		return Integer.parseInt(donnees.get(X_MAX_DESCRIPTION_INDEX));
	}
	
	/**
	 * extraireYMax
	 * 
	 * @param donnees
	 * @return la valeur yMax de la liste des donnees extraites de la description
	 */
	private int extraireYMax(List<String> donnees) {
		return Integer.parseInt(donnees.get(Y_MAX_DESCRIPTION_INDEX));
	}
}
