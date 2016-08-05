package com.thomrick.projects.xebia.tondeuses.interfaces.models;

import com.thomrick.projects.xebia.tondeuses.interfaces.constantes.OrientationConstantes;
import com.thomrick.projects.xebia.tondeuses.models.Orientation;
import com.thomrick.projects.xebia.tondeuses.models.Position;
import com.thomrick.projects.xebia.tondeuses.models.Tondeuse;

/**
 * TondeuseDescription.java
 *
 * @author ThomRick
 * @date 2016-08-04
 *
 */
public class TondeuseDescription {

	/** tondeuse */
	private Tondeuse tondeuse;
	
	/**
	 * TondeuseDescription 
	 *
	 * @param tondeuse
	 */
	public TondeuseDescription(Tondeuse tondeuse) {
		this.tondeuse = tondeuse;
	}
	
	/**
	 * decrire
	 * 
	 * @return une chaine de caracteres conforme au contrat d'interface specifie pour decrire une tondeuse
	 */
	public String decrire() {
		StringBuilder description = new StringBuilder();
		ajouterPosition(description);
		description.append(" ");
		ajouterOrientation(description);
		return description.toString();
	}


	/**
	 * ajouterPosition
	 * 
	 * @param description
	 */
	private void ajouterPosition(StringBuilder description) {
		Position position = this.tondeuse.getPosition(); 
		ajouterPositionX(description, position);
		description.append(" ");
		ajouterPositionY(description, position);
	}

	/**
	 * ajouterPositionX
	 * 
	 * @param description
	 * @param position
	 */
	private void ajouterPositionX(StringBuilder description, Position position) {
		int x = position.getX();
		description.append(x);
	}

	/**
	 * ajouterPositionY
	 * 
	 * @param description
	 * @param position
	 */
	private void ajouterPositionY(StringBuilder description, Position position) {
		int y = position.getY();
		description.append(y);
	}
	
	/**
	 * ajouterOrientation
	 * 
	 * @param description
	 */
	private void ajouterOrientation(StringBuilder description) {
		Orientation orientation = this.tondeuse.getOrientation();
		if (orientation.equals(Orientation.Y_POSITIF)) {
			description.append(OrientationConstantes.NORD);
		}
		else if (orientation.equals(Orientation.Y_NEGATIF)) {
			description.append(OrientationConstantes.SUD);
		}
		else if (orientation.equals(Orientation.X_POSITIF)) {
			description.append(OrientationConstantes.EST);
		}
		else if (orientation.equals(Orientation.X_NEGATIF)) {
			description.append(OrientationConstantes.OUEST);
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tondeuse == null) ? 0 : tondeuse.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TondeuseDescription other = (TondeuseDescription) obj;
		if (tondeuse == null) {
			if (other.tondeuse != null)
				return false;
		} else if (!tondeuse.equals(other.tondeuse))
			return false;
		return true;
	}
	
}
