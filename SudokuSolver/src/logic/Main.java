package logic;

public class Main {
	public static void main(String[] args) {
		Grid grid = new Grid();
/*
		grid.placeNumberInCell(4, 0, 3);
		grid.placeNumberInCell(5, 0, 2);
		grid.placeNumberInCell(7, 0, 5);
		grid.placeNumberInCell(8, 0, 7);
		grid.placeNumberInCell(2, 1, 5);
		grid.placeNumberInCell(3, 1, 1);
		grid.placeNumberInCell(0, 2, 2);
		grid.placeNumberInCell(1, 2, 8);
		grid.placeNumberInCell(2, 2, 1);
		grid.placeNumberInCell(3, 2, 7);
		grid.placeNumberInCell(4, 2, 4);
		grid.placeNumberInCell(5, 2, 5);
		grid.placeNumberInCell(7, 2, 9);
		grid.placeNumberInCell(8, 2, 6);
		grid.placeNumberInCell(4, 3, 7);
		grid.placeNumberInCell(2, 4, 8);
		grid.placeNumberInCell(5, 4, 9);
		grid.placeNumberInCell(6, 4, 7);
		grid.placeNumberInCell(7, 4, 6);
		grid.placeNumberInCell(1, 5, 4);
		grid.placeNumberInCell(3, 5, 5);
		grid.placeNumberInCell(5, 5, 1);
		grid.placeNumberInCell(8, 5, 8);
		grid.placeNumberInCell(0, 6, 5);
		grid.placeNumberInCell(2, 6, 3);
		grid.placeNumberInCell(3, 6, 9);
		grid.placeNumberInCell(4, 6, 8);
		grid.placeNumberInCell(5, 6, 4);
		grid.placeNumberInCell(7, 6, 7);
		grid.placeNumberInCell(0, 7, 6);
		grid.placeNumberInCell(2, 7, 4);
		grid.placeNumberInCell(4, 7, 5);
		grid.placeNumberInCell(5, 7, 7);
		grid.placeNumberInCell(7, 7, 3);
		grid.placeNumberInCell(8, 7, 1);
		grid.placeNumberInCell(2, 8, 2);
		grid.placeNumberInCell(4, 8, 1);
		grid.placeNumberInCell(8, 8, 9);
 		*/
		
		//expert
		grid.placeNumberInCell(2, 0, 5);
		grid.placeNumberInCell(5, 0, 8);
		grid.placeNumberInCell(0, 1, 1);
		grid.placeNumberInCell(2, 1, 6);
		grid.placeNumberInCell(5, 1, 3);
		grid.placeNumberInCell(8, 1, 4);		
		grid.placeNumberInCell(2, 2, 2);
		grid.placeNumberInCell(8, 2, 7);
		grid.placeNumberInCell(2, 3, 1);
		grid.placeNumberInCell(5, 3, 4);
		grid.placeNumberInCell(4, 4, 8);
		grid.placeNumberInCell(7, 4, 6);
		grid.placeNumberInCell(1, 5, 7);
		grid.placeNumberInCell(0, 6, 9);
		grid.placeNumberInCell(3, 6, 5);
		grid.placeNumberInCell(4, 6, 3);
		grid.placeNumberInCell(3, 7, 6);
		grid.placeNumberInCell(6, 7, 8);
		grid.placeNumberInCell(8, 7, 1);
		grid.placeNumberInCell(4, 8, 2);
		grid.placeNumberInCell(7, 8, 4);
		grid.placeNumberInCell(8, 8, 9);
		
		/*
		//hard 
		grid.placeNumberInCell(1, 0, 6);
		grid.placeNumberInCell(7, 0, 3);
		grid.placeNumberInCell(3, 1, 3);
		grid.placeNumberInCell(4, 1, 6);
		grid.placeNumberInCell(5, 1, 7);
		grid.placeNumberInCell(7, 1, 4);		
		grid.placeNumberInCell(1, 2, 7);
		grid.placeNumberInCell(8, 2, 1);
		grid.placeNumberInCell(2, 3, 3);
		grid.placeNumberInCell(5, 3, 2);
		grid.placeNumberInCell(1, 4, 1);
		grid.placeNumberInCell(3, 4, 6);
		grid.placeNumberInCell(1, 5, 9);
		grid.placeNumberInCell(3, 5, 7);
		grid.placeNumberInCell(4, 5, 5);
		grid.placeNumberInCell(5, 5, 1);
		grid.placeNumberInCell(1, 6, 2);
		grid.placeNumberInCell(3, 6, 9);
		grid.placeNumberInCell(7, 6, 6);
		grid.placeNumberInCell(0, 7, 6);
		grid.placeNumberInCell(6, 7, 5);
		grid.placeNumberInCell(7, 7, 2);
		grid.placeNumberInCell(2, 8, 1);
		grid.placeNumberInCell(4, 8, 7);
		grid.placeNumberInCell(8, 8, 4);
		*/

		//Medium
		/*
		grid.placeNumberInCell(1, 0, 3);
		grid.placeNumberInCell(2, 0, 9);
		grid.placeNumberInCell(5, 0, 7);
		grid.placeNumberInCell(8, 0, 5);
		grid.placeNumberInCell(1, 1, 7);
		grid.placeNumberInCell(3, 1, 9);
		grid.placeNumberInCell(4, 1, 1);
		grid.placeNumberInCell(7, 1, 2);
		grid.placeNumberInCell(0, 2, 5);
		grid.placeNumberInCell(1, 2, 4);
		grid.placeNumberInCell(8, 2, 1);
		grid.placeNumberInCell(2, 3, 3);
		grid.placeNumberInCell(4, 3, 7);
		grid.placeNumberInCell(5, 3, 1);
		grid.placeNumberInCell(6, 3, 2);
		grid.placeNumberInCell(0, 4, 2);
		grid.placeNumberInCell(2, 4, 7);
		grid.placeNumberInCell(3, 4, 3);
		grid.placeNumberInCell(5, 4, 9);
		grid.placeNumberInCell(6, 4, 5);
		grid.placeNumberInCell(0, 5, 9);
		grid.placeNumberInCell(7, 5, 3);
		grid.placeNumberInCell(8, 6, 6);
		grid.placeNumberInCell(1, 7, 2);
		grid.placeNumberInCell(6, 7, 3);
		grid.placeNumberInCell(7, 7, 4);
		grid.placeNumberInCell(8, 7, 7);
		grid.placeNumberInCell(2, 8, 5);
		grid.placeNumberInCell(4, 8, 6);
		grid.placeNumberInCell(8, 8, 2);
*/

		grid.printGrid();
		Solver theSolver = new Solver(grid);		
		theSolver.start();
		
		
		//UserInterface ui = new UserInterface(grid);
		//SwingUtilities.invokeLater(ui);
		
	}
}
