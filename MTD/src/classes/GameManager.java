package classes;


import Grid.*;

public class GameManager {
	
	Grid gameGrid;
	
	WaveManager waves;
	TowerManager towers;
	
	int resource;
	int currentWave;
	
	
	public GameManager(){
		gameGrid = new Grid(0);
	}
	
	
/*
	public static void main(String[] args){
		Grid test = new Grid(0);
		test.printIt();
	}
*/
	
	
}
