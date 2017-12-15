package Enemy;

public class Peasant extends Enemy{

	

	public Peasant(int locX, int locY){
		
		super(locX,locY);
		
		setSpeed(10);

		setArmor(10);

		setHealth(50);

		setDebuffDPS(0);

		setResourceGiven(100);
		//moving down images
		enemyImageBuffer[0] = ("/images/enemies/peasant/peasant_down/peasant_down0.png");
		enemyImageBuffer[1] = ("/images/enemies/peasant/peasant_down/peasant_down1.png");
		enemyImageBuffer[2] = ("/images/enemies/peasant/peasant_down/peasant_down2.png");
		enemyImageBuffer[3] = ("/images/enemies/peasant/peasant_down/peasant_down3.png");
		enemyImageBuffer[4] = ("/images/enemies/peasant/peasant_down/peasant_down4.png");
		//moving right images
		enemyImageBuffer[5] = ("/images/enemies/peasant/peasant_right/peasant_right0.png");
		enemyImageBuffer[6] = ("/images/enemies/peasant/peasant_right/peasant_right1.png");
		enemyImageBuffer[7] = ("/images/enemies/peasant/peasant_right/peasant_right2.png");
		enemyImageBuffer[8] = ("/images/enemies/peasant/peasant_right/peasant_right3.png");
		enemyImageBuffer[9] = ("/images/enemies/peasant/peasant_right/peasant_right4.png");
		//moving up images
		enemyImageBuffer[10] = ("/images/enemies/peasant/peasant_up/peasant_up0.png");
		enemyImageBuffer[11] = ("/images/enemies/peasant/peasant_up/peasant_up1.png");
		enemyImageBuffer[12] = ("/images/enemies/peasant/peasant_up/peasant_up2.png");
		enemyImageBuffer[13] = ("/images/enemies/peasant/peasant_up/peasant_up3.png");
		enemyImageBuffer[14] = ("/images/enemies/peasant/peasant_up/peasant_up4.png");
		//die animation
		enemyImageBuffer[15] = ("/images/enemies/peasant/peasant_die/peasant_die0.png");
		enemyImageBuffer[16] = ("/images/enemies/peasant/peasant_die/peasant_die1.png");
		enemyImageBuffer[17] = ("/images/enemies/peasant/peasant_die/peasant_die2.png");

		setEnemyImage(0);
	}



}
