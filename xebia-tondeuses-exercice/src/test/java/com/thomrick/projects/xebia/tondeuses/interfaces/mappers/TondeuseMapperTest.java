package com.thomrick.projects.xebia.tondeuses.interfaces.mappers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.thomrick.projects.xebia.tondeuses.models.Orientation;
import com.thomrick.projects.xebia.tondeuses.models.Position;
import com.thomrick.projects.xebia.tondeuses.models.Tondeuse;

public class TondeuseMapperTest {

	private TondeuseMapper tondeuseMapper;
	
	@Before
	public void initialiser() {
		this.tondeuseMapper = new TondeuseMapper();
	}
	
	@Test
	public void doitRetournerUneTondeuseEnPositionXEgalUnEtYEgalDeuxEtUneOrienteeVersLesXPositifs() {
		// ARRANGE
		Tondeuse tondeuseAttendue = new Tondeuse(new Position(1, 2), Orientation.X_POSITIF);
		String description = "1 2 E";
		// ACT
		Tondeuse tondeuseProduite = tondeuseMapper.mappFrom(description);
		// ASSERT
		assertEquals("La tondeuse n'est pas correctement mappee", tondeuseAttendue, tondeuseProduite);
	}
	
	@Test
	public void doitRetournerUneTondeuseEnPositionXEgalUnEtYEgalDeuxEtUneOrienteeVersLesXNegatifs() {
		// ARRANGE
		Tondeuse tondeuseAttendue = new Tondeuse(new Position(1, 2), Orientation.X_NEGATIF);
		String description = "1 2 W";
		// ACT
		Tondeuse tondeuseProduite = tondeuseMapper.mappFrom(description);
		// ASSERT
		assertEquals("La tondeuse n'est pas correctement mappee", tondeuseAttendue, tondeuseProduite);
	}
	
	@Test
	public void doitRetournerUneTondeuseEnPositionXEgalUnEtYEgalDeuxEtUneOrienteeVersLesYPositifs() {
		// ARRANGE
		Tondeuse tondeuseAttendue = new Tondeuse(new Position(1, 2), Orientation.Y_POSITIF);
		String description = "1 2 N";
		// ACT
		Tondeuse tondeuseProduite = tondeuseMapper.mappFrom(description);
		// ASSERT
		assertEquals("La tondeuse n'est pas correctement mappee", tondeuseAttendue, tondeuseProduite);
	}
	
	@Test
	public void doitRetournerUneTondeuseEnPositionXEgalUnEtYEgalDeuxEtUneOrienteeVersLesYNegatifs() {
		// ARRANGE
		Tondeuse tondeuseAttendue = new Tondeuse(new Position(1, 2), Orientation.Y_NEGATIF);
		String description = "1 2 S";
		// ACT
		Tondeuse tondeuseProduite = tondeuseMapper.mappFrom(description);
		// ASSERT
		assertEquals("La tondeuse n'est pas correctement mappee", tondeuseAttendue, tondeuseProduite);
	}

}
