package textExcel;

public abstract class RealCell implements Cell{
	
	private String userInput = "";
	
	public RealCell(String content){
		userInput = content;
	}
	public String abbreviatedCellText(){
		if(userInput.length() >= 10){
			return userInput.substring(0, 10);
		}else if(userInput.length() < 10){
			
		}
		return null;
	}
	
	public String fullCellText(){
		return null;
	}
	
	public abstract double getDoubleValue();

}