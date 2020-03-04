package reportConverter.jira_parser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import helpers.FileReaderHelper;
import helpers.Headers;

public class Parser {

	private FileReaderHelper fr;
	private HashMap<Headers, ArrayList<Integer>> headerRowMap;
	private HashMap<Integer, HashMap<Headers, ArrayList<String>>> rowInformation;
	
	
	public Parser(String file) throws FileNotFoundException, IOException {
		this.fr = new FileReaderHelper(file);
		this.headerRowMap = new HashMap<Headers, ArrayList<Integer>>();
		this.rowInformation = new HashMap<Integer, HashMap<Headers, ArrayList<String>>>();
	}
	
	
	public void parse() {
		this.headerRowMap = readHeaders();
		while(this.fr.hasNextLine()) {
			processNextRow(this.fr.nextLine());
		}		
	}
	
	
	
	public HashMap<Headers, ArrayList<Integer>> readHeaders() {
		String[] headers = this.fr.splitBySemicolon(this.fr.nextLine());
		HashMap<Headers, ArrayList<Integer>> headersMap =  new HashMap<Headers, ArrayList<Integer>>(); 
		for(Headers h : Headers.values()) {
			Integer position = 0;
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (String head : headers) {
				if (head.compareTo(h.label) == 0) {
					list.add(position);
				}
				position++;
			}
			headersMap.putIfAbsent(h, list);
		}
		return headersMap;
	}
	
	public void processNextRow(String line) {		
		String[] row = fr.splitBySemicolon(line);
		Integer issueID = Integer.valueOf(row[headerRowMap.get(Headers.ISSUE_ID).get(0)]);
		HashMap<Headers, ArrayList<String>> value = new HashMap<Headers, ArrayList<String>>();
		
		for(Headers h : this.headerRowMap.keySet()) {
			ArrayList<String> list = new ArrayList<String>();
		//can use iterator
			for (int i = 0; i < this.headerRowMap.get(h).size(); ++i) {
				list.add(row[i]);
			}
			value.put(h, list);
		}
			
		this.rowInformation.put(issueID, value);	
	}
	
	public void closeReader() {
		this.fr.closeReader();
	}
}
