package helpers;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class FileReaderHelper {

	private File file;
	private Scanner sc;

	public FileReaderHelper(final String fileName) throws FileNotFoundException {
		try {
			this.file = new File(fileName);
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			throw (e);
		}
	}

	public String nextLine() {
		return sc.nextLine();
	}

	public boolean hasNextLine() {
		if (this.sc.hasNextLine())
			return true;
		else {
			closeReader();
			return false;
		}
	}

	public String[] splitBySemicolon(String line) {
		return line.split(";");
	}

	public void closeReader() {
		if (this.sc != null)
			this.sc.close();
	}

}
