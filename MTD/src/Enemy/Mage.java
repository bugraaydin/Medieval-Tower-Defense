package Enemy;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Mage extends Enemy{

	

	public Mage(int locX, int locY){

		super(locX,locY);
		
		setSpeed(5);

		setArmor(10);

		setHealth(500);
		setMaxHealth(500);
		setResourceGiven(100);

		setDebuffDPS(0);

		setResourceGiven(100);
		//moving down images
		enemyImageBuffer[0] = ("/images/enemies/mage/mage_down/mage_down0.png");
		enemyImageBuffer[1] = ("/images/enemies/mage/mage_down/mage_down1.png");
		enemyImageBuffer[2] = ("/images/enemies/mage/mage_down/mage_down2.png");
		enemyImageBuffer[3] = ("/images/enemies/mage/mage_down/mage_down3.png");
		enemyImageBuffer[4] = ("/images/enemies/mage/mage_down/mage_down1.png");
		//moving right images
		enemyImageBuffer[5] = ("/images/enemies/mage/mage_right/mage_right0.png");
		enemyImageBuffer[6] = ("/images/enemies/mage/mage_right/mage_right1.png");
		enemyImageBuffer[7] = ("/images/enemies/mage/mage_right/mage_right2.png");
		enemyImageBuffer[8] = ("/images/enemies/mage/mage_right/mage_right3.png");
		enemyImageBuffer[9] = ("/images/enemies/mage/mage_right/mage_right4.png");
		//moving up images
		enemyImageBuffer[10] = ("/images/enemies/mage/mage_up/mage_up0.png");
		enemyImageBuffer[11] = ("/images/enemies/mage/mage_up/mage_up1.png");
		enemyImageBuffer[12] = ("/images/enemies/mage/mage_up/mage_up2.png");
		enemyImageBuffer[13] = ("/images/enemies/mage/mage_up/mage_up3.png");
		enemyImageBuffer[14] = ("/images/enemies/mage/mage_up/mage_up1.png");
		//die animation
		enemyImageBuffer[15] = ("/images/enemies/mage/mage_die/mage_die0.png");
		enemyImageBuffer[16] = ("/images/enemies/mage/mage_die/mage_die1.png");
		enemyImageBuffer[17] = ("/images/enemies/mage/mage_die/mage_die2.png");

		setEnemyImage(0);
	}
	public void playEnemyDie(){
		try {
			dieBuffer = getClass().getResourceAsStream("/sounds/die/mage_die.wav");
			dieSound = new AudioStream(dieBuffer);
			AudioPlayer.player.start(dieSound);
		}	catch(Exception exc) {
				exc.printStackTrace();
		}
	}

}
