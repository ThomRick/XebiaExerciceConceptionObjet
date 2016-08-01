package com.thomrick.projects.xebia.tondeuses.interfaces.models;

import static org.junit.Assert.*;

import org.junit.Test;

import com.thomrick.projects.xebia.tondeuses.models.Orientation;
import com.thomrick.projects.xebia.tondeuses.models.Position;
import com.thomrick.projects.xebia.tondeuses.models.Tondeuse;

public class TondeuseDescriptionTest {

	@Test
	public void doitDonnerUneDescriptionDeTondeuseEnPositionXEgalUnEtYEgalDeuxOrienteeVersLeNord() {
		// ARRANGE
		String descriptionAttendue = "1 2 N";
		Tondeuse tondeuse = new Tondeuse(new Position(1 ,2), Orientation.Y_POSITIF);
		TondeuseDescription tondeuseDescription = new TondeuseDescription(tondeuse);
		// ACT
		String descriptionProduite = tondeuseDescription.decrire();
		// ASSERT
		assertEquals("La description donnee n'est pas correcte", descriptionAttendue, descriptionProduite);
	}
	
	@Test
	public void doitDonnerUneDescriptionDeTondeuseEnPositionXEgalUnEtYEgalDeuxOrienteeVersLeSud() {
		// ARRANGE
		String descriptionAttendue = "1 2 S";
		Tondeuse tondeuse = new Tondeuse(new Position(1 ,2), Orientation.Y_NEGATIF);
		TondeuseDescription tondeuseDescription = new TondeuseDescription(tondeuse);
		// ACT
		String descriptionProduite = tondeuseDescription.decrire();
		// ASSERT
		assertEquals("La description donnee n'est pas correcte", descriptionAttendue, descriptionProduite);
	}
	
	@Test
	public void doitDonnerUneDescriptionDeTondeuseEnPositionXEgalUnEtYEgalDeuxOrienteeVersLEst() {
		// ARRANGE
		String descriptionAttendue = "1 2 E";
		Tondeuse tondeuse = new Tondeuse(new Position(1 ,2), Orientation.X_POSITIF);
		TondeuseDescription tondeuseDescription = new TondeuseDescription(tondeuse);
		// ACT
		String descriptionProduite = tondeuseDescription.decrire();
		// ASSERT
		assertEquals("La description donnee n'est pas correcte", descriptionAttendue, descriptionProduite);
	}
	
	@Test
	public void doitDonnerUneDescriptionDeTondeuseEnPositionXEgalUnEtYEgalDeuxOrienteeVersLOuest() {
		// ARRANGE
		String descriptionAttendue = "1 2 W";
		Tondeuse tondeuse = new Tondeuse(new Position(1 ,2), Orientation.X_NEGATIF);
		TondeuseDescription tondeuseDescription = new TondeuseDescription(tondeuse);
		// ACT
		String descriptionProduite = tondeuseDescription.decrire();
		// ASSERT
		assertEquals("La description donnee n'est pas correcte", descriptionAttendue, descriptionProduite);
	}

}
