package classes;

import java.util.ArrayList;

import Enemy.*;
import Grid.*;

public class EnemyManager {
	public ArrayList<Enemy> enemyList;
	public int enemyCount = 0;
	int enemySpawnLocX = 150;
	int enemySpawnLocY = 60;
	private int waveNo;

	public EnemyManager(){
		enemyList = new ArrayList<Enemy>();	
		enemySpawnLocX = 150;
		enemySpawnLocY = 60;
	}

	
	public void initializeEnemies(int waveNo){
		//initialize 1st wave
		if(waveNo == 0){
			this.waveNo = 0;
			for(int i = 0; i < 1; i++){ 
				//enemyList.add(new Footman(enemySpawnLocX, enemySpawnLocY)); 
				//enemyList.add(new GryphonRider(enemySpawnLocX, enemySpawnLocY));
				//enemyList.add(new Mage(enemySpawnLocX, enemySpawnLocY));
				//enemyList.add(new Grunt(enemySpawnLocX, enemySpawnLocY));
				//enemyList.add(new DwarvenDemolishers(enemySpawnLocX, enemySpawnLocY));
				//enemyList.add(new ElvenArcher(enemySpawnLocX, enemySpawnLocY));
				enemyList.add(new FlyingMachine(enemySpawnLocX, enemySpawnLocY));
				enemyCount++;
			}
		}
		//initialize 2nd wave
		if(waveNo == 1){
			this.waveNo = 1;
			for(int i = 0; i < 1; i++){
				enemyList.add(new Knight(enemySpawnLocX, enemySpawnLocY)); 
				enemyCount++;
			}
		}
	}
	public void killEnemy(int index){
		enemyList.remove(index);
		enemyCount--;
	}
	
	//GETTERS
	public int getWaveNo(){
		return waveNo;
	}
}
