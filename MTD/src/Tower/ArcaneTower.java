 package Tower;

public class ArcaneTower extends Tower{
	
	public ArcaneTower(){
		super();
		dmg = 25;
		upgradeCost = 25;
		towerRange = 225;
		attackSpeed = 25;
		setImage("/images/towers/arcane_tower.png");
	}
	
	public void upgradeCost(int playerMoney) {
		
		setDamage(10+dmg);
		setUpgradeCost(2*upgradeCost);
		setTowerRange(25+towerRange);
		setAttackSpeed(15+attackSpeed);
	}
}
