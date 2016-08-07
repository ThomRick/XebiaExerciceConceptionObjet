package com.thomrick.projects.xebia.tondeuses.consummers.impl;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Before;
import org.junit.Test;

import com.thomrick.projects.xebia.tondeuses.consummers.IBatchConsummer;

public class BatchConsummerTest {

	private IBatchConsummer batchConsummer;
	
	@Before
	public void initialize() {
		this.batchConsummer = new BatchConsummer();
	}
	
	@Test
	public void it_should_return_the_rigth_display_after_runing_the_batch() throws IOException {
		// ARRANGE
		String filePath = "src/test/resources/test-1-data.txt";
		String displayExpected = chargerData("src/test/resources/test-1-result.txt");
		// ACT
		String display = batchConsummer.run(filePath);
		// ASSERT
		assertEquals("The batch consummer run does not execute correctly", displayExpected, display);
	}
	
	private String chargerData(String filePath) throws IOException {
		InputStream inputStream = new FileInputStream(filePath);
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
