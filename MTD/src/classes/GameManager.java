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
		int delay = 100; // ~10 updates per second
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
		if(frameRate == 50){ //INITIALIZE SECOND WAVE AT 5TH SECOND
			enemyManager.initializeEnemies(1); //initializing the second wave
		}
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
		for(int i = 0; i < graveyard.size(); i++){
			graveyard.get(i).setEnemyImage(15);
		}
	}
	//UPDATING TOWER TARGETS
	private void updateTowerTargets(){
			for(int i=0; i<towerManager.towerCount; i++){	
				for(int j=0; j<enemyManager.enemyCount; j++){
					if(!towerManager.towerList[i].hasTarget()
							&&
							Math.abs(towerManager.towerList[i].getLocX() - enemyManager.enemyList.get(j).locX) < towerManager.towerList[i].getTowerRange()
							&&
							Math.abs(towerManager.towerList[i].getLocY() - enemyManager.enemyList.get(j).locY) < towerManager.towerList[i].getTowerRange())
					{
					System.out.println("INRANGEEEEEEEEEEEEEEEEEE");
					towerManager.towerList[i].setTarget(enemyManager.enemyList.get(j));
					j = enemyManager.enemyList.size();
					}
					//CLEAR TARGET NOT WORKING YET
					//
					//
					else if(towerManager.towerList[i].hasTarget()
							&&
							Math.abs(towerManager.towerList[i].getLocX() - enemyManager.enemyList.get(j).locX) > towerManager.towerList[i].getTowerRange()
							&&
							Math.abs(towerManager.towerList[i].getLocY() - enemyManager.enemyList.get(j).locY) > towerManager.towerList[i].getTowerRange())
					{
						if(j == enemyManager.enemyCount)
							towerManager.towerList[i].clearTarget();
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
	
	

