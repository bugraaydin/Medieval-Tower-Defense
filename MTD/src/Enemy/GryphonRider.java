package Enemy;

public class GryphonRider extends Enemy{

	

	public GryphonRider(int locX, int locY){
		
		super(locX,locY);
		
		setSpeed(10);

		setArmor(10);

		setHealth(50);

		setDebuffDPS(0);

		setResourceGiven(100);
		//moving down images
		enemyImageBuffer[0] = ("/images/enemies/gryphon_rider/gryphon_rider_down/gryphon_rider_down0.png");
		enemyImageBuffer[1] = ("/images/enemies/gryphon_rider/gryphon_rider_down/gryphon_rider_down1.png");
		enemyImageBuffer[2] = ("/images/enemies/gryphon_rider/gryphon_rider_down/gryphon_rider_down2.png");
		enemyImageBuffer[3] = ("/images/enemies/gryphon_rider/gryphon_rider_down/gryphon_rider_down3.png");
		enemyImageBuffer[4] = ("/images/enemies/gryphon_rider/gryphon_rider_down/gryphon_rider_down4.png");
		//moving right images
		enemyImageBuffer[5] = ("/images/enemies/gryphon_rider/gryphon_rider_right/gryphon_rider_right0.png");
		enemyImageBuffer[6] = ("/images/enemies/gryphon_rider/gryphon_rider_right/gryphon_rider_right1.png");
		enemyImageBuffer[7] = ("/images/enemies/gryphon_rider/gryphon_rider_right/gryphon_rider_right2.png");
		enemyImageBuffer[8] = ("/images/enemies/gryphon_rider/gryphon_rider_right/gryphon_rider_right3.png");
		enemyImageBuffer[9] = ("/images/enemies/gryphon_rider/gryphon_rider_right/gryphon_rider_right4.png");
		//moving up images
		enemyImageBuffer[10] = ("/images/enemies/gryphon_rider/gryphon_rider_up/gryphon_rider_up0.png");
		enemyImageBuffer[11] = ("/images/enemies/gryphon_rider/gryphon_rider_up/gryphon_rider_up1.png");
		enemyImageBuffer[12] = ("/images/enemies/gryphon_rider/gryphon_rider_up/gryphon_rider_up2.png");
		enemyImageBuffer[13] = ("/images/enemies/gryphon_rider/gryphon_rider_up/gryphon_rider_up3.png");
		enemyImageBuffer[14] = ("/images/enemies/gryphon_rider/gryphon_rider_up/gryphon_rider_up4.png");
		//die animation
		enemyImageBuffer[15] = ("/images/enemies/gryphon_rider/gryphon_rider_die/gryphon_rider_die0.png");
		enemyImageBuffer[16] = ("/images/enemies/gryphon_rider/gryphon_rider_die/gryphon_rider_die1.png");
		enemyImageBuffer[17] = ("/images/enemies/gryphon_rider/gryphon_rider_die/gryphon_rider_die2.png");

		setEnemyImage(0);
	}



}
