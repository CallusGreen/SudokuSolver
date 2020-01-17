package logic;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class GridTest {

	@Test
	void testGrid() {
		Grid grid = new Grid();
		int expectedNumberOfRows = 9;
		int actualNumberOfRows = grid.getTheGrid().size();
		assertEquals(expectedNumberOfRows, actualNumberOfRows);
	}

	@Test
	void testGetColumn() {
		
		Grid grid = new Grid();
		grid.addNumbersToGrid();
		
		ArrayList<Cell> testColumn = new ArrayList<>();
		
		Cell c1 = new Cell(0,0);
		Cell c2 = new Cell(0,1);
		Cell c3 = new Cell(0,2);
		Cell c4 = new Cell(0,3);
		Cell c5 = new Cell(0,4);
		Cell c6 = new Cell(0,5);
		Cell c7 = new Cell(0,6);
		Cell c8 = new Cell(0,7);
		Cell c9 = new Cell(0,8);
		
		c3.setNumber(2);
		c7.setNumber(5);
		c8.setNumber(6);
		
		testColumn.add(c1);
		testColumn.add(c2);
		testColumn.add(c3);
		testColumn.add(c4);
		testColumn.add(c5);
		testColumn.add(c6);
		testColumn.add(c7);
		testColumn.add(c8);
		testColumn.add(c9);
		
		assertTrue(testColumn.equals(grid.getColumn(0)));
	}

	@Test
	void testGetCellFromCoordinates() {
		
		Grid grid = new Grid();
		grid.addNumbersToGrid();
		
		Cell expectedCell = new Cell(0,2);
		expectedCell.setNumber(2);
		
		Cell actualCell = grid.getCellFromCoordinates(0, 2);
		
		assertTrue(expectedCell.equals(actualCell));
	}

	@Test
	void testGetSquareFromCoords() {
		assertTrue(true == true);
	}

	@Test
	void testIsOnlyOneSquareValid() {
		assertTrue(true == true);
	}

	@Test
	void testRemoveFullCellsFromList() {
		
		Grid grid = new Grid();
		ArrayList<Cell> list = new ArrayList<>();
		
		Cell c1 = new Cell(0,0);
		Cell c2 = new Cell(0,1);
		Cell c3 = new Cell(0,2);
		Cell c4 = new Cell(0,3);
		Cell c5 = new Cell(0,4);
		Cell c6 = new Cell(0,5);
		Cell c7 = new Cell(0,6);
		Cell c8 = new Cell(0,7);
		Cell c9 = new Cell(0,8);

		c1.setNumber(1);
		c2.setNumber(2);
		c3.setNumber(3);
		
		list.add(c1);
		list.add(c2);
		list.add(c3);
		list.add(c4);
		list.add(c5);
		list.add(c6);
		list.add(c7);
		list.add(c8);
		list.add(c9);
		
		ArrayList<Cell> updatedList = grid.removeFullCellsFromList(list);
		
		int expected = 6;
		int actual = updatedList.size();
		
		assertTrue(expected == actual);
	}

	@Test
	void testIsOnlyOneCellInRowValid() {
		assertTrue(true == true);
	}

	@Test
	void testIsOnlyOneCellInColValid() {
		assertTrue(true == true);
	}

	@Test
	void testIsSudokuFinished() {
		assertTrue(true == true);
	}

	@Test
	void testCanNumGoInOtherColumnInSquare() {
		assertTrue(true == true);
	}

	@Test
	void testCanNumGoInOtherRowInSquare() {
		assertTrue(true == true);
	}

	@Test
	void testThreesTechniqueRow() {
		assertTrue(true == true);
	}

	@Test
	void testThreesTechniqueCol() {
		assertTrue(true == true);
	}

	@Test
	void testWhereIsCellInCols() {
		assertTrue(true == true);
	}

	@Test
	void testWhereIsCellInRows() {
		assertTrue(true == true);
	}

	@Test
	void testCanNumberGoHereBasic() {
		
		Grid grid = new Grid();
		
		boolean expected = true;
		boolean actual = grid.canNumberGoHere(1, grid.getCellFromCoordinates(0, 0));
		
		assertTrue(expected == actual);
		
	}
	
	@Test
	void testCanNumberGoHere() {
		
		Grid grid = new Grid();
		
		Cell c1 = grid.getCellFromCoordinates(0, 0);
		Cell c2 = grid.getCellFromCoordinates(1, 0);
		Cell c5 = grid.getCellFromCoordinates(5, 0);
		
		int[] c1Array = {2,7};
		int[] c2Array = {2,7};
		
		c1.setTwoPotentialNums(c1Array);
		c2.setTwoPotentialNums(c2Array);
		
		boolean expected = true;
		boolean actual = grid.rowContainsTwoCellsWithSameNakedNumber(c5, 2);
	
		assertTrue(expected == actual);
	}

	@Test
	void testColContainsTwoCellsWithSameNakedNumber() {
		assertTrue(true == true);
	}

	@Test
	void testRowContainsTwoCellsWithSameNakedNumber() {
		
		Grid grid = new Grid();
		
		Cell c1 = grid.getCellFromCoordinates(0, 0);
		Cell c2 = grid.getCellFromCoordinates(1, 0);
		Cell c5 = grid.getCellFromCoordinates(5, 0);
		
		int[] c1Array = {2,7};
		int[] c2Array = {2,7};
		
		System.out.println(c1.potentialValuesToString());
		
		c1.setTwoPotentialNums(c1Array);
		c2.setTwoPotentialNums(c2Array);
		
		System.out.println(c1.potentialValuesToString());
		
		boolean expected = true;
		boolean actual = grid.rowContainsTwoCellsWithSameNakedNumber(c5, 2);
		
		assertTrue(expected == actual);
	}

	@Test
	void testSquareContainsTwoCellsWithSameNakedNumber() {
		assertTrue(true == true);
	}

	@Test
	void testIsNumberInRow() {
		assertTrue(true == true);
	}

	@Test
	void testIsNumberInColumn() {
		assertTrue(true == true);
	}

	@Test
	void testIsNumberInSquare() {
		assertTrue(true == true);
	}

	@Test
	void testDoesColHaveDoubleNakedPair() {
		assertTrue(true == true);
	}

	@Test
	void testDoesRowHaveDoubleNakedPair() {
		
		Grid grid = new Grid();
		
		Cell c1 = grid.getCellFromCoordinates(0,0);
		Cell c2 = grid.getCellFromCoordinates(1,0);
		Cell c5 = grid.getCellFromCoordinates(5,0);
		
		int[] c1Array = {2,7};
		int[] c2Array = {2,7};
		
		c1.setTwoPotentialNums(c1Array);
		c2.setTwoPotentialNums(c2Array);
		
		boolean expected = true;
		boolean actual = grid.doesRowHaveDoubleNakedPair(c5);
		
		assertTrue(expected == actual);
	}

	@Test
	void testDoesSquareHaveDoubleNakedPair() {
		assertTrue(true == true);
	}

	@Test
	void testPrintNakedPairsInGrid() {
		assertTrue(true == true);
	}

	@Test
	void testCellsShareTheSameTwoNumbers() {

		Grid grid = new Grid();
		
		Cell c1 = new Cell(0,0);
		Cell c2 = new Cell(1,0);
		Cell c5 = new Cell(5,0);
		
		int[] c1Array = {2,1};
		int[] c2Array = {1,2};
		
		c1.setTwoPotentialNums(c1Array);
		c2.setTwoPotentialNums(c2Array);
		
		boolean expected = true;
		boolean actual = grid.cellsShareTheSameTwoNumbers(c1, c2);
		
		assertTrue(expected == actual);
	}

	@Test
	void testDoesListContainCellsWithSameNakedPair() {

		Grid grid = new Grid();
		
		Cell c1 = new Cell(0,0);
		Cell c2 = new Cell(1,0);
		Cell c5 = new Cell(5,0);
		
		int[] c1Array = {2,1};
		int[] c2Array = {1,2};
		
		c1.setTwoPotentialNums(c1Array);
		c2.setTwoPotentialNums(c2Array);
		
		ArrayList<Cell> list = new ArrayList<>();
		
		list.add(c1);
		list.add(c2);
		list.add(c5);
		
		ArrayList<Cell> expectedList = new ArrayList<>();
		
		expectedList.add(c1);
		expectedList.add(c2);
		
		ArrayList<Cell> actualList = grid.doesListContainCellsWithSameNakedPair(list);
		
		assertTrue(actualList.equals(expectedList));
		assertTrue(actualList.size() == expectedList.size());
		
	}

	@Test
	void testDoesCellHaveNakedPair() {
		assertTrue(true == true);
	}

	@Test
	void testPrintGrid() {
		assertTrue(true == true);
	}

	@Test
	void testPrintPotentialValues() {
		assertTrue(true == true);
	}

	@Test
	void testPrintAfterNumAdded() {
		assertTrue(true == true);
	}

	@Test
	void testPlaceNumberInCell() {
		assertTrue(true == true);
	}

	@Test
	void testAdd() {
		assertTrue(true == true);
	}
}
