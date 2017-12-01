 package classes;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Timer;

import Control.Control;
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
	private int milisecond;
	private String time;
	public GameManager(){

		minute = 0;
		second = 0;
		milisecond = 0;
		time = minute + ":" + second;
		playerGold = 300;
		shop = new Shop();
		grid = new Grid(0);
		control = new Control();
		enemyManager = new EnemyManager(0, grid.gridSlotWidthInPixels, grid.gridSlotHeightInPixels, grid);//SPAWNS ENEMIES  IT'S CONSTRUCTOR
		towerManager = new TowerManager();
		screenX = grid.gridSlotWidthInPixels * grid.gridWidth;
		screenY = grid.gridSlotHeightInPixels * grid.gridHeight;
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
				updateEnemies(); // updating enemies
				updateTowerTargets(); // updating targets
				updateUserInputs(); // updating the controller
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
		milisecond++;
		if(milisecond%10 == 0){
			second++;
			if(second>59){
				minute++;
				second = 0;
			}
		}
		time = minute+":"+second;
	}
	//UPDATE ENEMIES
	private void updateEnemies(){
		for(int i=0; i<enemyManager.enemyCount; i++)
		{
			enemyManager.enemyList[i].move(grid.targetsX,grid.targetsY);
		}
	}
	//UPDATING TOWER TARGETS
	private void updateTowerTargets(){
			for(int i=0; i<towerManager.towerCount; i++){	
				for(int j=0; j<enemyManager.enemyCount; j++){
					if(!towerManager.towerList[i].hasTarget()
							&&
							Math.abs(towerManager.towerList[i].getLocX() - enemyManager.enemyList[j].locX) < towerManager.towerList[i].getTowerRange()
							&&
							Math.abs(towerManager.towerList[i].getLocY() - enemyManager.enemyList[j].locY) < towerManager.towerList[i].getTowerRange())
					{
					System.out.println("INRANGEEEEEEEEEEEEEEEEEE");
					towerManager.towerList[i].setTarget(enemyManager.enemyList[j]);
					j = enemyManager.enemyList.length;
					}
					//CLEAR TARGET NOT WORKING YET
					//
					//
					else if(towerManager.towerList[i].hasTarget()
							&&
							Math.abs(towerManager.towerList[i].getLocX() - enemyManager.enemyList[j].locX) > towerManager.towerList[i].getTowerRange()
							&&
							Math.abs(towerManager.towerList[i].getLocY() - enemyManager.enemyList[j].locY) > towerManager.towerList[i].getTowerRange())
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
			int gridNoX = (control.getMouseX())/(grid.gridSlotWidthInPixels);
			int gridNoY = (control.getMouseY())/(grid.gridSlotHeightInPixels);
			boolean b = grid.thisGrid[gridNoX][gridNoY].mouseHitThisSlot(shop.getTowerBought(), shop.getTowerToPlace(), gridNoX*grid.gridSlotWidthInPixels, gridNoY*grid.gridSlotHeightInPixels);
			if(b)
			{
				towerManager.towerList[towerManager.towerCount] = shop.getTowerToPlace();
				towerManager.addTower(shop.getTowerToPlace());
				shop.setTowerBought(false);
			}

		}
	}
}
	
	

