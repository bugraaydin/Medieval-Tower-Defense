package classes;

import Enemy.*;
import Grid.*;

public class EnemyManager {
	Grid grid;
	public Enemy[] enemyList;
	public int enemyCount = 0;
	int enemySpawnLocX = 150;
	int enemySpawnLocY = 60;

	public EnemyManager(int levelNo, int gridSizeX, int gridSizeY, Grid grid){

		if(levelNo == 0)
		{
			this.grid = grid;
			initializeFirstLevelWaves();
			enemySpawnLocX = 150;
			enemySpawnLocY = 60;
			//gridSizeY*3 + gridSizeY/2 + 
		}

	}

	
	public void initializeFirstLevelWaves(){

		enemyList = new Enemy[5];		
		for(int i = 0; i < 1; i++){ 
			enemyList[i] = new Footman(enemySpawnLocX, enemySpawnLocY); // first wave consists of 5 footmans
			enemyCount++;
		}

			enemyList[1] = new Footman(enemySpawnLocX + 5, enemySpawnLocY + 5);
			enemyCount++;


			enemyList[2] = new Footman(enemySpawnLocX + 10, enemySpawnLocY + 10);
			enemyCount++;

			enemyList[3] = new Footman(enemySpawnLocX + 15, enemySpawnLocY + 15);
			enemyCount++;


			enemyList[4] = new Footman(enemySpawnLocX + 20, enemySpawnLocY + 20);
			enemyCount++;


	}

}
