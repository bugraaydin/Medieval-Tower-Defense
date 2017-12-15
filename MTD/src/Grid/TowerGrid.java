package Grid;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Tower.Tower;

public class TowerGrid extends GridSlot{
	private Tower towerInThisSlot;

	private static final String TowerImageBuffer = "/images/grids/tower_grid.jpg";
	public boolean hasTower;
	
	public TowerGrid() {
		super();
		setGridSlotImage(TowerImageBuffer);

	}
	
	
	
	public boolean mouseHitThisSlot(boolean isInBuyMode, Tower towerToPlace, int x, int y)
	{
		if(isInBuyMode)
		{
			if(hasTower==true)
			{
				return false;
			}
			else if(hasTower==false)
			{
				towerInThisSlot = towerToPlace;
				towerInThisSlot.setLocX(x);
				towerInThisSlot.setLocY(y);
				hasTower=true;
				try {
					towerImage = ImageIO.read(getClass().getResourceAsStream(towerToPlace.getImage()));
				}	catch(IOException exc) {
						exc.printStackTrace();
				}
			}
		}
		return true;
	}	
	public Tower getTower(){
		return towerInThisSlot;
	}
}
