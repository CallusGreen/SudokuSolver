import java.util.ArrayList;
public class Grid {

	// <----------------- Object Variables -----------------> //
	private ArrayList<Row> theGrid;

	// <------------------- Constructors -------------------> //
	public Grid() {
		this.theGrid = new ArrayList<Row>();
		int gridParams = 9;
		for(int rowCounter=0; rowCounter<gridParams; rowCounter++) {
			Row tempRow = new Row(rowCounter);
			for(int cellCounter=0; cellCounter<gridParams; cellCounter++) {
				Cell tempCell = new Cell(cellCounter, rowCounter);
				tempRow.add(tempCell);
			}
			add(tempRow);
		}
	}

	// <---------------------- Methods ---------------------> //
	public ArrayList<Cell> getColumn(int colNum){
		ArrayList<Cell> theColumn = new ArrayList<Cell>();

		for(Row tempRow : getTheGrid()) {
			theColumn.add(tempRow.getTheRow().get(colNum));
		}
		return theColumn;
	}

	public Cell getCellFromCoordinates(int xCoord, int yCoord) {
		return getTheGrid().get(yCoord).getTheRow().get(xCoord);
	}

	public ArrayList<Cell> getSquareFromCoords(int xCoord, int yCoord){
		ArrayList<Cell> theSquare = new ArrayList<Cell>();
		int startingXCoord = 0;
		int startingYCoord = 0;

		if(xCoord >= 0 && xCoord <= 2) {
			startingXCoord = 0;
		} else if (xCoord >= 3 && xCoord <= 5) {
			startingXCoord = 3;
		} else if (xCoord > 5 && xCoord < 9) {
			startingXCoord = 6;
		} else {
			return new ArrayList<Cell>();
		}

		if(yCoord >= 0 && yCoord <= 2) {
			startingYCoord = 0;
		} else if (yCoord >= 3 && yCoord <= 5) {
			startingYCoord = 3;
		} else if (yCoord > 5 && yCoord < 9) {
			startingYCoord = 6;
		} else {
			return new ArrayList<Cell>();
		}

		for(int j=startingYCoord; j<startingYCoord+3; j++) {
			for(int i=startingXCoord; i<startingXCoord+3; i++) {
				Cell tempCell = getTheGrid().get(j).getTheRow().get(i);
				theSquare.add(tempCell);
			}
		}

		return theSquare;
	}

	public boolean isSudokuFinished() {
		boolean isFinished = true;
		for(Row tempRow : getTheGrid()) {
			for(Cell tempCell : tempRow.getTheRow()) {
				if(tempCell.getNumber()==0) {
					isFinished = false;
				}
			}
		}
		return isFinished;
	}

	public boolean isNumberInRow(int theNumber, int rowNum) {
		Row tempRow = getTheGrid().get(rowNum);
		boolean numThere = false;
		for(Cell tempCell : tempRow.getTheRow()) {
			if(tempCell.getNumber()==theNumber) {
				numThere = true;
			}
		}
		return numThere;
	}

	public boolean isNumberInColumn(int theNumber, Cell theCell) {
		boolean numThere = false;
		ArrayList<Cell> theColumn = getColumn(theCell.getxCoord());
		for(Cell tempCell : theColumn) {
			if(tempCell.getNumber()==theNumber) {
				numThere = true;
			}
		}
		return numThere;
	}

	public boolean isNumberInSquare(int theNumber, Cell theCell) {
		boolean numThere = false;

		ArrayList<Cell> theSquare = getSquareFromCoords(theCell.getxCoord(), theCell.getyCoord());
		for(Cell tempCell : theSquare) {
			if(tempCell.getNumber()==theNumber) {
				numThere = true;
			}
		}
		return numThere;
	}

	public void printGrid() {
		for(Row tempRow : getTheGrid()) {
			System.out.println(tempRow);
		}
	}

	public void placeNumberInCell(int xCoord, int yCoord, int num) {
		getTheGrid().get(yCoord).getTheRow().get(xCoord).setNumber(num);
	}

	public void add(Row row) {
		getTheGrid().add(row);
	}

	// <---------------- Getters & Setters -----------------> //
	public ArrayList<Row> getTheGrid() {
		return theGrid;
	}

	public void setTheGrid(ArrayList<Row> theGrid) {
		this.theGrid = theGrid;
	}
}
