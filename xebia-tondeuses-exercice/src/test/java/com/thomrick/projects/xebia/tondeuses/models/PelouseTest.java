package com.thomrick.projects.xebia.tondeuses.models;

import static org.junit.Assert.*;

import org.junit.Test;

import com.thomrick.projects.xebia.tondeuses.models.Orientation;
import com.thomrick.projects.xebia.tondeuses.models.Pelouse;
import com.thomrick.projects.xebia.tondeuses.models.Position;
import com.thomrick.projects.xebia.tondeuses.models.Tondeuse;

public class PelouseTest {

	@Test
	public void neSortPas() {
		// ARRANGE
		Tondeuse tondeuse = new Tondeuse();
		Pelouse pelouse = new Pelouse(5, 5);
		// ACT
		boolean estEnCollisionAvecUnBord = pelouse.sortParUnBord(tondeuse);
		// ASSERT
		assertFalse("La collision n'est pas sencee etre en collision", estEnCollisionAvecUnBord);
	}
	
	@Test
	public void sortParLeBordGauche() {
		// ARRANGE
		Tondeuse tondeuse = new Tondeuse(Orientation.X_NEGATIF);
		Pelouse pelouse = new Pelouse(5, 5);
		// ACT
		boolean estEnCollisionAvecUnBord = pelouse.sortParUnBord(tondeuse);
		// ASSERT
		assertTrue("La collision est censee etre en collision", estEnCollisionAvecUnBord);
	}
	
	@Test
	public void sortPartLeBordHaut() {
		// ARRANGE
		Tondeuse tondeuse = new Tondeuse(new Position(0, 5), Orientation.Y_POSITIF);
		Pelouse pelouse = new Pelouse(5, 5);
		// ACT
		boolean estEnCollisionAvecUnBord = pelouse.sortParUnBord(tondeuse);
		// ASSERT
		assertTrue("La collision est censee etre en collision", estEnCollisionAvecUnBord);
	}
	
	@Test
	public void sortParLeBordBas() {
		// ARRANGE
		Tondeuse tondeuse = new Tondeuse(new Position(0, 0), Orientation.Y_NEGATIF);
		Pelouse pelouse = new Pelouse(5, 5);
		// ACT
		boolean estEnCollisionAvecUnBord = pelouse.sortParUnBord(tondeuse);
		// ASSERT
		assertTrue("La collision est censee etre en collision", estEnCollisionAvecUnBord);
	}
	
	@Test
	public void sortParLeBordDroit() {
		// ARRANGE
		Tondeuse tondeuse = new Tondeuse(new Position(0, 0), Orientation.Y_NEGATIF);
		Pelouse pelouse = new Pelouse(5, 5);
		// ACT
		boolean estEnCollisionAvecUnBord = pelouse.sortParUnBord(tondeuse);
		// ASSERT
		assertTrue("La collision est censee etre en collision", estEnCollisionAvecUnBord);
	}

}
