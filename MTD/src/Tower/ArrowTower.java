 package Tower;

public class ArrowTower extends Tower{
	
	public ArrowTower(){
		super();
		setImage("/images/towers/arrow_tower.png");
		setDamage(60);
		setTowerRange(125);
		setAttackSpeed(25);
	}
}
