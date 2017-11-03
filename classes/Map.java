package classes;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;




public class Map {
	
	BufferedImage mapImage;
	
	public Map(){
	
			try{
				mapImage = ImageIO.read(new File("C:\\Users\\Bugra\\Desktop\\Masaüstü\\workspace\\MTD\\src\\map.png"));
			}catch(IOException e){}

		
	
	}



}
