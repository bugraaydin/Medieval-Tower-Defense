package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import Grid.Grid;
import classes.EnemyManager;
import classes.Projectile;
import classes.Shop;
import classes.TowerManager;

import java.awt.event.*;

public class GameplayPanel extends JPanel{
	/////////////////////
	//int gridSize = 10;
	/////////////////////
	//private Image dbImage;

	private Graphics dbg;
	//private BufferedImage tryImage;
	Projectile[] projectileArray;
	public EnemyManager enemyManager;
	public TowerManager towerManager;
	private Shop shop;
	private Grid grid;	
	private AL myAL;
	private int projectileCount = 0;
	private int playerGold = 300;
	private int shopHeight = 200;
	private int screenX = 640;
	private int screenY = 640;
	int rectX, rectY;

	JButton backBut;
	
	public GameplayPanel(){
		
        backBut = new javax.swing.JButton();
        backBut.setText("Back");
        backBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(672, Short.MAX_VALUE)
                .addComponent(backBut)
                .addGap(101, 101, 101))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(714, Short.MAX_VALUE)
                .addComponent(backBut)
                .addGap(37, 37, 37))
        );
        
		this.setPreferredSize(new Dimension(832,776));
		/////////////////////////////*TEST
		//////////////////////////////
		shop = new Shop();
		grid = new Grid(0);
		enemyManager = new EnemyManager(0, grid.gridSlotWidthInPixels, grid.gridSlotHeightInPixels, grid);//SPAWNS ENEMIES  IT'S CONSTRUCTOR
		projectileArray = new Projectile[100];
		towerManager = new TowerManager();
		
		screenX = grid.gridSlotWidthInPixels * grid.gridWidth;
		screenY = grid.gridSlotHeightInPixels * grid.gridHeight;

		
		setSize(screenX,screenY+shopHeight);
		setVisible(true);
		myAL = new AL();
		addMouseListener(myAL);
		addMouseMotionListener(myAL);

		
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
				updateProjectiles(); //updating projectiles
			}
		};
		new Timer(delay,taskPerformer).start();
	}

	//UPDATE ENEMIES
	private void updateEnemies(){
		for(int i=0; i<enemyManager.enemyCount; i++)
		{
			enemyManager.enemyList[i].move(grid.targetsX,grid.targetsY);
			repaint();
		}
	}
	//UPDATING TOWER TARGETS
	private void updateTowerTargets(){
		for(int i=0; i<towerManager.towerCount; i++){	
			for(int j=0; j<enemyManager.enemyCount; j++){
				if(!towerManager.towerList[i].hasTarget
						&&
						Math.abs(towerManager.towerList[i].locX - enemyManager.enemyList[j].locX) < towerManager.towerList[i].towerRange
						&&
						Math.abs(towerManager.towerList[i].locY - enemyManager.enemyList[j].locY) < towerManager.towerList[i].towerRange)
				{
					System.out.println("INRANGEEEEEEEEEEEEEEEEEE");
					towerManager.towerList[i].setTarget(enemyManager.enemyList[j]);
					j = enemyManager.enemyList.length;
				}
			}
		}
	}
	//UPDATE PROJECTILES
	private void updateProjectiles(){
		for(int i=0; i<towerManager.towerCount; i++){
			for(int j = 0; j < towerManager.towerList[i].projectileCount; j++){
				towerManager.towerList[i].projectilesSpawned[j].move();
			}
		}
	}
	//////////////////////////////////////////////////////////////////////////////
	///////////////////////////////PAINT OBJECTS//////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////
	public void paint(Graphics g){

		//DRAW GRIDS AND TOWERS
		drawGridsAndTowers(g);
		//DRAW ENEMIES
		drawEnemies(g);
		//DRAW PROJECTILES
		drawProjectiles(g);
		//DRAW SHOP
		drawShop(g);
	}
	
	
	private void drawGridsAndTowers(Graphics g){
		for(int i = 0; i < grid.gridWidth;i++){
			for(int j = 0; j < grid.gridHeight;j++){
				g.drawImage(grid.thisGrid[i][j].gridSlotImage, 64*i, 64*j, this);
				if(grid.thisGrid[i][j].hasTower==true){
					g.drawImage(grid.thisGrid[i][j].towerImage, grid.gridSlotWidthInPixels*i, grid.gridSlotHeightInPixels*j, this);
				}
			}
		}
	}
	
	private void drawEnemies(Graphics g){
		for(int i=0; i<enemyManager.enemyList.length; i++){	
			g.drawImage(enemyManager.enemyList[i].enemyImage, enemyManager.enemyList[i].getLocX(),enemyManager.enemyList[i].getLocY(), this);
		}
	}
	
	private void drawProjectiles(Graphics g){
		for(int i=0; i<towerManager.towerCount; i++){
			for(int j = 0; j < towerManager.towerList[i].projectileCount; j++){
				if(towerManager.towerList[i].projectilesSpawned[j].getLocY() < 580){ // shop screena kaçmasýn
					g.drawImage(towerManager.towerList[i].projectilesSpawned[j].projectileImage,
							towerManager.towerList[i].projectilesSpawned[j].getLocX(),
							towerManager.towerList[i].projectilesSpawned[j].getLocY(),
							this);		
				}
			}	
		}
	}
	
	private void drawShop(Graphics g){
		g.drawImage(shop.backgroundImage,0,576,this);
		for(int i=0; i<shop.getItemCount(); i++)
			g.drawImage(shop.itemImage[i], 64*i, 578, this);
		backBut.repaint();
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
	}
	
	
	
//BACK BUTTON
    private void backButActionPerformed(java.awt.event.ActionEvent evt) {                                        
    	this.hide();
    	GameFrame settingsTriggered = new GameFrame(new MainMenuPanel());
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
				shop.BuyTower(myX, playerGold);
			}
			else
			{
				System.out.println("Hit on tower slot");
				gridNoX = (e.getX())/(grid.gridSlotWidthInPixels);
				gridNoY = (e.getY())/(grid.gridSlotHeightInPixels);
				boolean b = grid.thisGrid[gridNoX][gridNoY].mouseHitThisSlot(shop.towerBought, shop.towerToPlace, gridNoX*grid.gridSlotWidthInPixels, gridNoY*grid.gridSlotHeightInPixels);
				repaint();
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