package views;

import java.util.ArrayList;
import java.util.HashMap;
import helpers.Headers;

public interface ReportView {

	public void export(HashMap<Integer, HashMap<Headers, ArrayList<String>>> information);
}
