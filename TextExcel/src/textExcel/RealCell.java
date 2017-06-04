package textExcel;

public abstract class RealCell implements Cell{
	
	private String userInput = "";
	
	//Constructor
	public RealCell(String content){
		userInput = content;
	}
	
	//Concatenate string into 10 characters long. 
	public String abbreviatedCellText(){
		String abbreviatedText = "";
		if(userInput.length() < 10){
			if(userInput.contains("%")){
				abbreviatedText = userInput.substring(0, userInput.indexOf(".")) + "%";
				return (abbreviatedText + "          ").substring(0, 10);
			}
			if(userInput.equals("0.0")){
				return (userInput + "          ").substring(0, 10);
			}
			if(!userInput.contains(".") && !userInput.contains("(") && !userInput.contains("%")){
				abbreviatedText = userInput + ".0";
				return (abbreviatedText + "          ").substring(0, 10);
			}
			if(!userInput.contains("(")){
				for(int i = userInput.length() - 1; i > 0; i--){
					if(userInput.charAt(userInput.length() - 1) == '0'){
						if(userInput.charAt(userInput.length() - 2) == '0'){
							userInput = userInput.substring(0, userInput.length() - 1);
						}
						userInput = userInput.substring(0, userInput.length() - 1);
					}
				}
			}
			if(userInput.charAt(userInput.length() - 1) == '.'){
				userInput += "0";
			}
		}else if(userInput.length() > 10){
			return (userInput + "          ").substring(0, 10);
		}
		return (userInput + "          ").substring(0, 10); 
	}
	
	//Return whatever is inside the cell as a full string, even if longer than 10 characters. 
	public String fullCellText(){
		RealCell cell;
		if(userInput.equals("0")){
			return "0";
		}
		if(userInput.contains("%")){
			cell = new PercentCell(userInput);
		}else{
			cell = new ValueCell(userInput);
		}
		String stringCell = cell.getDoubleValue() + "";
		if((stringCell.length() > 3) && (cell.getDoubleValue() > 0) && (stringCell.substring(stringCell.indexOf(".")).equals(".0"))){
			return stringCell.substring(0, stringCell.indexOf("."));
		}
		return cell.getDoubleValue() + "";
	}
	
	//Parse the value passed as a double
	public double getDoubleValue() {
		return Double.parseDouble(userInput);
	}
	
	//Set value passed into the RealCell
	public void setRealCell(String inputVal){
		userInput = inputVal;
	}
	
	//Return the value inside the RealCell
	public String getRealCell(){
		return userInput;
	}

}
