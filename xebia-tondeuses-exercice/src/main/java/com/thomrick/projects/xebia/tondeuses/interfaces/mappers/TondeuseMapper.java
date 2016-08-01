package com.thomrick.projects.xebia.tondeuses.interfaces.mappers;

import java.util.Arrays;
import java.util.List;

import com.thomrick.projects.xebia.tondeuses.interfaces.constantes.OrientationConstantes;
import com.thomrick.projects.xebia.tondeuses.models.Orientation;
import com.thomrick.projects.xebia.tondeuses.models.Position;
import com.thomrick.projects.xebia.tondeuses.models.Tondeuse;

public class TondeuseMapper {
	
	private static final int X_DESCRIPTION_INDEX = 0;
	private static final int Y_DESCRIPTION_INDEX = 1;
	private static final int ORIENTATION_DESCPRITION_INDEX = 2;

	public Tondeuse mappFrom(String description) {
		List<String> donnees = extraireDonneesFrom(description);
		Position position  = extrairePositionFrom(donnees);
		Orientation orientation = extraireOrientationFrom(donnees);
		return new Tondeuse(position, orientation);
	}

	private List<String> extraireDonneesFrom(String description) {
		return Arrays.asList(description.split(" "));
	}
	
	private Position extrairePositionFrom(List<String> donnees) {
		int x = extraireXFrom(donnees);
		int y = extraireYFrom(donnees);
		return new Position(x, y);
	}
	
	private int extraireXFrom(List<String> donnees) {
		return Integer.parseInt(donnees.get(X_DESCRIPTION_INDEX));
	}

	private int extraireYFrom(List<String> donnees) {
		return Integer.parseInt(donnees.get(Y_DESCRIPTION_INDEX));
	}

	private Orientation extraireOrientationFrom(List<String> donnees) {
		String orientationDescription = donnees.get(ORIENTATION_DESCPRITION_INDEX);
		Orientation orientation = null;
		if (orientationDescription.equals(OrientationConstantes.EST)) {
			orientation = Orientation.X_POSITIF;
		}
		else if (orientationDescription.equals(OrientationConstantes.OUEST)) {
			orientation = Orientation.X_NEGATIF;
		}
		else if (orientationDescription.equals(OrientationConstantes.NORD)) {
			orientation = Orientation.Y_POSITIF;
		}
		else if (orientationDescription.equals(OrientationConstantes.SUD)) {
			orientation = Orientation.Y_NEGATIF;
		}
		return orientation;
	}
	
}
