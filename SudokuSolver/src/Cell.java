import java.util.ArrayList;

public class Cell {

	// <----------------- Object Variables -----------------> //
	//add potential number1&2
	private int number;
	private int xCoord;
	private int yCoord;
	private ArrayList<Integer> potentialNumbers;

	// <------------------- Constructors -------------------> //
	public Cell(int xCoord, int yCoord) {
		this.number = 0;
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		potentialNumbers = new ArrayList<Integer>();
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
	
	public void addPotentialNumber(int num) {
		boolean numberExists = false;
		for(int tempNum : getPotentialNumbers()) {
			if(tempNum==num) {
				numberExists=true;
			}
		}
		if(!numberExists) {
			getPotentialNumbers().add(num);
		}
	}
	
	public boolean isNumPotentialNum(int num) {
		boolean numberExistsInList = false;
		for(int tempInt : getPotentialNumbers()) {
			if(tempInt == num) {
				numberExistsInList = true;
			}
		}
		return numberExistsInList;
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

	public ArrayList<Integer> getPotentialNumbers() {
		return potentialNumbers;
	}

	public void setPotentialNumbers(ArrayList<Integer> potentialNumbers) {
		this.potentialNumbers = potentialNumbers;
	}
}
