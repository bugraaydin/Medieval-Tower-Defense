 package Tower;

public class OilTower extends Tower{

	public OilTower(){
		super();
		setImage("/images/towers/oil_tower.png");
		setDamage(100);
		setTowerRange(125);
		setAttackSpeed(25);
		setUpgradeCost(50);
	}
	public void upgradeTower(int playerMoney) {
		
		setDamage(10+dmg);
		setUpgradeCost(2*upgradeCost);
		setTowerRange(25+towerRange);
		setAttackSpeed(15+attackSpeed);
		playerMoney -= upgradeCost;
		System.out.println("Player gold: " + playerMoney);
	}
}
