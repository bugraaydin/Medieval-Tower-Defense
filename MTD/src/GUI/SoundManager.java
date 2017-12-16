package GUI;


import java.io.InputStream;

import sun.audio.*;


public class SoundManager{
	
  public InputStream backgroundMusicBuffer;
  public AudioStream backGroundMusic;
  public SoundManager(){
	  setBackgroundMusic();
	 // stopBackgroundMusic();
  }
  
	public void setBackgroundMusic()
	{
		try {
			backgroundMusicBuffer = getClass().getResourceAsStream("/sounds/musics/background.wav");
			backGroundMusic = new AudioStream(backgroundMusicBuffer);
			AudioPlayer.player.start(backGroundMusic);
		}	catch(Exception exc) {
				exc.printStackTrace();
		}
	}
	public void stopBackgroundMusic(){
		AudioPlayer.player.stop(backGroundMusic);
	}
}