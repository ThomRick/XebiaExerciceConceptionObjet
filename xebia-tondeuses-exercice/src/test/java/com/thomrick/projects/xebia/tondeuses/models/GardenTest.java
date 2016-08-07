package com.thomrick.projects.xebia.tondeuses.models;

import static org.junit.Assert.*;

import org.junit.Test;

import com.thomrick.projects.xebia.tondeuses.models.Orientation;
import com.thomrick.projects.xebia.tondeuses.models.Garden;
import com.thomrick.projects.xebia.tondeuses.models.Position;
import com.thomrick.projects.xebia.tondeuses.models.Mower;

public class GardenTest {

	@Test
	public void it_should_return_false() {
		// ARRANGE
		Mower mower = new Mower(new Position(0, 0), Orientation.POSITIVE_X);
		Garden garden = new Garden(5, 5);
		// ACT
		boolean isGoingOut = garden.isGoingOut(mower);
		// ASSERT
		assertFalse("It should return false", isGoingOut);
	}
	
	@Test
	public void it_should_return_true_because_it_is_going_out_on_the_left_side() {
		// ARRANGE
		Mower mower = new Mower(new Position(0, 0), Orientation.NEGATIVE_X);
		Garden garden = new Garden(5, 5);
		// ACT
		boolean isGoingOut = garden.isGoingOut(mower);
		// ASSERT
		assertTrue("It should return true", isGoingOut);
	}
	
	@Test
	public void it_should_return_true_because_it_is_going_out_on_the_top_side() {
		// ARRANGE
		Mower mower = new Mower(new Position(0, 5), Orientation.POSITIVE_Y);
		Garden garden = new Garden(5, 5);
		// ACT
		boolean isGoingOut = garden.isGoingOut(mower);
		// ASSERT
		assertTrue("It should return true", isGoingOut);
	}
	
	@Test
	public void it_should_return_true_because_it_is_going_out_on_the_bottom_side() {
		// ARRANGE
		Mower mower = new Mower(new Position(0, 0), Orientation.NEGATIVE_Y);
		Garden garden = new Garden(5, 5);
		// ACT
		boolean isGoingOut = garden.isGoingOut(mower);
		// ASSERT
		assertTrue("It should return true", isGoingOut);
	}
	
	@Test
	public void it_should_return_true_because_it_is_going_out_on_the_right_side() {
		// ARRANGE
		Mower mower = new Mower(new Position(0, 0), Orientation.NEGATIVE_Y);
		Garden garden = new Garden(5, 5);
		// ACT
		boolean isGoingOut = garden.isGoingOut(mower);
		// ASSERT
		assertTrue("It should return true", isGoingOut);
	}

}
