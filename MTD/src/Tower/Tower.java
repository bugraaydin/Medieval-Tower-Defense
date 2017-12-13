package Tower;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;
import Enemy.*;
import classes.GameObject;
import classes.Projectile;

public class Tower extends GameObject{
	
	private Enemy target;
	private ArrayList<Projectile> projectilesSpawned;
	private String towerImageFile;
	private boolean hasTarget;
	private Timer myTimer;
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
	//Setting an enemy as target
	public void setTarget(Enemy target){
		double distance = Math.hypot(target.locX-locX, target.locY-locY);
		if(distance < this.towerRange && hasTarget==false && target.isAlive == true)
		{				
			this.target = target;
			hasTarget = true;
			activateTower();
		}
		else if(target.isAlive == false || distance < this.towerRange){			
			hasTarget = false;
			this.target = null;
			clearTarget();
		}
	}
	
	public void clearTarget()
	{
		hasTarget=false;
		deactivateTower();
	}
	
	//Activating the listener
	public void activateTower()
	{
		int delay = 250;//(1/attackSpeed)*500; // ~10 updates per second

		ActionListener taskPerformer = new ActionListener(){

			public void actionPerformed(ActionEvent e){
				if(target.isAlive && target != null) {
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
			Projectile spawnedProjectile = new Projectile(locX,locY,target);
			projectilesSpawned.add(spawnedProjectile);
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
	public void setHasTarget(boolean has_target){
		hasTarget = has_target;
	}
	//Getters
	public ArrayList<Projectile> getProjectilesSpawned(){ return projectilesSpawned;}
	public int getProjectileCount(){ return projectilesSpawned.size();}
	public boolean hasTarget(){ return hasTarget;}
	public String getImage(){ return towerImageFile;}
	public int getDamage(){return dmg;}
	public int getLocX(){ return locX;}
	public Enemy getEnemy(){ return target;}
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