 package Tower;

public class ArcaneTower extends Tower{
	
	public ArcaneTower(){
		super();
		setImage("/images/towers/arcane_tower.png");
		setDamage(25);
		setTowerRange(225);
		setAttackSpeed(25);
		setUpgradeCost(50);
	}
	public void upgradeTower(int playerMoney) {
		
		setDamage(10+dmg);
		setUpgradeCost(2*upgradeCost);
		setTowerRange(25+towerRange);
		setAttackSpeed(15+attackSpeed);
		playerMoney -= upgradeCost;
	}

}
