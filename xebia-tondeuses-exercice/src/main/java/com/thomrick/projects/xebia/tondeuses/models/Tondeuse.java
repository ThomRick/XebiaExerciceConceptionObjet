package com.thomrick.projects.xebia.tondeuses.models;

public class Tondeuse {
	
	private Position position;
	private Orientation orientation;
	
	public Tondeuse() {
		this(new Position(0, 0), Orientation.Y_POSITIF);
	}
	
	public Tondeuse(Position position) {
		this(position, Orientation.Y_POSITIF);
	}
	
	public Tondeuse(Orientation orientation) {
		this(new Position(0, 0), orientation);
	}
	
	public Tondeuse(Position position, Orientation orientation) {
		this.position = position;
		this.orientation = orientation;
	}
	
	public void avancer() {
		int nouvelleCoordonneeX = 0;
		int nouvelleCoordonneeY = 0;
		if (this.orientation.equals(Orientation.Y_POSITIF)) {
			nouvelleCoordonneeX = this.position.getX();
			nouvelleCoordonneeY = this.position.getY() + 1;
		}
		else if (this.orientation.equals(Orientation.X_POSITIF)) {
			nouvelleCoordonneeX = this.position.getX() + 1;
			nouvelleCoordonneeY = this.position.getY();
		}
		else if (this.orientation.equals(Orientation.X_NEGATIF)) {
			nouvelleCoordonneeX = this.position.getX() - 1;
			nouvelleCoordonneeY = this.position.getY();
		}
		else if (this.orientation.equals(Orientation.Y_NEGATIF)) {
			nouvelleCoordonneeX = this.position.getX();
			nouvelleCoordonneeY = this.position.getY() - 1;
		}
		this.position = new Position(nouvelleCoordonneeX, nouvelleCoordonneeY);
	}
	
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
	
	public Position getPosition() {
		return this.position;
	}
	
	public Orientation getOrientation() {
		return this.orientation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orientation == null) ? 0 : orientation.hashCode());
		result = prime * result + ((position == null) ? 0 : position.hashCode());
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

	@Override
	public String toString() {
		return "Tondeuse [position=" + position + ", orientation=" + orientation + "]";
	}
	
}
