package Tower;

import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import sun.audio.AudioStream;

import Enemy.*;
import classes.GameObject;
import classes.Projectile;

public class Tower extends GameObject{
	
	private Enemy target;
	private ArrayList<Projectile> projectilesSpawned;
	private String towerImageFile;
	private Timer myTimer;
	protected String[] projectilesImageBuffer;
	private boolean hasTarget;
	private int locX;
	private int locY;
	private int towerRange;
	private int cost;
	private int attackSpeed; 
	private int dmg;
	private int projectileType;
	
	public InputStream shootBuffer;
	public AudioStream shootSound;
	//Constructor
	public Tower()
	{
		projectileType=0;
		projectilesImageBuffer = new String[4]; //0 down //1 up //2 right //3 left
		cost = 100;
		projectilesSpawned  = new ArrayList<Projectile>();
	}
	
	public void playTowerShoot(){
	}

	public void setTarget(Enemy target){
		this.target = target;
		hasTarget = true;
		activateTower();
	}
	
	public void clearTarget()
	{
		hasTarget=false;
		deactivateTower();
	}
	
	//Activating the listener
	public void activateTower()
	{
		int delay = 750;//(1/attackSpeed)*500; // ~10 updates per second

		ActionListener taskPerformer = new ActionListener(){

			public void actionPerformed(ActionEvent e){
				if(target!=null)
					if(target.isAlive==true){
						spawnProjectile(target);
					}
			}
		};
		myTimer = new Timer(delay,taskPerformer);
		myTimer.start();
		//new Timer(delay,taskPerformer).start();
	}
	
	public void deactivateTower()
	{
		myTimer.stop();
	}

	public void spawnProjectile(Enemy target){
		Projectile spawnedProjectile = new Projectile(locX,locY,target,dmg,projectileType);
		if(target.locY >= locY){
			try {
				spawnedProjectile.projectileImage = ImageIO.read(getClass().getResourceAsStream(projectilesImageBuffer[0]));
				spawnedProjectile.projectileImageNumber = 0;
			}	catch(IOException exc) {
					exc.printStackTrace();
			}
		}
		else if(Math.abs(target.locY - locY) < 40 && target.locX > locX){
			try {
				spawnedProjectile.projectileImage = ImageIO.read(getClass().getResourceAsStream(projectilesImageBuffer[2]));
				spawnedProjectile.projectileImageNumber = 2;
			}	catch(IOException exc) {
					exc.printStackTrace();
			}
		}
		else if(Math.abs(target.locY - locY) < 40 && target.locX < locX){
			try {
				spawnedProjectile.projectileImage = ImageIO.read(getClass().getResourceAsStream(projectilesImageBuffer[3]));
				spawnedProjectile.projectileImageNumber = 3;
			}	catch(IOException exc) {
					exc.printStackTrace();
			}
		}
		else{
			try {
				spawnedProjectile.projectileImage = ImageIO.read(getClass().getResourceAsStream(projectilesImageBuffer[1]));
				spawnedProjectile.projectileImageNumber = 1;
			}	catch(IOException exc) {
					exc.printStackTrace();
			}
		}
		playTowerShoot();
		projectilesSpawned.add(spawnedProjectile);
	}
	public void upgradeTower(){
		setDamage(dmg+50);
		setAttackSpeed(attackSpeed+1);
		setTowerRange(towerRange+1);
	}
	
	//Setters
	public void setImage(String input){
		towerImageFile = input;
	}
	public void setDamage(int dmg){
		this.dmg = dmg;
	}
	public void setLocX(int x){
		locX = x;
	}
	public void setLocY(int y){
		locY = y;
	}
	public void setTowerRange(int range){
		towerRange = range;
	}
	public void setCost(int cost){
		this.cost = cost;
	}
	public void setAttackSpeed(int speed){
		attackSpeed = speed;
	}
	public void setHasTarget(boolean hasTarget){
		this.hasTarget = hasTarget;
	}
	public void setProjectileType(int projectileType)
	{
		this.projectileType = projectileType;
	}
	//Getters
	public ArrayList<Projectile> getProjectilesSpawned(){ return projectilesSpawned;}
	public int getProjectileCount(){ return projectilesSpawned.size();}
	public boolean hasTarget(){ return hasTarget;}
	public String getImage(){ return towerImageFile;}
	public int getDamage(){return dmg;}
	public int getLocX(){ return locX;}
	public Enemy getTarget(){ return target;}
	public int getLocY(){ return locY;}
	public int getTowerRange(){ return towerRange;}
	public int getCost(){ return cost;}
	public int getAttackSpeed(){ return attackSpeed;}
	
	///////////////////////////////////////////////////////
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
}