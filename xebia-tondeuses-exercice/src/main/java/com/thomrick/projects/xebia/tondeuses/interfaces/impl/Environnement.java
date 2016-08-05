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

/**
 * Environnement.java
 *
 * @author ThomRick
 * @date 2016-08-04
 *
 */
public class Environnement implements IEnvironnement {

	/** pelouseMapper */
	private final PelouseMapper pelouseMapper;
	/** tondeuseMapper */
	private final TondeuseMapper tondeuseMapper;
	/** tondeuseProgrammeMapper */
	private final TondeuseProgrammeMapper tondeuseProgrammeMapper;
	/** programmeRunner */
	private IProgrammeRunner programmeRunner;

	/** identifiants */
	private List<Integer> identifiants;
	/** tondeuses */
	private Map<Integer, Tondeuse> tondeuses;
	/** tondeuseProgrammes */
	private Map<Integer, TondeuseProgramme> tondeuseProgrammes;
	/** pelouse */
	private Pelouse pelouse;
	
	/**
	 * Environnement 
	 *
	 */
	public Environnement() {
		this.pelouseMapper = new PelouseMapper();
		this.tondeuseMapper = new TondeuseMapper();
		this.tondeuseProgrammeMapper = new TondeuseProgrammeMapper();
		this.programmeRunner = new ProgrammeRunner();
		this.identifiants = new ArrayList<Integer>();
		this.tondeuses = new HashMap<Integer, Tondeuse>();
		this.tondeuseProgrammes = new HashMap<Integer, TondeuseProgramme>();
	}
	
	/* (non-Javadoc)
	 * @see com.thomrick.projects.xebia.tondeuses.interfaces.IEnvironnement#initialiser(java.lang.String)
	 */
	public List<Integer> initialiser(String contenuFichier) {
		List<String> contenuFichierLignes = Arrays.asList(contenuFichier.split("\n"));
		initialiserPelouse(contenuFichierLignes);
		initialiserTondeuses(contenuFichierLignes);
		return this.identifiants;
	}

	/**
	 * initialiserPelouse
	 * 
	 * @param contenuFichierLignes
	 */
	private void initialiserPelouse(List<String> contenuFichierLignes) {
		String pelouseDescription = contenuFichierLignes.get(0);
		this.pelouse = this.pelouseMapper.mappFrom(pelouseDescription);
	}
	
	/**
	 * initialiserTondeuses
	 * 
	 * @param contenuFichierLignes
	 */
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
	
	/**
	 * genererTondeuseIdentifiant
	 * 
	 * @return un identifiant genere pour identifier une nouvelle tondeuse
	 */
	private int genererTondeuseIdentifiant() {
		int identifiant = this.tondeuses.size();
		this.identifiants.add(identifiant);
		return identifiant;
	}

	/**
	 * ajouterTondeuse
	 * 
	 * @param identifiant
	 * @param tondeuseDescription
	 */
	private void ajouterTondeuse(int identifiant, String tondeuseDescription) {
		Tondeuse tondeuse = this.tondeuseMapper.mappFrom(tondeuseDescription);
		this.tondeuses.put(identifiant, tondeuse);
	}

	/**
	 * ajouterTondeuseProgramme
	 * 
	 * @param identifiant
	 * @param tondeuseProgrammeDescription
	 */
	private void ajouterTondeuseProgramme(int identifiant, String tondeuseProgrammeDescription) {
		TondeuseProgramme tondeuseProgramme = this.tondeuseProgrammeMapper.mappFrom(tondeuseProgrammeDescription);
		this.tondeuseProgrammes.put(identifiant, tondeuseProgramme);
	}
	
	/* (non-Javadoc)
	 * @see com.thomrick.projects.xebia.tondeuses.interfaces.IEnvironnement#executerTondeuseProgramme(int)
	 */
	public TondeuseDescription executerTondeuseProgramme(int identifiant) {
		Tondeuse tondeuse = tondeuses.get(identifiant);
		TondeuseProgramme tondeuseProgramme = tondeuseProgrammes.get(identifiant);
		return this.programmeRunner.run(tondeuseProgramme, tondeuse, pelouse);
	}
	
	/**
	 * getPelouse
	 * 
	 * @return la pelouse du systeme
	 */
	public Pelouse getPelouse() {
		return this.pelouse;
	}
	
	/**
	 * getTondeuses
	 * 
	 * @return la table des tondeuses du syteme
	 */
	public Map<Integer, Tondeuse> getTondeuses() {
		return this.tondeuses;
	}

	/**
	 * getTondeuseProgrammes
	 * 
	 * @return la table des programmes associes aux tondeuses du systeme
	 */
	public Map<Integer, TondeuseProgramme> getTondeuseProgrammes() {
		return this.tondeuseProgrammes;
	}
	
}
