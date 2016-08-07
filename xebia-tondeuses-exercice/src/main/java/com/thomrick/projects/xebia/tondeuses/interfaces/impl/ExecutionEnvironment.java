package com.thomrick.projects.xebia.tondeuses.interfaces.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.thomrick.projects.xebia.tondeuses.interfaces.IExecutionEnvironment;
import com.thomrick.projects.xebia.tondeuses.interfaces.IProgramRunner;
import com.thomrick.projects.xebia.tondeuses.interfaces.mappers.GardenMapper;
import com.thomrick.projects.xebia.tondeuses.interfaces.mappers.MowerMapper;
import com.thomrick.projects.xebia.tondeuses.interfaces.mappers.ProgramMapper;
import com.thomrick.projects.xebia.tondeuses.interfaces.models.ExecutionReport;
import com.thomrick.projects.xebia.tondeuses.models.Garden;
import com.thomrick.projects.xebia.tondeuses.models.Mower;
import com.thomrick.projects.xebia.tondeuses.models.Program;

/**
 * ExecutionEnvironment.java
 *
 * @author ThomRick
 * @date 2016-08-04
 *
 */
public class ExecutionEnvironment implements IExecutionEnvironment {

	/** gardenMapper */
	private final GardenMapper gardenMapper;
	/** mowerMapper */
	private final MowerMapper mowerMapper;
	/** programMapper */
	private final ProgramMapper programMapper;
	/** programRunner */
	private IProgramRunner programRunner;

	/** ids */
	private List<Integer> ids;
	/** mowers */
	private Map<Integer, Mower> mowers;
	/** programs */
	private Map<Integer, Program> programs;
	/** garden */
	private Garden garden;
	
	/**
	 * ExecutionEnvironment 
	 *
	 */
	public ExecutionEnvironment() {
		this.gardenMapper = new GardenMapper();
		this.mowerMapper = new MowerMapper();
		this.programMapper = new ProgramMapper();
		this.programRunner = new ProgramRunner();
		this.ids = new ArrayList<Integer>();
		this.mowers = new HashMap<Integer, Mower>();
		this.programs = new HashMap<Integer, Program>();
	}
	
	/* (non-Javadoc)
	 * @see com.thomrick.projects.xebia.tondeuses.interfaces.IEnvironnement#initialiser(java.lang.String)
	 */
	public List<Integer> initialize(String fileContent) {
		List<String> fileContentLines = Arrays.asList(fileContent.split("\n"));
		initializeGardenFrom(fileContentLines);
		initialiszeMowersFrom(fileContentLines);
		return this.ids;
	}

	/**
	 * initializeGardenFrom
	 * 
	 * @param fileContentLines
	 */
	private void initializeGardenFrom(List<String> fileContentLines) {
		String gardenDescription = fileContentLines.get(0);
		this.garden = this.gardenMapper.mappFrom(gardenDescription);
	}
	
	/**
	 * initialiszeMowersFrom
	 * 
	 * @param fileContentLines
	 */
	private void initialiszeMowersFrom(List<String> fileContentLines) {
		int nombreLignes = fileContentLines.size();
		for (int i = 1; i < nombreLignes; i += 2) {
			int newId = generateNewId();
			String mowerDecription = fileContentLines.get(i);
			String mowerDescription = fileContentLines.get(i + 1);
			addMower(newId, mowerDecription);
			addProgram(newId, mowerDescription);
		}
	}
	
	/**
	 * generateNewId
	 * 
	 * @return a new id
	 */
	private int generateNewId() {
		int newId = this.mowers.size();
		this.ids.add(newId);
		return newId;
	}

	/**
	 * addMower
	 * 
	 * @param id
	 * @param mowerDescription
	 */
	private void addMower(int id, String mowerDescription) {
		Mower mower = this.mowerMapper.mappFrom(mowerDescription);
		this.mowers.put(id, mower);
	}

	/**
	 * addProgram
	 * 
	 * @param id
	 * @param programDescription
	 */
	private void addProgram(int id, String programDescription) {
		Program program = this.programMapper.mappFrom(programDescription);
		this.programs.put(id, program);
	}
	
	/* (non-Javadoc)
	 * @see com.thomrick.projects.xebia.tondeuses.interfaces.IEnvironnement#executerTondeuseProgramme(int)
	 */
	public ExecutionReport executeProgramById(int identifiant) {
		Mower mower = mowers.get(identifiant);
		Program program = programs.get(identifiant);
		return this.programRunner.run(program, mower, garden);
	}

	/**
	 * getMowers
	 * 
	 * @return the mowers
	 */
	public Map<Integer, Mower> getMowers() {
		return mowers;
	}

	/**
	 * getPrograms
	 * 
	 * @return the programs
	 */
	public Map<Integer, Program> getPrograms() {
		return programs;
	}

	/**
	 * getGarden
	 * 
	 * @return the garden
	 */
	public Garden getGarden() {
		return garden;
	}
	
	
}
