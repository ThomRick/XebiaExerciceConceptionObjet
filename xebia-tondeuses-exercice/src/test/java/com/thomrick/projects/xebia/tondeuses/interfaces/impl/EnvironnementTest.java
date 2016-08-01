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

import com.thomrick.projects.xebia.tondeuses.interfaces.IEnvironnement;
import com.thomrick.projects.xebia.tondeuses.interfaces.models.TondeuseDescription;
import com.thomrick.projects.xebia.tondeuses.models.Orientation;
import com.thomrick.projects.xebia.tondeuses.models.Pelouse;
import com.thomrick.projects.xebia.tondeuses.models.Position;
import com.thomrick.projects.xebia.tondeuses.models.Tondeuse;
import com.thomrick.projects.xebia.tondeuses.models.TondeuseProgramme;

public class EnvironnementTest {
	
	private IEnvironnement environnement;
	
	@Before
	public void intialiser() {
		this.environnement = new Environnement();
	}
	
	@Test
	public void initialiserDoitInitialiserUnePelouse() throws IOException {
		// ARRANGE
		Pelouse pelouseAttendue = new Pelouse(5, 5);
		String data = chargerData();
		// ACT
		environnement.initialiser(data);
		// ASSERT
		Environnement system = (Environnement) this.environnement;
		Pelouse pelouseProduite = system.getPelouse();
		assertEquals("Le system n'a pas correctement initialise la pelouse", pelouseAttendue, pelouseProduite);
	}
	
	@Test
	public void initialiserDoitInitialiserDeuxTondeuses() throws IOException {
		// ARRANGE
		Map<Integer, Tondeuse> tondeusesAttendues = new HashMap<Integer, Tondeuse>();
		tondeusesAttendues.put(0, new Tondeuse(new Position(1, 2), Orientation.Y_POSITIF));
		tondeusesAttendues.put(1, new Tondeuse(new Position(3, 3), Orientation.X_POSITIF));
		String data = chargerData();
		// ACT
		environnement.initialiser(data);
		// ASSERT
		Environnement system = (Environnement) this.environnement;
		Map<Integer, Tondeuse> tondeusesProduites = system.getTondeuses();
		assertEquals("Le system n'a pas correctement initialise les tondeuses", tondeusesAttendues, tondeusesProduites);
	}
	
	@Test
	public void initialiserDoitInitialiserDeuxTondeuseProgrammes() throws IOException {
		// ARRANGE
		Map<Integer, TondeuseProgramme> tondeuseProgrammesAttendues = new HashMap<Integer, TondeuseProgramme>();
		tondeuseProgrammesAttendues.put(0, new TondeuseProgramme(Arrays.asList("GAGAGAGAA".split(""))));
		tondeuseProgrammesAttendues.put(1, new TondeuseProgramme(Arrays.asList("AADAADADDA".split(""))));
		String data = chargerData();
		// ACT
		environnement.initialiser(data);
		// ASSERT
		Environnement system = (Environnement) this.environnement;
		Map<Integer, TondeuseProgramme> tondeuseProgrammesProduits = system.getTondeuseProgrammes();
		assertEquals("Le system n'a pas correctement initialise les programmes des tondeuses", tondeuseProgrammesAttendues, tondeuseProgrammesProduits);
	}
	
	@Test
	public void initialiserDoitRenvoyerUneListeDeDeuxIds() throws IOException {
		// ARRANGE
		List<Integer> idsAttendus = Arrays.asList(0, 1);
		String data = chargerData();
		// ACT
		List<Integer> idsProduits = environnement.initialiser(data);
		// ASSERT
		assertEquals("Le system n'est pas correctement initialise", idsAttendus, idsProduits);
	}
	
	@Test
	public void doitExecuterUnProgrammeEtRenvoyerLaBonneDescription() throws IOException {
		// ARRANGE
		TondeuseDescription tondeuseDescriptionAttendue = new TondeuseDescription(new Tondeuse(new Position(1, 3), Orientation.Y_POSITIF));
		String data = chargerData();
		List<Integer> identifiants = environnement.initialiser(data);
		// ACT
		TondeuseDescription tondeuseDescriptionProduite = environnement.executerTondeuseProgramme(identifiants.get(0)); 
		// ASSERT
		assertEquals("La description retournee n'est pas correcte", tondeuseDescriptionAttendue, tondeuseDescriptionProduite);
	}
	
	private String chargerData() throws IOException {
		InputStream inputStream = new FileInputStream("src/test/resources/test-1-data.txt");
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
