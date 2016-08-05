package com.thomrick.projects.xebia.tondeuses.consummers.impl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.thomrick.projects.xebia.tondeuses.consummers.IBatchConsummer;
import com.thomrick.projects.xebia.tondeuses.interfaces.IEnvironnement;
import com.thomrick.projects.xebia.tondeuses.interfaces.impl.Environnement;
import com.thomrick.projects.xebia.tondeuses.interfaces.models.TondeuseDescription;

/**
 * BatchConsummer.java
 *
 * @author ThomRick
 * @date 2016-08-04
 *
 */
public class BatchConsummer implements IBatchConsummer {
	
	/** environnement */
	private IEnvironnement environnement;
	
	/**
	 * BatchConsummer 
	 *
	 */
	public BatchConsummer() {
		this.environnement = new Environnement();
	}
	
	/* (non-Javadoc)
	 * @see com.thomrick.projects.xebia.tondeuses.consummers.IBatchConsummer#run(java.lang.String)
	 */
	public String run(String filePath) throws IOException {
		String contenuFichier = recupererContenuFrom(filePath);
		return imprimerRapportFrom(contenuFichier);
	}

	/**
	 * imprimerRapportFrom
	 * 
	 * @param data
	 * @return une chaine de caractere rapport d'execution du batch
	 */
	private String imprimerRapportFrom(String data) {
		StringBuilder rapport = new StringBuilder();
		List<Integer> identifiants = this.environnement.initialiser(data);
		for (int identifiant : identifiants) {
			TondeuseDescription tondeuseDescription = recupererRapportExecutionProgramme(identifiant);
			ajouterRapportExecutionProgramme(rapport, tondeuseDescription);
		}
		return rapport.toString();
	}

	/**
	 * recupererRapportExecutionProgramme
	 * 
	 * @param identifiant
	 * @return la description d'une tondeuse apres execution de son programme
	 */
	private TondeuseDescription recupererRapportExecutionProgramme(int identifiant) {
		return this.environnement.executerTondeuseProgramme(identifiant);
	}
	
	/**
	 * ajouterRapportExecutionProgramme
	 * 
	 * @param rapport
	 * @param tondeuseDescription
	 */
	private void ajouterRapportExecutionProgramme(StringBuilder rapport, TondeuseDescription tondeuseDescription) {
		String description = tondeuseDescription.decrire();
		rapport.append(description);
		rapport.append("\n");
	}

	/**
	 * recupererContenuFrom
	 * 
	 * @param filePath
	 * @return le contenu du fichier pour executer le batch
	 * @throws IOException
	 */
	private String recupererContenuFrom(String filePath) throws IOException {
		InputStream inputStream = new FileInputStream("src/test/resources/test-1-data.txt");
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		String contenu = "";
		String ligne;
		while ((ligne = bufferedReader.readLine()) != null) {
			contenu += ligne + "\n";
		}
		bufferedReader.close();
		return contenu;
	}

}
