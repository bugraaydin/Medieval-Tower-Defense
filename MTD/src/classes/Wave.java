package classes;
import Enemy.*;

public class Wave {
	
	EnemyManager[] wave;
	EnemyManager currentWave;
	int waveNumber;
	
	public Wave(int waveCount){
		wave = new EnemyManager[waveCount];
		currentWave = wave[0];
		waveNumber = 0;
		initWaves();
	}
	private void initWaves(){
		
	}
	
	public void updateWave(){
		if(waveNumber < wave.length){
			currentWave = wave[waveNumber+1];
			waveNumber++;
		}
	}
	
}
