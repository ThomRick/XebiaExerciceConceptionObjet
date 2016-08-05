package com.thomrick.projects.xebia.tondeuses.models;

/**
 * Tondeuse.java
 *
 * @author ThomRick
 * @date 2016-08-04
 *
 */
public class Tondeuse {
	
	/** position */
	private Position position;
	/** orientation */
	private Orientation orientation;
	
	/**
	 * Tondeuse 
	 *
	 * @param position
	 * @param orientation
	 */
	public Tondeuse(Position position, Orientation orientation) {
		this.position = position;
		this.orientation = orientation;
	}
	
	/**
	 * avancer
	 * 
	 */
	public void avancer() {
		int nouvellePositionX = 0;
		int nouvellePositionY = 0;
		if (this.orientation.equals(Orientation.Y_POSITIF)) {
			nouvellePositionX = this.position.getX();
			nouvellePositionY = this.position.getY() + 1;
		}
		else if (this.orientation.equals(Orientation.X_POSITIF)) {
			nouvellePositionX = this.position.getX() + 1;
			nouvellePositionY = this.position.getY();
		}
		else if (this.orientation.equals(Orientation.X_NEGATIF)) {
			nouvellePositionX = this.position.getX() - 1;
			nouvellePositionY = this.position.getY();
		}
		else if (this.orientation.equals(Orientation.Y_NEGATIF)) {
			nouvellePositionX = this.position.getX();
			nouvellePositionY = this.position.getY() - 1;
		}
		this.position = new Position(nouvellePositionX, nouvellePositionY);
	}
	
	/**
	 * pivoterADroite
	 * 
	 */
	public void pivoterADroite() {
		if (this.orientation.equals(Orientation.Y_POSITIF)) {
			this.orientation = Orientation.X_POSITIF;
		}
		else if (this.orientation.equals(Orientation.X_POSITIF)) {
			this.orientation = Orientation.Y_NEGATIF;
		}
		else if (this.orientation.equals(Orientation.Y_NEGATIF)) {
			this.orientation = Orientation.X_NEGATIF;
		}
		else if (this.orientation.equals(Orientation.X_NEGATIF)) {
			this.orientation = Orientation.Y_POSITIF;
		}
	}
	
	/**
	 * pivoterAGauche
	 * 
	 */
	public void pivoterAGauche() {
		if (this.orientation.equals(Orientation.Y_POSITIF)) {
			this.orientation = Orientation.X_NEGATIF;
		}
		else if (this.orientation.equals(Orientation.X_NEGATIF)) {
			this.orientation = Orientation.Y_NEGATIF;
		} 
		else if (this.orientation.equals(Orientation.Y_NEGATIF)) {
			this.orientation = Orientation.X_POSITIF;
		}
		else if (this.orientation.equals(Orientation.X_POSITIF)) {
			this.orientation = Orientation.Y_POSITIF;
		}
	}
	
	/**
	 * getPosition
	 * 
	 * @return la position de la tondeuse
	 */
	public Position getPosition() {
		return this.position;
	}
	
	/**
	 * getOrientation
	 * 
	 * @return l'orientation de la tondeuse
	 */
	public Orientation getOrientation() {
		return this.orientation;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orientation == null) ? 0 : orientation.hashCode());
		result = prime * result + ((position == null) ? 0 : position.hashCode());
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
		Tondeuse other = (Tondeuse) obj;
		if (orientation != other.orientation)
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Tondeuse [position=" + position + ", orientation=" + orientation + "]";
	}
	
}
