package textExcel;

public class PercentCell extends RealCell{
	
	private String userInput = "";
	
	//Constructor
	public PercentCell(String content){
		super(content);
		userInput = content;
		setRealCell(userInput);
	}
	
	//Value in decimal form, not percent form. 
	public double getDoubleValue() {
		return Double.parseDouble(userInput.substring(0, userInput.length() - 1)) / 100;
	}

}
