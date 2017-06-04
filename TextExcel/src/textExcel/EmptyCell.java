package textExcel;

//Class that returns empty cells

public class EmptyCell implements Cell {

	//Constructor
	public EmptyCell(){
	}
	
	//Just 10 empty spaces
	public String abbreviatedCellText() {
		return "          ";
	}

	//Nothing inside the string
	public String fullCellText() {
		return "";
	}

}
