 package Tower;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class IceTower extends Tower{
	
	public IceTower(){
		super();
		setImage("/images/towers/ice_tower/ice_tower.png");
		setDamage(100);
		setTowerRange(125);
		setAttackSpeed(25);
		projectilesImageBuffer[0] = ("/images/towers/ice_tower/projectiles/projectile_down.png");
		projectilesImageBuffer[1] = ("/images/towers/ice_tower/projectiles/projectile_up.png");
		projectilesImageBuffer[2] = ("/images/towers/ice_tower/projectiles/projectile_right.png");
		projectilesImageBuffer[3] = ("/images/towers/ice_tower/projectiles/projectile_left.png");
		setProjectileType(2);
	}
	public void playTowerShoot(){
		try {
			shootBuffer = getClass().getResourceAsStream("/sounds/shoot/ice.wav");
			shootSound = new AudioStream(shootBuffer);
			AudioPlayer.player.start(shootSound);
		}	catch(Exception exc) {
				exc.printStackTrace();
		}
	}
}
