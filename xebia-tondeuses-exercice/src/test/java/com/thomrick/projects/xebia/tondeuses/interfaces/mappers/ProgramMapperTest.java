package com.thomrick.projects.xebia.tondeuses.interfaces.mappers;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.thomrick.projects.xebia.tondeuses.models.Program;

public class ProgramMapperTest {

	private ProgramMapper programMapper;
	
	@Before
	public void initialize() {
		this.programMapper = new ProgramMapper();
	}
	
	@Test
	public void it_should_return_a_program_with_the_right_instructions() {
		// ARRANGE
		Program programExpected = new Program(Arrays.asList("GAGAGAGAA".split("")));
		String description = "GAGAGAGAA";
		// ACT
		Program program = programMapper.mappFrom(description);
		// ASSERT
		assertEquals("The program is not correctly mapped", programExpected, program);
	}

}
