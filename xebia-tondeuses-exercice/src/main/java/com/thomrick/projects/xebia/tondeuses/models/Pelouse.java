package com.thomrick.projects.xebia.tondeuses.models;

public class Pelouse {

	private int xMax;
	private int yMax;
	
	public Pelouse(int xMax, int yMax) {
		this.xMax = xMax;
		this.yMax = yMax;
	}

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

	public int getX() {
		return xMax;
	}

	public int getY() {
		return yMax;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + xMax;
		result = prime * result + yMax;
		return result;
	}

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

	@Override
	public String toString() {
		return "Pelouse [x=" + xMax + ", y=" + yMax + "]";
	}
	
}
