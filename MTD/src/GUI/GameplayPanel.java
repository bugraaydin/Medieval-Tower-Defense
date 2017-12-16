package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Grid.EnemyGrid;
import Grid.TowerGrid;
//import Tower.ArcaneTower;
import classes.GameManager;

public class GameplayPanel extends JPanel{

	private Graphics dbg;
	private GameManager game;
	private JButton backBut;
	
	private String timeImageBuffer;
	private String resourceImageBuffer;
	private BufferedImage timeImage; 
	private BufferedImage resourceImage;
	private String layoutBackgroundBuffer;
	private BufferedImage layoutBackground;
	private String waveImageBuffer;
	private BufferedImage waveImage;
	private String lifeImageBuffer;
	private BufferedImage lifeImage;
	private BufferedImage gameWonImage;
	private BufferedImage gameLostImage;
	private ImageIcon myImageIcon = new ImageIcon("/Sequences/64x48/explosion1_003.png");
	//
	private BufferedImage castleImage;
	private BufferedImage spawnImage;
	public GameplayPanel(){

		////////////////////////////
		//
		try {castleImage = ImageIO.read(getClass().getResourceAsStream("/images/grids/castle.png"));}	
		catch(IOException exc) {exc.printStackTrace();}
		try {spawnImage = ImageIO.read(getClass().getResourceAsStream("/images/grids/enemyspawn.png"));}	
		catch(IOException exc) {exc.printStackTrace();}
		//////////////////////////
		timeImageBuffer = "/images/shop/layout/time_icon.png";
		resourceImageBuffer = "/images/shop/layout/resource_icon.png";
		waveImageBuffer = "/images/shop/layout/wave_icon.png";
		lifeImageBuffer = "/images/shop/layout/life_icon.png";
		layoutBackgroundBuffer = "/images/shop/layout/layout_background.jpg";
		try {timeImage = ImageIO.read(getClass().getResourceAsStream(timeImageBuffer));}	
		catch(IOException exc) {exc.printStackTrace();}
		try {resourceImage = ImageIO.read(getClass().getResourceAsStream(resourceImageBuffer));}	
		catch(IOException exc) {exc.printStackTrace();}
		try {waveImage = ImageIO.read(getClass().getResourceAsStream(waveImageBuffer));}	
		catch(IOException exc) {exc.printStackTrace();}
		try {lifeImage = ImageIO.read(getClass().getResourceAsStream(lifeImageBuffer));}
		catch(IOException exc) {exc.printStackTrace();}
		try {layoutBackground = ImageIO.read(getClass().getResourceAsStream(layoutBackgroundBuffer));}
		catch(IOException exc) {exc.printStackTrace();}
		//
		try {gameWonImage = ImageIO.read(getClass().getResourceAsStream("/images/gamealert/game_won.png"));}	
		catch(IOException exc) {exc.printStackTrace();}
		try {gameLostImage = ImageIO.read(getClass().getResourceAsStream("/images/gamealert/game_lost.png"));}	
		catch(IOException exc) {exc.printStackTrace();}
		//////////////////////////
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
	//	drawEffects(g);
		//DRAW GRIDS AND TOWERS
		drawGridsAndTowers(g);
		//DRAW ENEMIES
		drawEnemies(g);
		//DRAW GRAVEYARD
		drawGraveyard(g);
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
		//g.drawImage((game.getEnemyManager().enemyList.get(i).enemyImage,game.getEnemyManager().enemyList.get(i).getLocX(),game.getEnemyManager().enemyList.get(i).getLocY(), this);
		for(int i=0; i<game.getEnemyManager().enemyList.size(); i++)
		{
			if(game.getEnemyManager().enemyList.get(i).isGettingHit())
				g.drawImage(game.getEnemyManager().enemyList.get(i).getImpactImageIcon().getImage(),game.getEnemyManager().enemyList.get(i).getLocX(),game.getEnemyManager().enemyList.get(i).getLocY(), this);
			//repaint();
		}
	}
	
