package com.thomrick.projects.xebia.tondeuses.interfaces.mappers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.thomrick.projects.xebia.tondeuses.models.Garden;

public class GardenMapperTest {

	private GardenMapper gardenMapper;
	
	@Before
	public void initialize() {
		this.gardenMapper = new GardenMapper();
	}
	
	@Test
	public void it_should_return_a_garden_of_5x5() {
		// ARRANGE
		Garden gardenExpected = new Garden(5, 5);
		String description = "5 5";
		// ACT
		Garden garden = gardenMapper.mappFrom(description);
		// ASSERT
		assertEquals("The garden is not correctly mapped", gardenExpected, garden);
	}

}
