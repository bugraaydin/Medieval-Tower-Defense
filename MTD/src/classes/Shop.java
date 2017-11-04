package classes;

//import java.awt.event.*;
import java.awt.image.*;
import java.io.IOException;

import javax.imageio.ImageIO;

import Tower.*;
public class Shop {
	
	public int itemCount = 2;//////////SET TOWER COUNT IN SHOP CORRECTLY !
	public String[] towersInShop = new String[5];
	public BufferedImage[] itemImage;
	//towersInShop = {"a","b"};
	public Tower towerToPlace;
	public boolean towerBought = false;
	
	public Shop()
	{
		itemImage = new BufferedImage[2];
		
		try {
			itemImage[0] = ImageIO.read(getClass().getResourceAsStream("/tower-defense-turrets/turret-1-1.png"));
		}	catch(IOException exc) {
				exc.printStackTrace();
		}
		try {
			itemImage[1] = ImageIO.read(getClass().getResourceAsStream("/tower-defense-turrets/turret-2-1.png"));
		}	catch(IOException exc) {
				exc.printStackTrace();
		}
		//towerToPlace = new Tower();
	}
	public void BuyTower(int mouseX, int playerGold)
	{
		setShopItems();
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
		//towersInShop[0] = "a";
		
	}
}
