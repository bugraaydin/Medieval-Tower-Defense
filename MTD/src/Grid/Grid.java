package Grid;

public class Grid {
	private GridSlot[][] gameGrid;
	public int gridSlotWidth;
	public int gridSlotHeight;
	public int gridWidth;
	public int gridHeight;
	public int[] targetsX;
	public int[] targetsY;
	
	public Grid(int level)
	{
		gridWidth = 13;
		gridHeight = 9;
		gridSlotWidth = 64;
		gridSlotHeight = 64;
		gameGrid = new GridSlot[gridWidth][gridHeight];
		initializeLevel(level);

	}
	
	public void initializeLevel(int levelNo)
	{
		if(levelNo==0)
		{
			targetsX = new int[3];
			targetsY = new int[3];
			targetsX[0] = 150;
			targetsY[0] = 470;
			targetsX[1] = 470;
			targetsY[1] = 470;
			targetsX[2] = 700;
			targetsY[2] = 470;
			
			for(int i=0; i<gridWidth; i++){
				for(int j=0; j<gridHeight; j++)
				{
					gameGrid[i][j] = new TowerGrid();
				}
			}
			for(int i=0; i<gridHeight-2; i++)///Enemy grids
			{
				gameGrid[2][i] = new EnemyGrid();
			}
			for(int i=0; i<gridWidth-2; i++)///Enemy grids
			{
				gameGrid[i+2][7] = new EnemyGrid();
			}
		}
	}
	
	//GETTERS

	public GridSlot getGridSlot(int i,int j){
		return gameGrid[i][j];
	}

}