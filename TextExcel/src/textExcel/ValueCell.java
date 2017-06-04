package textExcel;

public class ValueCell extends RealCell{
	
	private String userInput = "";

	//Constructor
	public ValueCell(String userInput) {
		super(userInput);
		this.userInput = userInput;
		setRealCell(userInput);
	}

	//Return the value passed as a double. 
	public double getDoubleValue() {
		return Double.parseDouble(userInput);
	}
}
