package Enemy;

public class FlyingMachine extends Enemy{

	

	public FlyingMachine(int locX, int locY){

		super(locX,locY);
		
		setSpeed(10);

		setArmor(10);

		setHealth(300);

		setDebuffDPS(0);

		setResourceGiven(100);
		//moving down images
		enemyImageBuffer[0] = ("/images/enemies/flying_machine/flying_machine_down/flying_machine_down0.png");
		enemyImageBuffer[1] = ("/images/enemies/flying_machine/flying_machine_down/flying_machine_down1.png");
		enemyImageBuffer[2] = ("/images/enemies/flying_machine/flying_machine_down/flying_machine_down2.png");
		enemyImageBuffer[3] = ("/images/enemies/flying_machine/flying_machine_down/flying_machine_down3.png");
		enemyImageBuffer[4] = ("/images/enemies/flying_machine/flying_machine_down/flying_machine_down1.png");
		//moving right images
		enemyImageBuffer[5] = ("/images/enemies/flying_machine/flying_machine_right/flying_machine_right0.png");
		enemyImageBuffer[6] = ("/images/enemies/flying_machine/flying_machine_right/flying_machine_right1.png");
		enemyImageBuffer[7] = ("/images/enemies/flying_machine/flying_machine_right/flying_machine_right2.png");
		enemyImageBuffer[8] = ("/images/enemies/flying_machine/flying_machine_right/flying_machine_right3.png");
		enemyImageBuffer[9] = ("/images/enemies/flying_machine/flying_machine_right/flying_machine_right4.png");
		//moving up images
		enemyImageBuffer[10] = ("/images/enemies/flying_machine/flying_machine_up/flying_machine_up0.png");
		enemyImageBuffer[11] = ("/images/enemies/flying_machine/flying_machine_up/flying_machine_up1.png");
		enemyImageBuffer[12] = ("/images/enemies/flying_machine/flying_machine_up/flying_machine_up2.png");
		enemyImageBuffer[13] = ("/images/enemies/flying_machine/flying_machine_up/flying_machine_up3.png");
		enemyImageBuffer[14] = ("/images/enemies/flying_machine/flying_machine_up/flying_machine_up1.png");
		//die animation
		enemyImageBuffer[15] = ("/images/enemies/flying_machine/flying_machine_die/flying_machine_die0.png");
		enemyImageBuffer[16] = ("/images/enemies/flying_machine/flying_machine_die/flying_machine_die1.png");
		enemyImageBuffer[17] = ("/images/enemies/flying_machine/flying_machine_die/flying_machine_die2.png");

		setEnemyImage(0);
	}


}
