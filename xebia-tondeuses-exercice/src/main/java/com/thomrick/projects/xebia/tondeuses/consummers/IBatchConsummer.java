package com.thomrick.projects.xebia.tondeuses.consummers;

import java.io.IOException;

public interface IBatchConsummer {
	
	String run(String filePath) throws IOException;
	
}
