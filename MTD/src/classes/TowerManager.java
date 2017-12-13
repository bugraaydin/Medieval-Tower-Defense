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
	

	/**	COMMENTING THIS PART OUT, MOVING BACK TO TOWER CLASS
	public void spawnProjectile(int i){
		System.out.println(towerList.get(i).getLocX()+","+towerList.get(i).getLocY());
		Projectile spawnedProjectile = new Projectile(towerList.get(i).getLocX(),towerList.get(i).getLocY(),towerList.get(i).getTarget(),towerList.get(i).getDamage());
		towerList.get(i).getProjectilesSpawned().add(spawnedProjectile);
}*/
}
