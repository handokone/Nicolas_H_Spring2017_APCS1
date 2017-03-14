package textExcel;

public class TextCell implements Cell {

	private String strContent;

	public String abbreviatedCellText() {
		String abbreviatedText = "";
		if(strContent.contains("\"")){
			abbreviatedText = strContent.substring(1, strContent.length() - 1);
		}
		if(strContent.length() > 10){
			abbreviatedText = abbreviatedText.substring(0,10);
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
	
	public TextCell(String strContent){
		this.strContent = strContent;
	}

}
