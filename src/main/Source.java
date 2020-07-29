package main;

import java.util.Scanner;
import matrix.Grid;

public class Source {

	public static void main(String[] args) {
		
		int width, height, cellX, cellY, generations;
		
		Scanner sc = new Scanner(System.in);
		
		width = sc.nextInt();
		height = sc.nextInt();
		
		if(width < 1 || height < 1) {
			throw new IllegalArgumentException("Invalid Arguments!");
		}
	
		String[] elems = new String[width];
		char[][] input = new char[width][height];
		
		sc.nextLine();	
		
		for(int i = 0; i < width; i++) {
			elems[i] = sc.nextLine();
			char[] line = elems[i].toCharArray();
			
			for(int j = 0; j < height; j++) {
				input[i][j] = line[j];
			}
			
					
		}
		
		
		cellX = sc.nextInt();
		cellY = sc.nextInt();
		generations = sc.nextInt();
		
		if(cellX < 0 || cellY < 0 || generations < 0) {
			throw new IllegalArgumentException("Invalid Arguments!");
		}
	
		
		Grid grid = new Grid(input, width, height);
		System.out.println(grid.getResult(generations, cellX + 1,cellY + 1));

	}

}
