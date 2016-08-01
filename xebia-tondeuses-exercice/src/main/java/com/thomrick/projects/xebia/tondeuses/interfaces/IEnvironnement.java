package com.thomrick.projects.xebia.tondeuses.interfaces;

import java.util.List;

import com.thomrick.projects.xebia.tondeuses.interfaces.models.TondeuseDescription;

public interface IEnvironnement {
	
	List<Integer> initialiser(String data);
	TondeuseDescription executerTondeuseProgramme(int identifiant);
	
}
