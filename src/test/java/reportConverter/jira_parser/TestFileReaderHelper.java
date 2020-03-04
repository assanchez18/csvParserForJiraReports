package reportConverter.jira_parser;

import java.io.FileNotFoundException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import helpers.FileReaderHelper;
import junit.framework.TestCase;

public class TestFileReaderHelper extends TestCase {
	
	private FileReaderHelper fr;
	private final String file = "C:\\Users\\enassre\\eclipse-workspace\\jira_parser\\FileForTestingJira.csv";
	
	@Before
	public void tearUp() {
		this.fr = null;
	}
	
	@After
	public void tearDown() {
		if(this.fr != null)
			this.fr.closeReader();
	}
	
	@Test
	public void testGivenWrongFileThenError() {
		try {
			this.fr = new FileReaderHelper("emptyFile");
			fail("Expected a FileNotFoundException to be thrown.");
		} catch(FileNotFoundException e) {
		    assertEquals(e.getMessage(), "emptyFile (The system cannot find the file specified)");
		}
	}	
	
	@Test
	public void testGivenValidFileThenRead() {
		try {
			this.fr = new FileReaderHelper(this.file);
		} catch(FileNotFoundException e) {
			fail("FileNotFoundException not expected. " + e.getMessage() );
		}
		String line = this.fr.nextLine();
		assertFalse("Could not read from a file.", line.isEmpty());
	}
	
	@Test
	public void testGivenValidFileThenParseHeaders() {
		try {
			this.fr = new FileReaderHelper(this.file);
		} catch(FileNotFoundException e) {
			fail("FileNotFoundException not expected. " + e.getMessage() );
		}
		
	}
}
