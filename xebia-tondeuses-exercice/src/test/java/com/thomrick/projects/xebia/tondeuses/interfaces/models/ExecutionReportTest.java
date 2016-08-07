package com.thomrick.projects.xebia.tondeuses.interfaces.models;

import static org.junit.Assert.*;

import org.junit.Test;

import com.thomrick.projects.xebia.tondeuses.models.Orientation;
import com.thomrick.projects.xebia.tondeuses.models.Position;
import com.thomrick.projects.xebia.tondeuses.models.Mower;

public class ExecutionReportTest {

	@Test
	public void it_should_display_1_2_N() {
		// ARRANGE
		String displayExpected = "1 2 N";
		Mower mower = new Mower(new Position(1 ,2), Orientation.POSITIVE_Y);
		ExecutionReport report = new ExecutionReport(mower);
		// ACT
		String display = report.display();
		// ASSERT
		assertEquals("The display is not correct", displayExpected, display);
	}
	
	@Test
	public void it_should_display_1_2_S() {
		// ARRANGE
		String displayExpected = "1 2 S";
		Mower mower = new Mower(new Position(1 ,2), Orientation.NEGATIVE_Y);
		ExecutionReport report = new ExecutionReport(mower);
		// ACT
		String display = report.display();
		// ASSERT
		assertEquals("The display is not correct", displayExpected, display);
	}
	
	@Test
	public void it_should_display_1_2_E() {
		// ARRANGE
		String displayExpected = "1 2 E";
		Mower mower = new Mower(new Position(1 ,2), Orientation.POSITIVE_X);
		ExecutionReport report = new ExecutionReport(mower);
		// ACT
		String display = report.display();
		// ASSERT
		assertEquals("The display is not correct", displayExpected, display);
	}
	
	@Test
	public void it_should_display_1_2_W() {
		// ARRANGE
		String displayExpected = "1 2 W";
		Mower mower = new Mower(new Position(1 ,2), Orientation.NEGATIVE_X);
		ExecutionReport report = new ExecutionReport(mower);
		// ACT
		String display = report.display();
		// ASSERT
		assertEquals("The display is not correct", displayExpected, display);
	}

}
