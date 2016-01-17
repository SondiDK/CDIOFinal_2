package entity;

import java.awt.Color;

import desktop_resources.GUI;

public abstract class Ownable extends Field {

	private int price;
	protected int rent;
	protected Player owner;
	private boolean isOwned;

	//konstruktor
	public Ownable( String fieldName, int price, Color backColor, String description, Player owner, boolean isOwned, int rent) {
		super(fieldName, backColor, description);
		this.price = price;
		this.owner = owner;
		this.isOwned = false;
		this.rent = rent;
	}
	// abstrakt klasse som defineres i de forskellige nedavninger
	public abstract int getRent();
	
	public boolean askBuy(Player player){
		boolean result = false;
		String answer = GUI.getUserButtonPressed("Does " + player.getPiece().getPlayerName()+  " want to buy " +getFieldName() + "?" ,"Yes","No");
		//tjekker om spilleren har penge og vil koebe
		if(answer.equals("Yes")&& player.getBalance()>= getPrice()){
			System.out.println(result);
			setOwner(player);
			player.updateBalance(-getPrice());
			result = true;
			System.out.println(result);
		}
		return result;
	}
	
	

	//get og set metoder 
	public int getPrice() {return price;}
	public void setPrice(int price) {this.price = price;}
	public Player getOwner () {return owner;}
	public String getOwnerName( ){return owner.getPiece().getPlayerName();}
	public void setOwner (Player owner) {setOwned(true);this.owner = owner;}
	public boolean getOwned() {return isOwned;}
	public void setOwned(boolean isOwned) {this.isOwned = isOwned;}
	
}