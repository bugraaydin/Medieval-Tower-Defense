package Tower;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import Enemy.*;
import classes.Projectile;

public class Tower {
	
	private Enemy target;
	private Projectile[] projectilesSpawned;
	private int projectileCount; //= 0;
	private String towerImageFile;
	private boolean hasTarget;// = false;
	
	private int locX;
	private int locY;
	private int towerRange;
	private int cost;
	private int attackSpeed; 
	private int dmg;
	

	
	//Constructor
	public Tower()
	{
		projectilesSpawned = new Projectile[50];	
	}
	//Setting an enemy as target
	public void setTarget(Enemy target)
	{
		this.target = target;
		hasTarget = true;
		activateTower();
	}
	
	//Activating the listener
	public void activateTower()
	{
		int delay = 500;//(1/attackSpeed)*500; // ~10 updates per second

		ActionListener taskPerformer = new ActionListener(){

			public void actionPerformed(ActionEvent e){
				spawnProjectile(target);
			}
		};
		new Timer(delay,taskPerformer).start();
	}

	public void spawnProjectile(Enemy target){

		Projectile spawnedProjectile = new Projectile(this.locX,this.locY,target);
		
		projectilesSpawned[projectileCount] = spawnedProjectile;
		projectileCount++;

	}
	
	///////////////////////////////////////////////////////
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
	//Getters
	public Projectile[] getProjectilesSpawned(){ return projectilesSpawned;}
	public int getProjectileCount(){ return projectileCount;}
	public boolean hasTarget(){ return hasTarget;}
	public String getImage(){ return towerImageFile;}
	public int getDamage(){return dmg;}
	public int getLocX(){ return locX;}
	public int getLocY(){ return locY;}
	public int getTowerRange(){ return towerRange;}
	public int getCost(){ return cost;}
	public int getAttackSpeed(){ return attackSpeed;}
	///////////////////////////////////////////////////////
}
