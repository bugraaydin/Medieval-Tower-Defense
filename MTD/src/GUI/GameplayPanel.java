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
	UILayout layout;
	BorderLayout borderLayout = new BorderLayout();
	public GameplayPanel(){
		this.setLayout(borderLayout);
		layout = new UILayout(){
			public Dimension getPrefferedSize(){
				return new Dimension(780,200);
			};
		};
		this.setPreferredSize(new Dimension(780,740));
		add(layout,BorderLayout.SOUTH);
		layout.setPreferredSize(new Dimension(780,200));
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
