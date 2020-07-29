package matrix;

import cells.Cell;
import cells.GreenCell;
import cells.RedCell;
import enums.CellType;

public class Grid {
	private Cell grid[][];
	private int width;
	private int height;
	
	public Grid(char input [][], int x, int y) {
		
		
		//wraps the input matrix with one aditional layer so every cell will have 8 neighbours
		//it doesn't matter if it's a corner cell or on the edge
		
		this.width = x + 2;
		this.height = y + 2;
		
		this.grid = new Cell[width][height];
		
		for(int j = 0; j < height; j++) {
			this.grid[0][j] = new RedCell(0,j);
			this.grid[width - 1][j] = new RedCell(width - 1, j);
		}
		
		for(int i = 1; i < width - 1; i++) {
			this.grid[i][0] = new RedCell(i,0);
			this.grid[i][height - 1] = new RedCell(i, height - 1);
		}
		
		//creates the cells in the matrix
		
		for(int i = 0; i < x; i++) {
			for(int j = 0; j < y; j++) {
				
				switch(input[i][j]) {
				
				case '0' : this.grid[i + 1][j + 1] = new RedCell(i + 1,j + 1);break;
				case '1' : this.grid[i + 1][j + 1] = new GreenCell(i + 1,j + 1);break;
				default : break;
				}
				
			}
		}
		
	}
	
	//sets the flag invert to true if the cell has to change colours and increments the times it is green
	
	public void changeCellNextGen(Cell cell)
	{
		
		if(cell.getType() == CellType.Red && (cell.getNumberOfGreenNeighbours() == 3 ||
				cell.getNumberOfGreenNeighbours() == 6)){
			cell.setInvert(true);
			cell.incrementTimes();
		}
		
		else if(cell.getType() == CellType.Red){
			return;
		}
		
		else if(cell.getType() == CellType.Green && (cell.getNumberOfGreenNeighbours() == 2 ||
				cell.getNumberOfGreenNeighbours() == 3 || cell.getNumberOfGreenNeighbours() == 6)){
			cell.incrementTimes();
		}
		
		else if(cell.getType() == CellType.Green){
			cell.setInvert(true);
		}
	}
	
	//generates the next generation and sets flag invert to false if it's true
	
	private void update() {
		for(int i = 0; i < width;i++) {
			for(int j = 0; j < height; j++) {
				if(this.grid[i][j].getInvert() == true) {
					this.grid[i][j].invert();
					this.grid[i][j].setInvert(false);
				}
			}
		}
	}
	
	//calculates the number of neighbours a cell has
	
	private void calculateNeighbours(Cell cell) {
		
		int i = cell.getX();
		int j = cell.getY();
	
				
				int numberOfGreenNeighbours = 0;
				
				if(this.grid[i + 1][j - 1].getType() == CellType.Green) {
					numberOfGreenNeighbours++;
					
				}
				
				if(this.grid[i + 1][j].getType() == CellType.Green) {
					numberOfGreenNeighbours++;
					
				}
				
				if(this.grid[i + 1][j + 1].getType() == CellType.Green) {
					numberOfGreenNeighbours++;
					
				}
				
				if(this.grid[i][j - 1].getType() == CellType.Green) {
					numberOfGreenNeighbours++;
					
				}
				
				if(this.grid[i][j + 1].getType() == CellType.Green) {
					numberOfGreenNeighbours++;
					
				}
				
				if(this.grid[i - 1][j - 1].getType() == CellType.Green) {
					numberOfGreenNeighbours++;
					
				}
				
				if(this.grid[i - 1][j].getType() == CellType.Green) {
					numberOfGreenNeighbours++;
					
				}
				
				if(this.grid[i - 1][j + 1].getType() == CellType.Green) {
					numberOfGreenNeighbours++;
					
				}
				
				this.grid[i][j].setNumberOfNeighbours(numberOfGreenNeighbours);
				
			
		
	}
	
	//this outputs the result by going through each generation
	
	public int getResult(int generations, int x, int y) {
		if(generations == 0) {
			return this.grid[x][y].getTimesChanged();
		}
		else {
			for (int k = 0; k < generations; k++) {
				for(int i = 1; i < this.width - 1; i++) {
					for(int j = 1; j < this.height - 1; j++) {
					calculateNeighbours(this.grid[i][j]);
					changeCellNextGen(this.grid[i][j]);
				}
			}
				
				update();
		}
			
			return this.grid[x][y].getTimesChanged();
		}
		
				
	}
	
	

}
