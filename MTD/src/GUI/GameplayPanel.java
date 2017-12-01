package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Grid.TowerGrid;
import classes.GameManager;

public class GameplayPanel extends JPanel{

	private Graphics dbg;
	private GameManager game;
	private JButton backBut;
	
	String timeImageBuffer;
	String resourceImageBuffer;
	BufferedImage timeImage; 
	BufferedImage resourceImage;
	String layoutBackgroundBuffer;
	BufferedImage layoutBackground;
	String waveImageBuffer;
	BufferedImage waveImage;
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
        backBut.setVisible(true);
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
		addMouseListener(game.getControl());
		addMouseMotionListener(game.getControl());
		backBut.repaint();
	}

	//////////////////////////////////////////////////////////////////////////////
	///////////////////////////////PAINT OBJECTS//////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////
	public void paint(Graphics g){
		//DRAWIN EFFECTS
		drawEffects(g);
		//DRAW GRIDS AND TOWERS
		drawGridsAndTowers(g);
		//DRAW ENEMIES
		drawEnemies(g);
		//DRAW PROJECTILES
		drawProjectiles(g);
		//DRAW SHOP
		game.getShop().draw(g);
		//DRAW LAYOUT ELEMENTS
		drawLayoutElements(g);
		backBut.repaint();
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
				if(game.getGrid().thisGrid[i][j] instanceof TowerGrid){
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
				{ 
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
	private void drawLayoutElements(Graphics g){
		timeImageBuffer = "/images/shop/layout/time_icon.png";
		resourceImageBuffer = "/images/shop/layout/resource_icon.png";
		waveImageBuffer = "/images/shop/layout/wave_icon.png";
		layoutBackgroundBuffer = "/images/shop/layout/layout_background.jpg";
		try {timeImage = ImageIO.read(getClass().getResourceAsStream(timeImageBuffer));}	
		catch(IOException exc) {exc.printStackTrace();}
		try {resourceImage = ImageIO.read(getClass().getResourceAsStream(resourceImageBuffer));}	
		catch(IOException exc) {exc.printStackTrace();}
		try {waveImage = ImageIO.read(getClass().getResourceAsStream(waveImageBuffer));}	
		catch(IOException exc) {exc.printStackTrace();}
		try {layoutBackground = ImageIO.read(getClass().getResourceAsStream(layoutBackgroundBuffer));}
		catch(IOException exc) {exc.printStackTrace();}
		
		g.drawImage(layoutBackground,0,736,this);		
		g.drawImage(timeImage,216,743,this);
		g.drawString(game.getTime(),248,758);
		g.drawImage(resourceImage,349,743,this);
		g.drawString(game.getPlayerGold()+"",381,758);
		g.drawImage(waveImage,482,743,this);
		//change to current wave
		g.drawString("50/50",514,758); // will be updated
		repaint();
		backBut.repaint(); // bugged idk why
		
		
	}
//BACK BUTTON
    private void backButActionPerformed(java.awt.event.ActionEvent evt) {                                        
    	this.hide();
    	GameFrame settingsTriggered = new GameFrame(new MainMenuPanel());
    }  
}