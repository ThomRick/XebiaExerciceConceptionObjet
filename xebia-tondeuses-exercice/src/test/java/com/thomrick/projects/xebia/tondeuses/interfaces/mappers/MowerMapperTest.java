package com.thomrick.projects.xebia.tondeuses.interfaces.mappers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.thomrick.projects.xebia.tondeuses.models.Orientation;
import com.thomrick.projects.xebia.tondeuses.models.Position;
import com.thomrick.projects.xebia.tondeuses.models.Mower;

public class MowerMapperTest {

	private MowerMapper mowerMapper;
	
	@Before
	public void initialize() {
		this.mowerMapper = new MowerMapper();
	}
	
	@Test
	public void it_should_return_a_mower_with_position_1_2_and_orientation_positiveX() {
		// ARRANGE
		Mower mowerExpected = new Mower(new Position(1, 2), Orientation.POSITIVE_X);
		String description = "1 2 E";
		// ACT
		Mower mower = mowerMapper.mappFrom(description);
		// ASSERT
		assertEquals("The mower is not correctly mapped", mowerExpected, mower);
	}
	
	@Test
	public void it_should_return_a_mower_with_position_1_2_and_orientation_negativeX() {
		// ARRANGE
		Mower mowerExpected = new Mower(new Position(1, 2), Orientation.NEGATIVE_X);
		String description = "1 2 W";
		// ACT
		Mower mower = mowerMapper.mappFrom(description);
		// ASSERT
		assertEquals("The mower is not correctly mapped", mowerExpected, mower);
	}
	
	@Test
	public void it_should_return_a_mower_with_position_1_2_and_orientation_positiveY() {
		// ARRANGE
		Mower mowerExpected = new Mower(new Position(1, 2), Orientation.POSITIVE_Y);
		String description = "1 2 N";
		// ACT
		Mower mower = mowerMapper.mappFrom(description);
		// ASSERT
		assertEquals("The mower is not correctly mapped", mowerExpected, mower);
	}
	
	@Test
	public void it_should_return_a_mower_with_position_1_2_and_orientation_negativeY() {
		// ARRANGE
		Mower mowerExpected = new Mower(new Position(1, 2), Orientation.NEGATIVE_Y);
		String description = "1 2 S";
		// ACT
		Mower mower = mowerMapper.mappFrom(description);
		// ASSERT
		assertEquals("The mower is not correctly mapped", mowerExpected, mower);
	}

}
