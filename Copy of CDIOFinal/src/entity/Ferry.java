package entity;

import java.awt.Color;



public class Ferry extends Ownable {

	public Ferry( String fieldName, Color backColor, String description, int price, Player owner, boolean isowned, int rent) {
		super(fieldName, price, backColor, description, owner, isowned, rent);
	}

	//Bestemmelse af rent for ferry feltet
	@Override
	public int getRent() {
		rent = (int) (500*(Math.pow(2, getOwner().getFerryCount() - 1 )));

		return rent;
	}

	//LandOnField metode
	@Override
	public void landOnField(Player player) {

		//hvis feltet ikke er ejet
		if(!getOwned()){
			if(askBuy(player)){
				System.out.println(player.getPiece().getPlayerName() + " just bought " + getFieldName());
				getOwner().addFerriesOwned();
			}
		}
		else{
			if(getOwner().isBankrupt()){
				if(askBuy(player)){
					System.out.println(player.getPiece().getPlayerName() + " just bought " + getFieldName());
					System.out.println("old owner is ded LOL");
				}
			}
			else{
				getOwner().updateBalance(getRent());
				player.updateBalance(-getRent());
				System.out.println(player.getPiece().getPlayerName() + " just payed " + getOwnerName());
			}
		}
	}	
}
