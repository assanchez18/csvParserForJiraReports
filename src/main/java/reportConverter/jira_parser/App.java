package reportConverter.jira_parser;

import java.io.IOException;

import helpers.FileReaderHelper;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	if (args.length == 0) {
    		System.out.println("Missing CSV File");
    		return;
    	}
    	try {
			FileReaderHelper fr = new FileReaderHelper(args[0]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println( "Hello World!" );
    }
}
