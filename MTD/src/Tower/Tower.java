package Tower;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import Enemy.*;
import classes.Projectile;

public class Tower {
	
	public int towerRange = 125;
	public Enemy target;
	public Projectile[] projectilesSpawned;
	public int projectileCount = 0;
	public int locX;
	public int locY;
	public int cost;
	private int attackSpeed = 25;
	public String towerImageFile;
	private TowerType towerType;
	private int gold = 100;
	private int dmg = 100;
	public boolean hasTarget = false;
	
	
	//Constructor
	public Tower(TowerType towerType)
	{
		this.towerType = towerType;
		if(towerType==TowerType.Arrow)
		{
			towerImageFile = "/images/towers/tower1.png";
			dmg = 150;
		}
		if(towerType==TowerType.Cannon)
		{
			towerImageFile = "/images/towers/tower2.png";
			dmg = 200;
		}
		if(towerType==TowerType.Fire)
		{
			towerImageFile = "images/towers/tower3.png";
			dmg = 250;
		}
		
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
				//System.out.println("Moved");
			}

		};

		new Timer(delay,taskPerformer).start();
	}

	public void spawnProjectile(Enemy target){

		Projectile spawnedProjectile = new Projectile(locX,locY,target);
		
		projectilesSpawned[projectileCount] = spawnedProjectile;
		projectileCount++;

	}
}
