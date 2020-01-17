package logic;

import java.util.ArrayList;

public class Solver {

	// <----------------- Object Variables -----------------> //
	private Grid grid;

	// <------------------- Constructors -------------------> //
	public Solver(Grid grid) {
		this.grid = grid;
	}

	// <---------------------- Methods ---------------------> //
	public void start() {
		int iterationCounter = 0;

		while(true) {
			boolean numAddedThisIteration = false;

			for(int rowCounter=0; rowCounter<9; rowCounter++) {
				for(int cellCounter=0; cellCounter<9; cellCounter++) {

					int valueCounter = 1;
					Cell tempCell = getGrid().getCellFromCoordinates(cellCounter, rowCounter);
					ArrayList<Integer> potentialNumberList = new ArrayList<Integer>();

					if(tempCell.getNumber()==0) {
						while(valueCounter < 10) {

							if(getGrid().threesTechniqueRow(valueCounter, tempCell)) {
								getGrid().setNumberOnCell(tempCell, valueCounter);
								System.out.println("3s technique row");
								getGrid().printAfterNumAdded(valueCounter, tempCell);
								numAddedThisIteration = true;
								break;

							} else if (getGrid().threesTechniqueCol(valueCounter, tempCell)) {
								getGrid().setNumberOnCell(tempCell, valueCounter);
								System.out.println("3s technique col");
								getGrid().printAfterNumAdded(valueCounter, tempCell);
								numAddedThisIteration = true;
								break;

							} else if(getGrid().canNumberGoHere(valueCounter, tempCell)) {
								potentialNumberList.add(valueCounter);
							}

							valueCounter++;
						}

						if(tempCell.getNumber()==0 && potentialNumberList.size()==1) {
							getGrid().setNumberOnCell(tempCell, potentialNumberList.get(0));
							getGrid().printAfterNumAdded(potentialNumberList.get(0), tempCell);
							numAddedThisIteration = true;

						}

						if(getGrid().isOnlyOneSquareValid(tempCell)) {
							numAddedThisIteration = true;
						}
						if(getGrid().isOnlyOneCellInRowValid(tempCell)) {
							numAddedThisIteration = true;
						}
						if(getGrid().isOnlyOneCellInColValid(tempCell)) {
							numAddedThisIteration = true;
						}

						if(potentialNumberList.size() == 2) {

							int[] potentialNumbers = putListNumbersIntoArray(potentialNumberList);
							tempCell.setTwoPotentialNums(potentialNumbers);
							System.out.println("Cell " + tempCell.toCoords() + " has been given " + potentialNumbers[0] + " & " + potentialNumbers[1] + " as potential numbers.");

						}						
					}
				}//end loop through cells
			}//end loop through rows

			getGrid().printCellList(getGrid().getColumn(8));

			if(getGrid().isSudokuFinished()) {
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
		getGrid().printGrid();
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
	public Grid getGrid() {
		return grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}
}
