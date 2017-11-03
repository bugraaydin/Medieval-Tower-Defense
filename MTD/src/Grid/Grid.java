package Grid;

public class Grid {
	int gridWidth;
	int gridHeight;
	GridSlot[][] gameGrid;
	
	public Grid(int level){
		initializeLevelGrid(level);
	}
	
	private void initializeLevelGrid(int levelNo){
		if(levelNo == 0){
			initializeFirstLevelGrid();
		}
	}
	
	private void initializeFirstLevelGrid(){
		gridWidth = 13;
		gridHeight = 9;
		gameGrid = new GridSlot[gridHeight][gridWidth];
		//initialize width 0
		gameGrid[0][0] = new TowerGrid();
		gameGrid[0][1] = new EnemyGrid();
		gameGrid[0][2] = new TowerGrid();
		gameGrid[0][3] = new TowerGrid();
		gameGrid[0][4] = new TowerGrid();
		gameGrid[0][5] = new TowerGrid();
		gameGrid[0][6] = new TowerGrid();
		gameGrid[0][7] = new TowerGrid();
		gameGrid[0][8] = new TowerGrid();
		gameGrid[0][9] = new TowerGrid();
		gameGrid[0][10] = new TowerGrid();
		gameGrid[0][11] = new EnemyGrid();
		gameGrid[0][12] = new TowerGrid();
		//initialize width 1
		gameGrid[1][0] = new TowerGrid();
		gameGrid[1][1] = new EnemyGrid();
		gameGrid[1][2] = new TowerGrid();
		gameGrid[1][3] = new EnemyGrid();
		gameGrid[1][4] = new EnemyGrid();
		gameGrid[1][5] = new EnemyGrid();
		gameGrid[1][6] = new TowerGrid();
		gameGrid[1][7] = new EnemyGrid();
		gameGrid[1][8] = new EnemyGrid();
		gameGrid[1][9] = new EnemyGrid();
		gameGrid[1][10] = new TowerGrid();
		gameGrid[1][11] = new EnemyGrid();
		gameGrid[1][12] = new TowerGrid();
		//initialize width 2
		gameGrid[2][0] = new TowerGrid();
		gameGrid[2][1] = new EnemyGrid();
		gameGrid[2][2] = new TowerGrid();
		gameGrid[2][3] = new EnemyGrid();
		gameGrid[2][4] = new TowerGrid();
		gameGrid[2][5] = new EnemyGrid();
		gameGrid[2][6] = new TowerGrid();
		gameGrid[2][7] = new EnemyGrid();
		gameGrid[2][8] = new TowerGrid();
		gameGrid[2][9] = new EnemyGrid();
		gameGrid[2][10] = new TowerGrid();
		gameGrid[2][11] = new EnemyGrid();
		gameGrid[2][12] = new TowerGrid();
		//initialize width 3
		gameGrid[3][0] = new TowerGrid();
		gameGrid[3][1] = new EnemyGrid();
		gameGrid[3][2] = new TowerGrid();
		gameGrid[3][3] = new EnemyGrid();
		gameGrid[3][4] = new TowerGrid();
		gameGrid[3][5] = new EnemyGrid();
		gameGrid[3][6] = new EnemyGrid();
		gameGrid[3][7] = new EnemyGrid();
		gameGrid[3][8] = new TowerGrid();
		gameGrid[3][9] = new EnemyGrid();
		gameGrid[3][10] = new TowerGrid();
		gameGrid[3][11] = new EnemyGrid();
		gameGrid[3][12] = new TowerGrid();
		//initialize width 4
		gameGrid[4][0] = new TowerGrid();
		gameGrid[4][1] = new EnemyGrid();
		gameGrid[4][2] = new TowerGrid();
		gameGrid[4][3] = new EnemyGrid();
		gameGrid[4][4] = new TowerGrid();
		gameGrid[4][5] = new EnemyGrid();
		gameGrid[4][6] = new TowerGrid();
		gameGrid[4][7] = new EnemyGrid();
		gameGrid[4][8] = new TowerGrid();
		gameGrid[4][9] = new EnemyGrid();
		gameGrid[4][10] = new TowerGrid();
		gameGrid[4][11] = new EnemyGrid();
		gameGrid[4][12] = new TowerGrid();
		//initialize width 5
		gameGrid[5][0] = new TowerGrid();
		gameGrid[5][1] = new EnemyGrid();
		gameGrid[5][2] = new TowerGrid();
		gameGrid[5][3] = new EnemyGrid();
		gameGrid[5][4] = new TowerGrid();
		gameGrid[5][5] = new EnemyGrid();
		gameGrid[5][6] = new TowerGrid();
		gameGrid[5][7] = new EnemyGrid();
		gameGrid[5][8] = new TowerGrid();
		gameGrid[5][9] = new EnemyGrid();
		gameGrid[5][10] = new TowerGrid();
		gameGrid[5][11] = new EnemyGrid();
		gameGrid[5][12] = new TowerGrid();
		//initialize width 6
		gameGrid[6][0] = new TowerGrid();
		gameGrid[6][1] = new EnemyGrid();
		gameGrid[6][2] = new TowerGrid();
		gameGrid[6][3] = new EnemyGrid();
		gameGrid[6][4] = new TowerGrid();
		gameGrid[6][5] = new EnemyGrid();
		gameGrid[6][6] = new TowerGrid();
		gameGrid[6][7] = new EnemyGrid();
		gameGrid[6][8] = new TowerGrid();
		gameGrid[6][9] = new EnemyGrid();
		gameGrid[6][10] = new TowerGrid();
		gameGrid[6][11] = new EnemyGrid();
		gameGrid[6][12] = new TowerGrid();
		//initialize width 7
		gameGrid[7][0] = new TowerGrid();
		gameGrid[7][1] = new EnemyGrid();
		gameGrid[7][2] = new EnemyGrid();
		gameGrid[7][3] = new EnemyGrid();
		gameGrid[7][4] = new TowerGrid();
		gameGrid[7][5] = new EnemyGrid();
		gameGrid[7][6] = new EnemyGrid();
		gameGrid[7][7] = new EnemyGrid();
		gameGrid[7][8] = new TowerGrid();
		gameGrid[7][9] = new EnemyGrid();
		gameGrid[7][10] = new EnemyGrid();
		gameGrid[7][11] = new EnemyGrid();
		gameGrid[7][12] = new TowerGrid();
		//initialize width 8
		gameGrid[8][0] = new TowerGrid();
		gameGrid[8][1] = new TowerGrid();
		gameGrid[8][2] = new TowerGrid();
		gameGrid[8][3] = new TowerGrid();
		gameGrid[8][4] = new TowerGrid();
		gameGrid[8][5] = new TowerGrid();
		gameGrid[8][6] = new EnemyGrid();
		gameGrid[8][7] = new TowerGrid();
		gameGrid[8][8] = new TowerGrid();
		gameGrid[8][9] = new TowerGrid();
		gameGrid[8][10] = new TowerGrid();
		gameGrid[8][11] = new TowerGrid();
		gameGrid[8][12] = new TowerGrid();
	}

	public void printIt(){
		for(int i = 0; i < gridHeight;i++){
			for(int j = 0; j < gridWidth;j++){
				if (gameGrid[i][j] instanceof TowerGrid)
					System.out.print(0);
				if(gameGrid[i][j] instanceof EnemyGrid)
					System.out.print(1);
			}
			System.out.println();
		}
	}

}

