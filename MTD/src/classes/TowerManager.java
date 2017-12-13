package classes;

import java.util.ArrayList;

import Tower.*;

public class TowerManager {

	public ArrayList<Tower> towerList;
	
	public int towerCount = 0;
	
	public TowerManager()
	{
		towerList = new ArrayList<>();
	}
	
	public void addTower(Tower towerToAdd)
	{
		towerList.add(towerToAdd);
		towerCount++;
	}
}
