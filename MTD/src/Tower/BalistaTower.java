 package Tower;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class BalistaTower extends Tower{
	
	public BalistaTower(){
		super();
		setImage("/images/towers/balista_tower/balista_tower.png");
		setDamage(100);
		setTowerRange(125);
		setAttackSpeed(25);
		projectilesImageBuffer[0] = ("/images/towers/balista_tower/projectiles/projectile_down.png");
		projectilesImageBuffer[1] = ("/images/towers/balista_tower/projectiles/projectile_up.png");
		projectilesImageBuffer[2] = ("/images/towers/balista_tower/projectiles/projectile_right.png");
		projectilesImageBuffer[3] = ("/images/towers/balista_tower/projectiles/projectile_left.png");
		setProjectileType(1);
		System.out.println("BALLISTA TOWERRRRRRRRR");
	}
	
	public void playTowerShoot(){
		try {
			shootBuffer = getClass().getResourceAsStream("/sounds/shoot/balista.wav");
			shootSound = new AudioStream(shootBuffer);
			AudioPlayer.player.start(shootSound);
		}	catch(Exception exc) {
				exc.printStackTrace();
		}
	}

}
