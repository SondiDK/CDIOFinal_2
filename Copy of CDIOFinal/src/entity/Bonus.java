package entity;

import java.awt.Color;

import desktop_resources.GUI;

public class Bonus extends Field {
	
	private int tax;
	
	public Bonus (String fieldName, Color backgroundColor, String description, int tax){
		super(fieldName, backgroundColor, description);
		this.tax = tax;
	}
	
	public void landOnField(Player player){
		
		GUI.showMessage("You have to pay your taxes to continue, please pay: " + tax);
		player.updateBalance(-tax);
		
	}

}
