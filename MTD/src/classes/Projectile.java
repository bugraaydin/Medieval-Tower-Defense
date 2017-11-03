package classes;
import Enemy.*;

public class Projectile {
	private int x;
	private int y;
	private int damage;
	private int damageType;
	private int slowRate;
	private int armorReduce;
	private int damagePerSec;
	private Enemy target;
	// private onhit effect2d :: 2d image
	// projectile animation :: 2dimage sequence
	// projectile brigtness : float
	//projectile sound effect :: sound2d
	
	public Projectile(int x,int y,int damage,int damageType,int slowRate,int armorReduce,int damagePerSec,Enemy target){
		this.x = x;
		this.y = y;
		this.damage = damage;
		this.damageType = damageType;
		this.slowRate = slowRate;
		this.armorReduce = armorReduce;
		this.damagePerSec = damagePerSec;
		this.target = target;
	}
	/////Getters
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
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
	
	public void update(){
		// update x and y to the target's x y
		if(target.getX() == this.getX() && target.getY() == this.getY())
			collision();
	}
	public void collision(){
		//if x and y is equal to the enemy's x y // enemy's healt/armor etc is reduced
		onHitDebuff();
	}
	public void onHitDebuff(){
		this.target.setSpeed(this.target.getSpeed() - this.slowRate); //updating target's speed
		this.target.setArmor(this.target.getArmor() - this.armorReduce); //updating target's armor
		this.target.setDebuffDPS(this.target.getDebuffDPS() + this.damagePerSec); // updating damage over time
		// damage koy
	}
}
