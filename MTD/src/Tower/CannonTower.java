 package Tower;

public class CannonTower extends Tower {
	
	public CannonTower(){
		super();
		setImage("/images/towers/cannon_tower.png");
		dmg = 100;
		towerRange = 125;
		attackSpeed = 25;
		upgradeCost = 25;
	}
	
	public void upgradeCost(int playerMoney) {
		
		setDamage(10+dmg);
		setUpgradeCost(2*upgradeCost);
		setTowerRange(25+towerRange);
		setAttackSpeed(15+attackSpeed);
	}
}
