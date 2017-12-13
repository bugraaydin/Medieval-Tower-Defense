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
	
	//
	
	
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
		int[][] test = {
							{0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0},
							{1,1,1,1,0,0,0,0,0},
							{0,0,0,1,0,0,0,0,0},
							{0,0,0,1,0,0,0,0,0},
							{0,0,0,1,0,0,0,0,0},
							{0,0,0,1,1,1,1,0,0},
							{0,0,0,0,0,0,1,0,0},
							{0,0,0,0,0,0,1,0,0},
							{0,0,1,1,1,1,1,0,0},
							{0,0,1,0,0,0,0,0,0},
							{0,0,1,1,1,1,1,0,0},
							{0,0,0,0,0,0,1,0,0}
						};
		grid = new Grid(test);
		control = new Control();
		enemyManager = new EnemyManager();
		enemyManager.initializeEnemies(0); // initializing the first wave
		towerManager = new TowerManager();
		screenX = grid.getGridSlotSize() * grid.getGridWidth();
		screenY = grid.getGridSlotSize() * grid.getGridHeight();
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
				updateGraveyard(); //
				updateProjectiles();//updating the projectiles
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
		//IMAGE SELECTION FOR ENEMY MOVEMENT
		if(enemyManager.enemyCount != 0){
			for(int i=0; i<enemyManager.enemyList.size(); i++)
			{	
				if(enemyManager.enemyList.get(i).getVelocity()[0] == 0 && enemyManager.enemyList.get(i).getVelocity()[1] == enemyManager.enemyList.get(i).getSpeed())
					enemyManager.enemyList.get(i).setEnemyImage(imageSelection);
				else if(enemyManager.enemyList.get(i).getVelocity()[0] == enemyManager.enemyList.get(i).getSpeed() && enemyManager.enemyList.get(i).getVelocity()[1] == 0)
					enemyManager.enemyList.get(i).setEnemyImage(imageSelection+5);
				else if(enemyManager.enemyList.get(i).getVelocity()[0] == 0&& enemyManager.enemyList.get(i).getVelocity()[1] == -enemyManager.enemyList.get(i).getSpeed())
 					enemyManager.enemyList.get(i).setEnemyImage(imageSelection+10);
			}
			for(int i=0; i<enemyManager.enemyList.size(); i++)
			{	
				int gridX = enemyManager.enemyList.get(i).locX / 64;
				int gridY = enemyManager.enemyList.get(i).locY / 64;
				if(enemyManager.enemyList.get(i).getVelocity()[1] == -enemyManager.enemyList.get(i).getSpeed() && grid.getGridSlot(gridX+1, gridY) instanceof EnemyGrid && enemyManager.enemyList.get(i).getLocY() > 5 + gridY * grid.getGridSlotSize())
					gridY++;

				if(gridX == grid.getGridWidth()-1 && enemyManager.enemyList.get(i).getVelocity()[0] == enemyManager.enemyList.get(i).getSpeed()){
					enemyManager.enemyList.remove(i);
					remainingChances--;
					continue;
				}
				if(gridY == grid.getGridHeight()-1 && enemyManager.enemyList.get(i).getVelocity()[1] == enemyManager.enemyList.get(i).getSpeed()){
					enemyManager.enemyList.remove(i);
					remainingChances--;
					continue;
				}
				if(gridY == 0 && enemyManager.enemyList.get(i).getVelocity()[1] == -enemyManager.enemyList.get(i).getSpeed()){
					enemyManager.enemyList.remove(i);
					remainingChances--;
					continue;
				}
				
				int switchCase;
				if(gridY == 0)
					switchCase = -1; //start
				else if(grid.getGridSlot(gridX, gridY + 1) instanceof EnemyGrid && enemyManager.enemyList.get(i).getVelocity()[1] == enemyManager.enemyList.get(i).getSpeed())
					switchCase = 1; //DOWN
				else if(grid.getGridSlot(gridX , gridY - 1) instanceof EnemyGrid && enemyManager.enemyList.get(i).getVelocity()[1] != enemyManager.enemyList.get(i).getSpeed() && !(grid.getGridSlot(gridX+1, gridY ) instanceof EnemyGrid))
					switchCase = 2; //UP
				else if(grid.getGridSlot(gridX + 1, gridY) instanceof EnemyGrid)
					switchCase = 3; //RIGHT

				else 
					switchCase = 0; //DEFAULT
				
				switch(switchCase){
					case -1:{
						enemyManager.enemyList.get(i).setVelocity(0, (enemyManager.enemyList.get(i).getSpeed()));
						enemyManager.enemyList.get(i).move(enemyManager.enemyList.get(i).getVelocity()[0], enemyManager.enemyList.get(i).getVelocity()[1]);
						break;
					}
					case 1:{
						enemyManager.enemyList.get(i).setVelocity(0, (enemyManager.enemyList.get(i).getSpeed()));
						enemyManager.enemyList.get(i).move(enemyManager.enemyList.get(i).getVelocity()[0], enemyManager.enemyList.get(i).getVelocity()[1]);
						break;
					}
					case 2:{
						enemyManager.enemyList.get(i).setVelocity(0, -(enemyManager.enemyList.get(i).getSpeed()));
						enemyManager.enemyList.get(i).move(enemyManager.enemyList.get(i).getVelocity()[0], enemyManager.enemyList.get(i).getVelocity()[1]);
						break;
					}
					case 3:{
						enemyManager.enemyList.get(i).setVelocity((enemyManager.enemyList.get(i).getSpeed()),0 );
						enemyManager.enemyList.get(i).move(enemyManager.enemyList.get(i).getVelocity()[0], enemyManager.enemyList.get(i).getVelocity()[1]);
						break;
					}
					default:{
						enemyManager.enemyList.get(i).setVelocity(0, (enemyManager.enemyList.get(i).getSpeed()));
						enemyManager.enemyList.get(i).move(enemyManager.enemyList.get(i).getVelocity()[0], enemyManager.enemyList.get(i).getVelocity()[1]);
						break;
					}
				
				}	
			

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
			for(int i=0; i<towerManager.towerList.size(); i++){	
				for(int j=0; j<enemyManager.enemyList.size(); j++){

					if(!towerManager.towerList.get(i).hasTarget()
							&&
							Math.sqrt((towerManager.towerList.get(i).getLocX() - enemyManager.enemyList.get(j).locX)*
									(towerManager.towerList.get(i).getLocX() - enemyManager.enemyList.get(j).locX)+
									(towerManager.towerList.get(i).getLocY() - enemyManager.enemyList.get(j).locY)*
									(towerManager.towerList.get(i).getLocY() - enemyManager.enemyList.get(j).locY))
							< towerManager.towerList.get(i).getTowerRange()
						)		
					{
						System.out.println("INRANGEEEEEEEEEEEEEEEEEE");
						towerManager.towerList.get(i).setTarget(enemyManager.enemyList.get(j));
						j = enemyManager.enemyList.size();
					}
					else if(towerManager.towerList.get(i).hasTarget()
							&&
							Math.sqrt((towerManager.towerList.get(i).getLocX() - towerManager.towerList.get(i).getTarget().locX)*
									(towerManager.towerList.get(i).getLocX() - towerManager.towerList.get(i).getTarget().locX)+
									(towerManager.towerList.get(i).getLocY() - towerManager.towerList.get(i).getTarget().locY)*
									(towerManager.towerList.get(i).getLocY() - towerManager.towerList.get(i).getTarget().locY))
							> towerManager.towerList.get(i).getTowerRange()
							)
					{
						towerManager.towerList.get(i).clearTarget();
						j=enemyManager.enemyList.size();
					}
						
						
					if(towerManager.towerList.get(i).getTarget() != null)
						if((!towerManager.towerList.get(i).getTarget().isAlive)){
							towerManager.towerList.get(i).setTarget(null);
							towerManager.towerList.get(i).setHasTarget(false);
							System.out.println("sa");
							return;
						}
				}
			}
		
		
	}
	//UPDATE PROJECTILES
	private void updateProjectiles(){
		int time = frameRate;
		if(towerManager.towerList.size() == 0)
			return;
		
		for(int i=0; i<towerManager.towerList.size(); i++){
			/**
			if(towerManager.towerList.get(i).getTarget() != null)
				if(towerManager.towerList.get(i).getTarget().isAlive == true && frameRate % 8 == 0){
					towerManager.spawnProjectile(i);
					System.out.println("wow");
				}
			*/
			for(int j = 0; j < towerManager.towerList.get(i).getProjectilesSpawned().size(); j++){
				
				towerManager.towerList.get(i).getProjectilesSpawned().get(j).update();
				if(towerManager.towerList.get(i).getTarget() == null )
					towerManager.towerList.get(i).getProjectilesSpawned().remove(j);

				
			}
		}
	}
	
	
	private void updateUserInputs(){
		boolean b;
		if(control.getMouseY()>screenY)
		{
			shop.buyTower(control.getMouseX(),control.getMouseY(), playerGold);
		}
		else
		{
			if(control.getMouseX() == 0 && control.getMouseY() == 0)
				return;
			int gridNoX = (control.getMouseX())/64;
			int gridNoY = (control.getMouseY())/64;
			if(!(grid.getGridSlot(gridNoX, gridNoY) instanceof TowerGrid))
					return;
			b = ((TowerGrid) grid.getGridSlot(gridNoX,gridNoY)).mouseHitThisSlot(shop.getTowerBought(), shop.getTowerToPlace(), gridNoX*grid.getGridHeight(), gridNoY*grid.getGridWidth());
			if(b)
			{

				towerManager.addTower(shop.getTowerToPlace());
				int gridX = control.getMouseX() / 64;
				int gridY = control.getMouseY() / 64;
				shop.getTowerToPlace().setLocX(gridX * 64 + 32);
				shop.getTowerToPlace().setLocY(gridY * 64 + 32);
				control.setMouseX(0);
				control.setMouseY(0);
				shop.setTowerBought(false);
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
	public ArrayList<Enemy> getGraveyard(){
		return graveyard;
	}
	public int getRemainingChances(){
		return remainingChances;
	}
}
	
	

