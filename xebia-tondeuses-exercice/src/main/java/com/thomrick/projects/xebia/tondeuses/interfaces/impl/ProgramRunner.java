package com.thomrick.projects.xebia.tondeuses.interfaces.impl;

import java.util.List;

import com.thomrick.projects.xebia.tondeuses.interfaces.IProgramRunner;
import com.thomrick.projects.xebia.tondeuses.interfaces.constantes.InstructionConstants;
import com.thomrick.projects.xebia.tondeuses.interfaces.models.ExecutionReport;
import com.thomrick.projects.xebia.tondeuses.models.Garden;
import com.thomrick.projects.xebia.tondeuses.models.Mower;
import com.thomrick.projects.xebia.tondeuses.models.Program;

/**
 * ProgramRunner.java
 *
 * @author ThomRick
 * @date 2016-08-04
 *
 */
public class ProgramRunner implements IProgramRunner {

	/* (non-Javadoc)
	 * @see com.thomrick.projects.xebia.tondeuses.interfaces.IProgrammeRunner#run(com.thomrick.projects.xebia.tondeuses.models.TondeuseProgramme, com.thomrick.projects.xebia.tondeuses.models.Tondeuse, com.thomrick.projects.xebia.tondeuses.models.Pelouse)
	 */
	public ExecutionReport run(Program program, Mower mower, Garden garden) {
		List<String> instructions = program.getInstructions();
		for (String instruction : instructions) {
			executeInstruction(instruction, mower, garden);
		}
		return new ExecutionReport(mower);
	}

	/**
	 * executerInstruction
	 * 
	 * @param instruction
	 * @param mower
	 * @param garden
	 */
	private void executeInstruction(String instruction, Mower mower, Garden garden) {
		if (instruction.equals(InstructionConstants.TURN_RIGHT)) {
			mower.turnRight();
		}
		else if (instruction.equals(InstructionConstants.TURN_LEFT)) {
			mower.turnLeft();
		}
		else if (instruction.equals(InstructionConstants.MOVE_FORWARD) && !garden.isGoingOut(mower)) {
			mower.moveForward();
		}
	}

}
