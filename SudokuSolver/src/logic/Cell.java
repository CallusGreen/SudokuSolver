package logic;

public class Cell {

	// <----------------- Object Variables -----------------> //
	private int number;
	private int xCoord;
	private int yCoord;
	private int[] twoPotentialNums;

	// <------------------- Constructors -------------------> //
	public Cell(int xCoord, int yCoord) {
		this.number = 0;
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		twoPotentialNums = new int[2];
	}

	public Cell() {
		twoPotentialNums = new int[2];
	}

	// <---------------------- Methods ---------------------> //
	public String toString() {
		String output = "";
		if(getNumber()==0) {
			output =  " . ";
		} else {
			output = " " + getNumber() + " ";
		}
		if(getxCoord() != 0 && (getxCoord()+1)%3==0) {
			output = output + " ";
		}
		return output;
	}
	
	public String toCoords() {
		return "(" + getxCoord() + "," + getyCoord() + ")";
	}
	
	public boolean isNumPotentialNum(int num) {
		for(int i=0; i<getTwoPotentialNums().length; i++) {
			if(getTwoPotentialNums()[i] == num) {
				return true;
			}
		}
		return false;
	}
	
	public boolean numbersAreNotZero() {
		for(int i=0; i<getTwoPotentialNums().length; i++) {
			if(getTwoPotentialNums()[i] == 0) {
				return false;
			}
		}
		return true;
	}
	
	public boolean cellPotentialNumsMatch(Cell cell) {
		if(this.getTwoPotentialNums()[0] == cell.getTwoPotentialNums()[0] && 
				this.getTwoPotentialNums()[1] == cell.getTwoPotentialNums()[1]) {
			return true;
		} else {
			return false;
		}
	}
	
	public String potentialValuesToString() {
		return "Cell: " + toCoords() + " - Potential Numbers are: " + getTwoPotentialNums()[0] + " and " + getTwoPotentialNums()[1];
	}

	// <---------------- Getters & Setters -----------------> //
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getxCoord() {
		return xCoord;
	}

	public void setxCoord(int xCoord) {
		this.xCoord = xCoord;
	}

	public int getyCoord() {
		return yCoord;
	}

	public void setyCoord(int yCoord) {
		this.yCoord = yCoord;
	}

	public int[] getTwoPotentialNums() {
		return twoPotentialNums;
	}

	public void setTwoPotentialNums(int[] twoPotentialNums) {
		boolean shouldSet = true;
		for(int i=0; i<2; i++) {
			if(getTwoPotentialNums()[i] != 0) {
				shouldSet = false;
			}
		}
		if(shouldSet) {
			this.twoPotentialNums = twoPotentialNums;
		}
	}
	
	@Override
	public boolean equals(Object object) {
		if(object == null) {
			return false;
		}
		
		if(getClass() != object.getClass()) {
			return false;
		}
		
		Cell compared = (Cell) object;
		
		if(this.xCoord != compared.getxCoord() || this.yCoord != compared.getyCoord()) {
			return false;
		}	
		return true;
	}
	
	public int hashCode() {
		return this.xCoord + this.yCoord;
	}
}
