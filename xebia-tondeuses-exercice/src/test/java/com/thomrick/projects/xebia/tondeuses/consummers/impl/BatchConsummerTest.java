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
	public void initialiser() {
		batchConsummer = new BatchConsummer();
	}
	
	
	@Test
	public void doitConsommerUnFichierPourExecuterLesProgrammesDeFaconSequentielleEtRetournerLesResultatsDeLExecution() throws IOException {
		// ARRANGE
		String cheminFichier = "src/test/resources/test-1-data.txt";
		String resultatAttendu = chargerData("src/test/resources/test-1-result.txt");
		// ACT
		String resultatProduit = batchConsummer.run(cheminFichier);
		// ASSERT
		assertEquals("Le batch ne s'est pas deroule correctement", resultatAttendu, resultatProduit);
	}
	
	private String chargerData(String filePath) throws IOException {
		InputStream inputStream = new FileInputStream(filePath);
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		String data = "";
		String ligne;
		while ((ligne = bufferedReader.readLine()) != null) {
			data += ligne + "\n";
		}
		bufferedReader.close();
		return data;
	}

}
