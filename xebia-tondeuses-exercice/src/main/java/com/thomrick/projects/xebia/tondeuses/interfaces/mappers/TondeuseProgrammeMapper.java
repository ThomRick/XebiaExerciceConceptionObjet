package com.thomrick.projects.xebia.tondeuses.interfaces.mappers;

import java.util.Arrays;
import java.util.List;

import com.thomrick.projects.xebia.tondeuses.models.TondeuseProgramme;

/**
 * TondeuseProgrammeMapper.java
 *
 * @author ThomRick
 * @date 2016-08-04
 *
 */
public class TondeuseProgrammeMapper {

	/**
	 * mappFrom
	 * 
	 * @param description
	 * @return le programme d'une tondeuse depuis la description
	 */
	public TondeuseProgramme mappFrom(String description) {
		List<String> instructions = extraireInstructionFrom(description);
		return new TondeuseProgramme(instructions);
	}

	/**
	 * extraireInstructionFrom
	 * 
	 * @param description
	 * @return la liste des instructions du programme depuis la description
	 */
	private List<String> extraireInstructionFrom(String description) {
		return Arrays.asList(description.split(""));
	}

}
