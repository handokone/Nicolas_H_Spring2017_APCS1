package textExcel;

public class Spreadsheet implements Grid
{
	private int rows = 20;
	private int cols = 12;
	public Spreadsheet(){
		Cell[][] arrayExcell = new EmptyCell[rows][cols];
	}
	
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
		System.out.print("   |");
		for(char a = 'A'; a < 'M'; a++){
			System.out.print(a + "         |");
		}
		System.out.println("");
		for(int i = 1; i < 21; i++){
			System.out.print(i + "  ");
			for(int j = 0; j < 13; j++){
				System.out.print("|          ");
			}
			System.out.println("");
		}
		
		return "";
	}

}
