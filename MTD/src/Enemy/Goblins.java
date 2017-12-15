package Enemy;

public class Goblins extends Enemy{

	

	public Goblins(int locX, int locY){
		
		super(locX,locY);
		
		setSpeed(10);

		setArmor(10);

		setHealth(50);

		setDebuffDPS(0);

		setResourceGiven(100);
		//moving down images
		enemyImageBuffer[0] = ("/images/enemies/goblins/goblins_down/goblins_down0.png");
		enemyImageBuffer[1] = ("/images/enemies/goblins/goblins_down/goblins_down1.png");
		enemyImageBuffer[2] = ("/images/enemies/goblins/goblins_down/goblins_down2.png");
		enemyImageBuffer[3] = ("/images/enemies/goblins/goblins_down/goblins_down3.png");
		enemyImageBuffer[4] = ("/images/enemies/goblins/goblins_down/goblins_down4.png");
		//moving right images
		enemyImageBuffer[5] = ("/images/enemies/goblins/goblins_right/goblins_right0.png");
		enemyImageBuffer[6] = ("/images/enemies/goblins/goblins_right/goblins_right1.png");
		enemyImageBuffer[7] = ("/images/enemies/goblins/goblins_right/goblins_right2.png");
		enemyImageBuffer[8] = ("/images/enemies/goblins/goblins_right/goblins_right3.png");
		enemyImageBuffer[9] = ("/images/enemies/goblins/goblins_right/goblins_right4.png");
		//moving up images
		enemyImageBuffer[10] = ("/images/enemies/goblins/goblins_up/goblins_up0.png");
		enemyImageBuffer[11] = ("/images/enemies/goblins/goblins_up/goblins_up1.png");
		enemyImageBuffer[12] = ("/images/enemies/goblins/goblins_up/goblins_up2.png");
		enemyImageBuffer[13] = ("/images/enemies/goblins/goblins_up/goblins_up3.png");
		enemyImageBuffer[14] = ("/images/enemies/goblins/goblins_up/goblins_up4.png");
		//die animation
		enemyImageBuffer[15] = ("/images/enemies/goblins/goblins_die/goblins_die0.png");
		enemyImageBuffer[16] = ("/images/enemies/goblins/goblins_die/goblins_die1.png");
		enemyImageBuffer[17] = ("/images/enemies/goblins/goblins_die/goblins_die2.png");

		setEnemyImage(0);
	}



}
