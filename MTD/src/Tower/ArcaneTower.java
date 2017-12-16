 package Tower;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class ArcaneTower extends Tower{
	
	public ArcaneTower(){
		super();
		setImage("/images/towers/arcane_tower/arcane_tower.png");
		setDamage(25);
		setTowerRange(225);
		setAttackSpeed(25);
		projectilesImageBuffer[0] = ("/images/towers/arcane_tower/projectiles/projectile_down.png");
		projectilesImageBuffer[1] = ("/images/towers/arcane_tower/projectiles/projectile_up.png");
		projectilesImageBuffer[2] = ("/images/towers/arcane_tower/projectiles/projectile_right.png");
		projectilesImageBuffer[3] = ("/images/towers/arcane_tower/projectiles/projectile_left.png");
	}
	
	public void playTowerShoot(){
		try {
			shootBuffer = getClass().getResourceAsStream("/sounds/shoot/arcane.wav");
			shootSound = new AudioStream(shootBuffer);
			AudioPlayer.player.start(shootSound);
		}	catch(Exception exc) {
				exc.printStackTrace();
		}
	}

}
