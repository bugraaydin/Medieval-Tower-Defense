package Enemy;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class DeathKnight extends Enemy{

	

	public DeathKnight(int locX, int locY){
		
		super(locX,locY);
		
		setSpeed(6);

		setArmor(10);

		setHealth(500);
		setMaxHealth(500);
		setResourceGiven(100);
		setDebuffDPS(0);

		setResourceGiven(100);
		//moving down images
		enemyImageBuffer[0] = ("/images/enemies/death_knight/death_knight_down/death_knight_down0.png");
		enemyImageBuffer[1] = ("/images/enemies/death_knight/death_knight_down/death_knight_down1.png");
		enemyImageBuffer[2] = ("/images/enemies/death_knight/death_knight_down/death_knight_down2.png");
		enemyImageBuffer[3] = ("/images/enemies/death_knight/death_knight_down/death_knight_down3.png");
		enemyImageBuffer[4] = ("/images/enemies/death_knight/death_knight_down/death_knight_down4.png");
		//moving right images
		enemyImageBuffer[5] = ("/images/enemies/death_knight/death_knight_right/death_knight_right0.png");
		enemyImageBuffer[6] = ("/images/enemies/death_knight/death_knight_right/death_knight_right1.png");
		enemyImageBuffer[7] = ("/images/enemies/death_knight/death_knight_right/death_knight_right2.png");
		enemyImageBuffer[8] = ("/images/enemies/death_knight/death_knight_right/death_knight_right3.png");
		enemyImageBuffer[9] = ("/images/enemies/death_knight/death_knight_right/death_knight_right4.png");
		//moving up images
		enemyImageBuffer[10] = ("/images/enemies/death_knight/death_knight_up/death_knight_up0.png");
		enemyImageBuffer[11] = ("/images/enemies/death_knight/death_knight_up/death_knight_up1.png");
		enemyImageBuffer[12] = ("/images/enemies/death_knight/death_knight_up/death_knight_up2.png");
		enemyImageBuffer[13] = ("/images/enemies/death_knight/death_knight_up/death_knight_up3.png");
		enemyImageBuffer[14] = ("/images/enemies/death_knight/death_knight_up/death_knight_up4.png");
		//die animation
		enemyImageBuffer[15] = ("/images/enemies/death_knight/death_knight_die/death_knight_die0.png");
		enemyImageBuffer[16] = ("/images/enemies/death_knight/death_knight_die/death_knight_die1.png");
		enemyImageBuffer[17] = ("/images/enemies/death_knight/death_knight_die/death_knight_die2.png");

		setEnemyImage(0);
	}


	public void playEnemyDie(){
		try {
			dieBuffer = getClass().getResourceAsStream("/sounds/die/deathknight_die.wav");
			dieSound = new AudioStream(dieBuffer);
			AudioPlayer.player.start(dieSound);
		}	catch(Exception exc) {
				exc.printStackTrace();
		}
	}
}
