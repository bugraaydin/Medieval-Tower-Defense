package GUI;


import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;

public class GameFrame extends JFrame{

	static String title = "Medieval TD";
	// grid width 13 * 60 / grid height 9 * 60 + 200
	static Dimension size = new Dimension(780,740);
	
	public GameFrame(){
		setTitle(title);
		setSize(size);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		init();
		
	}
	private void init(){
		setLayout(new GridLayout(1,1,0,0));
		
		GameplayPanel game = new GameplayPanel();
		add(game);
		setVisible(true);
		pack();
	}
	
	public static void main(String[] args){
		GameFrame f = new GameFrame();
	}
}
