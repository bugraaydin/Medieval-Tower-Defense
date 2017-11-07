package GUI;

import java.io.*;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

import sun.audio.*;


public class SoundManager{
	
  public InputStream backgroundMusicBuffer;
  public AudioInputStream backGroundMusic;
  public SoundManager(){
	  setBackgroundMusic();
	  
  }
  
	public void setBackgroundMusic()
	{
		try {
			backgroundMusicBuffer = getClass().getResourceAsStream("/sounds/musics/background.wav");
			backGroundMusic = AudioSystem.getAudioInputStream(backgroundMusicBuffer);
			Clip clip = AudioSystem.getClip();
			clip.open(backGroundMusic);
			clip.start();
		}	catch(Exception exc) {
				exc.printStackTrace();
		}
		
	}
}