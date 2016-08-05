package com.thomrick.projects.xebia.tondeuses.interfaces;

import com.thomrick.projects.xebia.tondeuses.interfaces.models.TondeuseDescription;
import com.thomrick.projects.xebia.tondeuses.models.Pelouse;
import com.thomrick.projects.xebia.tondeuses.models.Tondeuse;
import com.thomrick.projects.xebia.tondeuses.models.TondeuseProgramme;

/**
 * IProgrammeRunner.java
 *
 * @author ThomRick
 * @date 2016-08-04
 *
 */
public interface IProgrammeRunner {
	
	/**
	 * run
	 * 
	 * @param tondeuseProgramme
	 * @param tondeuse
	 * @param pelouse
	 * @return la description d'une tondeuse apres execution de son programme
	 */
	TondeuseDescription run(TondeuseProgramme tondeuseProgramme, Tondeuse tondeuse, Pelouse pelouse);
}
