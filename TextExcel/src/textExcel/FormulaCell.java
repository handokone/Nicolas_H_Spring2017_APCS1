package textExcel;

public class FormulaCell extends RealCell{

	public FormulaCell(String userInput){
		super(userInput);
		
	}
	
	public double getDoubleValue(){
		//Return whatever you want. 
		return 1.0;
	}
}
