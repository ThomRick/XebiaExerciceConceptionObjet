package com.thomrick.projects.xebia.tondeuses.interfaces.mappers;

import java.util.Arrays;
import java.util.List;

import com.thomrick.projects.xebia.tondeuses.interfaces.constantes.OrientationConstants;
import com.thomrick.projects.xebia.tondeuses.models.Orientation;
import com.thomrick.projects.xebia.tondeuses.models.Position;
import com.thomrick.projects.xebia.tondeuses.models.Mower;

/**
 * MowerMapper.java
 *
 * @author ThomRick
 * @date 2016-08-04
 *
 */
public class MowerMapper {
	
	/** X_DESCRIPTION_INDEX */
	private static final int X_DESCRIPTION_INDEX = 0;
	/** Y_DESCRIPTION_INDEX */
	private static final int Y_DESCRIPTION_INDEX = 1;
	/** ORIENTATION_DESCPRITION_INDEX */
	private static final int ORIENTATION_DESCPRITION_INDEX = 2;

	/**
	 * mappFrom
	 * 
	 * @param description
	 * @return a mower
	 */
	public Mower mappFrom(String description) {
		List<String> mowerData = extractMowerDataFrom(description);
		Position position  = extractPositionFrom(mowerData);
		Orientation orientation = extractOrientationFrom(mowerData);
		return new Mower(position, orientation);
	}

	/**
	 * extractMowerDataFrom
	 * 
	 * @param description
	 * @return the mower data
	 */
	private List<String> extractMowerDataFrom(String description) {
		return Arrays.asList(description.split(" "));
	}
	
	/**
	 * extractPositionFrom
	 * 
	 * @param mowerData
	 * @return the mower position
	 */
	private Position extractPositionFrom(List<String> mowerData) {
		int x = extractPositionXFrom(mowerData);
		int y = extractPositionYFrom(mowerData);
		return new Position(x, y);
	}
	
	/**
	 * extractPositionXFrom
	 * 
	 * @param donnees
	 * @return the position x value
	 */
	private int extractPositionXFrom(List<String> donnees) {
		return Integer.parseInt(donnees.get(X_DESCRIPTION_INDEX));
	}

	/**
	 * extractPositionYFrom
	 * 
	 * @param donnees
	 * @return the position y value
	 */
	private int extractPositionYFrom(List<String> donnees) {
		return Integer.parseInt(donnees.get(Y_DESCRIPTION_INDEX));
	}

	/**
	 * extractOrientationFrom
	 * 
	 * @param mowerData
	 * @return the orientation
	 */
	private Orientation extractOrientationFrom(List<String> mowerData) {
		String orientationData = mowerData.get(ORIENTATION_DESCPRITION_INDEX);
		Orientation orientation = null;
		if (orientationData.equals(OrientationConstants.EAST)) {
			orientation = Orientation.POSITIVE_X;
		}
		else if (orientationData.equals(OrientationConstants.WEST)) {
			orientation = Orientation.NEGATIVE_X;
		}
		else if (orientationData.equals(OrientationConstants.NORTH)) {
			orientation = Orientation.POSITIVE_Y;
		}
		else if (orientationData.equals(OrientationConstants.SOUTH)) {
			orientation = Orientation.NEGATIVE_Y;
		}
		return orientation;
	}
	
}
