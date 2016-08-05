package com.thomrick.projects.xebia.tondeuses.interfaces;

import java.util.List;

import com.thomrick.projects.xebia.tondeuses.interfaces.models.TondeuseDescription;

/**
 * IEnvironnement.java
 *
 * @author ThomRick
 * @date 2016-08-04
 *
 */
public interface IEnvironnement {
	
	/**
	 * initialiser
	 * 
	 * @param data
	 * @return la liste des identifiants des tondeuses apres initialisation du systeme
	 */
	List<Integer> initialiser(String data);
	
	/**
	 * executerTondeuseProgramme
	 * 
	 * @param identifiant
	 * @return la description de la tondeuse identifiant apres execution de son programme
	 */
	TondeuseDescription executerTondeuseProgramme(int identifiant);
	
}
