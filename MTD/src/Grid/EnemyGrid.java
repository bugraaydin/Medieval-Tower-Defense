package Grid;

import java.io.IOException;

import javax.imageio.ImageIO;

import Tower.Tower;

public class EnemyGrid extends GridSlot{
	
	private static final String EnemyImageBuffer = "/images/grids/enemy_grid.jpg";
	
	public EnemyGrid() {
		super();
		setGridSlotImage(EnemyImageBuffer);
	}
	


}