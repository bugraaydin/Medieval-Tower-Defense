 package classes;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Timer;

import Grid.*;

public class GameManager {
	private AL myAL;
	private int projectileCount;
	private int playerGold;
	private int shopHeight;
	private int screenX;
	private int screenY;
	private int rectX, rectY;
	private Projectile[] projectileArray;
	private EnemyManager enemyManager;
	private TowerManager towerManager;
	private Shop shop;
	private Grid grid;	
	
	
	public GameManager(){
		/////////////////////////////*TEST
		//////////////////////////////
		projectileCount = 0;
		playerGold = 300;
		shopHeight = 200;
		screenX = 640;
		screenY = 640;
		shop = new Shop();
		grid = new Grid(0);
		myAL = new AL();
		enemyManager = new EnemyManager(0, grid.gridSlotWidthInPixels, grid.gridSlotHeightInPixels, grid);//SPAWNS ENEMIES  IT'S CONSTRUCTOR
		projectileArray = new Projectile[100];
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
				updateEnemies(); // updating enemies
				updateTowerTargets(); // updating targets
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
			for(int j=0; j<enemyManager.enemyCount; j++)
			{
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
				//
				//
				//
			}
		}
	}
	//UPDATE PROJECTILES
	private void updateProjectiles() throws Throwable{
		for(int i=0; i<towerManager.towerCount; i++){
			for(int j = 0; j < towerManager.towerList[i].getProjectileCount(); j++){
				towerManager.towerList[i].getProjectilesSpawned()[j].update();
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
	public AL getAL(){
		return myAL;
	}
	
//////////////////CONTROLLER	
	public class AL extends MouseAdapter{
	private int gridNoY, gridNoX;
	
	public void mouseMoved(MouseEvent e){
	rectX = e.getX()-12;
	rectY = e.getY()-12;
	}
	
	public void mousePressed(MouseEvent e) {
	int myX = e.getX();
	int myY = e.getY();
	if(e.getY()>screenY)
	{
		//System.out.println(myX);
		shop.buyTower(myX,myY, playerGold);
	}
	else
	{
		System.out.println("Hit on tower slot");
		gridNoX = (e.getX())/(grid.gridSlotWidthInPixels);
		gridNoY = (e.getY())/(grid.gridSlotHeightInPixels);
		boolean b = grid.thisGrid[gridNoX][gridNoY].mouseHitThisSlot(shop.towerBought, shop.towerToPlace, gridNoX*grid.gridSlotWidthInPixels, gridNoY*grid.gridSlotHeightInPixels);
		if(b)
		{
			towerManager.towerList[towerManager.towerCount] = shop.towerToPlace;
			towerManager.addTower(shop.towerToPlace);
			shop.towerBought = false;
		}
		//grid.thisGrid[gridNoX][gridNoY].testFunction("ASDADASDSADSA");
		System.out.println("gridNoX: " + gridNoX);
		System.out.println("gridNoY: " + gridNoY);
		
		//System.out.println("gridHeight: " + grid.gridHeight);
		//System.out.println("screenX: " + screenX);
		//System.out.println("mouseX: " + e.getX());
	}
	}
	                     
	
	}
}
	
	

