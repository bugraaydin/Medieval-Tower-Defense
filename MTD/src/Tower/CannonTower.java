 package Tower;

public class CannonTower extends Tower {
	
	public CannonTower(){
		super();
		setImage("/images/towers/cannon_tower.png");
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
