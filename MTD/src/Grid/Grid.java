package Grid;

public class Grid {
	public GridSlot[][] thisGrid;
	public int gridSlotWidthInPixels = 64;
	public int gridSlotHeightInPixels = 64;
	public int gridWidth;
	public int gridHeight;
	int enemySpawnLocX = 0;
	int enemyspawnLocY = 0;
	public int[] targetsX;
	public int[] targetsY;
	
	public Grid(int level)
	{
		initializeLevel(level);
	}
	public Grid()
	{
		gridSlotWidthInPixels = 64;
		gridSlotHeightInPixels = 64;
		initializeLevel(0);
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
			
			gridWidth = 13;
			gridHeight = 9;
			thisGrid = new GridSlot[gridWidth][gridHeight];
			for(int i=0; i<gridWidth; i++)
				for(int j=0; j<gridHeight; j++)
				{
					thisGrid[i][j] = new GridSlot("/images/grids/tower_grid.jpg", true);
				}
			for(int i=0; i<gridHeight-2; i++)///DÜZ YOL ÇÝZ
			{
				thisGrid[2][i].setSlotImage("/images/grids/enemy_grid.jpg");
				thisGrid[2][i].canPlaceTower = false;
			}
			for(int i=0; i<gridWidth-2; i++)///DÜZ YOL ÇÝZ
			{
				thisGrid[i+2][7].setSlotImage("/images/grids/enemy_grid.jpg");
				thisGrid[i+2][7].canPlaceTower = false;
			}
					//g.drawImage(tryImage, 64*i, 64*j, this);
		}
	}

}