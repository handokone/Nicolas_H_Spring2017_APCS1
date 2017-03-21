package textExcel;

public class TextCell implements Cell {

	private String strContent = "";
	
	public TextCell(String strContent){
		this.strContent = strContent;
	}

	public String abbreviatedCellText() {
		String abbreviatedText = "";
		char[] charArray = strContent.toCharArray();
		
		if(strContent.contains("\"")){
			for(int i = 1; i < strContent.length() - 1; i++){
				abbreviatedText += charArray[i];
			}
		}
		if(strContent.length() > 10){
			return abbreviatedText.substring(0,10);
		}else{
			while(abbreviatedText.length() < 10){
				abbreviatedText = abbreviatedText + " ";
			}
			return abbreviatedText;
		}
	}

	public String fullCellText() {
		return strContent;
	}
	
}
