package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	private int rows = 20;
	private int cols = 12;
	private int[][] arrayExcell = new int[rows][cols];
	

	@Override
	public String processCommand(String command)
	{
		return command;
	}

	@Override
	public int getRows()
	{
		return this.rows;
	}

	@Override
	public int getCols()
	{
		return this.cols;
	}

	@Override
	public Cell getCell(Location loc)
	{
		return null;
	}

	@Override
	public String getGridText()
	{
		return null;
	}

}
