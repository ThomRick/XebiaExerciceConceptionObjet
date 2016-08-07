package com.thomrick.projects.xebia.tondeuses.interfaces.mappers;

import java.util.Arrays;
import java.util.List;

import com.thomrick.projects.xebia.tondeuses.models.Garden;

/**
 * GardenMapper.java
 *
 * @author ThomRick
 * @date 2016-08-04
 *
 */
public class GardenMapper {
	
	/** X_MAX_DESCRIPTION_INDEX */
	private static final int X_MAX_DESCRIPTION_INDEX = 0;
	/** Y_MAX_DESCRIPTION_INDEX */
	private static final int Y_MAX_DESCRIPTION_INDEX = 1;

	/**
	 * mappFrom
	 * 
	 * @param description
	 * @return a garden
	 */
	public Garden mappFrom(String description) {
		List<String> gardenData = extractGardenDataFrom(description);
		int xMax = extractXMaxFrom(gardenData);
		int yMax = extractYMaxFrom(gardenData);
		return new Garden(xMax, yMax);
	}
	
	/**
	 * extractGardenDataFrom
	 * 
	 * @param description
	 * @return the garden data
	 */
	private List<String> extractGardenDataFrom(String description) {
		return Arrays.asList(description.split(" "));
	}
	
	/**
	 * extractXMaxFrom
	 * 
	 * @param donnees
	 * @return the xMax value
	 */
	private int extractXMaxFrom(List<String> donnees) {
		return Integer.parseInt(donnees.get(X_MAX_DESCRIPTION_INDEX));
	}
	
	/**
	 * extractYMaxFrom
	 * 
	 * @param donnees
	 * @return the yMax value
	 */
	private int extractYMaxFrom(List<String> donnees) {
		return Integer.parseInt(donnees.get(Y_MAX_DESCRIPTION_INDEX));
	}
}
