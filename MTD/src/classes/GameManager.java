package classes;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import Grid.*;

public class GameManager {
	
	Grid gameGrid;
	
	WaveManager waves;
	TowerManager towers;
	
	int resource;
	int currentWave;
	int levelNo;
	int frames;
	int second;
	
	public GameManager(){
		initGame();
	}
	
	public void initGame(){
		gameGrid = new Grid(0);
		waves = new WaveManager(0);
		second = 0;
		frames = 0;
		int delay = 100; // ~10 updates per second
		ActionListener taskPerformer = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frames++;
				if((frames%10) == 0){
					second++;
					if(second < 20)
					System.out.println(second);
				}
			}
		};
		new Timer(delay,taskPerformer).start();
	}
	
	public Grid getGameGrid(){
		return gameGrid;
	}
	

	public static void main(String[] args){
		GameManager game = new GameManager();
		
	}

	
	
}
