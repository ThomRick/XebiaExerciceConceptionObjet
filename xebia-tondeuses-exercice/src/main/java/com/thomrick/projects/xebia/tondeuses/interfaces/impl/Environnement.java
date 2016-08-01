package com.thomrick.projects.xebia.tondeuses.interfaces.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.thomrick.projects.xebia.tondeuses.interfaces.IEnvironnement;
import com.thomrick.projects.xebia.tondeuses.interfaces.IProgrammeRunner;
import com.thomrick.projects.xebia.tondeuses.interfaces.mappers.PelouseMapper;
import com.thomrick.projects.xebia.tondeuses.interfaces.mappers.TondeuseMapper;
import com.thomrick.projects.xebia.tondeuses.interfaces.mappers.TondeuseProgrammeMapper;
import com.thomrick.projects.xebia.tondeuses.interfaces.models.TondeuseDescription;
import com.thomrick.projects.xebia.tondeuses.models.Pelouse;
import com.thomrick.projects.xebia.tondeuses.models.Tondeuse;
import com.thomrick.projects.xebia.tondeuses.models.TondeuseProgramme;

public class Environnement implements IEnvironnement {

	private final PelouseMapper pelouseMapper;
	private final TondeuseMapper tondeuseMapper;
	private final TondeuseProgrammeMapper tondeuseProgrammeMapper;
	private IProgrammeRunner programmeRunner;

	private List<Integer> identifiants;
	private Map<Integer, Tondeuse> tondeuses;
	private Map<Integer, TondeuseProgramme> tondeuseProgrammes;
	private Pelouse pelouse;
	
	public Environnement() {
		this.pelouseMapper = new PelouseMapper();
		this.tondeuseMapper = new TondeuseMapper();
		this.tondeuseProgrammeMapper = new TondeuseProgrammeMapper();
		this.programmeRunner = new ProgrammeRunner();
		this.identifiants = new ArrayList<Integer>();
		this.tondeuses = new HashMap<Integer, Tondeuse>();
		this.tondeuseProgrammes = new HashMap<Integer, TondeuseProgramme>();
	}
	
	public List<Integer> initialiser(String contenuFichier) {
		List<String> contenuFichierLignes = Arrays.asList(contenuFichier.split("\n"));
		initialiserPelouse(contenuFichierLignes);
		initialiserTondeuses(contenuFichierLignes);
		return this.identifiants;
	}

	private void initialiserPelouse(List<String> contenuFichierLignes) {
		String pelouseDescription = contenuFichierLignes.get(0);
		this.pelouse = this.pelouseMapper.mappFrom(pelouseDescription);
	}
	
	private void initialiserTondeuses(List<String> contenuFichierLignes) {
		int nombreLignes = contenuFichierLignes.size();
		for (int i = 1; i < nombreLignes; i += 2) {
			int tondeuseIdentifiant = genererTondeuseIdentifiant();
			String tondeuseDescription = contenuFichierLignes.get(i);
			String tondeuseProgrammeDescription = contenuFichierLignes.get(i + 1);
			ajouterTondeuse(tondeuseIdentifiant, tondeuseDescription);
			ajouterTondeuseProgramme(tondeuseIdentifiant, tondeuseProgrammeDescription);
		}
	}
	
	private int genererTondeuseIdentifiant() {
		int identifiant = this.tondeuses.size();
		this.identifiants.add(identifiant);
		return identifiant;
	}

	private void ajouterTondeuse(int identifiant, String tondeuseDescription) {
		Tondeuse tondeuse = this.tondeuseMapper.mappFrom(tondeuseDescription);
		this.tondeuses.put(identifiant, tondeuse);
	}


	private void ajouterTondeuseProgramme(int identifiant, String tondeuseProgrammeDescription) {
		TondeuseProgramme tondeuseProgramme = this.tondeuseProgrammeMapper.mappFrom(tondeuseProgrammeDescription);
		this.tondeuseProgrammes.put(identifiant, tondeuseProgramme);
	}
	
	public TondeuseDescription executerTondeuseProgramme(int identifiant) {
		Tondeuse tondeuse = tondeuses.get(identifiant);
		TondeuseProgramme tondeuseProgramme = tondeuseProgrammes.get(identifiant);
		return this.programmeRunner.run(tondeuseProgramme, tondeuse, pelouse);
	}
	
	public Pelouse getPelouse() {
		return this.pelouse;
	}
	
	public Map<Integer, Tondeuse> getTondeuses() {
		return this.tondeuses;
	}

	public Map<Integer, TondeuseProgramme> getTondeuseProgrammes() {
		return this.tondeuseProgrammes;
	}
	
}