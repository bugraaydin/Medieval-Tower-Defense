package Enemy;

public class Grunt extends Enemy{

	

	public Grunt(int locX, int locY){

		super(locX,locY);
		
		setSpeed(10);

		setArmor(10);

		setHealth(50);

		setDebuffDPS(0);

		setResourceGiven(100);
		//moving down images
		enemyImageBuffer[0] = ("/images/enemies/grunt/grunt_down/grunt_down0.png");
		enemyImageBuffer[1] = ("/images/enemies/grunt/grunt_down/grunt_down1.png");
		enemyImageBuffer[2] = ("/images/enemies/grunt/grunt_down/grunt_down2.png");
		enemyImageBuffer[3] = ("/images/enemies/grunt/grunt_down/grunt_down3.png");
		enemyImageBuffer[4] = ("/images/enemies/grunt/grunt_down/grunt_down4.png");
		//moving right images
		enemyImageBuffer[5] = ("/images/enemies/grunt/grunt_right/grunt_right0.png");
		enemyImageBuffer[6] = ("/images/enemies/grunt/grunt_right/grunt_right1.png");
		enemyImageBuffer[7] = ("/images/enemies/grunt/grunt_right/grunt_right2.png");
		enemyImageBuffer[8] = ("/images/enemies/grunt/grunt_right/grunt_right3.png");
		enemyImageBuffer[9] = ("/images/enemies/grunt/grunt_right/grunt_right4.png");
		//moving up images
		enemyImageBuffer[10] = ("/images/enemies/grunt/grunt_up/grunt_up0.png");
		enemyImageBuffer[11] = ("/images/enemies/grunt/grunt_up/grunt_up1.png");
		enemyImageBuffer[12] = ("/images/enemies/grunt/grunt_up/grunt_up2.png");
		enemyImageBuffer[13] = ("/images/enemies/grunt/grunt_up/grunt_up3.png");
		enemyImageBuffer[14] = ("/images/enemies/grunt/grunt_up/grunt_up4.png");
		//die animation
		enemyImageBuffer[15] = ("/images/enemies/grunt/grunt_die/grunt_die0.png");
		enemyImageBuffer[16] = ("/images/enemies/grunt/grunt_die/grunt_die1.png");
		enemyImageBuffer[17] = ("/images/enemies/grunt/grunt_die/grunt_die2.png");

		setEnemyImage(0);
	}


}
