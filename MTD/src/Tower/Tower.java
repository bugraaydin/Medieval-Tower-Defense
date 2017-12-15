package Tower;

import java.util.ArrayList;

import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Enemy.*;
import classes.GameObject;
import classes.Projectile;

public class Tower extends GameObject{
	
	private Enemy target;
	private ArrayList<Projectile> projectilesSpawned;
	private String towerImageFile;
	private Timer myTimer;
	
	private boolean hasTarget;
	private int locX;
	private int locY;
	private int towerRange;
	private int cost;
	private int attackSpeed; 
	private double dmg;
	//Constructor
	public Tower()
	{
		cost = 100;
		projectilesSpawned  = new ArrayList<Projectile>();
	}

	/**
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
	*/
	
	public void setTarget(Enemy target){
		//double distance = Math.sqrt(Math.pow(Math.abs(target.locX-this.locX), 2) 
		//		+ Math.pow(Math.abs(target.locY-this.locY), 2));
		//if(distance < this.towerRange && hasTarget==false)
		//{	
			this.target = target;
			hasTarget = true;
			activateTower();
		//}
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
					if(target.isAlive==true)
						spawnProjectile(target);
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
		Projectile spawnedProjectile = new Projectile(locX,locY,target,dmg);
		projectilesSpawned.add(spawnedProjectile);
	}
	public void upgradeTower(){
		setDamage(dmg+10);
		setAttackSpeed(attackSpeed+1);
		setTowerRange(towerRange+1);
	}
	
	//Setters
	public void setImage(String input){
		towerImageFile = input;
	}
	public void setDamage(double d){
		this.dmg = d;
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
	public double getDamage(){return dmg;}
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