package com.thomrick.projects.xebia.tondeuses.models;

/**
 * Mower.java
 *
 * @author ThomRick
 * @date 2016-08-04
 *
 */
public class Mower {
	
	/** position */
	private Position position;
	/** orientation */
	private Orientation orientation;
	
	/**
	 * Mower 
	 *
	 * @param position
	 * @param orientation
	 */
	public Mower(Position position, Orientation orientation) {
		this.position = position;
		this.orientation = orientation;
	}
	
	/**
	 * moveForward
	 * 
	 */
	public void moveForward() {
		int newPositionX = 0;
		int newPositionY = 0;
		if (this.orientation.equals(Orientation.POSITIVE_Y)) {
			newPositionX = this.position.getX();
			newPositionY = this.position.getY() + 1;
		}
		else if (this.orientation.equals(Orientation.POSITIVE_X)) {
			newPositionX = this.position.getX() + 1;
			newPositionY = this.position.getY();
		}
		else if (this.orientation.equals(Orientation.NEGATIVE_X)) {
			newPositionX = this.position.getX() - 1;
			newPositionY = this.position.getY();
		}
		else if (this.orientation.equals(Orientation.NEGATIVE_Y)) {
			newPositionX = this.position.getX();
			newPositionY = this.position.getY() - 1;
		}
		this.position = new Position(newPositionX, newPositionY);
	}
	
	/**
	 * turnRight
	 * 
	 */
	public void turnRight() {
		if (this.orientation.equals(Orientation.POSITIVE_Y)) {
			this.orientation = Orientation.POSITIVE_X;
		}
		else if (this.orientation.equals(Orientation.POSITIVE_X)) {
			this.orientation = Orientation.NEGATIVE_Y;
		}
		else if (this.orientation.equals(Orientation.NEGATIVE_Y)) {
			this.orientation = Orientation.NEGATIVE_X;
		}
		else if (this.orientation.equals(Orientation.NEGATIVE_X)) {
			this.orientation = Orientation.POSITIVE_Y;
		}
	}
	
	/**
	 * turnLeft
	 * 
	 */
	public void turnLeft() {
		if (this.orientation.equals(Orientation.POSITIVE_Y)) {
			this.orientation = Orientation.NEGATIVE_X;
		}
		else if (this.orientation.equals(Orientation.NEGATIVE_X)) {
			this.orientation = Orientation.NEGATIVE_Y;
		} 
		else if (this.orientation.equals(Orientation.NEGATIVE_Y)) {
			this.orientation = Orientation.POSITIVE_X;
		}
		else if (this.orientation.equals(Orientation.POSITIVE_X)) {
			this.orientation = Orientation.POSITIVE_Y;
		}
	}
	
	/**
	 * getPosition
	 * 
	 * @return the mower position
	 */
	public Position getPosition() {
		return this.position;
	}
	
	/**
	 * getOrientation
	 * 
	 * @return the mower orientation
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
		Mower other = (Mower) obj;
		if (orientation != other.orientation)
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Mower [position=" + position + ", orientation=" + orientation + "]";
	}

}
