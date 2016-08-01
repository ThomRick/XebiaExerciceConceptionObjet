package com.thomrick.projects.xebia.tondeuses.interfaces.mappers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.thomrick.projects.xebia.tondeuses.models.Pelouse;

public class PelouseMapperTest {

	private PelouseMapper pelouseMapper;
	
	@Before
	public void initialiser() {
		pelouseMapper = new PelouseMapper();
	}
	
	@Test
	public void doitRetournerUnePelouseDeCinqParCinq() {
		// ARRANGE
		Pelouse pelouseAttendue = new Pelouse(5, 5);
		String description = "5 5";
		// ACT
		Pelouse pelouseProduite = pelouseMapper.mappFrom(description);
		// ASSERT
		assertEquals("La pelouse n'est pas correctement mappee", pelouseAttendue, pelouseProduite);
	}

}
