package entity;

import java.awt.Color;

public class Jail extends Field {

	public Jail(String fieldName, Color backgroundColor, String description) {
		super(fieldName, backgroundColor, description);

	}

	@Override
	public void landOnField(Player player) {

		player.setJailed(true);
		player.getPiece().setPlacement(11);
		
	}

	
	
}
