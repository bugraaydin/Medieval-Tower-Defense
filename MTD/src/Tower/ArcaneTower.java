 package Tower;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ArcaneTower extends Tower{
	
	//public BufferedImage testImage;
	//private int scaleFactorX, scaleFactorY;
	public ArcaneTower(){
		super();
		setImage("/images/towers/arcane_tower.png");
		setDamage(10);
		setTowerRange(225);
		setAttackSpeed(25);
		setProjectileType(0);
		
		/**
		try {
			testImage = ImageIO.read(getClass().getResourceAsStream("/Sequences/Lightning/lightning_1_1.png"));
		}	catch(IOException exc) {
				exc.printStackTrace();
		}*/
	}
	
	/**
	public void setScaleFactors()
	{
		scaleFactorX = testImage.getWidth()/(this.getLocX() - getTarget().locX);
		scaleFactorY = testImage.getHeight()/(this.getLocY() - getTarget().locY);
	}
	
	public BufferedImage scale(BufferedImage sbi, int imageType, int dWidth, int dHeight, double fWidth, double fHeight) {
	    BufferedImage dbi = null;
	    if(sbi != null) {
	        dbi = new BufferedImage(dWidth, dHeight, imageType);
	        AffineTransform at = AffineTransform.getScaleInstance(fWidth, fHeight);
	    }
	    return dbi;
	}	
	
	public BufferedImage rotateMyImage()
	{
		// The required drawing location
		int drawLocationX = 50;
		int drawLocationY = 50;

		// Rotation information

		double rotationRequired = Math.toRadians (45);
		double locationX = testImage.getWidth() / 2;
		double locationY = testImage.getHeight() / 2;
		AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		return op.filter(testImage, null);
	}
	*/

}
