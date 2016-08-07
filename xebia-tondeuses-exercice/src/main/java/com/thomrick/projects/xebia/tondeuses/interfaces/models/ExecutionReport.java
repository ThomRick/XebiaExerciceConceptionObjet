package com.thomrick.projects.xebia.tondeuses.interfaces.models;

import com.thomrick.projects.xebia.tondeuses.interfaces.constantes.OrientationConstants;
import com.thomrick.projects.xebia.tondeuses.models.Orientation;
import com.thomrick.projects.xebia.tondeuses.models.Position;
import com.thomrick.projects.xebia.tondeuses.models.Mower;

/**
 * ExecutionReport.java
 *
 * @author ThomRick
 * @date 2016-08-04
 *
 */
public class ExecutionReport {

	/** mower */
	private Mower mower;
	
	/**
	 * TondeuseDescription 
	 *
	 * @param mower
	 */
	public ExecutionReport(Mower mower) {
		this.mower = mower;
	}
	
	/**
	 * display
	 * 
	 * @return the displayed report content
	 */
	public String display() {
		StringBuilder displayContentBuilder = new StringBuilder();
		addPositionTo(displayContentBuilder);
		displayContentBuilder.append(" ");
		addOrientationTo(displayContentBuilder);
		return displayContentBuilder.toString();
	}


	/**
	 * addPositionTo
	 * 
	 * @param displayContentBuilder
	 */
	private void addPositionTo(StringBuilder displayContentBuilder) {
		Position position = this.mower.getPosition(); 
		addPositionXTo(displayContentBuilder, position);
		displayContentBuilder.append(" ");
		addPositionYTo(displayContentBuilder, position);
	}

	/**
	 * addPositionXTo
	 * 
	 * @param displayContentBuilder
	 * @param position
	 */
	private void addPositionXTo(StringBuilder displayContentBuilder, Position position) {
		int x = position.getX();
		displayContentBuilder.append(x);
	}

	/**
	 * addPositionYTo
	 * 
	 * @param displayContentBuilder
	 * @param position
	 */
	private void addPositionYTo(StringBuilder displayContentBuilder, Position position) {
		int y = position.getY();
		displayContentBuilder.append(y);
	}
	
	/**
	 * addOrientationTo
	 * 
	 * @param displayContentBuilder
	 */
	private void addOrientationTo(StringBuilder displayContentBuilder) {
		Orientation orientation = this.mower.getOrientation();
		if (orientation.equals(Orientation.POSITIVE_Y)) {
			displayContentBuilder.append(OrientationConstants.NORTH);
		}
		else if (orientation.equals(Orientation.NEGATIVE_Y)) {
			displayContentBuilder.append(OrientationConstants.SOUTH);
		}
		else if (orientation.equals(Orientation.POSITIVE_X)) {
			displayContentBuilder.append(OrientationConstants.EAST);
		}
		else if (orientation.equals(Orientation.NEGATIVE_X)) {
			displayContentBuilder.append(OrientationConstants.WEST);
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mower == null) ? 0 : mower.hashCode());
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
		ExecutionReport other = (ExecutionReport) obj;
		if (mower == null) {
			if (other.mower != null)
				return false;
		} else if (!mower.equals(other.mower))
			return false;
		return true;
	}
	
}
