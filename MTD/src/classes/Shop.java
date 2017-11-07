package classes;

//import java.awt.event.*;
import java.awt.image.*;
import java.io.IOException;

import javax.imageio.ImageIO;

import Tower.*;
public class Shop {
	

	private int itemCount;
	private String[] towersInShop;
	
	public BufferedImage[] itemImage;
	public Tower towerToPlace;
	public boolean towerBought = false;
	private String backgroundImageBuffer = "/images/shop/shopBackground.jpg";
	public BufferedImage backgroundImage; 
	
	public Shop()
	{
		try {
			backgroundImage = ImageIO.read(getClass().getResourceAsStream(backgroundImageBuffer));
		}	catch(IOException exc) {
				exc.printStackTrace();
		}
		itemCount = 2;
		towersInShop = new String[itemCount];
		setShopItems();
	}
	public void BuyTower(int mouseX, int playerGold)
	{

		//System.out.println("Buy tower called");
		if(mouseX<60)
		{
			System.out.println("IN BUY ARROW TOWER MODE");
			if(playerGold>100)
			{
				towerToPlace = new Tower(TowerType.Arrow);
				towerBought = true;
				return;
				//return new Tower(TowerType.Arrow);
			}
			else
				return;
		}
		else if(mouseX>60&&mouseX<120)
		{
			System.out.println("BUY CANNON TOWER CALLED");
			if(playerGold>150)
			{
				towerToPlace = new Tower(TowerType.Cannon);
				towerBought = true;
				return;
				//return new Tower(TowerType.Cannon);
			}
			else
				return;
		}
		/*else if(mouseX>160&&mouseX<240)
		{
			System.out.println("BUY FIRE TOWER CALLED");
			if(playerGold>150)
			{
				towerToPlace = new Tower(TowerType.Fire);
				towerBought = true;
				return;
				//return new Tower(TowerType.Fire);
			}
			else
				return;
		}*/
		
		return;
	}
	
	public void setShopItems()
	{
		itemImage = new BufferedImage[itemCount];
		
		try {
			itemImage[0] = ImageIO.read(getClass().getResourceAsStream("/images/shop/tower_icons/tower1.png"));
		}	catch(IOException exc) {
				exc.printStackTrace();
		}
		try {
			itemImage[1] = ImageIO.read(getClass().getResourceAsStream("/images/shop/tower_icons/tower2.png"));
		}	catch(IOException exc) {
				exc.printStackTrace();
		}
		//towerToPlace = new Tower();
		
	}
	
	public int getItemCount(){
		return itemCount;
	}
}
