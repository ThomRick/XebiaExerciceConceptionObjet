package com.thomrick.projects.xebia.tondeuses.models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.thomrick.projects.xebia.tondeuses.models.Orientation;
import com.thomrick.projects.xebia.tondeuses.models.Position;
import com.thomrick.projects.xebia.tondeuses.models.Tondeuse;

public class TondeuseTest {

	@Test
	public void doitAvancerLaTondeuseDansLaDirectionDesYPositifs() {
		// ARRANGE
		Tondeuse tondeuse = new Tondeuse(new Position(0, 0), Orientation.Y_POSITIF);
		Position positionAttendue = new Position(0, 1);
		// ACT
		tondeuse.avancer();
		// ASSERT
		assertEquals("La position de la tondeuse n'est pas correctement modifiee", positionAttendue, tondeuse.getPosition());
	}
	
	@Test
	public void doitAvancerLaTondeuseDansLaDirectionDesXPositifs() {
		// ARRANGE
		Tondeuse tondeuse = new Tondeuse(new Position(0, 0), Orientation.X_POSITIF);
		Position positionAttendue = new Position(1, 0);
		// ACT
		tondeuse.avancer();
		// ASSERT
		assertEquals("La position de la tondeuse n'est pas correctement modifiee", positionAttendue, tondeuse.getPosition());
	}
	
	@Test
	public void doitAvancerLaTondeuseDansLaDirectionDesXNegatifs() {
		// ARRANGE
		Tondeuse tondeuse = new Tondeuse(new Position(5, 5), Orientation.X_NEGATIF);
		Position positionAttendue = new Position(4, 5);
		// ACT
		tondeuse.avancer();
		// ASSERT
		assertEquals("La position de la tondeuse n'est pas correctement modifiee", positionAttendue, tondeuse.getPosition());
	}
	
	@Test
	public void doitAvancerLaTondeuseDansLaDirectionDesYNegatifs() {
		// ARRANGE
		Tondeuse tondeuse = new Tondeuse(new Position(5, 5), Orientation.Y_NEGATIF);
		Position positionAttendue = new Position(5, 4);
		// ACT
		tondeuse.avancer();
		// ASSERT
		assertEquals("La position de la tondeuse n'est pas correctement modifiee", positionAttendue, tondeuse.getPosition());
	}
	
	@Test
	public void doitPivoterADroiteLaTondeuseVersLaDirectionDesXPositifs() {
		// ARRANGE
		Tondeuse tondeuse = new Tondeuse(new Position(0, 0), Orientation.Y_POSITIF);
		Orientation orientationAttendue = Orientation.X_POSITIF;
		// ACT
		tondeuse.pivoterADroite();
		// ASSERT
		assertEquals("L'orientation de la tondeuse n'est pas correctement modifiee", orientationAttendue, tondeuse.getOrientation());
	}
	
	@Test
	public void doitPivoterADroiteLaTondeuseVersLaDirectionDesYNegatifs() {
		// ARRANGE
		Tondeuse tondeuse = new Tondeuse(new Position(0, 0), Orientation.X_POSITIF);
		Orientation orientationAttendue = Orientation.Y_NEGATIF;
		// ACT
		tondeuse.pivoterADroite();
		// ASSERT
		assertEquals("L'orientation de la tondeuse n'est pas correctement modifiee", orientationAttendue, tondeuse.getOrientation());
	}
	
	@Test
	public void doitPivoterADroiteLaTondeuseVersLaDirectionDesXNegatifs() {
		// ARRANGE
		Tondeuse tondeuse = new Tondeuse(new Position(0, 0), Orientation.Y_NEGATIF);
		Orientation orientationAttendue = Orientation.X_NEGATIF;
		// ACT
		tondeuse.pivoterADroite();
		// ASSERT
		assertEquals("L'orientation de la tondeuse n'est pas correctement modifiee", orientationAttendue, tondeuse.getOrientation());
	}
	
	@Test
	public void doitPivoterADroiteLaTondeuseVersLaDirectionDesYPositifs() {
		// ARRANGE
		Tondeuse tondeuse = new Tondeuse(new Position(0, 0), Orientation.X_NEGATIF);
		Orientation orientationAttendue = Orientation.Y_POSITIF;
		// ACT
		tondeuse.pivoterADroite();
		// ASSERT
		assertEquals("L'orientation de la tondeuse n'est pas correctement modifiee", orientationAttendue, tondeuse.getOrientation());
	}
	
	@Test
	public void doitPivoterAGaucheLaTondeuseVersLaDirectionDesXNegatifs() {
		// ARRANGE
		Tondeuse tondeuse = new Tondeuse(new Position(0, 0), Orientation.Y_POSITIF);
		Orientation orientationAttendue = Orientation.X_NEGATIF;
		// ACT
		tondeuse.pivoterAGauche();
		// ASSERT
		assertEquals("L'orientation de la tondeuse n'est pas correctement modifiee", orientationAttendue, tondeuse.getOrientation());
	}
	
	@Test
	public void doitPivoterAGaucheLaTondeuseVersLaDirectionDesYNegatifs() {
		// ARRANGE
		Tondeuse tondeuse = new Tondeuse(new Position(0, 0), Orientation.X_NEGATIF);
		Orientation orientationAttendue = Orientation.Y_NEGATIF;
		// ACT
		tondeuse.pivoterAGauche();
		// ASSERT
		assertEquals("L'orientation de la tondeuse n'est pas correctement modifiee", orientationAttendue, tondeuse.getOrientation());
	}
	
	@Test
	public void doitPivoterAGaucheLaTondeuseVersLaDirectionDesXPositifs() {
		// ARRANGE
		Tondeuse tondeuse = new Tondeuse(new Position(0, 0), Orientation.Y_NEGATIF);
		Orientation orientationAttendue = Orientation.X_POSITIF;
		// ACT
		tondeuse.pivoterAGauche();
		// ASSERT
		assertEquals("L'orientation de la tondeuse n'est pas correctement modifiee", orientationAttendue, tondeuse.getOrientation());
	}
	
	@Test
	public void doitPivoterAGaucheLaTondeuseVersLaDirectionDesYPositifis() {
		// ARRANGE
		Tondeuse tondeuse = new Tondeuse(new Position(0, 0), Orientation.X_POSITIF);
		Orientation orientationAttendue = Orientation.Y_POSITIF;
		// ACT
		tondeuse.pivoterAGauche();
		// ASSERT
		assertEquals("L'orientation de la tondeuse n'est pas correctement modifiee", orientationAttendue, tondeuse.getOrientation());
	}
}
