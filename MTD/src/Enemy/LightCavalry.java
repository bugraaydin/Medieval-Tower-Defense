package Enemy;

public class LightCavalry extends Enemy{

	

	public LightCavalry(int locX, int locY){

		super(locX,locY);
		
		setSpeed(10);

		setArmor(10);

		setHealth(10);

		setDebuffDPS(0);

		setResourceGiven(100);

		setEnemyImage("/creep/creep-1-red/1.png");
	}



}