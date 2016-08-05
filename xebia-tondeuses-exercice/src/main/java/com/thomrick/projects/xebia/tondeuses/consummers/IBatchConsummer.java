package com.thomrick.projects.xebia.tondeuses.consummers;

import java.io.IOException;

/**
 * IBatchConsummer.java
 *
 * @author ThomRick
 * @date 2016-08-04
 *
 */
public interface IBatchConsummer {
	
	/**
	 * run
	 * 
	 * @param filePath
	 * @return le resultat d'execution du batch sous forme d'une chaine de caracteres
	 * @throws IOException
	 */
	String run(String filePath) throws IOException;
	
}
