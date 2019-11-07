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

		while(true) {

			for(int rowCounter=0; rowCounter<9; rowCounter++) {
				for(int cellCounter=0; cellCounter<9; cellCounter++) {

					int valueCounter = 1;
					Cell tempCell = getaGrid().getCellFromCoordinates(cellCounter, rowCounter);
					ArrayList<Integer> potentialNumberList = new ArrayList<Integer>();

					if(tempCell.getNumber()==0) {
						while(valueCounter < 10) {

							if(getaGrid().isNumberInRow(valueCounter, rowCounter) 
									|| getaGrid().isNumberInColumn(valueCounter, tempCell) 
									|| getaGrid().isNumberInSquare(valueCounter, tempCell)) {
								valueCounter++;
							} else {
								potentialNumberList.add(valueCounter);
								valueCounter++;
							}
						}

						if(tempCell.getNumber()==0 && potentialNumberList.size()==1) {
							getaGrid().getCellFromCoordinates(cellCounter, rowCounter).setNumber(potentialNumberList.get(0));
							getaGrid().printGrid();
							System.out.println("Added a " + potentialNumberList.get(0) + " at: (" + cellCounter + "," + rowCounter + ")");
							System.out.println("---------------------------------");
						}
					}
				}//end loop through cells
			}//end loop through rows

			if(getaGrid().isSudokuFinished()) {
				break;
			}
		}
	}

	// <---------------- Getters & Setters -----------------> //
	public Grid getaGrid() {
		return aGrid;
	}

	public void setaGrid(Grid aGrid) {
		this.aGrid = aGrid;
	}
}
