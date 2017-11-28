package Enemy;


import java.awt.image.*;
import java.io.IOException;


import javax.imageio.ImageIO;

public class Enemy {
	
	private boolean b = true;
	
	int second = 0;

	int frames = 0;
	
	public int targetCount = 0;

	public int locX = 300; // if enemy is dead, x and y are both -100

	public int locY = 300;
	
	private int targetLocX;
	private int targetLocY;

	private int speed = 10;  // current speed

	private int armor;  // current armor

	private int health;  // current hp

	private int debuffDPS; // from poison tower, taken per sec

	private int resourceGiven;
	
	private double spawnTime; //will be moved to wave class later

	public BufferedImage enemyImage;
	
	public String enemyImageBuffer;
	
	public boolean isAlive = true;
	
	public Enemy(int locX, int locY)
	{
		this.locX = locX;
		this.locY = locY;
		this.spawnTime = 0;
	}
	
	public void takeDamage(int dmg)
	{
		health = health - dmg;
		if(health<1)
			isAlive = false;
	}
		
	
	public void move(int[] targetsX, int[] targetsY)
	{
		
		if(b)
		{
			targetLocX = targetsX[targetCount]-locX;
			targetLocY = targetsY[targetCount]-locY;
			b= false;
		}
////////////////////////////////////////////////////
		locX = locX+ (targetLocX/50) * 2;
		locY = locY+ (targetLocY/50) * 2;
		//System.out.println(locX);
		if(Math.abs(locX - targetsX[targetCount]) < 30 && Math.abs(targetsY[targetCount] - locY) < 30)
		{
			if(targetCount +1< targetsX.length)
			{
				targetCount++;
				System.out.println("TARGET COUNT ++++++++");
				b=true;
			}

		}
	}
	//////////Setters
	
	public void setEnemyImage(String s)
	{
		enemyImageBuffer = s;
		try {
			enemyImage = ImageIO.read(getClass().getResourceAsStream(s));
		}	catch(IOException exc) {
				exc.printStackTrace();
		}
		
	}

	public void setX(int x){

		this.locX = x;

	}

	public void setY(int y){

		this.locY = y;

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

	public int getLocX(){

		return this.locX;

	}

	public int getLocY(){

		return this.locY;

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

	public double getSpawnTime() {
		return spawnTime;
	}

	public void setSpawnTime(double spawnTime) {
		this.spawnTime = spawnTime;
	}

	////////////////////



	

}