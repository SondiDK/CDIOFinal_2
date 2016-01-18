package controller;

import java.awt.Color;



import desktop_codebehind.Car;
import desktop_fields.Field;
import desktop_fields.Street;
import desktop_resources.GUI;
import entity.DiceCup;
import entity.GameBoard;
import entity.Player;

public class GUIController {

	private GameBoard g;	
	private static Car[] carArray;
	// Alle biler instantieres fra starten istedet for at k√∏re afh√¶ngigt af antal spillere
	private Car car1 = setCar(Color.ORANGE, Color.RED);
	private Car car2 = setCar(Color.WHITE, Color.BLACK);
	private Car car3 = setCar(Color.BLUE, Color.GRAY);
	private Car car4 = setCar(Color.PINK, Color.GREEN);
	private Car car5 = setCar(Color.CYAN, Color.BLACK);
	private Car car6 = setCar(Color.WHITE, Color.MAGENTA);

	GUIController(GameBoard g){
		this.g = g;
	}

	public Street getFieldValues(int iterator){
		return new Street.Builder()
				.setTitle(g.getField(iterator).getFieldName())
				.setSubText("" + (iterator+1) + "")
				.setBgColor(g.getField(iterator).getBackgroundColor())
				.setDescription(g.getField(iterator).getDescription())
				.build();
	}

	public void startGame(){

		// Koden til felterne
		Field[] fields = new Field[40];
		for(int i = 0;i < fields.length;i++){
			fields[i] = getFieldValues(i);
		}
		GUI.create(fields);
	}

	public Car setCar(Color c1, Color c2){

		// Laver et nyt objekt af typen Car og returner dette
		return new Car.Builder()
				.typeTractor()
				.patternHorizontalDualColor()
				.primaryColor(c1)
				.secondaryColor(c2)
				.build();
	}

	//sender en besked og knaptekster der spÔøΩrger om hvor mange spillere der skal med
	public int GUIbuttons5(String beskedtekst, String knaptekst1, String knaptekst2, String knaptekst3, String knaptekst4, String knaptekst5){
		String players = 	GUI.getUserButtonPressed(beskedtekst, knaptekst1, knaptekst2, knaptekst3, knaptekst4, knaptekst5);
		int pn = Integer.parseInt(players);

		for(int i = 0; i<=pn-1 ;i++){
			carArray = new Car[]{car1,car2,car3,car4,car5,car6};
			GUI.addPlayer("Player " + (i+1),30000,carArray[i]);
		}
		return pn ;
	}

	//updater spillerscore
	public void updatesPlayerScore(Player player){
		GUI.setBalance(player.getPiece().getPlayerName(), player.getBalance());
	}

	//sÔøΩtter terninger
	public void setDices(DiceCup dicecup){
		GUI.setDice(dicecup.getDice(1), dicecup.getDice(2));
	}
	//placerer brik
	public void placePiece(Player p, int field){
		GUI.setCar(field, p.getPiece().getPlayerName());

	}
	//viser besked
	public void showMessage(String besked){
		GUI.showMessage(besked);
	}
	// fjener brik
	public void RemovePiece(Player p, int field){
		// removes car 
		GUI.removeCar(field, p.getPiece().getPlayerName());
	}

	public void remooveCar(Player p){
		GUI.removeAllCars(p.getPiece().getPlayerName());
	}
	//slutter brik

	//tilf¯jer hus til en grund og, hvis der er 5 et hotel
	public int setHouse(Player p, int field, int houseCount){
		int number = (GUI.getUserInteger("How many?", 1, 5))+houseCount;
		GUI.setHouses(field, number);
		if(number==5)
			GUI.setHotel(field, true);
		return number;
	}

	//sp¯rger om et nummer	
	public int NumberAsk(String text){

		int fieldNumber = GUI.getUserInteger(text);
		return fieldNumber;	 
	}

	//Sp¯rger og givet 2 svarmuligheder
	public String showMesseageYesNo(String question, String answer1, String answer2){
		return GUI.getUserButtonPressed(question,answer1,answer2);
	}
	// lukker gui'en
	public void closeGame(){
		GUI.close();
	}
	// viser chancekords beskrivelse
	public void showChance(String descrip){
		GUI.displayChanceCard(descrip);
	}
}