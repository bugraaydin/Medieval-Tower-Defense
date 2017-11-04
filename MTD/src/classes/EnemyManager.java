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

		enemyList = new Enemy[30];
		for(int i = 0; i < 10; i++){ 

			enemyList[i] = new Footman(enemySpawnLocX, enemySpawnLocY); // first wave consists of 10 footmans
			//enemyList[i].activateEnemy(targetsX, targetsY);
			enemyCount++;
			//System.out.println(enemySpawnLocX);
		}

		for(int i = 10; i < 20; i++){

			enemyList[i] = new LightCavalry(enemySpawnLocX, enemySpawnLocY);
			enemyCount++;
		}

		for(int i = 20; i < 30; i++){

			enemyList[i] = new Knight(enemySpawnLocX, enemySpawnLocY);
			enemyCount++;
		}

	}

}
