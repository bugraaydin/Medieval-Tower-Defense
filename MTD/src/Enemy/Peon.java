package Enemy;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Peon extends Enemy{

	

	public Peon(int locX, int locY){
		
		super(locX,locY);
		
		setSpeed(5);

		setArmor(10);

		setHealth(100);
		setMaxHealth(100);
		setResourceGiven(20);

		setDebuffDPS(0);

		setResourceGiven(100);
		//moving down images
		enemyImageBuffer[0] = ("/images/enemies/peon/peon_down/peon_down0.png");
		enemyImageBuffer[1] = ("/images/enemies/peon/peon_down/peon_down1.png");
		enemyImageBuffer[2] = ("/images/enemies/peon/peon_down/peon_down2.png");
		enemyImageBuffer[3] = ("/images/enemies/peon/peon_down/peon_down3.png");
		enemyImageBuffer[4] = ("/images/enemies/peon/peon_down/peon_down4.png");
		//moving right images
		enemyImageBuffer[5] = ("/images/enemies/peon/peon_right/peon_right0.png");
		enemyImageBuffer[6] = ("/images/enemies/peon/peon_right/peon_right1.png");
		enemyImageBuffer[7] = ("/images/enemies/peon/peon_right/peon_right2.png");
		enemyImageBuffer[8] = ("/images/enemies/peon/peon_right/peon_right3.png");
		enemyImageBuffer[9] = ("/images/enemies/peon/peon_right/peon_right4.png");
		//moving up images
		enemyImageBuffer[10] = ("/images/enemies/peon/peon_up/peon_up0.png");
		enemyImageBuffer[11] = ("/images/enemies/peon/peon_up/peon_up1.png");
		enemyImageBuffer[12] = ("/images/enemies/peon/peon_up/peon_up2.png");
		enemyImageBuffer[13] = ("/images/enemies/peon/peon_up/peon_up3.png");
		enemyImageBuffer[14] = ("/images/enemies/peon/peon_up/peon_up4.png");
		//die animation
		enemyImageBuffer[15] = ("/images/enemies/peon/peon_die/peon_die0.png");
		enemyImageBuffer[16] = ("/images/enemies/peon/peon_die/peon_die1.png");
		enemyImageBuffer[17] = ("/images/enemies/peon/peon_die/peon_die2.png");

		setEnemyImage(0);
	}
	public void playEnemyDie(){
		try {
			dieBuffer = getClass().getResourceAsStream("/sounds/die/peon_die.wav");
			dieSound = new AudioStream(dieBuffer);
			AudioPlayer.player.start(dieSound);
		}	catch(Exception exc) {
				exc.printStackTrace();
		}
	}


}
