 package Tower;

public class MortarTower extends Tower{
	
	public MortarTower(){
		super();
		setImage("/images/towers/mortar_tower.png");
		setDamage(100);
		setTowerRange(125);
		setAttackSpeed(25);
	}

}
