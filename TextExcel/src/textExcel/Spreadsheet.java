package textExcel;

public class Spreadsheet implements Grid
{
	private int rows = 20;
	private int cols = 12;
	private Cell[][] arrayExcell = new EmptyCell[rows][cols];
	
	private String fullGrid = "";

	public String processCommand(String command)
	{
		return command;
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
		return null;
	}

	public String getGridText()
	{
		/*for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				fullGrid = fullGrid + arrayExcell[i][j];
			}
		}
		return fullGrid;
		*/
		//Cell[][] sprsht = new EmptyCell[rows][cols];
		//Use this to put in the cells. 
	}

}
