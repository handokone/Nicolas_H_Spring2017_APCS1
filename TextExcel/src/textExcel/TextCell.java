package textExcel;

public class TextCell implements Cell {
	
	private String strContent = "";
	private String[] arraysChar = strContent.split("");
	private String abbreviatedText;

	public String abbreviatedCellText() {
		for(int i = 0; i < 10; i++){
			abbreviatedText = abbreviatedText + arraysChar[i];
		}
		return abbreviatedText;
	}

	public String fullCellText() {
		return null;
	}
	
	public void setValue(String strContent){
		this.strContent = strContent;
	}

}
