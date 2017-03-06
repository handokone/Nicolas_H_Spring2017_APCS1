package textExcel;

//Class that returns empty cells

public class EmptyCell implements Cell {

	public String abbreviatedCellText() {
		return "";
	}

	public String fullCellText() {
		return "";
	}

}
