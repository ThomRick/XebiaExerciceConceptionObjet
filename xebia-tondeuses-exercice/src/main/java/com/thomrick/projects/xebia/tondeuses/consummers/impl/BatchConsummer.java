package com.thomrick.projects.xebia.tondeuses.consummers.impl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.thomrick.projects.xebia.tondeuses.consummers.IBatchConsummer;
import com.thomrick.projects.xebia.tondeuses.interfaces.IExecutionEnvironment;
import com.thomrick.projects.xebia.tondeuses.interfaces.impl.ExecutionEnvironment;
import com.thomrick.projects.xebia.tondeuses.interfaces.models.ExecutionReport;

/**
 * BatchConsummer.java
 *
 * @author ThomRick
 * @date 2016-08-04
 *
 */
public class BatchConsummer implements IBatchConsummer {
	
	/** executionEnvironment */
	private IExecutionEnvironment executionEnvironment;
	
	/**
	 * BatchConsummer 
	 *
	 */
	public BatchConsummer() {
		this.executionEnvironment = new ExecutionEnvironment();
	}
	
	/* (non-Javadoc)
	 * @see com.thomrick.projects.xebia.tondeuses.consummers.IBatchConsummer#run(java.lang.String)
	 */
	public String run(String filePath) throws IOException {
		String fileContent = getFileContentFrom(filePath);
		return printExecutionReportFrom(fileContent);
	}

	/**
	 * imprimerRapportFrom
	 * 
	 * @param data
	 * @return the displayed report content
	 */
	private String printExecutionReportFrom(String data) {
		StringBuilder reportContentBuilder = new StringBuilder();
		List<Integer> ids = this.executionEnvironment.initialize(data);
		for (int id : ids) {
			ExecutionReport executionReport = getExecutionReportOf(id);
			addExecutionReportTo(reportContentBuilder, executionReport);
		}
		return reportContentBuilder.toString();
	}

	/**
	 * getExecutionReport
	 * 
	 * @param id
	 * @return an execution report
	 */
	private ExecutionReport getExecutionReportOf(int id) {
		return this.executionEnvironment.executeProgramById(id);
	}
	
	/**
	 * addExecutionReportTo
	 * 
	 * @param executionReportContentBuilder
	 * @param executionReport
	 */
	private void addExecutionReportTo(StringBuilder executionReportContentBuilder, ExecutionReport executionReport) {
		String executionReportContent = executionReport.display();
		executionReportContentBuilder.append(executionReportContent);
		executionReportContentBuilder.append("\n");
	}

	/**
	 * getFileContentFrom
	 * 
	 * @param filePath
	 * @return the file content to execute batch
	 * @throws IOException
	 */
	private String getFileContentFrom(String filePath) throws IOException {
		InputStream inputStream = new FileInputStream("src/test/resources/test-1-data.txt");
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		String content = "";
		String ligne;
		while ((ligne = bufferedReader.readLine()) != null) {
			content += ligne + "\n";
		}
		bufferedReader.close();
		return content;
	}

}
