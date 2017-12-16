package Grid;

import java.io.IOException;

import javax.imageio.ImageIO;

import Tower.Tower;

public class EnemyGrid extends GridSlot{
	
	private String enemyGridImageBuffer;
	public EnemyGrid() {
		super();
		int i;
		for(int j = 0; j < 4; j++){
			i = (int) (Math.random() * 10);
			if(i == 0)
				enemyGridImageBuffer = "/images/grids/enemy0.png";
			if(i == 1)
				enemyGridImageBuffer = "/images/grids/enemy1.png";
			if(i == 2)
				enemyGridImageBuffer = "/images/grids/enemy2.png";
			if(i == 3)
				enemyGridImageBuffer = "/images/grids/enemy3.png";
			if(i == 4)
				enemyGridImageBuffer = "/images/grids/enemy4.png";
			if(i == 5)
				enemyGridImageBuffer = "/images/grids/enemy5.png";
			if(i == 6)
				enemyGridImageBuffer = "/images/grids/enemy6.png";
			if(i == 7)
				enemyGridImageBuffer = "/images/grids/enemy7.png";
			if(i == 8)
				enemyGridImageBuffer = "/images/grids/enemy8.png";
			if(i == 9)
				enemyGridImageBuffer = "/images/grids/enemy9.png";
			try {
				gridSlotImage[j] = ImageIO.read(getClass().getResourceAsStream(enemyGridImageBuffer));
			}	catch(IOException exc) {
					exc.printStackTrace();
			}
		}

	}
	


}