package classes;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import Enemy.*;


public class Projectile {
	private int locX;
	private int locY;
	private double timeTillHit;
	private int damage;
	private int damageType;
	private int slowRate;
	private int armorReduce;
	public BufferedImage projectileImage;
	public int projectileImageNumber;
	private int damagePerSec;
	private Enemy target;
	private int speed;
	private int targetLocX;
	private int targetLocY;
	public boolean isAlive = true;

	
	public Projectile(int x, int y, Enemy target, int damage){
		timeTillHit = 20;
		this.damage = damage;
		slowRate = 0;
		armorReduce = 0;
		damagePerSec = 0;
		speed = 10;
		this.locX = x;
		this.locY = y;
		this.target = target;
		
		targetLocX = target.locX;
		targetLocY =  target.locY;
	}
	
	
	public void dealDamage(){
		target.onDamageTaken(damage);
	}
	
	
	public void update(){
		if(target==null)
			return;
		targetLocX = target.locX;
		targetLocY =  target.locY;
		double dx = target.locX - this.locX;
		double dy = target.locY - this.locY;
		double dist = Math.sqrt(Math.pow(dx, 2)+Math.pow(dy, 2));
		dx = dx/dist;
		dy = dy/dist;
		if(Math.abs(targetLocX - this.getLocX()) < 15 && Math.abs(targetLocY - this.getLocY()) < 15 ) {
			collision();	
			dealDamage();
			isAlive = false;
			return;
		}
		else {
				locX = (int) (dx*timeTillHit + locX);
				locY = (int) (dy*timeTillHit + locY);
		}
	}

	public void collision(){
		//if x and y is equal to the enemy's x y // enemy's healt/armor etc is reduced
		//onHitDebuff();
	}

	public void onHitDebuff(){
		this.target.setSpeed(this.target.getSpeed() - this.slowRate); //updating target's speed
		this.target.setArmor(this.target.getArmor() - this.armorReduce); //updating target's armor
		this.target.setDebuffDPS(this.target.getDebuffDPS() + this.damagePerSec); // updating damage over time
		// damage koy
	}
	
	/////Getters
	public int getLocX(){
		return this.locX;
	}
	public int getLocY(){
		return this.locY;
	}
	public int getDamage(){
		return this.damage;
	}
	public int getDamageType(){
		return this.damageType;
	}
	public int getSlowRate(){
		return this.slowRate;
	}
	public int getArmorReduce(){
		return this.armorReduce;
	}
	public int getDamagePerSec(){
		return this.damagePerSec;
	}
	public Enemy getTarget(){
		return this.target;
	}
}