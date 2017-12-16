package Enemy;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Footman extends Enemy{

	

	public Footman(int locX, int locY){

		super(locX,locY);
		
		setSpeed(5);

		setArmor(10);

		setHealth(50);

		setDebuffDPS(0);

		setResourceGiven(100);
		//moving down images
		enemyImageBuffer[0] = ("/images/enemies/footman/footman_down/footman_down0.png");
		enemyImageBuffer[1] = ("/images/enemies/footman/footman_down/footman_down1.png");
		enemyImageBuffer[2] = ("/images/enemies/footman/footman_down/footman_down2.png");
		enemyImageBuffer[3] = ("/images/enemies/footman/footman_down/footman_down3.png");
		enemyImageBuffer[4] = ("/images/enemies/footman/footman_down/footman_down1.png");
		//moving right images
		enemyImageBuffer[5] = ("/images/enemies/footman/footman_right/footman_right0.png");
		enemyImageBuffer[6] = ("/images/enemies/footman/footman_right/footman_right1.png");
		enemyImageBuffer[7] = ("/images/enemies/footman/footman_right/footman_right2.png");
		enemyImageBuffer[8] = ("/images/enemies/footman/footman_right/footman_right3.png");
		enemyImageBuffer[9] = ("/images/enemies/footman/footman_right/footman_right4.png");
		//moving up images
		enemyImageBuffer[10] = ("/images/enemies/footman/footman_up/footman_up0.png");
		enemyImageBuffer[11] = ("/images/enemies/footman/footman_up/footman_up1.png");
		enemyImageBuffer[12] = ("/images/enemies/footman/footman_up/footman_up2.png");
		enemyImageBuffer[13] = ("/images/enemies/footman/footman_up/footman_up3.png");
		enemyImageBuffer[14] = ("/images/enemies/footman/footman_up/footman_up1.png");
		//die animation
		enemyImageBuffer[15] = ("/images/enemies/footman/footman_die/footman_die0.png");
		enemyImageBuffer[16] = ("/images/enemies/footman/footman_die/footman_die1.png");
		enemyImageBuffer[17] = ("/images/enemies/footman/footman_die/footman_die2.png");

		setEnemyImage(0);
	}
	public void playEnemyDie(){
		try {
			dieBuffer = getClass().getResourceAsStream("/sounds/die/footman_die.wav");
			dieSound = new AudioStream(dieBuffer);
			AudioPlayer.player.start(dieSound);
		}	catch(Exception exc) {
				exc.printStackTrace();
		}
	}

}
