package com.thomrick.projects.xebia.tondeuses.models;

import java.util.ArrayList;
import java.util.List;

public class TondeuseProgramme {

	private List<String> instructions;
	
	public TondeuseProgramme() {
		this(new ArrayList<String>());
	}
	
	public TondeuseProgramme(List<String> instructions) {
		this.instructions = instructions;
	}

	public List<String> getInstructions() {
		return instructions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((instructions == null) ? 0 : instructions.hashCode());
		return result;
	}

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

	@Override
	public String toString() {
		return "TondeuseProgramme [instructions=" + instructions + "]";
	}
	
}
