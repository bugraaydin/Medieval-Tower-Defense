package classes;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class GameFrame extends JFrame{
	GamePanel p;
	
	public GameFrame(){
		p = new GamePanel();
		setLayout(new GridLayout(1,1,0,0));
		add(p);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
	}
	
	public static void main(String[] args){
		GameFrame f = new GameFrame();
	}

}
