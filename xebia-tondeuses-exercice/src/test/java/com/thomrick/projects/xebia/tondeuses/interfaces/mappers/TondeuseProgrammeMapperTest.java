package com.thomrick.projects.xebia.tondeuses.interfaces.mappers;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.thomrick.projects.xebia.tondeuses.models.TondeuseProgramme;

public class TondeuseProgrammeMapperTest {

	private TondeuseProgrammeMapper tondeuseProgrammeMapper;
	
	@Before
	public void initialiser() {
		tondeuseProgrammeMapper = new TondeuseProgrammeMapper();
	}
	
	
	@Test
	public void doitRenvoyerUnProgrammeAvecLesBonnesInstructions() {
		// ARRANGE
		TondeuseProgramme tondeuseProgrammeAttendu = new TondeuseProgramme(Arrays.asList("GAGAGAGAA".split("")));
		String description = "GAGAGAGAA";
		// ACT
		TondeuseProgramme tondeuseProgrammeProduit = tondeuseProgrammeMapper.mappFrom(description);
		// ASSERT
		assertEquals("Le tondeuse programme n'est pas correctement mappe", tondeuseProgrammeAttendu, tondeuseProgrammeProduit);
	}

}
