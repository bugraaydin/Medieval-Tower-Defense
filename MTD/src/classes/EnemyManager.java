package classes;

import java.util.ArrayList;

import Enemy.*;
import Grid.*;

public class EnemyManager {
	public ArrayList<Enemy> enemyList;
	public int enemyCount = 0;
	int enemySpawnLocX;
	int enemySpawnLocY;
	private int waveNo;

	public EnemyManager(){
		enemyList = new ArrayList<Enemy>();	
		enemySpawnLocX = 76;
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
			enemyList.add(new Peasant(enemySpawnLocX, enemySpawnLocY)); 
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
		//__________________________________________
		//initialize 5th wave
		if(waveNo==4 && enemyNo == 0){
			this.waveNo = 4;
			enemyList.add(new Demon(enemySpawnLocX, enemySpawnLocY));
			enemyCount++;
		}
		//_______________________________________________________________________________
		//initialize 6th wave
		if(waveNo==5 && enemyNo == 0){
			this.waveNo = 5;
			enemyList.add(new Knight(enemySpawnLocX, enemySpawnLocY));
			enemyCount++;
		}
		if(waveNo==5 && enemyNo == 1){
			this.waveNo = 5;
			enemyList.add(new Knight(enemySpawnLocX, enemySpawnLocY));
			enemyCount++;
		}
		if(waveNo==5 && enemyNo == 2){
			this.waveNo = 5;
			enemyList.add(new DeathKnight(enemySpawnLocX, enemySpawnLocY));
			enemyCount++;
		}
		if(waveNo==5 && enemyNo == 3){
			this.waveNo = 5;
			enemyList.add(new DeathKnight(enemySpawnLocX, enemySpawnLocY));
			enemyCount++;
		}
		//_______________________________________________________________________________
		//initialize 7th wave
		if(waveNo==6 && enemyNo == 0){
			this.waveNo = 6;
			enemyList.add(new DwarvenDemolishers(enemySpawnLocX, enemySpawnLocY));
			enemyCount++;
		}
		if(waveNo==6 && enemyNo == 1){
			this.waveNo = 6;
			enemyList.add(new DwarvenDemolishers(enemySpawnLocX, enemySpawnLocY));
			enemyCount++;
		}
		if(waveNo==6 && enemyNo == 2){
			this.waveNo = 6;
			enemyList.add(new Goblins(enemySpawnLocX, enemySpawnLocY));
			enemyCount++;
		}
		if(waveNo==6 && enemyNo == 3){
			this.waveNo = 6;
			enemyList.add(new Goblins(enemySpawnLocX, enemySpawnLocY));
			enemyCount++;
		}
		//_______________________________________________________________________________
		//initialize 8th wave
		if(waveNo==7 && enemyNo == 0){
			this.waveNo = 7;
			enemyList.add(new GryphonRider(enemySpawnLocX, enemySpawnLocY));
			enemyCount++;
		}
		if(waveNo==7 && enemyNo == 1){
			this.waveNo = 7;
			enemyList.add(new GryphonRider(enemySpawnLocX, enemySpawnLocY));
			enemyCount++;
		}
		if(waveNo==7 && enemyNo == 2){
			this.waveNo = 7;
			enemyList.add(new FlyingMachine(enemySpawnLocX, enemySpawnLocY));
			enemyCount++;
		}
		if(waveNo==7 && enemyNo == 3){
			this.waveNo = 7;
			enemyList.add(new FlyingMachine(enemySpawnLocX, enemySpawnLocY));
			enemyCount++;
		}
		//_______________________________________________________________________________
		//initialize 9th wave
		if(waveNo==8 && enemyNo == 0){
			this.waveNo = 8;
			enemyList.add(new Grunt(enemySpawnLocX, enemySpawnLocY));
			enemyCount++;
		}
		if(waveNo==8 && enemyNo == 1){
			this.waveNo = 8;
			enemyList.add(new Grunt(enemySpawnLocX, enemySpawnLocY));
			enemyCount++;
		}
		if(waveNo==8 && enemyNo == 2){
			this.waveNo = 8;
			enemyList.add(new Troll(enemySpawnLocX, enemySpawnLocY));
			enemyCount++;
		}
		if(waveNo==8 && enemyNo == 3){
			this.waveNo = 8;
			enemyList.add(new Troll(enemySpawnLocX, enemySpawnLocY));
			enemyCount++;
		}
		//__________________________________________
		//initialize 10th wave
		if(waveNo==9 && enemyNo == 0){
			this.waveNo = 9;
			enemyList.add(new Ogre(enemySpawnLocX, enemySpawnLocY));
			enemyCount++;
		}
		//_______________________________________________________________________________
		//initialize 11th wave
		if(waveNo==10 && enemyNo == 0){
			this.waveNo = waveNo;
			enemyList.add(new Mage(enemySpawnLocX, enemySpawnLocY));
			enemyCount++;
		}
		if(waveNo==10 && enemyNo == 1){
			this.waveNo = waveNo;
			enemyList.add(new Mage(enemySpawnLocX, enemySpawnLocY));
			enemyCount++;
		}
		if(waveNo==10 && enemyNo == 2){
			this.waveNo = waveNo;
			enemyList.add(new Demon(enemySpawnLocX, enemySpawnLocY));
			enemyCount++;
		}
		if(waveNo==10 && enemyNo == 3){
			this.waveNo = waveNo;
			enemyList.add(new Demon(enemySpawnLocX, enemySpawnLocY));
			enemyCount++;
		}
		//_______________________________________________________________________________
		//initialize 12th wave
		if(waveNo==11 && enemyNo == 0){
			this.waveNo = waveNo;
			enemyList.add(new Ogre(enemySpawnLocX, enemySpawnLocY));
			enemyCount++;
		}
		if(waveNo==11 && enemyNo == 1){
			this.waveNo = waveNo;
			enemyList.add(new Ogre(enemySpawnLocX, enemySpawnLocY));
			enemyCount++;
		}
		if(waveNo==11 && enemyNo == 2){
			this.waveNo = waveNo;
			enemyList.add(new DeathKnight(enemySpawnLocX, enemySpawnLocY));
			enemyCount++;
		}
		if(waveNo==11 && enemyNo == 3){
			this.waveNo = waveNo;
			enemyList.add(new DeathKnight(enemySpawnLocX, enemySpawnLocY));
			enemyCount++;
		}
		//_______________________________________________________________________________
		//initialize 13th wave
		if(waveNo==12 && enemyNo == 0){
			this.waveNo = waveNo;
			enemyList.add(new Knight(enemySpawnLocX, enemySpawnLocY));
			enemyCount++;
		}
		if(waveNo==12 && enemyNo == 1){
			this.waveNo = waveNo;
			enemyList.add(new Knight(enemySpawnLocX, enemySpawnLocY));
			enemyCount++;
		}
		if(waveNo==12 && enemyNo == 2){
			this.waveNo = waveNo;
			enemyList.add(new GryphonRider(enemySpawnLocX, enemySpawnLocY));
			enemyCount++;
		}
		if(waveNo==12 && enemyNo == 3){
			this.waveNo = waveNo;
			enemyList.add(new GryphonRider(enemySpawnLocX, enemySpawnLocY));
			enemyCount++;
		}
		//_______________________________________________________________________________
		//initialize 14th wave
		if(waveNo==13 && enemyNo == 0){
			this.waveNo = waveNo;
			enemyList.add(new ElvenArcher(enemySpawnLocX, enemySpawnLocY));
			enemyCount++;
		}
		if(waveNo==13 && enemyNo == 1){
			this.waveNo = waveNo;
			enemyList.add(new ElvenArcher(enemySpawnLocX, enemySpawnLocY));
			enemyCount++;
		}
		if(waveNo==13 && enemyNo == 2){
			this.waveNo = waveNo;
			enemyList.add(new Footman(enemySpawnLocX, enemySpawnLocY));
			enemyCount++;
		}
		if(waveNo==13 && enemyNo == 3){
			this.waveNo = waveNo;
			enemyList.add(new Footman(enemySpawnLocX, enemySpawnLocY));
			enemyCount++;
		}
		//_______________________________________________________________________________
		//initialize 15th wave
		if(waveNo==14 && enemyNo == 0){
			this.waveNo = waveNo;
			enemyList.add(new Dragon(enemySpawnLocX, enemySpawnLocY));
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
