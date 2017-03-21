package textExcel;

public class FormulaCell extends RealCell{
	private String value = "";
	public FormulaCell(String userInput){
		value = userInput;
		
	}
	
	public double getDoubleValue(){
		//Return whatever you want. 
		return 1.0;
	}
}
