package Enemy;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Knight extends Enemy{

	

	public Knight(int locX, int locY){
		
		super(locX,locY);
		
		setSpeed(6);

		setArmor(10);

		setHealth(500);
		setMaxHealth(500);
		setResourceGiven(100);

		setDebuffDPS(0);

		setResourceGiven(100);
		//moving down images
		enemyImageBuffer[0] = ("/images/enemies/knight/knight_down/knight_down0.png");
		enemyImageBuffer[1] = ("/images/enemies/knight/knight_down/knight_down1.png");
		enemyImageBuffer[2] = ("/images/enemies/knight/knight_down/knight_down2.png");
		enemyImageBuffer[3] = ("/images/enemies/knight/knight_down/knight_down3.png");
		enemyImageBuffer[4] = ("/images/enemies/knight/knight_down/knight_down4.png");
		//moving right images
		enemyImageBuffer[5] = ("/images/enemies/knight/knight_right/knight_right0.png");
		enemyImageBuffer[6] = ("/images/enemies/knight/knight_right/knight_right1.png");
		enemyImageBuffer[7] = ("/images/enemies/knight/knight_right/knight_right2.png");
		enemyImageBuffer[8] = ("/images/enemies/knight/knight_right/knight_right3.png");
		enemyImageBuffer[9] = ("/images/enemies/knight/knight_right/knight_right4.png");
		//moving up images
		enemyImageBuffer[10] = ("/images/enemies/knight/knight_up/knight_up0.png");
		enemyImageBuffer[11] = ("/images/enemies/knight/knight_up/knight_up1.png");
		enemyImageBuffer[12] = ("/images/enemies/knight/knight_up/knight_up2.png");
		enemyImageBuffer[13] = ("/images/enemies/knight/knight_up/knight_up3.png");
		enemyImageBuffer[14] = ("/images/enemies/knight/knight_up/knight_up4.png");
		//die animation
		enemyImageBuffer[15] = ("/images/enemies/knight/knight_die/knight_die0.png");
		enemyImageBuffer[16] = ("/images/enemies/knight/knight_die/knight_die1.png");
		enemyImageBuffer[17] = ("/images/enemies/knight/knight_die/knight_die2.png");

		setEnemyImage(0);
	}

	public void playEnemyDie(){
		try {
			dieBuffer = getClass().getResourceAsStream("/sounds/die/knight_die.wav");
			dieSound = new AudioStream(dieBuffer);
			AudioPlayer.player.start(dieSound);
		}	catch(Exception exc) {
				exc.printStackTrace();
		}
	}

}
