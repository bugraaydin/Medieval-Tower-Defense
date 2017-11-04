package Enemy;

public class Knight extends Enemy{

	

	public Knight(int locX, int locY){
		
		super(locX,locY);

		setSpeed(10);

		setArmor(10);

		setHealth(10);

		setDebuffDPS(0);

		setResourceGiven(100);

		setEnemyImage("/creep/creep-1-green/1.png");
	}



}
