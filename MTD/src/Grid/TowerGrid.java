package Grid;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Tower.Tower;

public class TowerGrid extends GridSlot{
	private Tower towerInThisSlot;

	private String towerGridImageBuffer;
	public boolean hasTower;
	
	public TowerGrid() {
		super();
		int i;
		for(int j = 0; j < 4; j++){
			i = (int) (Math.random() * 10);
			if(i == 0)
				towerGridImageBuffer = "/images/grids/tower0.png";
			if(i == 1)
				towerGridImageBuffer = "/images/grids/tower1.png";
			if(i == 2)
				towerGridImageBuffer = "/images/grids/tower2.png";
			if(i == 3)
				towerGridImageBuffer = "/images/grids/tower3.png";
			if(i == 4)
				towerGridImageBuffer = "/images/grids/tower4.png";
			if(i == 5)
				towerGridImageBuffer = "/images/grids/tower5.png";
			if(i == 6)
				towerGridImageBuffer = "/images/grids/tower6.png";
			if(i == 7)
				towerGridImageBuffer = "/images/grids/tower7.png";
			if(i == 8)
				towerGridImageBuffer = "/images/grids/tower8.png";
			if(i == 9)
				towerGridImageBuffer = "/images/grids/tower9.png";
			try {
				gridSlotImage[j] = ImageIO.read(getClass().getResourceAsStream(towerGridImageBuffer));
			}	catch(IOException exc) {
					exc.printStackTrace();
			}
		}

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
