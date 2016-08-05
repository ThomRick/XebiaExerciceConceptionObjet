package com.thomrick.projects.xebia.tondeuses.models;

import java.util.ArrayList;
import java.util.List;

/**
 * TondeuseProgramme.java
 *
 * @author ThomRick
 * @date 2016-08-04
 *
 */
public class TondeuseProgramme {

	/** instructions */
	private List<String> instructions;
	
	/**
	 * TondeuseProgramme 
	 *
	 */
	public TondeuseProgramme() {
		this(new ArrayList<String>());
	}
	
	/**
	 * TondeuseProgramme 
	 *
	 * @param instructions
	 */
	public TondeuseProgramme(List<String> instructions) {
		this.instructions = instructions;
	}

	/**
	 * getInstructions
	 * 
	 * @return la liste des instructions du programme
	 */
	public List<String> getInstructions() {
		return instructions;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((instructions == null) ? 0 : instructions.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TondeuseProgramme other = (TondeuseProgramme) obj;
		if (instructions == null) {
			if (other.instructions != null)
				return false;
		} else if (!instructions.equals(other.instructions))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TondeuseProgramme [instructions=" + instructions + "]";
	}
	
}
