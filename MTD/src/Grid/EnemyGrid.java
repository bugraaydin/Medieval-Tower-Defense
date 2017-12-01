package Grid;

import java.io.IOException;

import javax.imageio.ImageIO;

public class EnemyGrid extends GridSlot{
	
	public EnemyGrid() {
		super();
		canPlaceTower = false;
		try {
			gridSlotImage = ImageIO.read(getClass().getResourceAsStream("/images/grids/enemy_grid.jpg"));
		}	catch(IOException exc) {
				exc.printStackTrace();
		}
	}

}