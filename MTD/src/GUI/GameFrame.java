package GUI;


import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;

public class GameFrame extends JFrame{
	MainMenuPanel mainMenu;
	GameplayPanel game;
	InformationPanel information;
	SettingsPanel settings;
	HelpPanel help;
	CreditsPanel credits;
	HighScorePanel highScore;
	static String title = "Medieval TD";
	// grid width 13 * 60 / grid height 9 * 60 + 200
	static Dimension size = new Dimension(780,740);
	
	public GameFrame(){
		mainMenu = new MainMenuPanel();
		add(mainMenu);
		init();
		setVisible(true);
		pack();
	}
	public GameFrame(MainMenuPanel mainMenu){
		init();
		this.mainMenu = mainMenu;
		add(this.mainMenu);
		setVisible(true);
		pack();
	}
	public GameFrame(SettingsPanel settings){
		init();
		this.settings = settings;
		add(this.settings);
		setVisible(true);
		pack();
	}
	public GameFrame(InformationPanel info){
		init();
		this.information = info;
		add(this.information);
		setVisible(true);
		pack();
	}
	public GameFrame(HighScorePanel highScore){
		init();
		this.highScore = highScore;
		add(this.highScore);
		setVisible(true);
		pack();
	}
	public GameFrame(HelpPanel help){
		init();
		this.help = help;
		add(this.help);
		setVisible(true);
		pack();
	}
	public GameFrame(GameplayPanel game){
		init();
		this.game = game;
		add(this.game);
		setVisible(true);
		pack();	
	}
	public GameFrame(CreditsPanel credits){
		init();
		this.credits = credits;
		add(this.credits);
		setVisible(true);
		pack();
	}
	private void init(){
		setLayout(new GridLayout(1,1,0,0));
		setTitle(title);
		setSize(size);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//mainMenu = new MainMenuPanel();
		//add(mainMenu);
		//add(game);
		//add(settings);
		//information = new InformationPanel();
		//add(information);
		//add(help);
		//add(credits);
		//add(highScore);

	}
	
	public static void main(String[] args){
		GameFrame f = new GameFrame();
	}
}
