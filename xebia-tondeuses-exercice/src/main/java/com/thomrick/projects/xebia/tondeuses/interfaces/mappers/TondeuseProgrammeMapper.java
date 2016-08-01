package com.thomrick.projects.xebia.tondeuses.interfaces.mappers;

import java.util.Arrays;
import java.util.List;

import com.thomrick.projects.xebia.tondeuses.models.TondeuseProgramme;

public class TondeuseProgrammeMapper {

	public TondeuseProgramme mappFrom(String description) {
		List<String> instructions = extraireInstructionFrom(description);
		return new TondeuseProgramme(instructions);
	}

	private List<String> extraireInstructionFrom(String description) {
		return Arrays.asList(description.split(""));
	}

}
