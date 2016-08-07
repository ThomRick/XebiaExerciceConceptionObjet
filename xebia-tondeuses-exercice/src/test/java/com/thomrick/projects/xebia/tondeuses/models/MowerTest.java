package com.thomrick.projects.xebia.tondeuses.models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.thomrick.projects.xebia.tondeuses.models.Orientation;
import com.thomrick.projects.xebia.tondeuses.models.Position;
import com.thomrick.projects.xebia.tondeuses.models.Mower;

public class MowerTest {

	@Test
	public void it_should_move_forward_from_0_0_to_0_1() {
		// ARRANGE
		Mower mower = new Mower(new Position(0, 0), Orientation.POSITIVE_Y);
		Position positionExpected = new Position(0, 1);
		// ACT
		mower.moveForward();
		// ASSERT
		assertEquals("The new mower position is not correct", positionExpected, mower.getPosition());
	}
	
	@Test
	public void it_should_move_forward_from_0_0_to_1_0() {
		// ARRANGE
		Mower mower = new Mower(new Position(0, 0), Orientation.POSITIVE_X);
		Position positionExpected = new Position(1, 0);
		// ACT
		mower.moveForward();
		// ASSERT
		assertEquals("The new mower position is not correct", positionExpected, mower.getPosition());
	}
	
	@Test
	public void it_should_move_forward_from_5_5_to_4_5() {
		// ARRANGE
		Mower mower = new Mower(new Position(5, 5), Orientation.NEGATIVE_X);
		Position positionExpected = new Position(4, 5);
		// ACT
		mower.moveForward();
		// ASSERT
		assertEquals("The new mower position is not correct", positionExpected, mower.getPosition());
	}
	
	@Test
	public void it_should_move_forward_from_5_5_to_5_4() {
		// ARRANGE
		Mower mower = new Mower(new Position(5, 5), Orientation.NEGATIVE_Y);
		Position positionExpected = new Position(5, 4);
		// ACT
		mower.moveForward();
		// ASSERT
		assertEquals("The new mower position is not correct", positionExpected, mower.getPosition());
	}
	
	@Test
	public void it_should_turnRight_from_positiveY_to_positiveX() {
		// ARRANGE
		Mower mower = new Mower(new Position(0, 0), Orientation.POSITIVE_Y);
		Orientation orientationExpected = Orientation.POSITIVE_X;
		// ACT
		mower.turnRight();
		// ASSERT
		assertEquals("The new mower orientation is not correct", orientationExpected, mower.getOrientation());
	}
	
	@Test
	public void it_should_turnRight_from_positiveX_to_negativeY() {
		// ARRANGE
		Mower mower = new Mower(new Position(0, 0), Orientation.POSITIVE_X);
		Orientation orientationExpected = Orientation.NEGATIVE_Y;
		// ACT
		mower.turnRight();
		// ASSERT
		assertEquals("The new mower orientation is not correct", orientationExpected, mower.getOrientation());
	}
	
	@Test
	public void it_should_turnRight_from_negativeY_to_negativeX() {
		// ARRANGE
		Mower mower = new Mower(new Position(0, 0), Orientation.NEGATIVE_Y);
		Orientation orientationExpected = Orientation.NEGATIVE_X;
		// ACT
		mower.turnRight();
		// ASSERT
		assertEquals("The new mower orientation is not correct", orientationExpected, mower.getOrientation());
	}
	
	@Test
	public void it_should_turnRight_from_negativeX_to_positiveY() {
		// ARRANGE
		Mower mower = new Mower(new Position(0, 0), Orientation.NEGATIVE_X);
		Orientation orientationExpected = Orientation.POSITIVE_Y;
		// ACT
		mower.turnRight();
		// ASSERT
		assertEquals("The new mower orientation is not correct", orientationExpected, mower.getOrientation());
	}
	
	@Test
	public void it_should_turnLeft_from_positiveY_to_negativeX() {
		// ARRANGE
		Mower mower = new Mower(new Position(0, 0), Orientation.POSITIVE_Y);
		Orientation orientationExpected = Orientation.NEGATIVE_X;
		// ACT
		mower.turnLeft();
		// ASSERT
		assertEquals("The new mower orientation is not correct", orientationExpected, mower.getOrientation());
	}
	
	@Test
	public void it_should_turnLeft_from_negativeX_to_negativeY() {
		// ARRANGE
		Mower mower = new Mower(new Position(0, 0), Orientation.NEGATIVE_X);
		Orientation orientationExpected = Orientation.NEGATIVE_Y;
		// ACT
		mower.turnLeft();
		// ASSERT
		assertEquals("The new mower orientation is not correct", orientationExpected, mower.getOrientation());
	}
	
	@Test
	public void it_should_turnLeft_from_negativeY_to_positiveX() {
		// ARRANGE
		Mower mower = new Mower(new Position(0, 0), Orientation.NEGATIVE_Y);
		Orientation orientationExpected = Orientation.POSITIVE_X;
		// ACT
		mower.turnLeft();
		// ASSERT
		assertEquals("The new mower orientation is not correct", orientationExpected, mower.getOrientation());
	}
	
	@Test
	public void it_should_turnLeft_from_positiveX_to_positiveY() {
		// ARRANGE
		Mower mower = new Mower(new Position(0, 0), Orientation.POSITIVE_X);
		Orientation orientationExpected = Orientation.POSITIVE_Y;
		// ACT
		mower.turnLeft();
		// ASSERT
		assertEquals("The new mower orientation is not correct", orientationExpected, mower.getOrientation());
	}
}
