package com.thomrick.projects.xebia.tondeuses.interfaces.impl;

import java.util.List;

import com.thomrick.projects.xebia.tondeuses.interfaces.IProgrammeRunner;
import com.thomrick.projects.xebia.tondeuses.interfaces.constantes.InstructionConstantes;
import com.thomrick.projects.xebia.tondeuses.interfaces.models.TondeuseDescription;
import com.thomrick.projects.xebia.tondeuses.models.Pelouse;
import com.thomrick.projects.xebia.tondeuses.models.Tondeuse;
import com.thomrick.projects.xebia.tondeuses.models.TondeuseProgramme;

public class ProgrammeRunner implements IProgrammeRunner {

	public TondeuseDescription run(TondeuseProgramme tondeuseProgramme, Tondeuse tondeuse, Pelouse pelouse) {
		List<String> instructions = tondeuseProgramme.getInstructions();
		for (String instruction : instructions) {
			executerInstruction(instruction, tondeuse, pelouse);
		}
		return new TondeuseDescription(tondeuse);
	}

	private void executerInstruction(String instruction, Tondeuse tondeuse, Pelouse pelouse) {
		if (instruction.equals(InstructionConstantes.PIVOTER_DROITE)) {
			tondeuse.pivoterADroite();
		}
		else if (instruction.equals(InstructionConstantes.PIVOTER_GAUCHE)) {
			tondeuse.pivoterAGauche();
		}
		else if (instruction.equals(InstructionConstantes.AVANCER) && !pelouse.sortParUnBord(tondeuse)) {
			tondeuse.avancer();
		}
	}

}
