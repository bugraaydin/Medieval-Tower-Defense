package classes;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
	GameManager game;
	
	public GamePanel(){
		setPreferredSize(new Dimension(650,495));
		game = new GameManager();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(game.map.mapImage, 0, 0, null);
	}
}
