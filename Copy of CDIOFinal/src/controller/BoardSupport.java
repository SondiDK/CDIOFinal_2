package controller;

import entity.Chance;
import entity.Deck;
import entity.Field;
import entity.GameBoard;
import entity.Houseable;
import entity.Player;

public class BoardSupport {

	private GameBoard gb;
	private Deck d;

	public BoardSupport() {
		gb = new GameBoard();
		d = new Deck();
	}

	//checker om player ejer hele serien af paagaeldende felt
	public boolean buyHouse(Player p, int feltNum){
		System.out.println("buyHouse");
		boolean result= false;
		Field[] f = gb.getFields();
		Field currentField = f[feltNum];
		System.out.println(currentField.getFieldName() + currentField);

		if (currentField instanceof Houseable){
			System.out.println("currentfield=houseable");

			Houseable h = ((Houseable) currentField);
			System.out.println(h.getOwned());

			Player owner = h.getOwner();

			System.out.println("player" + p.getPiece().getPlayerName());
			System.out.println(owner);
			System.out.println("Current series owned" + p.getSpecificSerialChecker(h.getSerialNumber()-1));
			System.out.println("max series ownable" + h.getMaxSeries());

			if(owner == p && p.getSpecificSerialChecker(h.getSerialNumber()-1)==h.getMaxSeries()){
				System.out.println("we made it in");
				result =  true;
			}
		}
		return result;
	}
	public GameBoard getGb() {	return gb;}

	//Hvis man er landet paa et chance felt, traekkes et chance kort
	public String chanceDraw(Player p, int feltNum){

		Field[] f = gb.getFields();
		Field currentField = f[feltNum];

		if (currentField instanceof Chance) {

			int randomNum = (int) (Math.random()*d.getDeckLength()-1);
			//til test, for at vaelge bestemt kort
			//randomNum = 16;

			d.getCard(randomNum).chance(p);
			return "" + d.getCard(randomNum).getDescription();
		}
		else 
			return "";
	}

	//Tjekker om player har mulighed for at koebe hus mindst et sted
	public boolean houseChecker(Player p){
		boolean houseLicense = false;

		Field[] f = gb.getFields();

		for (int i = 0; i <f.length; i++) {

			Field currentFields = f[i];
			if(currentFields instanceof Houseable){
				Houseable h =((Houseable) currentFields);

				Player owner = h.getOwner();
				if(owner == p && p.getSpecificSerialChecker(h.getSerialNumber()-1)==h.getMaxSeries()  ){

					houseLicense = true;
				}	
			}
		}
		return houseLicense;
	}
}
