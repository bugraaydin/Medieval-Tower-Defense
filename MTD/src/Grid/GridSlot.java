package Grid;

import java.awt.image.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import Tower.*;

public class GridSlot {
	


	public BufferedImage[] gridSlotImage;
	public BufferedImage towerImage;

	public GridSlot(){
		gridSlotImage = new BufferedImage[4];
	}

	

	

	
	//getters
	public BufferedImage[] getGridSlotImage(){
		return gridSlotImage;
	}
	

}
