package entity;

import java.awt.Color;




public class Soda  extends Ownable {

	public Soda(String fieldName, Color backgroundColor, String description, int price,
			Player owner,  int rent, boolean isOwned) {

		super(fieldName, price, backgroundColor, description, owner, isOwned, rent);

	}

	@Override
	public int getRent() { return rent;	}
	public void setRent(int rent){ this.rent = rent; }

	@Override
	public void landOnField(Player player) {
		//hvis feltet ikke er ejet
		if(!getOwned()){
			//tjekker om spilleren har penge og vil købe
			if(askBuy(player)){
				System.out.println(player.getPiece().getPlayerName() + " just bought " + getFieldName());
				player.addSodaOwned();
				System.out.println(player.getSodaCount());
				System.out.println("lol");
			}
		}
		//hvis ejeren er gået bankerot, kan spilleren købe hans grund
		else{
			if(getOwner().isBankrupt()){
				if(askBuy(player)){
					System.out.println(player.getPiece().getPlayerName() + " just bought " + getFieldName());
					System.out.println("old owner is ded LOL");
				}
			}
			else{
				System.out.println("owner count" + owner.getSodaCount());
				int rent = player.getPiece().getLastDiceSum()*owner.getSodaCount()*getRent();
				System.out.println("rent" +  rent);
				player.updateBalance(-rent);
				getOwner().updateBalance(rent);
			}
		}
	}
}
