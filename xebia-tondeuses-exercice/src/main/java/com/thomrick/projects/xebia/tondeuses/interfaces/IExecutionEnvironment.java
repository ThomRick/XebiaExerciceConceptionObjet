package com.thomrick.projects.xebia.tondeuses.interfaces;

import java.util.List;

import com.thomrick.projects.xebia.tondeuses.interfaces.models.ExecutionReport;

/**
 * IExecutionEnvironment.java
 *
 * @author ThomRick
 * @date 2016-08-04
 *
 */
public interface IExecutionEnvironment {
	
	/**
	 * initialize
	 * 
	 * @param data
	 * @return list of created ids
	 */
	List<Integer> initialize(String data);
	
	/**
	 * executeProgramById
	 * 
	 * @param id
	 * @return a report of program id execution
	 */
	ExecutionReport executeProgramById(int id);
	
}
