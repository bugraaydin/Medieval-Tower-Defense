package Tower;
import Enemy.*;
import classes.Projectile;

public class Tower {
	private int x;
	private int y;
	private int attackPoint; // attackPoint / armor = damage
	private int attackType;  // 1 splash 0 single target
	private int attackFrequency; // 10 = 1 shot per second
	private int attackRange; // ??
	private int slowRate; // - movement speed of enemies
	private int armorReduce; // - armor of enemies
	private int damagePerSec;
	private int cost; // cost of the tower to build
	

	////////Setters
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	public void setAttackPoint(int attackPoint){
		this.attackPoint = attackPoint;
	}
	public void setAttackType(int attackType){
		this.attackType = attackType;
	}
	public void setAttackFrequency(int attackFrequency){
		this.attackFrequency = attackFrequency;
	}
	public void setAttackRange(int attackRange){
		this.attackRange = attackRange;
	}
	public void setSlowRate(int slowRate){
		this.slowRate = slowRate;
	}
	public void setArmorReduce(int armorReduce){
		this.armorReduce = armorReduce;
	}
	public void setDPS(int damagePerSec){
		this.damagePerSec = damagePerSec;
	}
	public void setCost(int cost){
		this.cost = cost;
	}
	////////////////Getters
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
	public int getAttackPoint(){
		return this.attackPoint;
	}
	public int getAttackType(){
		return this.attackType;
	}
	public int getAttackFrequency(){
		return this.attackFrequency;
	}
	public int getAttackRange(){
		return this.attackRange;
	}
	public int getSlowRate(){
		return this.slowRate;
	}
	public int getArmorReduce(){
		return this.armorReduce;
	}
	public int getDPS(){
		return this.damagePerSec;
	}
	public int getCost(){
		return this.cost;
	}
	////////////////////////////
	//detect enemy metodu lazým
	
	//projectile spawn method
	public Projectile spawnProjectile(Enemy foundTarget){
		
		Projectile projectile = new Projectile(this.getX(),this.getY(),this.getAttackPoint(),this.getAttackType(),this.getSlowRate(),this.getArmorReduce(),this.getDPS(),foundTarget);
		return projectile;
	}
}
