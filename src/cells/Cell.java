package cells;

import enums.CellType;

public abstract class Cell {
	
	// invert is a flag that tells us that we have to change a cell from green to red or vice versa
	
	private int x;
	private int y;
	private int numberOfGreenNeighbours;
	private boolean invert;
	
	protected int generationsGreen;
	protected CellType type;
	
	public Cell(int x, int y) {
		
		this.x = x;
		this.y = y;
		this.invert = false;
		this.generationsGreen = 0;
	}
	
	public void setNumberOfNeighbours(int numberOfGreenNeighbours) {
		this.numberOfGreenNeighbours = numberOfGreenNeighbours;
	}
	
	public int getNumberOfGreenNeighbours() {
		
		return this.numberOfGreenNeighbours;
	}
	
	
	 //returns the times the cell changed to green
	
	public int getTimesChanged() {
		return this.generationsGreen;
	}
	
	public void incrementTimes() {
		this.generationsGreen++;
	}
	
	//returns the flag that tell us if we have to change to colour of a cell
	
	public boolean getInvert() {
		return this.invert;
	}
	
	public void setInvert(boolean invert) {
		this.invert = invert;
	}
	

	
	public void setType(CellType type) {
		this.type = type;
	}
	
	public CellType getType() {
		
		return this.type;
	}
	
	//changes the type/colour of the cell
	
	public void invert() {
		if(getType() == CellType.Green) {
			setType(CellType.Red);
		}
		else {
			setType(CellType.Green);
		}
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
		
			

}
