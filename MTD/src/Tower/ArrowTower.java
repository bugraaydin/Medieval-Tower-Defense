 package Tower;

public class ArrowTower extends Tower{
	
	public ArrowTower(){
		super();
		setImage("/images/towers/arrow_tower.png");
		setDamage(100);
		setTowerRange(125);
		setAttackSpeed(25);
	}
	public void upgradeTower(int playerMoney) {
		
		setDamage(10+dmg);
		setUpgradeCost(2*upgradeCost);
		setTowerRange(25+towerRange);
		setAttackSpeed(15+attackSpeed);
	}
}
