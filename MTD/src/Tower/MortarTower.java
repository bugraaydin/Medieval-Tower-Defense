 package Tower;

public class MortarTower extends Tower{
	
	public MortarTower(){
		super();
		setImage("/images/towers/mortar_tower.png");
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
