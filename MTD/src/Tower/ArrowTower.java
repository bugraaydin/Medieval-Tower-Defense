 package Tower;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class ArrowTower extends Tower{
	
	public ArrowTower(){
		super();
		setImage("/images/towers/arrow_tower/arrow_tower.png");
		setDamage(100);
		setTowerRange(125);
		setAttackSpeed(25);
		projectilesImageBuffer[0] = ("/images/towers/arrow_tower/projectiles/projectile_down.png");
		projectilesImageBuffer[1] = ("/images/towers/arrow_tower/projectiles/projectile_up.png");
		projectilesImageBuffer[2] = ("/images/towers/arrow_tower/projectiles/projectile_right.png");
		projectilesImageBuffer[3] = ("/images/towers/arrow_tower/projectiles/projectile_left.png");
		setProjectileType(1);
	}
	public void playTowerShoot(){
		try {
			shootBuffer = getClass().getResourceAsStream("/sounds/shoot/arrow.wav");
			shootSound = new AudioStream(shootBuffer);
			AudioPlayer.player.start(shootSound);
		}	catch(Exception exc) {
				exc.printStackTrace();
		}
	}
}
