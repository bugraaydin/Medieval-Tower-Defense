package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import Grid.Grid;
import classes.EnemyManager;
import classes.GameManager;
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
	private GameManager game;
	private int screenX = 640;
	private int screenY = 640;

	JButton backBut;
	
	private ImageIcon myImageIcon = new ImageIcon("/Sequences/64x48/explosion1_003.png");
	
	public GameplayPanel(){
		game = new GameManager();
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
		setVisible(true);
		addMouseListener(game.getAL());
		addMouseMotionListener(game.getAL());
	}

	//////////////////////////////////////////////////////////////////////////////
	///////////////////////////////PAINT OBJECTS//////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////
	public void paint(Graphics g){
		drawEffects(g);
		//DRAW GRIDS AND TOWERS
		drawGridsAndTowers(g);
		//DRAW ENEMIES
		drawEnemies(g);
		//DRAW PROJECTILES
		drawProjectiles(g);
		//DRAW SHOP
		drawShop(g);
		

	}
	
	private void drawEffects(Graphics g)
	{
		myImageIcon.paintIcon(this, g, 345, 345);
		g.drawImage(myImageIcon.getImage(), 345, 345, this);
		for(int i=0; i<game.getEnemyManager().enemyList.length; i++)
		{
			if(game.getEnemyManager().enemyList[i].isGettingHit())
				g.drawImage(game.getEnemyManager().enemyList[i].getImpactImageIcon().getImage(),game.getEnemyManager().enemyList[i].getLocX(),game.getEnemyManager().enemyList[i].getLocY(), this);
			//repaint();
		}
	}
	
	private void drawGridsAndTowers(Graphics g){
		for(int i = 0; i < game.getGrid().gridWidth;i++){
			for(int j = 0; j < game.getGrid().gridHeight;j++){
				g.drawImage(game.getGrid().thisGrid[i][j].gridSlotImage, 64*i, 64*j, this);
				if(game.getGrid().thisGrid[i][j].hasTower==true){
					g.drawImage(game.getGrid().thisGrid[i][j].towerImage, game.getGrid().gridSlotWidthInPixels*i, game.getGrid().gridSlotHeightInPixels*j, this);
				}
			}
		}
	}
	
	private void drawEnemies(Graphics g){
		for(int i=0; i<game.getEnemyManager().enemyList.length; i++){	
			g.drawImage(game.getEnemyManager().enemyList[i].enemyImage,game.getEnemyManager().enemyList[i].getLocX(),game.getEnemyManager().enemyList[i].getLocY(), this);
			repaint();
		}
	}
	
	private void drawProjectiles(Graphics g)
	{
		for(int i=0; i<game.getTowerManager().towerCount; i++)
		{
			for(int j = 0; j < game.getTowerManager().towerList[i].getProjectileCount(); j++)
			{
				if(game.getTowerManager().towerList[i].getProjectilesSpawned().get(j).getLocY() < 580
						&& game.getTowerManager().towerList[i].getProjectilesSpawned().get(j) != null)
				{ // shop screena kaçmasýn
					if(game.getTowerManager().towerList[i].getProjectilesSpawned().get(j).isAlive == false)
						game.getTowerManager().towerList[i].getProjectilesSpawned().remove(j);
					else
					{
						g.drawImage(game.getTowerManager().towerList[i].getProjectilesSpawned().get(j).projectileImage,
								game.getTowerManager().towerList[i].getProjectilesSpawned().get(j).getLocX(),
								game.getTowerManager().towerList[i].getProjectilesSpawned().get(j).getLocY(),
								this);
								repaint();
					}

					
				}
			}	
		}
	}
	
	private void drawShop(Graphics g){
		g.drawImage(game.getShop().backgroundImage,0,576,this);
		g.drawImage(game.getShop().itemImage[0],0,576,this);
		g.drawImage(game.getShop().itemImage[1],60,576,this);
		g.drawImage(game.getShop().itemImage[2],120,576,this);
		g.drawImage(game.getShop().itemImage[3],180,576,this);
		g.drawImage(game.getShop().itemImage[4],0,636,this);
		g.drawImage(game.getShop().itemImage[5],60,636,this);
		g.drawImage(game.getShop().itemImage[6],120,636,this);
		g.drawImage(game.getShop().itemImage[7],180,636,this);
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
	
	

	

	
}