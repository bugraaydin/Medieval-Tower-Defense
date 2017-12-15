 package Tower;

public class ArrowTower extends Tower{
	
	public ArrowTower(){
		super();
		setImage("/images/towers/arrow_tower.png");
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
