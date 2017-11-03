package Enemy;

public class Enemy {
	private int x; // if enemy is dead, x and y are both -100
	private int y;
	private int speed;  // current speed
	private int armor;  // current armor
	private int health;  // current hp
	private int debuffDPS; // from poison tower, taken per sec
	private int resourceGiven;
	//////////Setters
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	public void setSpeed(int speed){
		this.speed = speed;
	}
	public void setArmor(int armor){
		this.armor = armor;
	}
	public void setHealth(int health){
		this.health = health;
	}
	public void setDebuffDPS(int debuffDPS){
		this.debuffDPS = debuffDPS;
	}
	public void setResourceGiven(int resourceGiven){
		this.resourceGiven = resourceGiven;
	}
	//////////Getters
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
	public int getSpeed(){
		return this.speed;
	}
	public int getArmor(){
		return this.armor;
	}
	public int getHealth(){
		return this.health;
	}
	public int getDebuffDPS(){
		return this.debuffDPS;
	}
	public int getResourceGiven(){
		return this.resourceGiven;
	}
	////////////////////

	
}
