package com.thomrick.projects.xebia.tondeuses.interfaces.impl;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.thomrick.projects.xebia.tondeuses.interfaces.IProgrammeRunner;
import com.thomrick.projects.xebia.tondeuses.interfaces.constantes.InstructionConstantes;
import com.thomrick.projects.xebia.tondeuses.interfaces.models.TondeuseDescription;
import com.thomrick.projects.xebia.tondeuses.models.Orientation;
import com.thomrick.projects.xebia.tondeuses.models.Pelouse;
import com.thomrick.projects.xebia.tondeuses.models.Position;
import com.thomrick.projects.xebia.tondeuses.models.Tondeuse;
import com.thomrick.projects.xebia.tondeuses.models.TondeuseProgramme;

public class ProgrammeRunnerTest {
	
	private IProgrammeRunner programmeRunner;
	
	@Before
	public void initialiser() {
		programmeRunner = new ProgrammeRunner();
	}

	@Test
	public void doitExecuterLeProgrammeEnPivotantLaTondeuseSurLaDroite() {
		// ARRANGE
		Pelouse pelouse = new Pelouse(5, 5);
		TondeuseProgramme tondeuseProgramme = new TondeuseProgramme(Arrays.asList(InstructionConstantes.PIVOTER_DROITE));
		Tondeuse tondeuse = new Tondeuse(new Position(0, 0), Orientation.Y_POSITIF);
		TondeuseDescription tondeuseDescriptionAttendue = new TondeuseDescription(new Tondeuse(new Position(0, 0), Orientation.X_POSITIF));
		// ACT
		TondeuseDescription tondeuseDescriptionProduite = programmeRunner.run(tondeuseProgramme, tondeuse, pelouse); 
		// ASSERT
		assertEquals("Le programme ne s'est pas correctement execute", tondeuseDescriptionAttendue, tondeuseDescriptionProduite);
	}
	
	@Test
	public void doitExecuterLeProgrammeEnPivotantLaTondeuseSurLaGauche() {
		// ARRANGE
		Pelouse pelouse = new Pelouse(5, 5);
		TondeuseProgramme tondeuseProgramme = new TondeuseProgramme(Arrays.asList(InstructionConstantes.PIVOTER_GAUCHE));
		Tondeuse tondeuse = new Tondeuse(new Position(0, 0), Orientation.Y_POSITIF);
		TondeuseDescription tondeuseDescriptionAttendue = new TondeuseDescription(new Tondeuse(new Position(0, 0), Orientation.X_NEGATIF));
		// ACT
		TondeuseDescription tondeuseDescriptionProduite = programmeRunner.run(tondeuseProgramme, tondeuse, pelouse); 
		// ASSERT
		assertEquals("Le programme ne s'est pas correctement execute", tondeuseDescriptionAttendue, tondeuseDescriptionProduite);
	}
	
	@Test
	public void doitExecuterLeProgrammeEnFaisantAvancerLaTondeuseVersLesYPositifs() {
		// ARRANGE
		Pelouse pelouse = new Pelouse(5, 5);
		TondeuseProgramme tondeuseProgramme = new TondeuseProgramme(Arrays.asList(InstructionConstantes.AVANCER));
		Tondeuse tondeuse = new Tondeuse(new Position(0, 0), Orientation.Y_POSITIF);
		TondeuseDescription tondeuseDescriptionAttendue = new TondeuseDescription(new Tondeuse(new Position(0, 1), Orientation.Y_POSITIF));
		// ACT
		TondeuseDescription tondeuseDescriptionProduite = programmeRunner.run(tondeuseProgramme, tondeuse, pelouse); 
		// ASSERT
		assertEquals("Le programme ne s'est pas correctement execute", tondeuseDescriptionAttendue, tondeuseDescriptionProduite);
	}
	
	@Test
	public void doitExecuterLeProgrammeEnNeDeplacantPasLaTondeuseQuiAllaitSortirDeLaPelouse() {
		// ARRANGE
		Pelouse pelouse = new Pelouse(5, 5);
		TondeuseProgramme tondeuseProgramme = new TondeuseProgramme(Arrays.asList(InstructionConstantes.AVANCER));
		Tondeuse tondeuse = new Tondeuse(new Position(0, 0), Orientation.X_NEGATIF);
		TondeuseDescription tondeuseDescriptionAttendue = new TondeuseDescription(new Tondeuse(new Position(0, 0), Orientation.X_NEGATIF));
		// ACT
		TondeuseDescription tondeuseDescriptionProduite = programmeRunner.run(tondeuseProgramme, tondeuse, pelouse); 
		// ASSERT
		assertEquals("Le programme ne s'est pas correctement execute", tondeuseDescriptionAttendue, tondeuseDescriptionProduite);
	}

}
