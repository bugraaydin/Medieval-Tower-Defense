package classes;

import Enemy.*;

public class WaveManager {
	
	
	Wave[] waves;
	
	public WaveManager(int levelNo){
		if(levelNo == 0)
			initializeFirstLevelWaves();
	}
	
	
	public void initializeLevelWaves(int levelNo){
		if(levelNo == 0){
			initializeFirstLevelWaves();
		}
	}
	
	public void initializeFirstLevelWaves(){
		waves = new Wave[3]; // total waves will be changed
		for(int i = 0; i < 10; i++){ 
			waves[0].enemiesInWave[i] = new Footman(); // first wave consists of 10 footmans
		}
		for(int i = 0; i < 10; i++){
			waves[1].enemiesInWave[i] = new LightCavalry();
		}
		for(int i = 0; i < 10; i++){
			waves[2].enemiesInWave[i] = new Knight();
		}
	}
}
