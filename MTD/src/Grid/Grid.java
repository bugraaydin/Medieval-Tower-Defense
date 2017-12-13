package Grid;

public class Grid {
	private GridSlot[][] gameGrid;
	private static final int gridHeight = 9;
	private static final int gridWidth = 13;
	private static final int gridSlotSize = 64;

	
	public Grid(int[][] level)
	{
		gameGrid = new GridSlot[gridWidth][gridHeight];
		initializeLevel(level);
	}
	
	public void initializeLevel(int[][] level){ /// if 0 tower grid, if 1 enemy grid
		for(int i = 0; i < gridWidth; i++){
			for(int j = 0; j < gridHeight; j++){
				if(level[i][j] == 0)
					gameGrid[i][j] = new TowerGrid();
				if(level[i][j] == 1)
					gameGrid[i][j] = new EnemyGrid();
			}
		}
	}
	
	//GETTERS

	public GridSlot getGridSlot(int i,int j){
		return gameGrid[i][j];
	}
	public int getGridHeight(){
		return gridHeight;
	}
	public int getGridWidth(){
		return gridWidth;
	}
	public int getGridSlotSize(){
		return gridSlotSize;
	}

}