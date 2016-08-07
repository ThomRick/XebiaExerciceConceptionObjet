package com.thomrick.projects.xebia.tondeuses.interfaces.impl;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.thomrick.projects.xebia.tondeuses.interfaces.IProgramRunner;
import com.thomrick.projects.xebia.tondeuses.interfaces.constantes.InstructionConstants;
import com.thomrick.projects.xebia.tondeuses.interfaces.models.ExecutionReport;
import com.thomrick.projects.xebia.tondeuses.models.Orientation;
import com.thomrick.projects.xebia.tondeuses.models.Garden;
import com.thomrick.projects.xebia.tondeuses.models.Position;
import com.thomrick.projects.xebia.tondeuses.models.Mower;
import com.thomrick.projects.xebia.tondeuses.models.Program;

public class ProgramRunnerTest {
	
	private IProgramRunner programRunner;
	
	@Before
	public void initialize() {
		programRunner = new ProgramRunner();
	}

	@Test
	public void it_should_emit_a_report_with_mower_position_to_0_0_and_orientation_positiveX_by_running_the_input_program() {
		// ARRANGE
		Garden garden = new Garden(5, 5);
		Program program = new Program(Arrays.asList(InstructionConstants.TURN_RIGHT));
		Mower mower = new Mower(new Position(0, 0), Orientation.POSITIVE_Y);
		ExecutionReport reportExpected = new ExecutionReport(new Mower(new Position(0, 0), Orientation.POSITIVE_X));
		// ACT
		ExecutionReport report = programRunner.run(program, mower, garden); 
		// ASSERT
		assertEquals("The program run does not emit the rigth report", reportExpected, report);
	}
	
	@Test
	public void it_should_emit_a_report_with_mower_position_to_0_0_and_orientation_negativeX_by_running_the_input_program() {
		// ARRANGE
		Garden garden = new Garden(5, 5);
		Program program = new Program(Arrays.asList(InstructionConstants.TURN_LEFT));
		Mower mower = new Mower(new Position(0, 0), Orientation.POSITIVE_Y);
		ExecutionReport reportExpected = new ExecutionReport(new Mower(new Position(0, 0), Orientation.NEGATIVE_X));
		// ACT
		ExecutionReport report = programRunner.run(program, mower, garden); 
		// ASSERT
		assertEquals("The program run does not emit the rigth report", reportExpected, report);
	}
	
	@Test
	public void it_should_emit_a_report_with_mower_position_to_0_1_and_orientation_positiveY_by_running_the_input_program() {
		// ARRANGE
		Garden garden = new Garden(5, 5);
		Program program = new Program(Arrays.asList(InstructionConstants.MOVE_FORWARD));
		Mower mower = new Mower(new Position(0, 0), Orientation.POSITIVE_Y);
		ExecutionReport reportExpected = new ExecutionReport(new Mower(new Position(0, 1), Orientation.POSITIVE_Y));
		// ACT
		ExecutionReport report = programRunner.run(program, mower, garden); 
		// ASSERT
		assertEquals("The program run does not emit the rigth report", reportExpected, report);
	}
	
	@Test
	public void it_should_emit_a_report_with_mower_in_the_same_position_as_starting_by_running_the_input_program() {
		// ARRANGE
		Garden garden = new Garden(5, 5);
		Program program = new Program(Arrays.asList(InstructionConstants.MOVE_FORWARD));
		Mower mower = new Mower(new Position(0, 0), Orientation.NEGATIVE_X);
		ExecutionReport reportExpected = new ExecutionReport(new Mower(new Position(0, 0), Orientation.NEGATIVE_X));
		// ACT
		ExecutionReport report = programRunner.run(program, mower, garden); 
		// ASSERT
		assertEquals("The program run does not emit the rigth report", reportExpected, report);
	}

}
