package com.thomrick.projects.xebia.tondeuses.interfaces;

import com.thomrick.projects.xebia.tondeuses.interfaces.models.TondeuseDescription;
import com.thomrick.projects.xebia.tondeuses.models.Pelouse;
import com.thomrick.projects.xebia.tondeuses.models.Tondeuse;
import com.thomrick.projects.xebia.tondeuses.models.TondeuseProgramme;

public interface IProgrammeRunner {
	
	TondeuseDescription run(TondeuseProgramme tondeuseProgramme, Tondeuse tondeuse, Pelouse pelouse);
}
