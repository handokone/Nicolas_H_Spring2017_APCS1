package textExcel;


public class SpreadsheetLocation implements Location
{
	private String loc;

    public int getRow()
    {
        int rows = Integer.parseInt(loc.substring(1));
        return rows - 1;
    }

    public int getCol()
    {
        char collumn = loc.charAt(0);
        int cols = (int) collumn;
        return cols - 'A';
    }
    
    public SpreadsheetLocation(String cellName)
    {
    	this.loc = cellName;
    }

}
