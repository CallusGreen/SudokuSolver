public class Cell {

	// <----------------- Object Variables -----------------> //
	//add potential number1&2
	private int number;
	private int xCoord;
	private int yCoord;

	// <------------------- Constructors -------------------> //
	public Cell(int xCoord, int yCoord) {
		this.number = 0;
		this.xCoord = xCoord;
		this.yCoord = yCoord;
	}

	public Cell() {
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
}
