import java.util.ArrayList;

public class Row {

	// <----------------- Object Variables -----------------> //
	private ArrayList<Cell> theRow;
	private int rowNum;

	// <------------------- Constructors -------------------> //
	public Row(int rowNum) {
		this.theRow = new ArrayList<Cell>();
		this.rowNum = rowNum;
	}

	public Row() {
		this.theRow = new ArrayList<Cell>();
	}

	// <---------------------- Methods ---------------------> //
	public void add(Cell cell) {
		getTheRow().add(cell);
	}

	public String toString() {
		String output = "";
		for(Cell tempCell : getTheRow()) {
			output = output + tempCell;
		}
		if(getRowNum() != 0 && (getRowNum()+1) % 3 == 0) {
			output = output + "\n";
		}
		return output;
	}

	// <---------------- Getters & Setters -----------------> //
	public ArrayList<Cell> getTheRow() {
		return theRow;
	}

	public void setTheRow(ArrayList<Cell> theRow) {
		this.theRow = theRow;
	}

	public int getRowNum() {
		return rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}
}
