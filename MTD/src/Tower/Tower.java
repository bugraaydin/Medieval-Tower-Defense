package Tower;

import java.util.ArrayList;
import Enemy.*;
import classes.GameObject;
import classes.Projectile;

public class Tower extends GameObject{
	
	private Enemy target;
	private ArrayList<Projectile> projectilesSpawned;
	private String towerImageFile;
	private boolean hasTarget;
	private int locX;
	private int locY;
	private int towerRange;
	private int cost;
	private int attackSpeed; 
	private int dmg;
	//Constructor
	public Tower()
	{
		projectilesSpawned  = new ArrayList<Projectile>();
	}

	
	public void setTarget(Enemy target){
		if(target == null){
			hasTarget = false;
			return;
		}
		double distance = Math.sqrt(Math.pow(Math.abs(target.locX-this.towerRange), 2) 
				+ Math.pow(Math.abs(target.locX-this.towerRange), 2));
		if(distance < this.towerRange && hasTarget==false)
		{	
			this.target = target;
			hasTarget = true;
		}
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