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
		enemySpawnLocX = 150;
		enemySpawnLocY = 60;
	}

	
	public void initializeEnemies(int waveNo){
		//initialize 1st wave
		if(waveNo == 0){
			this.waveNo = 0;
			for(int i = 0; i < 1; i++){ 
				enemyList.add(new Footman(enemySpawnLocX, enemySpawnLocY)); 
				//enemyList.add(new Grunt(enemySpawnLocX, enemySpawnLocY));
				//enemyList.add(new DwarvenDemolishers(enemySpawnLocX, enemySpawnLocY));
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
		//initialize 3rd wave
		if(waveNo==2){
			this.waveNo = 2;
			for(int i = 0; i < 1; i++){
				enemyList.add(new ElvenArcher(enemySpawnLocX, enemySpawnLocY));
				enemyCount++;
			}
		}
		//initialize 4rd wave
		if(waveNo==3){
			this.waveNo = 3;
			for(int i = 0; i < 1; i++){
				enemyList.add(new GryphonRider(enemySpawnLocX, enemySpawnLocY));
				enemyCount++;
			}
		}
		//initialize 5th wave
		if(waveNo==4){
			this.waveNo = 4;
			for(int i = 0; i < 1; i++){
				enemyList.add(new Mage(enemySpawnLocX, enemySpawnLocY));
				enemyCount++;
			}
		}
		//initialize 6th wave
		if(waveNo==5){
			this.waveNo = 5;
			for(int i = 0; i < 1; i++){
				enemyList.add(new FlyingMachine(enemySpawnLocX, enemySpawnLocY));
				enemyCount++;
			}
		}
		//initialize 7th wave
		if(waveNo==6){
			this.waveNo = 6;
			for(int i = 0; i < 1; i++){
				enemyList.add(new Grunt(enemySpawnLocX, enemySpawnLocY));
				enemyCount++;
			}
		}
		//initialize 8th wave
		if(waveNo==7){
			this.waveNo = 7;
			for(int i = 0; i < 1; i++){
				enemyList.add(new DwarvenDemolishers(enemySpawnLocX, enemySpawnLocY));
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
