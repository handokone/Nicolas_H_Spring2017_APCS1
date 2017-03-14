package textExcel;

public class TextCell implements Cell {

	private String strContent = "";
	private String[] arraysChar = strContent.split("");

	public String abbreviatedCellText() {
		String abbreviatedText = "";
		if(strContent.contains("\"")){
			abbreviatedText = strContent.substring(1, strContent.length() - 1);
		}
		if(strContent.length() > 10){
			for(int i = 0; i < 10; i++){
				abbreviatedText = abbreviatedText + arraysChar[i];
			}
			return abbreviatedText;
		}else{
			while(abbreviatedText.length() != 10){
				abbreviatedText = abbreviatedText + " ";
			}
			return abbreviatedText;
		}
	}

	public String fullCellText() {
		return strContent;
	}
	
	public void setValue(String strContent){
		this.strContent = strContent;
	}
	
	public TextCell(String strContent){
		this.strContent = strContent;
	}

}
