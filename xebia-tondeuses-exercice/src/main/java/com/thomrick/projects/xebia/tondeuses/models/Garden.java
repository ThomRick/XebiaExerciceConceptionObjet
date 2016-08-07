package com.thomrick.projects.xebia.tondeuses.models;

/**
 * Garden.java
 *
 * @author ThomRick
 * @date 2016-08-04
 *
 */
public class Garden {

	/** xMax */
	private int xMax;
	/** yMax */
	private int yMax;
	
	/**
	 * Garden 
	 *
	 * @param xMax
	 * @param yMax
	 */
	public Garden(int xMax, int yMax) {
		this.xMax = xMax;
		this.yMax = yMax;
	}

	/**
	 * isGoingOut
	 * 
	 * @param mower
	 * @return true if the mower is going out of the garden
	 */
	public boolean isGoingOut(Mower mower) {
		boolean isGoingOut = false;
		Position position = mower.getPosition();
		Orientation orientation = mower.getOrientation();
		int futurPosistion = 0;
		if (orientation.equals(Orientation.NEGATIVE_X)) {
			futurPosistion = position.getX() - 1;
			isGoingOut = futurPosistion < 0;
		}
		else if (orientation.equals(Orientation.POSITIVE_Y)) {
			futurPosistion = position.getY() + 1;
			isGoingOut = futurPosistion > this.yMax;
		}
		else if (orientation.equals(Orientation.NEGATIVE_Y)) {
			futurPosistion = position.getY() - 1;
			isGoingOut = futurPosistion < 0;
		}
		else if (orientation.equals(Orientation.POSITIVE_X)) {
			futurPosistion = position.getX() + 1;
			isGoingOut = futurPosistion > this.xMax;
		}
		return isGoingOut;
	}

	/**
	 * getXMax
	 * 
	 * @return xMax the maximum x axis moving position
	 */
	public int getXMax() {
		return this.xMax;
	}

	/**
	 * getYMax
	 * 
	 * @return yMax the maximum y axis moving position
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
		Garden other = (Garden) obj;
		if (xMax != other.xMax)
			return false;
		if (yMax != other.yMax)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Garden [xMax=" + xMax + ", yMax=" + yMax + "]";
	}

}
