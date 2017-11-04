package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

import classes.GameManager;


public class GameplayPanel extends JPanel{

	GameManager game;
	BorderLayout borderLayout = new BorderLayout();
	public GameplayPanel(){
		this.setLayout(borderLayout);

		this.setPreferredSize(new Dimension(780,740));

		setVisible(true);
		this.setBackground(Color.black);
		game = new GameManager();
	}
	
	
	
	
	public void drawMap(){
		for(int i = 0; i < game.getGameGrid().getGridHeight(); i++){
			for(int j = 0; i < game.getGameGrid().getGridWidth(); j++){
				
			}
		}
	}

	
	
}
