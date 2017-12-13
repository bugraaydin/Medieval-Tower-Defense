package Grid;

import java.awt.image.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import Tower.*;

public class GridSlot {
	


	private BufferedImage gridSlotImage;
	public BufferedImage towerImage;

	public GridSlot(){
		
	}

	
	public void setSlotImage(String s)
	{
		try {
			gridSlotImage = ImageIO.read(getClass().getResourceAsStream(s));
		}	catch(IOException exc) {
				exc.printStackTrace();
		}
	}
	
	public boolean mouseHitThisSlot(boolean isInBuyMode, Tower towerToPlace, int x, int y) {
		return false;
	}

	
	//getters
	public BufferedImage getGridSlotImage(){
		return gridSlotImage;
	}
	
	//setters
	public void setGridSlotImage(String s){
		try {
			gridSlotImage = ImageIO.read(getClass().getResourceAsStream(s));
		}	catch(IOException exc) {
				exc.printStackTrace();
		}
		
	}
}
