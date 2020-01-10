package logic;

import java.util.ArrayList;

public class Solver {

	// <----------------- Object Variables -----------------> //
	private Grid aGrid;

	// <------------------- Constructors -------------------> //
	public Solver(Grid aGrid) {
		this.aGrid = aGrid;
	}

	// <---------------------- Methods ---------------------> //
	public void start() {
		int iterationCounter = 0;
		
		while(true) {
			boolean numAddedThisIteration = false;
			
			for(int rowCounter=0; rowCounter<9; rowCounter++) {
				for(int cellCounter=0; cellCounter<9; cellCounter++) {

					int valueCounter = 1;
					Cell tempCell = getaGrid().getCellFromCoordinates(cellCounter, rowCounter);
					ArrayList<Integer> potentialNumberList = new ArrayList<Integer>();

					if(tempCell.getNumber()==0) {
						while(valueCounter < 10) {
							
							if(getaGrid().threesTechniqueRow(valueCounter, tempCell)) {
								getaGrid().getCellFromCoordinates(cellCounter, rowCounter).setNumber(valueCounter);
								getaGrid().printAfterNumAdded(valueCounter, tempCell);
								numAddedThisIteration = true;
								break;
								
							} else if (getaGrid().threesTechniqueCol(valueCounter, tempCell)) {
								getaGrid().getCellFromCoordinates(cellCounter, rowCounter).setNumber(valueCounter);
								getaGrid().printAfterNumAdded(valueCounter, tempCell);
								numAddedThisIteration = true;
								break;
								
							} else if(getaGrid().canNumberGoHere(valueCounter, tempCell)) {
								potentialNumberList.add(valueCounter);
							}
							
							valueCounter++;
						}

						if(tempCell.getNumber()==0 && potentialNumberList.size()==1) {
							getaGrid().getCellFromCoordinates(cellCounter, rowCounter).setNumber(potentialNumberList.get(0));
							getaGrid().printAfterNumAdded(potentialNumberList.get(0), tempCell);
							numAddedThisIteration = true;
							
						}
						
						if(getaGrid().isOnlyOneSquareValid(tempCell)) {
							numAddedThisIteration = true;
						}
						if(getaGrid().isOnlyOneCellInRowValid(tempCell)) {
							numAddedThisIteration = true;
						}
						if(getaGrid().isOnlyOneCellInColValid(tempCell)) {
							numAddedThisIteration = true;
						}
						
						if(potentialNumberList.size() == 2) {
							int[] potentialNumbers = putListNumbersIntoArray(potentialNumberList);
							tempCell.setTwoPotentialNums(potentialNumbers);
						}
					}
					getaGrid().doesColHaveDoubleNakedPair(tempCell);
					getaGrid().doesRowHaveDoubleNakedPair(tempCell);
					getaGrid().doesSquareHaveDoubleNakedPair(tempCell);

				}//end loop through cells
			}//end loop through rows
			
			if(getaGrid().isSudokuFinished()) {
				break;
			}
			
			if(numAddedThisIteration == false) {
				iterationCounter++;
			} else {
				iterationCounter = 0;
			}
			
			if(iterationCounter == 3) {
				break;
			}
		}
		getaGrid().printGrid();
	}
	
	public int[] putListNumbersIntoArray(ArrayList<Integer> list) {
		int size = list.size();
		int[] regularArray = new int[size];
		
		for(int i=0; i<size; i++) {
			regularArray[i] = list.get(i);
		}
		
		return regularArray;
	}

	// <---------------- Getters & Setters -----------------> //
	public Grid getaGrid() {
		return aGrid;
	}

	public void setaGrid(Grid aGrid) {
		this.aGrid = aGrid;
	}
}
