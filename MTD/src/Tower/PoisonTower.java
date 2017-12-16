 package Tower;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class PoisonTower extends Tower{
	
	public PoisonTower(){
		super();
		setImage("/images/towers/posion_tower/poison_tower.png");
		setDamage(100);
		setTowerRange(125);
		setAttackSpeed(25);
		projectilesImageBuffer[0] = ("/images/towers/poison_tower/projectiles/projectile_down.png");
		projectilesImageBuffer[1] = ("/images/towers/poison_tower/projectiles/projectile_up.png");
		projectilesImageBuffer[2] = ("/images/towers/poison_tower/projectiles/projectile_right.png");
		projectilesImageBuffer[3] = ("/images/towers/poison_tower/projectiles/projectile_left.png");
	}
	public void playTowerShoot(){
		try {
			shootBuffer = getClass().getResourceAsStream("/sounds/shoot/poison.wav");
			shootSound = new AudioStream(shootBuffer);
			AudioPlayer.player.start(shootSound);
		}	catch(Exception exc) {
				exc.printStackTrace();
		}
	}
}
