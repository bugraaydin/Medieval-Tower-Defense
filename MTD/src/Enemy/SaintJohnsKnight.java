 package Enemy;

public class SaintJohnsKnight extends Enemy{
	
	public SaintJohnsKnight(int locX, int locY){

		super(locX,locY);
		
		setSpeed(10);

		setArmor(10);

		setHealth(10);

		setDebuffDPS(0);

		setResourceGiven(100);

		setEnemyImage("/images/enemies/footman/footman.png");
	}
}
