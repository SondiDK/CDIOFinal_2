package entity;

import java.awt.Color;

public class Empty extends Field{
	
	//Kontruktør
	public Empty(  String fieldName, Color backColor, String description) {
		super( fieldName, backColor, description);
		
	}
	
	@Override
	public void landOnField(Player player) {
		
		
	}
	
}
