package com.thomrick.projects.xebia.tondeuses.models;

/**
 * Position.java
 *
 * @author ThomRick
 * @date 2016-08-04
 *
 */
public class Position {

	/** x */
	private int x;
	/** y */
	private int y;

	/**
	 * Position 
	 *
	 * @param x
	 * @param y
	 */
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * getX
	 * 
	 * @return la valeur x de la position
	 */
	public int getX() {
		return x;
	}

	/**
	 * getY
	 * 
	 * @return la valeur y de la position
	 */
	public int getY() {
		return y;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
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
		Position other = (Position) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Position [x=" + x + ", y=" + y + "]";
	}
	
	
}
