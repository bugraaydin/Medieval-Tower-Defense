package classes;

import java.awt.Graphics;
//import java.awt.event.*;
import java.awt.image.*;
import java.io.IOException;

import javax.imageio.ImageIO;

import Tower.*;
public class Shop {
	

	private int itemCount;
	private BufferedImage[] itemImage;
	private Tower towerToPlace;
	private boolean towerBought = false;
	private String backgroundImageBuffer;
	private BufferedImage backgroundImage; 
	
	public Shop()
	{
		backgroundImageBuffer = "/images/shop/shopBackground.jpg";
		try {
			backgroundImage = ImageIO.read(getClass().getResourceAsStream(backgroundImageBuffer));
		}	catch(IOException exc) {
				exc.printStackTrace();
		}
		itemCount = 8;
		setShopItems();
	}
	public void buyTower(int mouseX, int mouseY, int playerGold)
	{
		if((mouseX > 0 && mouseX<60) && (mouseY < 636 && mouseY > 576))
		{
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
	//GETTERS
	public int getItemCount(){
		return itemCount;
	}
	public boolean getTowerBought(){
		return towerBought;
	}
	public Tower getTowerToPlace(){
		return towerToPlace;
	}
	//SETTERS
	public void setTowerBought(boolean inp){
		towerBought = inp;
	}
	public void draw(Graphics g){
		g.drawImage(backgroundImage,0,576,null);
		g.drawImage(itemImage[0],0,576,null);
		g.drawImage(itemImage[1],60,576,null);
		g.drawImage(itemImage[2],120,576,null);
		g.drawImage(itemImage[3],180,576,null);
		g.drawImage(itemImage[4],0,636,null);
		g.drawImage(itemImage[5],60,636,null);
		g.drawImage(itemImage[6],120,636,null);
		g.drawImage(itemImage[7],180,636,null);
	}
}
