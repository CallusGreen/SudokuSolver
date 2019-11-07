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
	/*
	public boolean isPotentialNumberInRowTwice(int theNumber, int rowNum) {
		boolean numThere = false;
		int numberCounter = 0;
		Row tempRow = getTheGrid().get(rowNum);
		for(Cell tempCell : tempRow.getTheRow()) {
			if(tempCell.isNumPotentialNum(theNumber)) {
				numberCounter++;
			}
		}
		if(numberCounter == 2) {
			numThere = true;
		}
		return numThere;
	}
	
	public boolean isPotentialNumberInColumnTwice(int theNumber, int colNum) {
		boolean numThere = false;
		int numberCounter = 0;
		ArrayList<Cell> tempCol = getColumn(colNum);
		for(Cell tempCell : tempCol) {
			if(tempCell.isNumPotentialNum(theNumber)) {
				numberCounter++;
			}
		}
		if(numberCounter == 2) {
			numThere = true;
		}
		return numThere;
	}
	
	public boolean isPotentialNumberInSquareTwice(int theNumber, Cell theCell) {
		boolean numThere = false;
		int numberCounter = 0;
		ArrayList<Cell> theSquare = getSquareFromCoords(theCell.getxCoord(), theCell.getyCoord());
		for(Cell tempCell : theSquare) {
			if(tempCell.isNumPotentialNum(theNumber)) {
				numberCounter++;
			}
		}
		if(numberCounter == 2) {
			numThere = true;
		}
		return numThere;
	}
*/
	//can num go in other column in square
	public boolean canNumGoInOtherColumnInSquare(int theNumber, int colNum) {

		int megaColNum = 0;
		if(colNum >= 0 && colNum <= 2) {
			megaColNum = 0;
		} else if(colNum >=3 && colNum <= 5) {
			megaColNum = 3;
		} else {
			megaColNum = 6;
		}
		boolean canNumGoInOtherCol = false;
		
		for(int i=megaColNum; i<megaColNum+3; i++) {
			//doesn't test against own column
			if(i!=colNum) {
				//if number is not in other column
				if(!(isNumberInColumn(theNumber, i))) {
					canNumGoInOtherCol = true;
				}
			}
		}
		//if number is not in other column return true
		return canNumGoInOtherCol;
	}
	
	//can num go in other row in square
	public boolean canNumGoInOtherRowInSquare(int theNumber, int rowNum) {
		int megaRowNum = 0;
		if(rowNum >= 0 && rowNum <= 2) {
			megaRowNum = 0;
		} else if(rowNum >=3 && rowNum <= 5) {
			megaRowNum = 3;
		} else {
			megaRowNum = 6;
		}
		boolean canNumGoInOtherRow = false;
		
		for(int i=megaRowNum; i<megaRowNum+3; i++) {
			//doesn't test against own column
			if(i!=rowNum) {
				//if number is not in other column
				if(!(isNumberInRow(theNumber, i))) {
					canNumGoInOtherRow = true;
				}
			}
		}
		//if number is not in other column return true
		return canNumGoInOtherRow;
	}
	
	public boolean threesTechniqueRow(int theNumber, Cell theCell) {
		boolean canNumGoInOtherRow = canNumGoInOtherRowInSquare(theNumber, theCell.getyCoord());
		boolean techniqueWorks = false;
		if(canNumGoInOtherRow) {
		} else {
			boolean canNumGo1 = true;
			boolean canNumGo2 = true;
			if(whereIsCellInCols(theCell) == 0) {
				canNumGo1 = canNumberGoHere(theNumber, getCellFromCoordinates(theCell.getxCoord()-1, theCell.getyCoord()));
				canNumGo2 = canNumberGoHere(theNumber, getCellFromCoordinates(theCell.getxCoord()-2, theCell.getyCoord()));
			} else if(whereIsCellInCols(theCell) == 1) {
				canNumGo1 = canNumberGoHere(theNumber, getCellFromCoordinates(theCell.getxCoord()+1, theCell.getyCoord()));
				canNumGo2 = canNumberGoHere(theNumber, getCellFromCoordinates(theCell.getxCoord()+2, theCell.getyCoord()));
			} else {
				canNumGo1 = canNumberGoHere(theNumber, getCellFromCoordinates(theCell.getxCoord()+1, theCell.getyCoord()));
				canNumGo2 = canNumberGoHere(theNumber, getCellFromCoordinates(theCell.getxCoord()-1, theCell.getyCoord()));
			}
			if(canNumGo1 || canNumGo2) {
				
			} else {
				if(canNumberGoHere(theNumber, theCell) && theCell.getNumber()==0) {
					techniqueWorks = true;
				}
			}
		}
		return techniqueWorks;
	}
	
	public boolean threesTechniqueCol(int theNumber, Cell theCell) {
		boolean canNumGoInOtherColumn = canNumGoInOtherColumnInSquare(theNumber, theCell.getxCoord());
		boolean techniqueWorks = false;
		if(canNumGoInOtherColumn) {
		} else {
			boolean canNumGo1 = true;
			boolean canNumGo2 = true;
			if(whereIsCellInRows(theCell) == 0) {
				canNumGo1 = canNumberGoHere(theNumber, getCellFromCoordinates(theCell.getxCoord(), theCell.getyCoord()-1));
				canNumGo2 = canNumberGoHere(theNumber, getCellFromCoordinates(theCell.getxCoord(), theCell.getyCoord()-2));				
			} else if(whereIsCellInRows(theCell) == 1) {
				canNumGo1 = canNumberGoHere(theNumber, getCellFromCoordinates(theCell.getxCoord(), theCell.getyCoord()+1));
				canNumGo2 = canNumberGoHere(theNumber, getCellFromCoordinates(theCell.getxCoord(), theCell.getyCoord()+2));
			} else {
				canNumGo1 = canNumberGoHere(theNumber, getCellFromCoordinates(theCell.getxCoord(), theCell.getyCoord()+1));
				canNumGo2 = canNumberGoHere(theNumber, getCellFromCoordinates(theCell.getxCoord(), theCell.getyCoord()-1));
			}
			if(canNumGo1 || canNumGo2) {
				
			} else {
				if(canNumberGoHere(theNumber, theCell) && theCell.getNumber()==0) {
					techniqueWorks = true;
				}
				//getTheGrid().get(theCell.getyCoord()).getTheRow().get(theCell.getxCoord()).setNumber(theNumber);
			}
		}
		return techniqueWorks;
	}
	
	// CHECK THE NUMBER IS NOT IN THE SQUARE
	// CHECK THE NUMBER IS NOT IN THE ROW
	// CHECK THE NUMBER IS NOT IN THE COLUMN
	
	// 3S TEQUNIQUE
	// CHECK IF NUMBER IS IN OTHER TWO ROWS IN YOUR QUADRANT
	// IF NOT - SKIP
	// IF IN BOTH ROWS - CHECK IF THERE IS SPACE TO EITHER SIDE
	// IF NO SPACE - PLACE NUMBER
	// IF SPACE 1/2 - CHECK IF CAN PLACE NUMBER THERE
	// IF YES - SKIP
	// IF NO - PLACE IN ORIGNAL SQUARE
	
	// Modulus Checking:
	// The Cell's xcoord+1 %3
	// if 0, 1, 2
	// if 0 - the right side
	// if 1 - the left side
	// if 2 - the middle
	
	public int whereIsCellInCols(Cell theCell) {
		return (theCell.getxCoord()+1) % 3;
	}
	
	public int whereIsCellInRows(Cell theCell) {
		return (theCell.getyCoord()+1) % 3;
	}
	
	public boolean canNumberGoHere(int theNumber, Cell theCell) {
		boolean numberCanGoHere = true;
		if(isNumberInRow(theNumber, theCell.getyCoord()) 
				|| isNumberInColumn(theNumber, theCell.getxCoord()) 
				|| isNumberInSquare(theNumber, theCell)
				|| theCell.getNumber()!= 0) {
			numberCanGoHere = false;
		}
		return numberCanGoHere;
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

	public boolean isNumberInColumn(int theNumber, int colNum) {
		boolean numThere = false;
		ArrayList<Cell> theColumn = getColumn(colNum);
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
