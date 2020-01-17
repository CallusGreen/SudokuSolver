package logic;

import java.util.ArrayList;

public class Grid {

	// <----------------- Object Variables -----------------> //
	private ArrayList<Row> theGrid;

	// <------------------- Constructors -------------------> //
	public Grid() {
		this.theGrid = new ArrayList<Row>();
		int gridParams = 9;
		createGrid(gridParams);
	}

	// <---------------------- Methods ---------------------> //

	public void createGrid(int sizeOfGrid) {
		for(int rowCounter = 0; rowCounter < sizeOfGrid; rowCounter++) {
			Row tempRow = new Row(rowCounter);
			for(int cellCounter = 0; cellCounter < sizeOfGrid; cellCounter++) {
				Cell tempCell = new Cell(cellCounter, rowCounter);
				tempRow.add(tempCell);
			}
			add(tempRow);
		}
	}
	
	public void addNumbersToGrid() {
		placeNumberInCell(4, 0, 3);
		placeNumberInCell(5, 0, 2);
		placeNumberInCell(7, 0, 5);
		placeNumberInCell(8, 0, 7);
		placeNumberInCell(2, 1, 5);
		placeNumberInCell(3, 1, 1);
		placeNumberInCell(0, 2, 2);
		placeNumberInCell(1, 2, 8);
		placeNumberInCell(2, 2, 1);
		placeNumberInCell(3, 2, 7);
		placeNumberInCell(4, 2, 4);
		placeNumberInCell(5, 2, 5);
		placeNumberInCell(7, 2, 9);
		placeNumberInCell(8, 2, 6);
		placeNumberInCell(4, 3, 7);
		placeNumberInCell(2, 4, 8);
		placeNumberInCell(5, 4, 9);
		placeNumberInCell(6, 4, 7);
		placeNumberInCell(7, 4, 6);
		placeNumberInCell(1, 5, 4);
		placeNumberInCell(3, 5, 5);
		placeNumberInCell(5, 5, 1);
		placeNumberInCell(8, 5, 8);
		placeNumberInCell(0, 6, 5);
		placeNumberInCell(2, 6, 3);
		placeNumberInCell(3, 6, 9);
		placeNumberInCell(4, 6, 8);
		placeNumberInCell(5, 6, 4);
		placeNumberInCell(7, 6, 7);
		placeNumberInCell(0, 7, 6);
		placeNumberInCell(2, 7, 4);
		placeNumberInCell(4, 7, 5);
		placeNumberInCell(5, 7, 7);
		placeNumberInCell(7, 7, 3);
		placeNumberInCell(8, 7, 1);
		placeNumberInCell(2, 8, 2);
		placeNumberInCell(4, 8, 1);
		placeNumberInCell(8, 8, 9);
	}

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
		}

		if(yCoord >= 0 && yCoord <= 2) {
			startingYCoord = 0;
		} else if (yCoord >= 3 && yCoord <= 5) {
			startingYCoord = 3;
		} else if (yCoord > 5 && yCoord < 9) {
			startingYCoord = 6;
		}

		for(int j = startingYCoord; j < startingYCoord + 3; j++) {
			for(int i = startingXCoord; i < startingXCoord + 3; i++) {
				Cell tempCell = getTheGrid().get(j).getTheRow().get(i);
				theSquare.add(tempCell);
			}
		}
		return theSquare;
	}

	//can number go in any other square in big square

	public boolean isOnlyOneSquareValid(Cell cell) {
		ArrayList<Cell> theSquare = getSquareFromCoords(cell.getxCoord(), cell.getyCoord());

		theSquare = removeFullCellsFromList(theSquare);

		for(int i=1; i<9; i++) {
			int numCells = 0;
			Cell onlyCell = new Cell();

			for(Cell tempCell : theSquare) {
				if(canNumberGoHere(i, tempCell)) {
					numCells++;
					onlyCell = tempCell;
				}
			}
			if(numCells == 1) {
				setNumberOnCell(onlyCell, i);
				System.out.println("Added a " + onlyCell.getNumber() + " at: " + onlyCell.toCoords() + " - BY NEW SQUARE METHOD");
				printGrid();
				System.out.println("---------------------------------");
				return true;
			}
		}
		return false;
	}

	public ArrayList<Cell> removeFullCellsFromList(ArrayList<Cell> list){

		ArrayList<Cell> theList = new ArrayList<>();

		for(Cell tempCell : list) {
			if(tempCell.getNumber() == 0) {
				theList.add(tempCell);
			}
		}

		return theList;
	}
	
	public void printCellList(ArrayList<Cell> list) {
		
		for(Cell tempCell : list) {
			System.out.println(tempCell.potentialValuesToString());
		}
		
	}

	public boolean isOnlyOneCellInRowValid(Cell cell) {

		ArrayList<Cell> newRow = new ArrayList<Cell>();

		for(Cell tempCell : getTheGrid().get(cell.getyCoord()).getTheRow()) {
			if(tempCell.getNumber() == 0) {
				newRow.add(tempCell);
			}
		}

		for(int i=1; i<9; i++) {
			int numCells = 0;
			Cell onlyCell = new Cell();
			for(Cell tempCell : newRow) {
				if(canNumberGoHere(i, tempCell)) {
					numCells++;
					onlyCell = tempCell;
				}
			}
			if(numCells == 1) {
				setNumberOnCell(onlyCell, i);
				System.out.println("Added a " + onlyCell.getNumber() + " at: " + onlyCell.toCoords() + " - BY NEW ROW METHOD");
				printGrid();
				System.out.println("---------------------------------");
				return true;
			}
		}
		return false;
	}

	public boolean isOnlyOneCellInColValid(Cell cell) {

		ArrayList<Cell> newCol = new ArrayList<Cell>();

		for(Cell tempCell : getColumn(cell.getxCoord())) {
			if(tempCell.getNumber() == 0) {
				newCol.add(tempCell);
			}
		}

		for(int i=1; i<9; i++) {
			int numCells = 0;
			Cell onlyCell = new Cell();
			for(Cell tempCell : newCol) {
				if(canNumberGoHere(i, tempCell)) {
					numCells++;
					onlyCell = tempCell;
				}
			}
			if(numCells == 1) {
				setNumberOnCell(onlyCell, i);
				System.out.println("Added a " + onlyCell.getNumber() + " at: " + onlyCell.toCoords() + " - BY NEW COL METHOD");
				printGrid();
				System.out.println("---------------------------------");
				return true;
			}
		}
		return false;
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

	//can num go in other column in square
	public boolean canNumGoInOtherColumnInSquare(int theNumber, Cell theCell) {

		int megaColNum = 0;
		if(theCell.getxCoord() >= 0 && theCell.getxCoord() <= 2) {
			megaColNum = 0;
		} else if(theCell.getxCoord() >=3 && theCell.getxCoord() <= 5) {
			megaColNum = 3;
		} else {
			megaColNum = 6;
		}
		boolean canNumGoInOtherCol = false;

		for(int i=megaColNum; i<megaColNum+3; i++) {
			//doesn't test against own column
			if(i!=theCell.getxCoord()) {
				//if number is not in other column
				if(!(isNumberInColumn(theNumber, getTheGrid().get(0).getTheRow().get(i)))) {
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
				if(!(isNumberInRow(theNumber, getTheGrid().get(i).getTheRow().get(0)))) {
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
		boolean canNumGoInOtherColumn = canNumGoInOtherColumnInSquare(theNumber, theCell);
		boolean techniqueWorks = false;
		if(canNumGoInOtherColumn) {
		} else {
			boolean canNumGo1 = true;
			boolean canNumGo2 = true;
			if(whereIsCellInRows(theCell) == 0) {
				canNumGo1 = canNumberGoHere(theNumber, 
						getCellFromCoordinates(theCell.getxCoord(), theCell.getyCoord()-1));
				canNumGo2 = canNumberGoHere(theNumber, 
						getCellFromCoordinates(theCell.getxCoord(), theCell.getyCoord()-2));				
			} else if(whereIsCellInRows(theCell) == 1) {
				canNumGo1 = canNumberGoHere(theNumber, 
						getCellFromCoordinates(theCell.getxCoord(), theCell.getyCoord()+1));
				canNumGo2 = canNumberGoHere(theNumber, 
						getCellFromCoordinates(theCell.getxCoord(), theCell.getyCoord()+2));
			} else {
				canNumGo1 = canNumberGoHere(theNumber, 
						getCellFromCoordinates(theCell.getxCoord(), theCell.getyCoord()+1));
				canNumGo2 = canNumberGoHere(theNumber, 
						getCellFromCoordinates(theCell.getxCoord(), theCell.getyCoord()-1));
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

	public int whereIsCellInCols(Cell theCell) {
		return (theCell.getxCoord()+1) % 3;
	}

	public int whereIsCellInRows(Cell theCell) {
		return (theCell.getyCoord()+1) % 3;
	}

	public boolean canNumberGoHere(int theNumber, Cell theCell) {
		boolean numberCanGoHere = true;
		if(isNumberInRow(theNumber, theCell) 
				|| isNumberInColumn(theNumber, theCell) 
				|| isNumberInSquare(theNumber, theCell)
				|| colContainsTwoCellsWithSameNakedNumber(theCell, theNumber)
				|| rowContainsTwoCellsWithSameNakedNumber(theCell, theNumber)
				|| squareContainsTwoCellsWithSameNakedNumber(theCell, theNumber)
				|| theCell.getNumber()!= 0) {
			numberCanGoHere = false;
		}
		return numberCanGoHere;
	}

	public boolean colContainsTwoCellsWithSameNakedNumber(Cell theCell, int theNumber) {

		if(doesColHaveDoubleNakedPair(theCell)) {
			ArrayList<Cell> list = getColumn(theCell.getxCoord());
			int numCellsSharingNumber = 0;

			for(Cell tempCell : list) {
				if(!theCell.equals(tempCell) && tempCell.isNumPotentialNum(theNumber)) {
					numCellsSharingNumber++;
				}
			}
			if(numCellsSharingNumber >= 2) {
				return true;
			}	
		}
		return false;
	}

	public boolean rowContainsTwoCellsWithSameNakedNumber(Cell theCell, int theNumber) {

		if(doesRowHaveDoubleNakedPair(theCell)) {
			ArrayList<Cell> list = getTheGrid().get(theCell.getyCoord()).getTheRow();
			int numCellsSharingNumber = 0;

			for(Cell tempCell : list) {
				if((!theCell.equals(tempCell)) && tempCell.isNumPotentialNum(theNumber)) {
					numCellsSharingNumber++;
				}
			}
			if(numCellsSharingNumber >= 2) {
				return true;
			}	
		}
		return false;
	}

	// Cells 0,8 and 2,8 contain 3 so its not allowed to go there?
	// This needs to be changed, 
	
	public boolean squareContainsTwoCellsWithSameNakedNumber(Cell theCell, int theNumber) {

		if(doesSquareHaveDoubleNakedPair(theCell)) {
			ArrayList<Cell> list = getSquareFromCoords(theCell.getxCoord(), theCell.getyCoord());
			int numCellsSharingNumber = 0;

			for(Cell tempCell : list) {
				if(!theCell.equals(tempCell) && tempCell.isNumPotentialNum(theNumber)) {
					numCellsSharingNumber++;
				}
			}
			if(numCellsSharingNumber >= 2) {
				return true;
			}	
		}
		return false;
	}

	public boolean isNumberInRow(int theNumber, Cell theCell) {
		boolean numThere = false;
		Row tempRow = getTheGrid().get(theCell.getyCoord());
		for(Cell tempCell : tempRow.getTheRow()) {
			if(tempCell.getNumber() == theNumber) {
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

	public boolean doesColHaveDoubleNakedPair(Cell cell) {

		ArrayList<Cell> theCol = getColumn(cell.getxCoord());
		ArrayList<Cell> updatedCol = new ArrayList<>();

		updatedCol = removeFullCellsFromList(theCol);
		updatedCol = doesListContainCellsWithSameNakedPair(updatedCol);
		if(updatedCol.size() == 2) {
			if(cellsShareTheSameTwoNumbers(updatedCol.get(0), updatedCol.get(1))) {
				//printNakedPairsInGrid(updatedCol);
				return true;
			}
		}
		return false;
	}

	public boolean doesRowHaveDoubleNakedPair(Cell cell) {

		ArrayList<Cell> theRow = getTheGrid().get(cell.getyCoord()).getTheRow();
		ArrayList<Cell> updatedRow = new ArrayList<>();

		updatedRow = removeFullCellsFromList(theRow);
		updatedRow = doesListContainCellsWithSameNakedPair(updatedRow);
		
		if(updatedRow.size() == 2) {
			if(cellsShareTheSameTwoNumbers(updatedRow.get(0), updatedRow.get(1))) {
				//printNakedPairsInGrid(updatedRow);
				return true;
			}
		}
		return false;
	}

	public boolean doesSquareHaveDoubleNakedPair(Cell cell) {

		ArrayList<Cell> theSquare = getSquareFromCoords(cell.getxCoord(), cell.getyCoord());
		ArrayList<Cell> updatedSquare = new ArrayList<>();

		updatedSquare = removeFullCellsFromList(theSquare);
		updatedSquare = doesListContainCellsWithSameNakedPair(updatedSquare);
		if(updatedSquare.size() == 2) {
			if(cellsShareTheSameTwoNumbers(updatedSquare.get(0), updatedSquare.get(1))) {
				//printNakedPairsInGrid(updatedSquare);
				return true;
			}
		}
		return false;
	}

	public void printNakedPairsInGrid(ArrayList<Cell> list) {
		System.out.println("Cells: " + list.get(0).toCoords() + " & " + list.get(1).toCoords() + " share the same naked pair with: " 
				+ list.get(0).getTwoPotentialNums()[0] + " & " + list.get(0).getTwoPotentialNums()[1]);
	}

	public boolean cellsShareTheSameTwoNumbers(Cell cellOne, Cell cellTwo) {

		int[] cellOneArray = cellOne.getTwoPotentialNums();
		int cellOneNumOne = cellOneArray[0];
		int cellOneNumTwo = cellOneArray[1];

		int[] cellTwoArray = cellTwo.getTwoPotentialNums();
		int cellTwoNumOne = cellTwoArray[0];
		int cellTwoNumTwo = cellTwoArray[1];

		if(((cellOneNumOne == cellTwoNumOne) && (cellOneNumTwo == cellTwoNumTwo))
				|| ((cellOneNumOne == cellTwoNumTwo) && (cellOneNumTwo == cellTwoNumOne))) {
			if(doesCellHaveNakedPair(cellOne) && doesCellHaveNakedPair(cellTwo)) {
				return true;
			}
		}
		return false;
	}

	public ArrayList<Cell> doesListContainCellsWithSameNakedPair(ArrayList<Cell> list){
		ArrayList<Cell> pairedCells = new ArrayList<>();

		for(Cell tempCell : list) {
			for(Cell otherCell : list) {
				if((!tempCell.equals(otherCell)) && cellsShareTheSameTwoNumbers(tempCell, otherCell)) {
					if(!pairedCells.contains(tempCell)) {
						pairedCells.add(tempCell);
					}
				}
			}
		}
		return pairedCells;
	}
	
	public boolean onlyTwoPlacesForNakedPair(Cell cell, int number) {
		
		ArrayList<Cell> row = getTheGrid().get(cell.getyCoord()).getTheRow();
		
		ArrayList<Cell> availableCells = removeFullCellsFromList(row);
		
		if(availableCells.size() == 2) {
			return true;
		}
		
		int numberOfAvailableSquares = 0;
		
		for(Cell tempCell : availableCells) {
			if(canNumberGoHere(number, tempCell)) {
				numberOfAvailableSquares++;
			}
		}
		
		if(numberOfAvailableSquares == 2) {
			return true;
		}
		
		return false;
	}
	
	public void setNumberOnCell(Cell cell, int number) {
		
		cell.setNumber(number);
		
		int[] zeroArray = {0,0};
		cell.setTwoPotentialNums(zeroArray);
	}

	public boolean doesCellHaveNakedPair(Cell tempCell) {
		if(tempCell.numbersAreNotZero()) {
			return true;
		}
		return false;
	}

	public void printGrid() {
		for(Row tempRow : getTheGrid()) {
			System.out.println(tempRow);
		}
	}

	public void printPotentialValues() {
		for(Row tempRow : getTheGrid()) {
			for(Cell tempCell : tempRow.getTheRow()) {
				if(!tempCell.isNumPotentialNum(0)) {
					System.out.println(tempCell.potentialValuesToString());
				}
			}
		}
	}

	public void printAfterNumAdded(int value, Cell cell) {
		System.out.println("Added a " + value + " at: " + cell.toCoords());
		printGrid();
		System.out.println("---------------------------------");
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
