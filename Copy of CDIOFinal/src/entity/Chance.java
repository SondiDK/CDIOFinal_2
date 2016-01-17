package entity;

import java.awt.Color;

public class Chance extends Field {

	private int amount;
	
	//Konstruktor
	public Chance(String fieldName, Color backgroundColor, String description) {
		super(fieldName, backgroundColor, description);
	}
	

	
	@Override
	public void landOnField(Player player) {
		
		
		
	}

	public void setAmount( int amount) {
		this.amount = amount;
	}
	public int getAmount () {
		return this.amount;
	}
}

