package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;


public class TextExcel
{

	public static void main(String[] args)
	{
	    Spreadsheet sheets = new Spreadsheet();
	    Scanner userInput = new Scanner(System.in);
	    String userScannerInput = userInput.next();
	    while(!userScannerInput.equals("quit")){
	    	sheets.processCommand(userScannerInput);
	    	userScannerInput = userInput.next();
	    }
	}
}
