package textExcel;
import java.io.*;
import java.util.*;

public class Spreadsheet implements Grid
{
	private int rows = 20;
	private int cols = 12;
	private Cell[][] arrayExcell = new Cell[20][12];
	
	public Spreadsheet(){
		for(int i = 0; i < 20; i++){
			for(int j = 0; j < 12; j++){
				arrayExcell[i][j] = new EmptyCell();
			}
		}
	} 

	public String processCommand(String command)
	{
		String[] commandSplit = command.split(" ");
		if(command.toLowerCase().contains("save")){
			return (writeToFile(commandSplit[1]));
		}
		if(command.toLowerCase().contains("open")){
			return (readFromFile(commandSplit[1]));
		}
		if(command.equals("")){
			return "";
		}else if(command.length() <= 3){
			return checkCell(commandSplit[0].toUpperCase());
		}else if(commandSplit.length >= 3){
			String input = commandSplit[2];
			for(int i = 3; i < commandSplit.length; i++){
				input += " " + commandSplit[i];
			}
			String cellName = commandSplit[0].toUpperCase();
			assignCell(input, cellName);
			return getGridText();
		}else if(commandSplit[0].toLowerCase().contains("clear")){
			if(commandSplit.length == 1){
				for(int i = 0; i < 20; i++){
					for(int j = 0; j < 12; j++){
						arrayExcell[i][j] = new EmptyCell();
					}
				}
				return getGridText();
			}else {
				clearOneCell(commandSplit[1].toUpperCase());
				return getGridText();
			}
		}
		return "";
	}

	public int getRows()
	{
		return this.rows;
	}

	public int getCols()
	{
		return this.cols;
	}

	public Cell getCell(Location loc)
	{
		return arrayExcell[loc.getRow()][loc.getCol()];
	}

	public String getGridText()
	{
		String gridText = "   |";
		
		for(char a = 'A'; a < 'M'; a++){
			gridText = gridText + a + "         |";
		}
		
		for(int i = 1; i <= rows; i++){
			
			gridText += "\n" + i;
			
			if(i < 10){
				gridText += "  |";
			}else if(i >= 10){
				gridText += " |";
			}
			for(int j = 0; j < cols; j++){
				gridText += arrayExcell[i-1][j].abbreviatedCellText() + "|";
			}
		}
		gridText += "\n";
		return gridText;
	}
	
	public void clearOneCell(String cellName){
		SpreadsheetLocation clearACell = new SpreadsheetLocation(cellName);
		arrayExcell[clearACell.getRow()][clearACell.getCol()] = new EmptyCell();
	}
	
	public void assignCell(String userInput, String cellName){
		SpreadsheetLocation assign = new SpreadsheetLocation(cellName);
		if(userInput.contains("\"")){
			arrayExcell[assign.getRow()][assign.getCol()] = new TextCell(userInput);
		}else if(userInput.contains("(")){
			arrayExcell[assign.getRow()][assign.getCol()] = new FormulaCell(userInput);
		}else if(userInput.contains("%")){
			arrayExcell[assign.getRow()][assign.getCol()] = new PercentCell(userInput);
		}else{
			arrayExcell[assign.getRow()][assign.getCol()] = new ValueCell(userInput);
		}
	}
	
	public String checkCell(String cellName){
		SpreadsheetLocation cellCheck = new SpreadsheetLocation(cellName); 
		return arrayExcell[cellCheck.getRow()][cellCheck.getCol()].fullCellText();
	}
	
	private String writeToFile(String filename){
		PrintStream outputFile;
		try {
			outputFile = new PrintStream(new File(filename));
		}
		catch (FileNotFoundException e){
			return "File not found: " + filename;
		}
		String data = "";
		for(int i = 0; i < 20; i++){
			for(int j = 0; j < 12; j++){
				//Make sure it's not an Empty Cell
				//Only cells with data are saved
				if(!(arrayExcell[i][j] instanceof EmptyCell)){
					if(arrayExcell[i][j] instanceof TextCell){
						data += "TextCell" + ",";
					}else if(arrayExcell[i][j] instanceof ValueCell){
						data += "ValueCell" + ",";
					}else if(arrayExcell[i][j] instanceof PercentCell){
						data += "PercentCell" + ",";
					}else{
						data += "FormulaCell" + ",";
					}
					outputFile.println((char)(j + 'A') + "" + (i + 1) + "," + data + arrayExcell[i][j].fullCellText());
				}
				data = "";
			}
		}
		outputFile.close();
		return "";
	}
	
	private String readFromFile(String filename){
		Scanner inputFile;
		try {
			inputFile = new Scanner(new File(filename));
		}
		catch (FileNotFoundException e){
			return "File not found: " + filename;
		}
		while(inputFile.hasNextLine()){
			String[] data = inputFile.nextLine().split(",", 3);
			if(data[1].equals("PercentCell")){
				data[2] = (Double.parseDouble(data[2]) * 100) + "%";
			}
			assignCell(data[2], data[0]);
		}
		inputFile.close();
		return getGridText();
	}

}
