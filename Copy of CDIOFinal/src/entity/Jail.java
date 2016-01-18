package entity;

import java.awt.Color;

public class Jail extends Field {

	public Jail(String fieldName, Color backgroundColor, String description) {
		super(fieldName, backgroundColor, description);

	}

	@Override
	public void landOnField(Player player) {
//places the player in jail and sets jail to true for the player
		player.setJailed(true);
		player.getPiece().setPlacement(11);
		
	}

	
	
}
