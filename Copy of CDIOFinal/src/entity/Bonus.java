package entity;

import java.awt.Color;

import desktop_resources.GUI;

public class Bonus extends Field {
	
	//atributter
	private int tax;
	
	//konstruktor
	public Bonus (String fieldName, Color backgroundColor, String description, int tax){
		super(fieldName, backgroundColor, description);
		this.tax = tax;
	}
	
	//effect naar der landes på denne type felt
	public void landOnField(Player player){
		
		GUI.showMessage("You have to pay your taxes to continue, please pay: " + tax);
		player.updateBalance(-tax);
		
	}

}
