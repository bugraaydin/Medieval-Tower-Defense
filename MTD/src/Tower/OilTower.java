 package Tower;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class OilTower extends Tower{

	public OilTower(){
		super();
		setImage("/images/towers/oil_tower/oil_tower.png");
		setDamage(100);
		setTowerRange(125);
		setAttackSpeed(25);
		projectilesImageBuffer[0] = ("/images/towers/oil_tower/projectiles/projectile_down.png");
		projectilesImageBuffer[1] = ("/images/towers/oil_tower/projectiles/projectile_up.png");
		projectilesImageBuffer[2] = ("/images/towers/oil_tower/projectiles/projectile_right.png");
		projectilesImageBuffer[3] = ("/images/towers/oil_tower/projectiles/projectile_left.png");
	}
	public void playTowerShoot(){
		try {
			shootBuffer = getClass().getResourceAsStream("/sounds/shoot/oil.wav");
			shootSound = new AudioStream(shootBuffer);
			AudioPlayer.player.start(shootSound);
		}	catch(Exception exc) {
				exc.printStackTrace();
		}
	}
}
