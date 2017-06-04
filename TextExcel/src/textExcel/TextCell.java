package textExcel;

public class TextCell implements Cell {

	private String strContent = "";
	
	//Constructor
	public TextCell(String strContent){
		this.strContent = strContent;
	}

	//Concatenate string so it's only 10 characters long. 
	public String abbreviatedCellText() {
		String abbreviatedText = "";
		char[] charArray = strContent.toCharArray();
		
		if(strContent.contains("\"")){
			for(int i = 1; i < strContent.length() - 1; i++){
				abbreviatedText += charArray[i];
			}
		}
		return (abbreviatedText + "          ").substring(0, 10);
	}

	//Return full string even if it's more than 10 characters long. 
	public String fullCellText() {
		return strContent;
	}
	
}
