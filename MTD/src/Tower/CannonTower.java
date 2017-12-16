 package Tower;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class CannonTower extends Tower {
	
	public CannonTower(){
		super();
		setImage("/images/towers/cannon_tower/cannon_tower.png");
		setDamage(100);
		setTowerRange(125);
		setAttackSpeed(25);
		projectilesImageBuffer[0] = ("/images/towers/cannon_tower/projectiles/projectile_down.png");
		projectilesImageBuffer[1] = ("/images/towers/cannon_tower/projectiles/projectile_up.png");
		projectilesImageBuffer[2] = ("/images/towers/cannon_tower/projectiles/projectile_right.png");
		projectilesImageBuffer[3] = ("/images/towers/cannon_tower/projectiles/projectile_left.png");
	}
	public void playTowerShoot(){
		try {
			shootBuffer = getClass().getResourceAsStream("/sounds/shoot/cannon.wav");
			shootSound = new AudioStream(shootBuffer);
			AudioPlayer.player.start(shootSound);
		}	catch(Exception exc) {
				exc.printStackTrace();
		}
	}
}
