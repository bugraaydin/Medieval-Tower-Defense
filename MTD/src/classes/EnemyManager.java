package classes;

import java.util.ArrayList;

import Enemy.*;
import Grid.*;

public class EnemyManager {
	public ArrayList<Enemy> enemyList;
	public int enemyCount = 0;
	int enemySpawnLocX = 128;
	int enemySpawnLocY = 64;
	private int waveNo;

	public EnemyManager(){
		enemyList = new ArrayList<Enemy>();	
		enemySpawnLocX = 140;
		enemySpawnLocY = 32;
	}

	
	public void initializeEnemies(int waveNo, int enemyNo){
		//initialize 1st wave_________________________________________________________
		if(waveNo == 0 && enemyNo == 0){
			this.waveNo = 0;
			enemyList.add(new Peon(enemySpawnLocX, enemySpawnLocY)); 
				enemyCount++;
		}
		if(waveNo == 0 && enemyNo == 1){
			this.waveNo = 0;
			enemyList.add(new Ogre(enemySpawnLocX, enemySpawnLocY)); 
			enemyCount++;
		}
		if(waveNo == 0 && enemyNo == 2){
			this.waveNo = 0;
			enemyList.add(new Peasant(enemySpawnLocX, enemySpawnLocY)); 
			enemyCount++;
		}
		if(waveNo == 0 && enemyNo == 3){
			this.waveNo = 0;
			enemyList.add(new Peon(enemySpawnLocX, enemySpawnLocY)); 
			enemyCount++;
		}
		//_______________________________________________________________________________
		//initialize 2nd wave____________________________________________________________
		if(waveNo == 1 && enemyNo == 0){
			this.waveNo = 1;
			enemyList.add(new Footman(enemySpawnLocX, enemySpawnLocY)); 
			enemyCount++;
		}
		if(waveNo == 1 && enemyNo == 1){
			this.waveNo = 1;
			enemyList.add(new Footman(enemySpawnLocX, enemySpawnLocY)); 
			enemyCount++;
		}
		if(waveNo == 1 && enemyNo == 2){
			this.waveNo = 1;
			enemyList.add(new Grunt(enemySpawnLocX, enemySpawnLocY)); 
			enemyCount++;
		}
		if(waveNo == 1 && enemyNo == 3){
			this.waveNo = 1;
			enemyList.add(new Grunt(enemySpawnLocX, enemySpawnLocY)); 
			enemyCount++;
		}
		//_______________________________________________________________________________
		//initialize 3rd wave
		if(waveNo==2 && enemyNo == 0){
			this.waveNo = 2;
			enemyList.add(new ElvenArcher(enemySpawnLocX, enemySpawnLocY));
			enemyCount++;
		}
		if(waveNo==2 && enemyNo == 1){
			this.waveNo = 2;
			enemyList.add(new ElvenArcher(enemySpawnLocX, enemySpawnLocY));
			enemyCount++;
		}
		if(waveNo==2 && enemyNo == 2){
			this.waveNo = 2;
			enemyList.add(new Troll(enemySpawnLocX, enemySpawnLocY));
			enemyCount++;
		}
		if(waveNo==2 && enemyNo == 3){
			this.waveNo = 2;
			enemyList.add(new Troll(enemySpawnLocX, enemySpawnLocY));
			enemyCount++;
		}
		//_______________________________________________________________________________
		//initialize 4th wave
		if(waveNo==3 && enemyNo == 0){
			this.waveNo = 3;
			enemyList.add(new Skeleton(enemySpawnLocX, enemySpawnLocY));
			enemyCount++;
		}
		if(waveNo==3 && enemyNo == 1){
			this.waveNo = 3;
			enemyList.add(new Skeleton(enemySpawnLocX, enemySpawnLocY));
			enemyCount++;
		}
		if(waveNo==3 && enemyNo == 2){
			this.waveNo = 3;
			enemyList.add(new Mage(enemySpawnLocX, enemySpawnLocY));
			enemyCount++;
		}
		if(waveNo==3 && enemyNo == 3){
			this.waveNo = 3;
			enemyList.add(new Mage(enemySpawnLocX, enemySpawnLocY));
			enemyCount++;
		}
		if(waveNo==4 && enemyNo == 0){
			this.waveNo = 4;
			enemyList.add(new Demon(enemySpawnLocX, enemySpawnLocY));
			enemyCount++;
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
