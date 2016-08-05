package com.thomrick.projects.xebia.tondeuses;

import java.io.IOException;

import com.thomrick.projects.xebia.tondeuses.consummers.IBatchConsummer;
import com.thomrick.projects.xebia.tondeuses.consummers.impl.BatchConsummer;

/**
 * TondeusesExerciceStarter.java
 *
 * @author ThomRick
 * @date 2016-08-04
 *
 */
public class TondeusesExerciceStarter {

	/**
	 * main
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] filePaths) throws IOException {
		IBatchConsummer batchConsummer = new BatchConsummer();
		for (String filePath : filePaths) {
			String rapport = batchConsummer.run(filePath);
			printRapport(filePath, rapport);
		}
	}
	
	/**
	 * printRapport
	 * 
	 * @param filePath
	 * @param rapport
	 */
	private static void printRapport(String filePath, String rapport) {
		System.out.println("Rapport d'execution:\n");
		System.out.println("	- fichier d'entree:");
		System.out.println(filePath + "\n");
		System.out.println("	- rapport de sortie:");
		System.out.println(rapport);
		System.out.println("-------------------------------------");
	}

}
