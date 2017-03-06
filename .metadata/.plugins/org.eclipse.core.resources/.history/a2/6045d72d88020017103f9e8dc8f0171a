package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;


public class TextExcel
{

	public static void main(String[] args)
	{
	    Spreadsheet sheets = new Spreadsheet();
	    Scanner userInput = new Scanner(System.in);
	    String userScanner = userInput.next();
	    while(!userScanner.equals("quit")){
	    	sheets.processCommand(userScanner);
	    	userScanner = userInput.next();
	    }
	}
}
