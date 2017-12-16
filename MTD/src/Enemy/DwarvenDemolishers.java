package Enemy;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class DwarvenDemolishers extends Enemy{

	

	public DwarvenDemolishers(int locX, int locY){

		super(locX,locY);
		
		setSpeed(10);

		setArmor(10);

		setHealth(50);

		setDebuffDPS(0);

		setResourceGiven(100);
		//moving down images
		enemyImageBuffer[0] = ("/images/enemies/dwarven_demolishers/dwarven_demolishers_down/dwarven_demolishers_down0.png");
		enemyImageBuffer[1] = ("/images/enemies/dwarven_demolishers/dwarven_demolishers_down/dwarven_demolishers_down1.png");
		enemyImageBuffer[2] = ("/images/enemies/dwarven_demolishers/dwarven_demolishers_down/dwarven_demolishers_down2.png");
		enemyImageBuffer[3] = ("/images/enemies/dwarven_demolishers/dwarven_demolishers_down/dwarven_demolishers_down3.png");
		enemyImageBuffer[4] = ("/images/enemies/dwarven_demolishers/dwarven_demolishers_down/dwarven_demolishers_down1.png");
		//moving right images
		enemyImageBuffer[5] = ("/images/enemies/dwarven_demolishers/dwarven_demolishers_right/dwarven_demolishers_right0.png");
		enemyImageBuffer[6] = ("/images/enemies/dwarven_demolishers/dwarven_demolishers_right/dwarven_demolishers_right1.png");
		enemyImageBuffer[7] = ("/images/enemies/dwarven_demolishers/dwarven_demolishers_right/dwarven_demolishers_right2.png");
		enemyImageBuffer[8] = ("/images/enemies/dwarven_demolishers/dwarven_demolishers_right/dwarven_demolishers_right3.png");
		enemyImageBuffer[9] = ("/images/enemies/dwarven_demolishers/dwarven_demolishers_right/dwarven_demolishers_right4.png");
		//moving up images
		enemyImageBuffer[10] = ("/images/enemies/dwarven_demolishers/dwarven_demolishers_up/dwarven_demolishers_up0.png");
		enemyImageBuffer[11] = ("/images/enemies/dwarven_demolishers/dwarven_demolishers_up/dwarven_demolishers_up1.png");
		enemyImageBuffer[12] = ("/images/enemies/dwarven_demolishers/dwarven_demolishers_up/dwarven_demolishers_up2.png");
		enemyImageBuffer[13] = ("/images/enemies/dwarven_demolishers/dwarven_demolishers_up/dwarven_demolishers_up3.png");
		enemyImageBuffer[14] = ("/images/enemies/dwarven_demolishers/dwarven_demolishers_up/dwarven_demolishers_up1.png");
		//die animation
		enemyImageBuffer[15] = ("/images/enemies/dwarven_demolishers/dwarven_demolishers_die/dwarven_demolishers_die0.png");
		enemyImageBuffer[16] = ("/images/enemies/dwarven_demolishers/dwarven_demolishers_die/dwarven_demolishers_die1.png");
		enemyImageBuffer[17] = ("/images/enemies/dwarven_demolishers/dwarven_demolishers_die/dwarven_demolishers_die2.png");

		setEnemyImage(0);
	}

	public void playEnemyDie(){
		try {
			dieBuffer = getClass().getResourceAsStream("/sounds/die/dwarf_die.wav");
			dieSound = new AudioStream(dieBuffer);
			AudioPlayer.player.start(dieSound);
		}	catch(Exception exc) {
				exc.printStackTrace();
		}
	}
}
