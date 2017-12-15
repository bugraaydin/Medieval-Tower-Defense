package Enemy;

public class Ogre extends Enemy{

	

	public Ogre(int locX, int locY){
		
		super(locX,locY);
		
		setSpeed(10);

		setArmor(10);

		setHealth(50);

		setDebuffDPS(0);

		setResourceGiven(100);
		//moving down images
		enemyImageBuffer[0] = ("/images/enemies/ogre/ogre_down/ogre_down0.png");
		enemyImageBuffer[1] = ("/images/enemies/ogre/ogre_down/ogre_down1.png");
		enemyImageBuffer[2] = ("/images/enemies/ogre/ogre_down/ogre_down2.png");
		enemyImageBuffer[3] = ("/images/enemies/ogre/ogre_down/ogre_down3.png");
		enemyImageBuffer[4] = ("/images/enemies/ogre/ogre_down/ogre_down4.png");
		//moving right images
		enemyImageBuffer[5] = ("/images/enemies/ogre/ogre_right/ogre_right0.png");
		enemyImageBuffer[6] = ("/images/enemies/ogre/ogre_right/ogre_right1.png");
		enemyImageBuffer[7] = ("/images/enemies/ogre/ogre_right/ogre_right2.png");
		enemyImageBuffer[8] = ("/images/enemies/ogre/ogre_right/ogre_right3.png");
		enemyImageBuffer[9] = ("/images/enemies/ogre/ogre_right/ogre_right4.png");
		//moving up images
		enemyImageBuffer[10] = ("/images/enemies/ogre/ogre_up/ogre_up0.png");
		enemyImageBuffer[11] = ("/images/enemies/ogre/ogre_up/ogre_up1.png");
		enemyImageBuffer[12] = ("/images/enemies/ogre/ogre_up/ogre_up2.png");
		enemyImageBuffer[13] = ("/images/enemies/ogre/ogre_up/ogre_up3.png");
		enemyImageBuffer[14] = ("/images/enemies/ogre/ogre_up/ogre_up4.png");
		//die animation
		enemyImageBuffer[15] = ("/images/enemies/ogre/ogre_die/ogre_die0.png");
		enemyImageBuffer[16] = ("/images/enemies/ogre/ogre_die/ogre_die1.png");
		enemyImageBuffer[17] = ("/images/enemies/ogre/ogre_die/ogre_die2.png");

		setEnemyImage(0);
	}



}
