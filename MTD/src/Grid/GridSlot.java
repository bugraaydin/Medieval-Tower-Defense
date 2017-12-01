package Grid;

import java.awt.event.MouseEvent;
import java.awt.image.*;
import java.io.IOException;

import javax.imageio.ImageIO;

import Tower.*
;
public class GridSlot {
	
	// GRID SLOT BASIC ATTRIBUTES
	public boolean canPlaceTower = false;
	public boolean hasTower;
	// GRID SLOT GRAPHICS
	String towerImageBufferStream;
	public BufferedImage towerImage;
	public BufferedImage gridSlotImage;
	// GRID SLOT ATTRIBUTES
	private Tower towerInThisSlot;


	public GridSlot()
	{
		hasTower = false;

	}
	public boolean mouseHitThisSlot(boolean isInBuyMode, Tower towerToPlace, int x, int y)
	{
		if(canPlaceTower==false)
			return false;
		else
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
					towerImageBufferStream = towerToPlace.getImage();//towerToPlace.getImage();
					hasTower=true;
					try {
						towerImage = ImageIO.read(getClass().getResourceAsStream(towerImageBufferStream));
					}	catch(IOException exc) {
							exc.printStackTrace();
					}
					return true;
				}
			}
		}
		return false;
		
	}
	
	public void setSlotImage(String s)
	{
		try {
			gridSlotImage = ImageIO.read(getClass().getResourceAsStream(s));
		}	catch(IOException exc) {
				exc.printStackTrace();
		}
	}

}
