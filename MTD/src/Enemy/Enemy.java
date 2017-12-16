package Enemy;

import java.io.InputStream;
import sun.audio.AudioStream;
import java.io.IOException;
import java.awt.image.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;



public class Enemy {
	
	private ImageIcon impactImageIcon;
	public int targetCount = 0;
	public int locX; 
	public int locY;
	private int speed;
	private int[] velocity = new int[2];
	private int armor;  // current armor
	private int health;  // current hp
	private int debuffDPS; // from poison tower, taken per sec
	private int resourceGiven;
	private boolean isGettingHit = false;
	private int maxHealth;
	public InputStream dieBuffer;
	public AudioStream dieSound;
	
	private int enemyImageNumber;
	public BufferedImage enemyImage;
	public String[] enemyImageBuffer;
	
	public BufferedImage enemyHealth;
	
	public boolean isAlive = true;
	
	public Enemy(int locX, int locY)
	{
		maxHealth = 100;
		this.locX = locX;
		this.locY = locY;
		velocity[0] = 0;
		velocity[1] = 0;
		enemyImageBuffer = new String[18];
		resourceGiven = 100;
	}
	public void playEnemyDie(){
	}
	
	//////////Setters
	public void setEnemyHB(double i)
	{
		if(i >= 1.00){
			try {
				enemyHealth = ImageIO.read(getClass().getResourceAsStream("/images/healthbar/hb100.png"));
			}	catch(IOException exc) {
					exc.printStackTrace();
			}
		}
		if(i > 0.8 && i <= 0.9){
			try {
				enemyHealth = ImageIO.read(getClass().getResourceAsStream("/images/healthbar/hb90.png"));
			}	catch(IOException exc) {
					exc.printStackTrace();
			}
		}
		if(i > 0.7 && i <= 0.8){
			try {
				enemyHealth = ImageIO.read(getClass().getResourceAsStream("/images/healthbar/hb80.png"));
			}	catch(IOException exc) {
					exc.printStackTrace();
			}
		}
		if(i > 0.6 && i <= 0.7){
			try {
				enemyHealth = ImageIO.read(getClass().getResourceAsStream("/images/healthbar/hb70.png"));
			}	catch(IOException exc) {
					exc.printStackTrace();
			}
		}
		if(i > 0.5 && i <= 0.6){
			try {
				enemyHealth = ImageIO.read(getClass().getResourceAsStream("/images/healthbar/hb60.png"));
			}	catch(IOException exc) {
					exc.printStackTrace();
			}
		}
		if(i > 0.4 && i <= 0.5){
			try {
				enemyHealth = ImageIO.read(getClass().getResourceAsStream("/images/healthbar/hb50.png"));
			}	catch(IOException exc) {
					exc.printStackTrace();
			}
		}
		if(i > 0.3 && i <= 0.4){
			try {
				enemyHealth = ImageIO.read(getClass().getResourceAsStream("/images/healthbar/hb40.png"));
			}	catch(IOException exc) {
					exc.printStackTrace();
			}
		}
		if(i > 0.2 && i <= 0.3){
			try {
				enemyHealth = ImageIO.read(getClass().getResourceAsStream("/images/healthbar/hb30.png"));
			}	catch(IOException exc) {
					exc.printStackTrace();
			}
		}
		if(i > 0.1 && i <= 0.2){
			try {
				enemyHealth = ImageIO.read(getClass().getResourceAsStream("/images/healthbar/hb20.png"));
			}	catch(IOException exc) {
					exc.printStackTrace();
			}
		}
		if(i > 0.0 && i <= 0.1){
			try {
				enemyHealth = ImageIO.read(getClass().getResourceAsStream("/images/healthbar/hb10.png"));
			}	catch(IOException exc) {
					exc.printStackTrace();
			}
		}
		if(i <= 0.0){
			try {
				enemyHealth = ImageIO.read(getClass().getResourceAsStream("/images/healthbar/hb0.png"));
			}	catch(IOException exc) {
					exc.printStackTrace();
			}
		}
	}
	
	
	public void onDamageTaken(int dmg)
	{
		if(!isAlive)
			return;
		health = health - dmg;
		isGettingHit=true;
		if(health<1)
		{
			isAlive = false;
		}

	}
		
	
	public void move(int velocityX, int velocityY)
	{
		locX = locX + velocityX;
		locY = locY + velocityY;

	}
	
	//////////Setters
	public void setEnemyImage(int i)
	{
			try {
				enemyImage = ImageIO.read(getClass().getResourceAsStream(enemyImageBuffer[i]));
				enemyImageNumber = i;
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
	public void setVelocity(int i,int j){
		velocity[0] = i;
		velocity[1] = j;
	}
	public void setMaxHealth(int i){
		maxHealth = i;
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
	public int getMaxHealth(){
		return this.maxHealth;
	}
	
	public ImageIcon getImpactImageIcon()
	{
		return impactImageIcon;
	}
	
	public boolean isGettingHit()
	{
		return isGettingHit;
	}
	public int[] getVelocity(){
		return velocity;
	}
	public int getEnemyImageNumber(){
		return enemyImageNumber;
	}
	public int getResource(){
		return resourceGiven;
	}
	////////////////////



	

}