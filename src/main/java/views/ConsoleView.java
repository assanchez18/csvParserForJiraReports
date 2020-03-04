package views;

import java.util.ArrayList;
import java.util.HashMap;

import helpers.Headers;

public class ConsoleView implements ReportView {

	public void export(HashMap<Integer, HashMap<Headers, ArrayList<String>>> information) {
		for(HashMap<Headers, ArrayList<String>> content : information.values()) {
			printMap(content);
		}
	}

	private void printMap(HashMap<Headers, ArrayList<String>> content) {
		for(Headers h : content.keySet()) {
			for(String s : content.get(h)) {
				System.out.println(h.label +  "\t" + s);
			}
		}
	}
}
