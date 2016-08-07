package com.thomrick.projects.xebia.tondeuses.interfaces;

import com.thomrick.projects.xebia.tondeuses.interfaces.models.ExecutionReport;
import com.thomrick.projects.xebia.tondeuses.models.Garden;
import com.thomrick.projects.xebia.tondeuses.models.Mower;
import com.thomrick.projects.xebia.tondeuses.models.Program;

/**
 * IProgramRunner.java
 *
 * @author ThomRick
 * @date 2016-08-04
 *
 */
public interface IProgramRunner {
	
	/**
	 * run
	 * 
	 * @param program
	 * @param mower
	 * @param garden
	 * @return a report of the execution
	 */
	ExecutionReport run(Program program, Mower mower, Garden garden);
}
