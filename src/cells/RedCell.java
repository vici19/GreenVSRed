package cells;

import enums.CellType;

public class RedCell extends Cell{
	
	public RedCell(int x, int y) {
		super(x,y);
		super.setType(CellType.Red);
	}

}
