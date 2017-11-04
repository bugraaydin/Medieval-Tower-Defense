package classes;

import Tower.*;

public class TowerManager {

	public Tower[] towerList;
	
	public int towerCount = 0;
	
	public TowerManager()
	{
		towerList = new Tower[50];
	}
	
	public void addTower(Tower towerToAdd)
	{
		towerList[towerCount] = towerToAdd;
		towerCount++;
	}
}
