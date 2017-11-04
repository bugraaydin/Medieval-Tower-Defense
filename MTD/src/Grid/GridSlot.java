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
	TowerType a;
	// GRID SLOT GRAPHICS
	String imageBufferStream = "/Grass_double.jpg";
	String towerImageBufferStream = "/Grass_double.jpg";
	public BufferedImage towerImage;
	public BufferedImage gridSlotImage;
	// GRID SLOT ATTRIBUTES
	private Tower towerInThisSlot;

	public GridSlot()
	{
		try {
			gridSlotImage = ImageIO.read(getClass().getResourceAsStream("/Grass_double.jpg"));
		}	catch(IOException exc) {
				exc.printStackTrace();
		}
		try {
			towerImage = ImageIO.read(getClass().getResourceAsStream("/turret-1-1.png"));
		}	catch(IOException exc) {
				exc.printStackTrace();
		}
	}
	public GridSlot(String imageBufferStream, boolean canPlaceTower)
	{
		hasTower = false;
		this.canPlaceTower = canPlaceTower;
		this.imageBufferStream = imageBufferStream;

		try {
			gridSlotImage = ImageIO.read(getClass().getResourceAsStream("/Grass_double.jpg"));
		}	catch(IOException exc) {
				exc.printStackTrace();
		}
		try {
			towerImage = ImageIO.read(getClass().getResourceAsStream("/turret-1-1.png"));
		}	catch(IOException exc) {
				exc.printStackTrace();
		}
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
					///PRINT THIS SLOT HAS TOWER
					///
					///
				}
				else if(hasTower==false)
				{
					
					towerInThisSlot = towerToPlace;
					towerInThisSlot.locX = x;
					towerInThisSlot.locY = y;
					towerImageBufferStream = towerToPlace.towerImageFile;
					hasTower=true;
					
					try {
						towerImage = ImageIO.read(getClass().getResourceAsStream(towerImageBufferStream));
					}	catch(IOException exc) {
							exc.printStackTrace();
					}
					System.out.println(hasTower);
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
	
	public void testFunction(String s)
	{
		System.out.println(s);
	}
}
