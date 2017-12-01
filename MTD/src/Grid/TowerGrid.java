package Grid;

import java.io.IOException;

import javax.imageio.ImageIO;

public class TowerGrid extends GridSlot{
	
	public TowerGrid() {
		super();
		canPlaceTower = true;
		try {
			gridSlotImage = ImageIO.read(getClass().getResourceAsStream("/images/grids/tower_grid.jpg"));
		}	catch(IOException exc) {
				exc.printStackTrace();
		}
	}
}