	private void drawGridsAndTowers(Graphics g){
		for(int i = 0; i < game.getGrid().getGridWidth();i++){
			for(int j = 0; j < game.getGrid().getGridHeight();j++){
				g.drawImage(game.getGrid().getGridSlot(i,j).gridSlotImage[0], game.getGrid().getGridSlotSize()*i, game.getGrid().getGridSlotSize()*j, this);
				g.drawImage(game.getGrid().getGridSlot(i,j).gridSlotImage[1], game.getGrid().getGridSlotSize()*i+32, game.getGrid().getGridSlotSize()*j, this);
				g.drawImage(game.getGrid().getGridSlot(i,j).gridSlotImage[2], game.getGrid().getGridSlotSize()*i, game.getGrid().getGridSlotSize()*j+32, this);
				g.drawImage(game.getGrid().getGridSlot(i,j).gridSlotImage[3], game.getGrid().getGridSlotSize()*i+32, game.getGrid().getGridSlotSize()*j+32, this);
				if(i == 1 && j == 0){
					g.drawImage(castleImage, game.getGrid().getGridSlotSize()*i, game.getGrid().getGridSlotSize()*j, this);
				}
				if(i == 12 && game.getGrid().getGridSlot(i,j) instanceof EnemyGrid){
					g.drawImage(spawnImage, game.getGrid().getGridSlotSize()*i, game.getGrid().getGridSlotSize()*j, this);
				}
				repaint();
				if(game.getGrid().getGridSlot(i,j) instanceof TowerGrid){
					g.drawImage((game.getGrid().getGridSlot(i,j)).towerImage, game.getGrid().getGridSlotSize()*i, game.getGrid().getGridSlotSize()*j, this);
					repaint();
				}
			}
		}
	}
	//ALSO DRAWS ON HIT EFFECTS
	private void drawEnemies(Graphics g){
		for(int i=0; i<game.getEnemyManager().enemyList.size(); i++){	
			//DRAW ENEMIES
			g.drawImage(game.getEnemyManager().enemyList.get(i).enemyImage,game.getEnemyManager().enemyList.get(i).getLocX(),game.getEnemyManager().enemyList.get(i).getLocY(), this);
			//DRAW HEALTHBAR
			g.drawImage(game.getEnemyManager().enemyList.get(i).enemyHealth,game.getEnemyManager().enemyList.get(i).getLocX()-15,game.getEnemyManager().enemyList.get(i).getLocY()-12, this);
			//DRAW EFFECTS
			
			if(game.getEnemyManager().enemyList.get(i).isGettingHit())
			{


				// Drawing the rotated image at the required drawing locations
				//g.drawImage((ArcaneTower)game.getTowerManager().towerList.get(0).g,150,150,this);
				//System.out.println("DRAWING AN EFFECT");
				g.drawImage(game.getEnemyManager().enemyList.get(i).hitEffectImage,game.getEnemyManager().enemyList.get(i).getLocX(),game.getEnemyManager().enemyList.get(i).getLocY(), this);
			}
			
			repaint();
		}
	}
	//
	private void drawGraveyard(Graphics g){
		for(int i = 0; i < game.getGraveyard().size();i++){
			g.drawImage(game.getGraveyard().get(i).enemyImage,game.getGraveyard().get(i).getLocX(),game.getGraveyard().get(i).getLocY(),this);
			repaint();
		}
	}
	//
	private void drawProjectiles(Graphics g)
	{
		for(int i=0; i<game.getTowerManager().towerCount; i++)
		{
			for(int j = 0; j < game.getTowerManager().towerList.get(i).getProjectileCount(); j++)
			{
				if(game.getTowerManager().towerList.get(i).getProjectilesSpawned().get(j).getLocY() < 580
						&& game.getTowerManager().towerList.get(i).getProjectilesSpawned().get(j) != null)
				{ 
					if(game.getTowerManager().towerList.get(i).getProjectilesSpawned().get(j).isAlive == false)
						game.getTowerManager().towerList.get(i).getProjectilesSpawned().remove(j);
					else
					{
						g.drawImage(game.getTowerManager().towerList.get(i).getProjectilesSpawned().get(j).projectileImage,
								game.getTowerManager().towerList.get(i).getProjectilesSpawned().get(j).getLocX(),
								game.getTowerManager().towerList.get(i).getProjectilesSpawned().get(j).getLocY(),
								this);
								repaint();
					}	
				}
			}	
		}
	}
	private void drawLayoutElements(Graphics g){
		
		if(game.getIsGameWon()){
			g.drawImage(gameWonImage,300,300,this);
		}
		if(game.getIsGameLost()){
			g.drawImage(gameLostImage,300,300,this);
		}
		
		g.drawImage(layoutBackground,0,736,this);		
		g.drawImage(timeImage,170,743,this);
		g.drawString(game.getTime(),202,758);
		g.drawImage(resourceImage,312,743,this);
		g.drawString(game.getPlayerGold()+"",342,758);
		g.drawImage(waveImage,452,743,this);
		g.drawString((game.getEnemyManager().getWaveNo() + 1) + "" +"/15" ,484,758); // will be updated
		g.drawImage(lifeImage,594,743,this);
		g.drawString(game.getRemainingChances()+"/10",626,758);
		repaint();
		backBut.repaint(); // bugged idk why
		
		
	}
//BACK BUTTON
    private void backButActionPerformed(java.awt.event.ActionEvent evt) {                                        
    	this.hide();
    	GameFrame settingsTriggered = new GameFrame(new MainMenuPanel());
    }  
}