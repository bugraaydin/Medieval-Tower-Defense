package Enemy;

public class Footman extends Enemy{

	

	public Footman(int locX, int locY){

		super(locX,locY)
		;
		setSpeed(10);

		setArmor(10);

		setHealth(10);

		setDebuffDPS(0);

		setResourceGiven(100);
		
		setEnemyImage("/images/enemies/footman/footman.png");

	}





}
