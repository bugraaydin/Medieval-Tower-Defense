 package classes;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Timer;

import Control.Control;
import Enemy.Enemy;
import Grid.*;

public class GameManager {
	
	private HighScoreTable scoreTable;
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
	private boolean gameLost;
	private boolean gameWon;
	
	//
	
	
	//CHANGE
	private ArrayList<Enemy> graveyard;
	//
	//public BufferedImage testImage;
	public GameManager(){
		
		////////

		////////

		//
		scoreTable = new HighScoreTable();
		scoreTable.writeScore(100);
		gameLost = false;
		gameWon = false;
		remainingChances = 10;
		graveyard = new ArrayList<Enemy>();
		//
		minute = 0;
		second = 0;
		frameRate = 0;
		time = minute + ":" + second;
		playerGold = 400;
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
				//Checking if game is lost
				if(remainingChances < 1)
					gameLost = true;
				//Checking if game is won
				if(enemyManager.getWaveNo() == 15 && enemyManager.enemyList.size() == 0)
					gameWon = true;
				if(gameLost || gameWon)
					return;
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
		//FIRST WAVE__________________________________________________
		if(frameRate == 30){ // second = 3
			enemyManager.initializeEnemies(0,0); //initializing 1.1 enemy
		}
		if(frameRate == 40){ // second = 4
			enemyManager.initializeEnemies(0,1); //initializing 1.2 enemy
		}
		if(frameRate == 50){ // second = 5
			enemyManager.initializeEnemies(0,2);//initializing 1.3 enemy
		}
		if(frameRate == 60){ // second = 6
			enemyManager.initializeEnemies(0,3);//initializing 1.4 enemy
		}
		//____________________________________________________________
		//SECOND WAVE_________________________________________________
		if(frameRate == 150){ // second = 15
			enemyManager.initializeEnemies(1,0); //initializing 2.1 enemy
		}
		if(frameRate == 160){ // second = 16
			enemyManager.initializeEnemies(1,1); //initializing the 2.2 enemy
		}
		if(frameRate == 170){ // second = 17
			enemyManager.initializeEnemies(1,2); //initializing the 2.3 enemy
		}
		if(frameRate == 180){ // second = 18
			enemyManager.initializeEnemies(1,3); //initializing the 2.4 enemy
		}
		//_____________________________________________________________
		//THIRD WAVE___________________________________________________
		if(frameRate == 250){ // second = 25
			enemyManager.initializeEnemies(2,0); //initializing 3.1 enemy
		}
		if(frameRate == 260){ // second = 26
			enemyManager.initializeEnemies(2,1); //initializing the 3.2 enemy
		}
		if(frameRate == 270){ // second = 27
			enemyManager.initializeEnemies(2,2); //initializing the 3.3 enemy
		}
		if(frameRate == 280){ // second = 28
			enemyManager.initializeEnemies(2,3); //initializing the 3.4 enemy
		}
		//_____________________________________________________________
		//FOURTH WAVE__________________________________________________
		if(frameRate == 350){ // second = 35
			enemyManager.initializeEnemies(3,0); //initializing 4.1 enemy
		}
		if(frameRate == 360){ // second = 36
			enemyManager.initializeEnemies(3,1); //initializing the 4.2 enemy
		}
		if(frameRate == 370){ // second = 37
			enemyManager.initializeEnemies(3,2); //initializing the 4.3 enemy
		}
		if(frameRate == 380){ // second = 38
			enemyManager.initializeEnemies(3,3); //initializing the 4.4 enemy
		}
		//_________________________________________________________________
		//FIFTH WAVE_______________________________________________________
		if(frameRate == 450){ // second = 45
			enemyManager.initializeEnemies(4,0); //initializing 4.1 enemy
		}
	}
	//UPDATE ENEMIES
	private void updateEnemies(){
		//update alive enemies
		for(int i = 0; i < enemyManager.enemyList.size();i++){
			if(!(enemyManager.enemyList.get(i).isAlive)){
				graveyard.add(enemyManager.enemyList.get(i));
				playerGold = playerGold + enemyManager.enemyList.get(i).getResource();
				enemyManager.enemyList.get(i).playEnemyDie();
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
				double hppercent = ((double)enemyManager.enemyList.get(i).getHealth() / (double)enemyManager.enemyList.get(i).getMaxHealth()) ;
				System.out.println(hppercent);
				enemyManager.enemyList.get(i).setEnemyHB(hppercent);
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
	int testNumber=1;
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

						if(enemyManager.enemyList.get(j).isAlive==true)
						{
							testNumber++;
							towerManager.towerList.get(i).setTarget(enemyManager.enemyList.get(j));
							j = enemyManager.enemyList.size();					
						}

					}
					
					else if(towerManager.towerList.get(i).hasTarget())
					{
						if(towerManager.towerList.get(i).getTarget().isAlive==false)
						{
							towerManager.towerList.get(i).clearTarget();
							return;
						}
						testNumber++;
						if(Math.sqrt((towerManager.towerList.get(i).getLocX() - towerManager.towerList.get(i).getTarget().locX)*
								(towerManager.towerList.get(i).getLocX() - towerManager.towerList.get(i).getTarget().locX)+
								(towerManager.towerList.get(i).getLocY() - towerManager.towerList.get(i).getTarget().locY)*
								(towerManager.towerList.get(i).getLocY() - towerManager.towerList.get(i).getTarget().locY))
						> towerManager.towerList.get(i).getTowerRange()
							)				
						{
							towerManager.towerList.get(i).clearTarget();
							j=enemyManager.enemyList.size();
						}
											
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
			for(int j = 0; j < towerManager.towerList.get(i).getProjectilesSpawned().size(); j++){
				
				towerManager.towerList.get(i).getProjectilesSpawned().get(j).update();
				if(towerManager.towerList.get(i).getTarget() == null )
					towerManager.towerList.get(i).getProjectilesSpawned().remove(j);
			}
		}
	}
	
	
	private void updateUserInputs(){
		boolean b;
		int gridNoX = (control.getMouseX())/64;
		int gridNoY = (control.getMouseY())/64;
		if(control.getMouseX() == 0 && control.getMouseY() == 0)
			return;
		if(control.getMouseY()>screenY)
		{
			shop.buyTower(control.getMouseX(),control.getMouseY(), playerGold);
			control.setMouseX(0);
			control.setMouseY(0);
			return;
		}
		if(grid.getGridSlot(gridNoX, gridNoY) instanceof TowerGrid && control.getMouseX() != 0 && control.getMouseY() != 0 ){
			if(((TowerGrid)grid.getGridSlot(gridNoX, gridNoY)).hasTower == true){
				if(playerGold >= ((TowerGrid)grid.getGridSlot(gridNoX, gridNoY)).getTower().getCost()){
				((TowerGrid)grid.getGridSlot(gridNoX, gridNoY)).getTower().upgradeTower();
				control.setMouseX(0);
				control.setMouseY(0);
				playerGold = playerGold - ((TowerGrid)grid.getGridSlot(gridNoX, gridNoY)).getTower().getCost();
				return;
				}
			}
			
		}
		
			if(!(grid.getGridSlot(gridNoX, gridNoY) instanceof TowerGrid))
					return;
			b = ((TowerGrid) grid.getGridSlot(gridNoX,gridNoY)).mouseHitThisSlot(shop.getTowerBought(), shop.getTowerToPlace(), gridNoX*grid.getGridHeight(), gridNoY*grid.getGridWidth());
			if(shop.getTowerToPlace() != null){
				if(b && playerGold > shop.getTowerToPlace().getCost())
				{
					towerManager.addTower(shop.getTowerToPlace());
					shop.getTowerToPlace().setLocX(gridNoX * 64 + 32);
					shop.getTowerToPlace().setLocY(gridNoY * 64 + 32);
					shop.setTowerBought(false);
					control.setMouseX(0);
					control.setMouseY(0);
					playerGold = playerGold - shop.getTowerToPlace().getCost();
					shop.setTowerToPlace(null);
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
	
	

