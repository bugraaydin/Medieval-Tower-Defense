 package classes;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

import Control.Control;
import Enemy.Enemy;
import Grid.*;

public class GameManager {
	private int playerGold;
	private int screenX;
	private int screenY;
	private EnemyManager enemyManager;
	private TowerManager towerManager;
	private Shop shop;
	private Grid grid;	
	private Control control;
	private int minute;
	private int second;
	private int frameRate;
	private String time;
	private int remainingChances;
	
	//CHANGE
	private ArrayList<Enemy> graveyard;
	//
	public GameManager(){

		//
		remainingChances = 10;
		graveyard = new ArrayList<Enemy>();
		//
		minute = 0;
		second = 0;
		frameRate = 0;
		time = minute + ":" + second;
		playerGold = 300;
		shop = new Shop();
		grid = new Grid(0);
		control = new Control();
		enemyManager = new EnemyManager();
		enemyManager.initializeEnemies(0); // initializing the first wave
		towerManager = new TowerManager();
		screenX = grid.gridSlotWidth * grid.gridHeight;
		screenY = grid.gridSlotHeight * grid.gridHeight;
		updateObjects();
		
		
	}
	//////////////////////////////////////////////////////////////////////////////
	//////////////////////////////UPDATES/////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////
	public void updateObjects()
	{
		int delay = 100; // ~5 updates per second
		ActionListener taskPerformer = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				updateTime();
				updateWave();
				updateEnemies(); // updating enemies
				updateTowerTargets(); // updating targets
				updateUserInputs(); // updating the controller
				updateGraveyard();
				try {
					updateProjectiles();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} //updating projectiles
			}
		};
		new Timer(delay,taskPerformer).start();
	}
	//UPDATE TIME
	private void updateTime(){
		frameRate++;
		if(frameRate%10 == 0){
			second++;
			if(second>59){
				minute++;
				second = 0;
			}
		}
		time = minute+":"+second;
	}
	//UPDATING WAVES
	public void updateWave(){
		if(frameRate == 50){ // second = 5
			enemyManager.initializeEnemies(1); //initializing the 2. wave
		}
		if(frameRate == 100){ // second = 10
			enemyManager.initializeEnemies(2); //initializing the 3. wave
		}
		if(frameRate == 150){ // second = 15
			enemyManager.initializeEnemies(3); //initializing the 4. wave
		}
		if(frameRate == 200){ // second = 20
			enemyManager.initializeEnemies(4); //initializing the 5. wave
		}
		if(frameRate == 250){ // second = 25
			enemyManager.initializeEnemies(5); //initializing the 6. wave
		}
		if(frameRate == 300){ // second = 30
			enemyManager.initializeEnemies(6); //initializing the 7. wave
		}
		if(frameRate == 350){ // second = 35
			enemyManager.initializeEnemies(7); //initializing the 8. wave
		}
		/*
		if(frameRate == 400){ // second = 40
			enemyManager.initializeEnemies(8); //initializing the 9. wave
		}
		if(frameRate == 450){ // second = 45
			enemyManager.initializeEnemies(9); //initializing the 10. wave
		}
		if(frameRate == 500){ // second = 50
			enemyManager.initializeEnemies(10); //initializing the 11. wave
		}
		if(frameRate == 550){ // second = 60
			enemyManager.initializeEnemies(3); //initializing the 12. wave
		}
		if(frameRate == 600){ // second = 65
			enemyManager.initializeEnemies(3); //initializing the 13. wave
		}
		if(frameRate == 700){ // second = 70
			enemyManager.initializeEnemies(3); //initializing the 14. wave
		}
		if(frameRate == 800){ // second = 75
			enemyManager.initializeEnemies(3); //initializing the 15. wave
		}
		*/
	}
	//UPDATE ENEMIES
	private void updateEnemies(){
		//update alive enemies
		for(int i = 0; i < enemyManager.enemyList.size();i++){
			if(!(enemyManager.enemyList.get(i).isAlive)){
				graveyard.add(enemyManager.enemyList.get(i));
				enemyManager.killEnemy(i);
			}
		}
		
		int imageSelection;
		imageSelection = frameRate/3 % 5;
		if(enemyManager.enemyCount != 0){
			for(int i=0; i<enemyManager.enemyCount; i++)
			{	
				enemyManager.enemyList.get(i).setEnemyImage(imageSelection);
			}
			for(int i=0; i<enemyManager.enemyCount; i++)
			{	
				enemyManager.enemyList.get(i).move(grid.targetsX,grid.targetsY);
			}
		}
	}
	//UPDATING GRAVEYARD
	private void updateGraveyard(){
		int updateFrequency = frameRate % 2;
		if(updateFrequency == 0)
			updateDyingEnemy();
	}
	//UPDATE DYING ENEMY
	private void updateDyingEnemy(){
		
		for(int i = 0; i < graveyard.size(); i++){
			int timeForCorpse = frameRate % 30;
			if(graveyard.get(i).getEnemyImageNumber() == 15)
			graveyard.get(i).setEnemyImage(16);
			else if(graveyard.get(i).getEnemyImageNumber() == 16)
			graveyard.get(i).setEnemyImage(17);
			else if(graveyard.get(i).getEnemyImageNumber() == 17 && timeForCorpse == 28){
				graveyard.remove(i);
			}
			else if(graveyard.get(i).getEnemyImageNumber() == 17 && timeForCorpse < 29){
				graveyard.get(i).setEnemyImage(17);	
			}
			else
				graveyard.get(i).setEnemyImage(15);	
		}	
	}
	//UPDATING TOWER TARGETS
	private void updateTowerTargets(){
			for(int i=0; i<towerManager.towerCount; i++){	
				for(int j=0; j<enemyManager.enemyCount; j++){
					Enemy en = enemyManager.enemyList.get(enemyManager.enemyCount-1);
					if(//!towerManager.towerList[i].hasTarget()
							//en.isAlive
							//&&
							Math.abs(towerManager.towerList[i].getLocX() - enemyManager.enemyList.get(j).locX) < towerManager.towerList[i].getTowerRange()
							&&
							Math.abs(towerManager.towerList[i].getLocY() - enemyManager.enemyList.get(j).locY) < towerManager.towerList[i].getTowerRange())
					{
						System.out.println("INRANGEEEEEEEEEEEEEEEEEE of tower: "+towerManager.towerList[i].getLocX()+","+towerManager.towerList[i].getLocY());
						towerManager.towerList[i].setTarget(enemyManager.enemyList.get(j));
						j = enemyManager.enemyList.size();
					/*	if(towerManager.towerList[i].getEnemy().getHealth()<=0) {
							Enemy enemy = towerManager.towerList[i].getEnemy();
							enemyManager.enemyList.remove(enemy);
							continue;
						}*/
							
					}
					//CLEAR TARGET NOT WORKING YET
					//
					//
					else if(//towerManager.towerList[i].hasTarget()
							//&&
							Math.abs(towerManager.towerList[i].getLocX() - enemyManager.enemyList.get(j).locX) > towerManager.towerList[i].getTowerRange()
							&&
							Math.abs(towerManager.towerList[i].getLocY() - enemyManager.enemyList.get(j).locY) > towerManager.towerList[i].getTowerRange())
					{
						if(j == enemyManager.enemyCount) {
							towerManager.towerList[i].setTarget(null);
							continue;
						}
					}
				}
			}
		
		
	}
	//UPDATE PROJECTILES
	private void updateProjectiles() throws Throwable{
		for(int i=0; i<towerManager.towerCount; i++){
			for(int j = 0; j < towerManager.towerList[i].getProjectileCount(); j++){
				towerManager.towerList[i].getProjectilesSpawned().get(j).update();
			}
		}
	}
	
	//getters
	public Grid getGrid(){
		return grid;
	}
	public EnemyManager getEnemyManager(){
		return enemyManager;
	}
	public TowerManager getTowerManager(){
		return towerManager;
	}
	public Shop getShop(){
		return shop;
	}
	public Control getControl(){
		return control;
	}
	public String getTime(){
		return time;
	}
	public int getPlayerGold(){
		return playerGold;
	}
	
	private void updateUserInputs(){
		if(control.getMouseY()>screenY)
		{
			shop.buyTower(control.getMouseX(),control.getMouseY(), playerGold);
		}
		else
		{
			int gridNoX = (control.getMouseX())/64;
			int gridNoY = (control.getMouseY())/64;
			boolean b = grid.getGridSlot(gridNoX,gridNoY).mouseHitThisSlot(shop.getTowerBought(), shop.getTowerToPlace(), gridNoX*grid.gridSlotWidth, gridNoY*grid.gridSlotHeight);
			if(b)
			{
				towerManager.towerList[towerManager.towerCount] = shop.getTowerToPlace();
				towerManager.addTower(shop.getTowerToPlace());
				shop.setTowerBought(false);
			}

		}
	}
	public ArrayList<Enemy> getGraveyard(){
		return graveyard;
	}
	public int getRemainingChances(){
		return remainingChances;
	}
}
	
	

