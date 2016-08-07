package com.thomrick.projects.xebia.tondeuses.interfaces.mappers;

import java.util.Arrays;
import java.util.List;

import com.thomrick.projects.xebia.tondeuses.models.Program;

/**
 * ProgramMapper.java
 *
 * @author ThomRick
 * @date 2016-08-04
 *
 */
public class ProgramMapper {

	/**
	 * mappFrom
	 * 
	 * @param description
	 * @return a program
	 */
	public Program mappFrom(String description) {
		List<String> instructions = extractInstructionsFrom(description);
		return new Program(instructions);
	}

	/**
	 * extractInstructionsFrom
	 * 
	 * @param description
	 * @return a list of instructions
	 */
	private List<String> extractInstructionsFrom(String description) {
		return Arrays.asList(description.split(""));
	}

}
