package Enemy;

public class Dragon extends Enemy{

	

	public Dragon(int locX, int locY){
		
		super(locX,locY);
		
		setSpeed(4);

		setArmor(1);

		setHealth(1000);

		setDebuffDPS(0);

		setResourceGiven(100);
		//moving down images
		enemyImageBuffer[0] = ("/images/enemies/dragon/dragon_down/dragon_down0.png");
		enemyImageBuffer[1] = ("/images/enemies/dragon/dragon_down/dragon_down1.png");
		enemyImageBuffer[2] = ("/images/enemies/dragon/dragon_down/dragon_down2.png");
		enemyImageBuffer[3] = ("/images/enemies/dragon/dragon_down/dragon_down3.png");
		enemyImageBuffer[4] = ("/images/enemies/dragon/dragon_down/dragon_down4.png");
		//moving right images
		enemyImageBuffer[5] = ("/images/enemies/dragon/dragon_right/dragon_right0.png");
		enemyImageBuffer[6] = ("/images/enemies/dragon/dragon_right/dragon_right1.png");
		enemyImageBuffer[7] = ("/images/enemies/dragon/dragon_right/dragon_right2.png");
		enemyImageBuffer[8] = ("/images/enemies/dragon/dragon_right/dragon_right3.png");
		enemyImageBuffer[9] = ("/images/enemies/dragon/dragon_right/dragon_right4.png");
		//moving up images
		enemyImageBuffer[10] = ("/images/enemies/dragon/dragon_up/dragon_up0.png");
		enemyImageBuffer[11] = ("/images/enemies/dragon/dragon_up/dragon_up1.png");
		enemyImageBuffer[12] = ("/images/enemies/dragon/dragon_up/dragon_up2.png");
		enemyImageBuffer[13] = ("/images/enemies/dragon/dragon_up/dragon_up3.png");
		enemyImageBuffer[14] = ("/images/enemies/dragon/dragon_up/dragon_up4.png");
		//die animation
		enemyImageBuffer[15] = ("/images/enemies/dragon/dragon_die/dragon_die0.png");
		enemyImageBuffer[16] = ("/images/enemies/dragon/dragon_die/dragon_die1.png");
		enemyImageBuffer[17] = ("/images/enemies/dragon/dragon_die/dragon_die2.png");

		setEnemyImage(0);
	}



}
