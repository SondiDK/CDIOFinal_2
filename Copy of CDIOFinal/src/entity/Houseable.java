package entity;

import java.awt.Color;



public class Houseable extends Ownable {

	//private int rent;
	private int serialNumber;
	//Hvad koster et hus på gruden
	private int houseprice;
	//Lejepris for antal huse
	private int house1;
	private int house2;
	private int house3;
	private int house4;
	private int hotel;
	private int houseCount  = 0;
	private int maxSeries;
	//private static int [] serialChecker = new int[8];

	public Houseable(String fieldName, Color backgroundColor, String description, int price,
			Player owner,  int rent, boolean isOwned, int serialNumber, int huspris, int hus1, int hus2, int hus3, int hus4, int hotel, int maxSeries) {
		super(fieldName, price, backgroundColor, description, owner, isOwned, rent);
		this.rent = rent; this.serialNumber = serialNumber; this.houseprice = huspris; this.house1 = hus1; this.house2 = hus2; this.house3 = hus3;
		this.house4 = hus4; this.hotel = hotel;
		this.setMaxSeries(maxSeries);
	}

	//LandOnField metode
	@Override
	public void landOnField(Player player) {
		//hvis feltet ikke er ejet
		if(!getOwned()){
			if(askBuy(player)){
				player.addSpecificSerialChecker(getSerialNumber()-1);
				System.out.println(player.getPiece().getPlayerName() + " just bought " + fieldName + this.owner+this);
				for (int i = 0; i < player.getserialChecker().length; i++) {
					System.out.println("serialcounterchecker: " + player.getSpecificSerialChecker(i));
				}
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
				if(owner.getSpecificSerialChecker(serialNumber-1)==maxSeries && houseCount == 0){
					player.updateBalance(-getRent()*2);
					getOwner().updateBalance(getRent()*2);
				}

				else{
					getOwner().updateBalance(getRent());
					player.updateBalance(-getRent());
					System.out.println(player.getPiece().getPlayerName() + " just payed " + getOwnerName());
				}
			}
		}
	}	

	
	@Override
	public int getRent() { 
		if(houseCount<1){
			return rent;
		}
		else{
			switch(houseCount){
			case 1: rent = house1;
			break;
			case 2: rent = house2;
			break;
			case 3: rent = house3;
			break;
			case 4: rent = house4;
			break;
			case 5: rent = hotel;
			}
			return rent;
		}
	}
	public int getSerialNumber() {return serialNumber;}

	public int getHousePrice(){return houseprice;}

	public int getRentHouse1(){return house1;}

	public int getRentHouse2(){return house2;}

	public int getRentHouse3(){return house3;}

	public int getRentHouse4(){return house4;}

	public int getRentHotel(){return hotel;}

	public int getHouseCount() {return houseCount;}

	public void addHouseCount(int amount) {
		this.houseCount += amount; 	
	}
	public int getMaxSeries() {return maxSeries;}

	public void setMaxSeries(int maxSeries) {this.maxSeries = maxSeries;}


	
}
