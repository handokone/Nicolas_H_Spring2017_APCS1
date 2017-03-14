package textExcel;

public class Spreadsheet implements Grid
{
	private int rows = 20;
	private int cols = 12;
	private Cell[][] arrayExcell = new Cell[rows][cols];
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
		commandSplit[0] = commandSplit[0].toLowerCase();
		
		if(command.length() == 0){
			return "";
		}else if(commandSplit.length >= 3){
			String input = commandSplit[2];
			int count = 3;
			while(count < commandSplit.length){
				input += " " + commandSplit[count];
				count++;
			}
			assignCell(input, commandSplit[0].toUpperCase());
			return getGridText();
		}else if(command.length() <= 3){
			return checkCell(commandSplit[0].toUpperCase());
		}else if(commandSplit[0].contains("clear")){
			if(commandSplit.length == 1){
				clearCell();
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
			gridText += a + "         |";
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
	
	public void clearCell(){
		for(int i = 0; i < 20; i++){
			for(int j = 0; j < 12; i++){
				arrayExcell[i][j] = new EmptyCell();
			}
		}
	}
	
	public void clearOneCell(String cellName){
		SpreadsheetLocation clearACell = new SpreadsheetLocation(cellName);
		arrayExcell[clearACell.getRow()][clearACell.getCol()] = new EmptyCell();
	}
	
	public void assignCell(String userInput, String cellName){
		SpreadsheetLocation cellAssign = new SpreadsheetLocation(cellName);
		arrayExcell[cellAssign.getRow()][cellAssign.getCol()] = new TextCell(userInput);
	}
	
	public String checkCell(String cellName){
		SpreadsheetLocation cellCheck = new SpreadsheetLocation(cellName); 
		String check = arrayExcell[cellCheck.getRow()][cellCheck.getCol()].fullCellText();
		return check;
	}

}
