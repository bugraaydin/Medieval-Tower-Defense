package Enemy;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class ElvenArcher extends Enemy{

	

	public ElvenArcher(int locX, int locY){

		super(locX,locY);
		
		setSpeed(6);

		setArmor(10);

		setHealth(500);
		setMaxHealth(500);
		setResourceGiven(100);

		setDebuffDPS(0);

		setResourceGiven(100);
		//moving down images
		enemyImageBuffer[0] = ("/images/enemies/elven_archer/elven_archer_down/elven_archer_down0.png");
		enemyImageBuffer[1] = ("/images/enemies/elven_archer/elven_archer_down/elven_archer_down1.png");
		enemyImageBuffer[2] = ("/images/enemies/elven_archer/elven_archer_down/elven_archer_down2.png");
		enemyImageBuffer[3] = ("/images/enemies/elven_archer/elven_archer_down/elven_archer_down3.png");
		enemyImageBuffer[4] = ("/images/enemies/elven_archer/elven_archer_down/elven_archer_down1.png");
		//moving right images
		enemyImageBuffer[5] = ("/images/enemies/elven_archer/elven_archer_right/elven_archer_right0.png");
		enemyImageBuffer[6] = ("/images/enemies/elven_archer/elven_archer_right/elven_archer_right1.png");
		enemyImageBuffer[7] = ("/images/enemies/elven_archer/elven_archer_right/elven_archer_right2.png");
		enemyImageBuffer[8] = ("/images/enemies/elven_archer/elven_archer_right/elven_archer_right3.png");
		enemyImageBuffer[9] = ("/images/enemies/elven_archer/elven_archer_right/elven_archer_right4.png");
		//moving up images
		enemyImageBuffer[10] = ("/images/enemies/elven_archer/elven_archer_up/elven_archer_up0.png");
		enemyImageBuffer[11] = ("/images/enemies/elven_archer/elven_archer_up/elven_archer_up1.png");
		enemyImageBuffer[12] = ("/images/enemies/elven_archer/elven_archer_up/elven_archer_up2.png");
		enemyImageBuffer[13] = ("/images/enemies/elven_archer/elven_archer_up/elven_archer_up3.png");
		enemyImageBuffer[14] = ("/images/enemies/elven_archer/elven_archer_up/elven_archer_up1.png");
		//die animation
		enemyImageBuffer[15] = ("/images/enemies/elven_archer/elven_archer_die/elven_archer_die0.png");
		enemyImageBuffer[16] = ("/images/enemies/elven_archer/elven_archer_die/elven_archer_die1.png");
		enemyImageBuffer[17] = ("/images/enemies/elven_archer/elven_archer_die/elven_archer_die2.png");

		setEnemyImage(0);
	}

	public void playEnemyDie(){
		try {
			dieBuffer = getClass().getResourceAsStream("/sounds/die/elf_die.wav");
			dieSound = new AudioStream(dieBuffer);
			AudioPlayer.player.start(dieSound);
		}	catch(Exception exc) {
				exc.printStackTrace();
		}
	}
}
