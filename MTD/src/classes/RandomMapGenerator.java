package classes;

public class RandomMapGenerator {

	private int [][] map;
	private int width = 13;
	private int height = 9;
	private int enemySpawnLocX = 1;
	private int enemySpawnLocY = 0;
	private int currentX = enemySpawnLocX;
	private int currentY = enemySpawnLocY;
	private int direction = 0; //0 down, 1 up, 2 right
	private int oldDirection = 0;
	public RandomMapGenerator(){
		map = new int[width][height]; 
		for(int i = 0; i < width; i++){
			for(int j = 0; j < height;j++){
				map[i][j] = 0;
			}
		}
		map[enemySpawnLocX][enemySpawnLocY] = 1;
		boolean b = currentX == width-1;
		do{
			if(direction == 0){
				if(currentY+1 < height){
						//oldDirection = 0;
						//direction = 0;
						map[currentX][currentY+1] = 1;
						currentY++;
					
				}
				/*else{
					if(currentX+1 < 13){
						oldDirection = 0;
						direction = 2;
						map[currentX+1][currentY] = 1;
						currentX++;
					}
				}
				*/
			}
			else if(direction == 1){
				if(currentY-1 > 0){
					//oldDirection = 1;
					//direction = 1;
					map[currentX][currentY-1] = 1;
					currentY--;
				}
				/*
				else{
					if(currentX+1 < 13){
						oldDirection = 1;
						direction = 2;
						map[currentX+1][currentY] = 1;
						currentX++;
					}
				}
				*/
			}
			else if(direction == 2){
				if(currentX+1 < width){
					//oldDirection = 2;
					//direction = 2;
					map[currentX+1][currentY] = 1;
					currentX++;
				}
			}
			randomChangeDirection(direction);
			System.out.println(direction+","+oldDirection);
			b = currentX == width-1;
		}
		while(!b);
	}
	
	private void randomChangeDirection(int direct){
		int i = (int) (Math.random() * 10);
		if(direction == 2 && (oldDirection == 0 || oldDirection == 1)){
			System.out.println("topLul");
			direction = 2;
			oldDirection = 2;
			return;
		} 
		if(direct == 0){
			if(i >= 4){
				oldDirection = 0;
				direction = 0;
				return;
			}
			else{
				oldDirection = 0;
				direction = 2;
				return;
			}
		}
		if(direct == 1){
			if( i >= 4){
				oldDirection = 1;
				direction = 1;
				return;
			}
			else{
				oldDirection = 1;
				direction = 2;
			}
		}
		if(direct == 2){
			if(i >= 6){
				oldDirection = 2;
				direction = 2;
				return;
			}
			if( i >= 3 && i < 6){
				oldDirection = 2;
				direction = 1;
				return;
			}
			if( i >= 0 && i < 3){
				oldDirection = 2;
				direction = 0;
				return;
			}
		}
		
	}
	
	
	
	public int[][] randomMap(){
		return map;
	}
}
