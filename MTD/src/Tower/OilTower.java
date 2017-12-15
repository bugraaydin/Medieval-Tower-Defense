 package Tower;

public class OilTower extends Tower{

	public OilTower(){
		super();
		setImage("/images/towers/oil_tower.png");
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
