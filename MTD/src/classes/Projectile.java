package classes;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import Enemy.*;


public class Projectile {
	private String projectileImageBuffer;
	public BufferedImage projectileImage;
	private int locX;
	private int locY;
	private double timeTillHit;
	private int damage;
	private int damageType;
	private int slowRate;
	private int armorReduce;
	private int damagePerSec;
	private Enemy target;
	private int speed;
	private int targetLocX;
	private int targetLocY;
	public boolean isAlive = true;
	private int onHitEffectFramerate;
	private int projectileFramerate;//NOT USED YET, ONLY USED IF PROJECTILE ITSELF IS AN ANIMATION, NOT THE ON HIT EFFECT
	
	public Projectile(int x, int y, Enemy target, int damage, int projectileType){
		
		setProjectileProperties(projectileType);
		
		timeTillHit = 20;
		this.damage = damage;
		slowRate = 0;
		armorReduce = 0;
		damagePerSec = 0;
		speed = 10;
		projectileImageBuffer = "/images/projectiles/ex0.png";
		this.locX = x;
		this.locY = y;
		this.target = target;
		
		try {
			projectileImage = ImageIO.read(getClass().getResourceAsStream(projectileImageBuffer));
		}	catch(IOException exc) {
				exc.printStackTrace();
		}
		
		targetLocX = target.locX;
		targetLocY =  target.locY;
	}
	
	
	public void dealDamage(){
		target.onDamageTaken(damage, onHitEffectFramerate);
	}
	
	public void setProjectileProperties(int projectileType)
	{
		if(projectileType==0)
		{
			setOnHitEffectFramerate(89);
		}
		else if(projectileType==1)
		{
			//setOnHitEffectFramerate();
			//SET SECOND PROJECTILE TYPE FRAMERATE
		}
	}
	
	public void setProjectileFramerate(int projectileFramerate)
	{
		this.projectileFramerate = projectileFramerate;
	}
	
	public void setOnHitEffectFramerate(int onHitEffectFramerate)
	{
		this.onHitEffectFramerate = onHitEffectFramerate;
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
	public int getOnHitEffectFramerate()
	{
		return onHitEffectFramerate;
	}
}