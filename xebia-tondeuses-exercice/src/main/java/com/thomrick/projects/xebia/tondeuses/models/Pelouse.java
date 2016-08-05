package com.thomrick.projects.xebia.tondeuses.models;

/**
 * Pelouse.java
 *
 * @author ThomRick
 * @date 2016-08-04
 *
 */
public class Pelouse {

	/** xMax */
	private int xMax;
	/** yMax */
	private int yMax;
	
	/**
	 * Pelouse 
	 *
	 * @param xMax
	 * @param yMax
	 */
	public Pelouse(int xMax, int yMax) {
		this.xMax = xMax;
		this.yMax = yMax;
	}

	/**
	 * sortParUnBord
	 * 
	 * @param tondeuse
	 * @return true si la tondeuse sort de la pelouse pour son prochain deplacement en position
	 */
	public boolean sortParUnBord(Tondeuse tondeuse) {
		boolean estEnCollisionAvecUnBord = false;
		Position position = tondeuse.getPosition();
		Orientation orientation = tondeuse.getOrientation();
		int futurePosistion = 0;
		if (orientation.equals(Orientation.X_NEGATIF)) {
			futurePosistion = position.getX() - 1;
			estEnCollisionAvecUnBord = futurePosistion < 0;
		}
		else if (orientation.equals(Orientation.Y_POSITIF)) {
			futurePosistion = position.getY() + 1;
			estEnCollisionAvecUnBord = futurePosistion > this.yMax;
		}
		else if (orientation.equals(Orientation.Y_NEGATIF)) {
			futurePosistion = position.getY() - 1;
			estEnCollisionAvecUnBord = futurePosistion < 0;
		}
		else if (orientation.equals(Orientation.X_POSITIF)) {
			futurePosistion = position.getX() + 1;
			estEnCollisionAvecUnBord = futurePosistion > this.xMax;
		}
		return estEnCollisionAvecUnBord;
	}

	/**
	 * getXMax
	 * 
	 * @return la valeur xMax position x maximale possible d'une tondeuse sur la pelouse
	 */
	public int getXMax() {
		return this.xMax;
	}

	/**
	 * getYMax
	 * 
	 * @return la valeur yMax position y maximale possible d'une tondeuse sur la pelouse
	 */
	public int getYMax() {
		return this.yMax;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + xMax;
		result = prime * result + yMax;
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
		Pelouse other = (Pelouse) obj;
		if (xMax != other.xMax)
			return false;
		if (yMax != other.yMax)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Pelouse [x=" + xMax + ", y=" + yMax + "]";
	}
	
}
