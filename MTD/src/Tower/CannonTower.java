 package Tower;

public class CannonTower extends Tower {
	
	public CannonTower(){
		super();
		setImage("/images/towers/cannon_tower.png");
		setDamage(100);
		setTowerRange(125);
		setAttackSpeed(25);
	}
}
