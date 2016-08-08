package com.thomrick.projects.xebia.tondeuses;

import java.io.IOException;

import com.thomrick.projects.xebia.tondeuses.consummers.IBatchConsummer;
import com.thomrick.projects.xebia.tondeuses.consummers.impl.BatchConsummer;

/**
 * MowerExerciceStarter.java
 *
 * @author ThomRick
 * @date 2016-08-04
 *
 */
public class MowerExerciceStarter {

	/**
	 * main
	 * 
	 * @param filePaths
	 * @throws IOException
	 */
	public static void main(String[] filePaths) throws IOException {
		IBatchConsummer batchConsummer = new BatchConsummer();
		for (String filePath : filePaths) {
			String reportDisplayContent = batchConsummer.run(filePath);
			printReportDisplayContent(filePath, reportDisplayContent);
		}
	}
	
	/**
	 * printReportDisplayContent
	 * 
	 * @param filePath
	 * @param reportDisplayContent
	 */
	private static void printReportDisplayContent(String filePath, String reportDisplayContent) {
		System.out.println("Rapport d'execution:\n");
		System.out.println("	- fichier d'entree:");
		System.out.println(filePath + "\n");
		System.out.println("	- rapport de sortie:");
		System.out.println(reportDisplayContent);
		System.out.println("-------------------------------------");
	}

}
