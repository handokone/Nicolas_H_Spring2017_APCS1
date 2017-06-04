package textExcel;


public class SpreadsheetLocation implements Location
{
	private String loc;

	//Return row number
    public int getRow()
    {
        int rows = Integer.parseInt(loc.substring(1));
        return rows - 1;
    }

    //Return the col character's ASCII value
    public int getCol()
    {
        char collumn = loc.charAt(0);
        int cols = (int) collumn;
        return cols - 'A';
    }
    
    //Conctructor
    public SpreadsheetLocation(String cellName)
    {
    	loc = cellName;
    }

}
