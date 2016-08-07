package com.thomrick.projects.xebia.tondeuses.interfaces.impl;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.thomrick.projects.xebia.tondeuses.interfaces.IExecutionEnvironment;
import com.thomrick.projects.xebia.tondeuses.interfaces.models.ExecutionReport;
import com.thomrick.projects.xebia.tondeuses.models.Orientation;
import com.thomrick.projects.xebia.tondeuses.models.Garden;
import com.thomrick.projects.xebia.tondeuses.models.Position;
import com.thomrick.projects.xebia.tondeuses.models.Mower;
import com.thomrick.projects.xebia.tondeuses.models.Program;

public class ExecutionEnvironmentTest {
	
	private IExecutionEnvironment executionEnvironment;
	
	@Before
	public void initialize() {
		this.executionEnvironment = new ExecutionEnvironment();
	}
	
	@Test
	public void it_should_return_a_garden_from_the_execution_environment_after_initialize() throws IOException {
		// ARRANGE
		Garden gardenExpected = new Garden(5, 5);
		String data = loadData();
		// ACT
		executionEnvironment.initialize(data);
		// ASSERT
		ExecutionEnvironment executionEnvironment = (ExecutionEnvironment) this.executionEnvironment;
		Garden garden = executionEnvironment.getGarden();
		assertEquals("The garden is not correctly initialized", gardenExpected, garden);
	}
	
	@Test
	public void it_should_return_2_mowers_from_the_execution_environment_after_initialize() throws IOException {
		// ARRANGE
		Map<Integer, Mower> mowersExpected = new HashMap<Integer, Mower>();
		mowersExpected.put(0, new Mower(new Position(1, 2), Orientation.POSITIVE_Y));
		mowersExpected.put(1, new Mower(new Position(3, 3), Orientation.POSITIVE_X));
		String data = loadData();
		// ACT
		executionEnvironment.initialize(data);
		// ASSERT
		ExecutionEnvironment executionEnvironment = (ExecutionEnvironment) this.executionEnvironment;
		Map<Integer, Mower> mowers = executionEnvironment.getMowers();
		assertEquals("The 2 mowers are not correctly initilized", mowersExpected, mowers);
	}
	
	@Test
	public void it_should_return_2_programs_from_the_execution_environment_after_initialize() throws IOException {
		// ARRANGE
		Map<Integer, Program> programsExpected = new HashMap<Integer, Program>();
		programsExpected.put(0, new Program(Arrays.asList("GAGAGAGAA".split(""))));
		programsExpected.put(1, new Program(Arrays.asList("AADAADADDA".split(""))));
		String data = loadData();
		// ACT
		executionEnvironment.initialize(data);
		// ASSERT
		ExecutionEnvironment executionEnvironment = (ExecutionEnvironment) this.executionEnvironment;
		Map<Integer, Program> porgrams = executionEnvironment.getPrograms();
		assertEquals("The 2 programs are not correctly initialized", programsExpected, porgrams);
	}
	
	@Test
	public void it_should_return_a_list_of_2_ids_after_initialize() throws IOException {
		// ARRANGE
		List<Integer> idsExpected = Arrays.asList(0, 1);
		String data = loadData();
		// ACT
		List<Integer> ids = executionEnvironment.initialize(data);
		// ASSERT
		assertEquals("The list of returned ids is not correct", idsExpected, ids);
	}
	
	@Test
	public void it_should_return_the_rigth_report_after_execute_a_program_by_its_id() throws IOException {
		// ARRANGE
		ExecutionReport reportExpected = new ExecutionReport(new Mower(new Position(1, 3), Orientation.POSITIVE_Y));
		String data = loadData();
		List<Integer> ids = executionEnvironment.initialize(data);
		// ACT
		ExecutionReport report = executionEnvironment.executeProgramById(ids.get(0)); 
		// ASSERT
		assertEquals("The execution does not produce the rigth report", reportExpected, report);
	}
	
	private String loadData() throws IOException {
		InputStream inputStream = new FileInputStream("src/test/resources/test-1-data.txt");
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		String data = "";
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			data += line + "\n";
		}
		bufferedReader.close();
		return data;
	}
	
}
