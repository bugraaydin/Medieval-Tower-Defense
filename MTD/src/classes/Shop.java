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
		itemCount = 8;
		towersInShop = new String[itemCount];
		setShopItems();
	}
	public void buyTower(int mouseX, int mouseY, int playerGold)
	{

		//System.out.println("Buy tower called");
		if((mouseX > 0 && mouseX<60) && (mouseY < 636 && mouseY > 576))
		{
			System.out.println("IN BUY ARCANE TOWER MODE");
			if(playerGold>100)
			{
				towerToPlace = new ArcaneTower();
				towerBought = true;
				return;
			}
			else
				return;
		}
		else if((mouseX>60&&mouseX<120) && (mouseY < 636 && mouseY > 576) )
		{
			System.out.println("BUY ARROW TOWER CALLED");
			if(playerGold>150)
			{
				towerToPlace = new ArrowTower();
				towerBought = true;
				return;
			}
			else
				return;
		}
		else if((mouseX>120&&mouseX<180) && (mouseY < 636 && mouseY > 576))
		{
			System.out.println("BUY Balista TOWER CALLED");
			if(playerGold>150)
			{
				towerToPlace = new BalistaTower();
				towerBought = true;
				return;
			}
			else
				return;
		}
		else if((mouseX>180&&mouseX<240) && (mouseY < 636 && mouseY > 576))
		{
			System.out.println("BUY CANNON TOWER CALLED");
			if(playerGold>150)
			{
				towerToPlace = new CannonTower();
				towerBought = true;
				return;
			}
			else
				return;
		}
		else if((mouseX>0&&mouseX<60) && (mouseY < 696 && mouseY > 636))
		{
			System.out.println("BUY ICE TOWER CALLED");
			if(playerGold>150)
			{
				towerToPlace = new IceTower();
				towerBought = true;
				return;
			}
			else
				return;
		}
		else if((mouseX>60&&mouseX<120) && (mouseY < 696 && mouseY > 636))
		{
			System.out.println("BUY MORTAr TOWER CALLED");
			if(playerGold>150)
			{
				towerToPlace = new MortarTower();
				towerBought = true;
				return;
			}
			else
				return;
		}
		else if((mouseX>120&&mouseX<180) && (mouseY < 696 && mouseY > 636))
		{
			System.out.println("BUY OIL TOWER CALLED");
			if(playerGold>150)
			{
				towerToPlace = new OilTower();
				towerBought = true;
				return;
			}
			else
				return;
		}
		else if((mouseX>180&&mouseX<240) && (mouseY < 696 && mouseY > 636))
		{
			System.out.println("BUY Poison TOWER CALLED");
			if(playerGold>150)
			{
				towerToPlace = new PoisonTower();
				towerBought = true;
				return;
			}
			else
				return;
		}
		return;
	}
	
	public void setShopItems()
	{
		itemImage = new BufferedImage[itemCount];
		try {
			itemImage[0] = ImageIO.read(getClass().getResourceAsStream("/images/shop/tower_icons/arcane_tower_shop.png"));
		}	catch(IOException exc) {
				exc.printStackTrace();
		}
		try {
			itemImage[1] = ImageIO.read(getClass().getResourceAsStream("/images/shop/tower_icons/arrow_tower_shop.png"));
		}	catch(IOException exc) {
				exc.printStackTrace();
		}
		try {
			itemImage[2] = ImageIO.read(getClass().getResourceAsStream("/images/shop/tower_icons/balista_tower_shop.png"));
		}	catch(IOException exc) {
				exc.printStackTrace();
		}
		try {
			itemImage[3] = ImageIO.read(getClass().getResourceAsStream("/images/shop/tower_icons/cannon_tower_shop.png"));
		}	catch(IOException exc) {
				exc.printStackTrace();
		}
		try {
			itemImage[4] = ImageIO.read(getClass().getResourceAsStream("/images/shop/tower_icons/ice_tower_shop.png"));
		}	catch(IOException exc) {
				exc.printStackTrace();
		}
		try {
			itemImage[5] = ImageIO.read(getClass().getResourceAsStream("/images/shop/tower_icons/mortar_tower_shop.png"));
		}	catch(IOException exc) {
				exc.printStackTrace();
		}
		try {
			itemImage[6] = ImageIO.read(getClass().getResourceAsStream("/images/shop/tower_icons/oil_tower_shop.png"));
		}	catch(IOException exc) {
				exc.printStackTrace();
		}
		try {
			itemImage[7] = ImageIO.read(getClass().getResourceAsStream("/images/shop/tower_icons/poison_tower_shop.png"));
		}	catch(IOException exc) {
				exc.printStackTrace();
		}
	}
	
	public int getItemCount(){
		return itemCount;
	}
}
