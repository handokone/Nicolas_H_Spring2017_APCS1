package textExcel;

public class ValueCell extends RealCell{
	
	public ValueCell(String content) {
		super(content);
	}

	@Override
	public double getDoubleValue() {
		return 0;
	}
}
