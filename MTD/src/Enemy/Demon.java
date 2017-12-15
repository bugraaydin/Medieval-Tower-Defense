package Enemy;

public class Demon extends Enemy{

	

	public Demon(int locX, int locY){
		
		super(locX,locY);
		
		setSpeed(10);

		setArmor(10);

		setHealth(50);

		setDebuffDPS(0);

		setResourceGiven(100);
		//moving down images
		enemyImageBuffer[0] = ("/images/enemies/demon/demon_down/demon_down0.png");
		enemyImageBuffer[1] = ("/images/enemies/demon/demon_down/demon_down1.png");
		enemyImageBuffer[2] = ("/images/enemies/demon/demon_down/demon_down2.png");
		enemyImageBuffer[3] = ("/images/enemies/demon/demon_down/demon_down3.png");
		enemyImageBuffer[4] = ("/images/enemies/demon/demon_down/demon_down4.png");
		//moving right images
		enemyImageBuffer[5] = ("/images/enemies/demon/demon_right/demon_right0.png");
		enemyImageBuffer[6] = ("/images/enemies/demon/demon_right/demon_right1.png");
		enemyImageBuffer[7] = ("/images/enemies/demon/demon_right/demon_right2.png");
		enemyImageBuffer[8] = ("/images/enemies/demon/demon_right/demon_right3.png");
		enemyImageBuffer[9] = ("/images/enemies/demon/demon_right/demon_right4.png");
		//moving up images
		enemyImageBuffer[10] = ("/images/enemies/demon/demon_up/demon_up0.png");
		enemyImageBuffer[11] = ("/images/enemies/demon/demon_up/demon_up1.png");
		enemyImageBuffer[12] = ("/images/enemies/demon/demon_up/demon_up2.png");
		enemyImageBuffer[13] = ("/images/enemies/demon/demon_up/demon_up3.png");
		enemyImageBuffer[14] = ("/images/enemies/demon/demon_up/demon_up4.png");
		//die animation
		enemyImageBuffer[15] = ("/images/enemies/demon/demon_die/demon_die0.png");
		enemyImageBuffer[16] = ("/images/enemies/demon/demon_die/demon_die1.png");
		enemyImageBuffer[17] = ("/images/enemies/demon/demon_die/demon_die2.png");

		setEnemyImage(0);
	}



}
