package Grid;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import Tower.*;

public class TowerGrid extends GridSlot{

	boolean hasTower;
	private Tower towerInSlot;
	//
	BufferedImage towerGridImage;
	
	public TowerGrid(){
		try{
			towerGridImage = ImageIO.read(new File(""));
		}catch(IOException e){}
	}
}
