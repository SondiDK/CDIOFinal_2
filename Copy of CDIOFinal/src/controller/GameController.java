package controller;

import controller.GUIController;


import entity.DiceCup;
import entity.Field;
import entity.Houseable;
import entity.Player;

public class GameController {
	private  GUIController gc;
	private  DiceCup dc;
	public  boolean  winner = false;
	private  Player playerArray[];
	private BoardSupport bs;
	private int bankruptCounter;
	//this is for test
	boolean testingmode = true;

	//Starter spillet
	public void RunGame(){

		//opretter noedtvendige objekter
		bs = new BoardSupport();
		gc = new GUIController(bs.getGb());
		dc = new DiceCup();

		gc.startGame();	
		showMessage("Welcome to group 39's monopoly game!");
		// Finder ud af hvor mange spillere der er, og returnere det som en int
		int numberOfPlayers = gc.GUIbuttons5("How  many players?", "2", "3", "4", "5", "6");

		// Placere spillere ind i et array, og laver spillere tilsvarende til antallet Bruger har angivet
		playerArray = new Player[numberOfPlayers];
		for (int i = 0 ; i <= numberOfPlayers - 1 ; i++) {
			playerArray[i] = new Player();
		}
		// for bankerot rest
//		for (int i = 1; i < playerArray.length; i++) {
//			playerArray[i].setBalance(2500);
//		}

		//k�rer spilrunden for hver spiller s� l�nge, der ikke er en vinder og springer dig over hvis du bankerot
		while(!winner){
			for(int j=0;j<playerArray.length;j++){
				if(playerArray[j].isBankrupt())
					continue;
				if(!winner){
					showMessage("Player " + (j+1) +  " click OK to roll");	
					playRound(playerArray[j]);
					if ( playerArray[j].isDoubleTurn() ){
						playerArray[j].setDoubleTurn(false);
						j--;
					}	
				}
			}
		}
	}

	//styrer hvad der sker i en runde
	public void playRound(Player p){

		if(!p.isJailed())
			removePiece(p);

		//standard runde
		if(!testingmode && !p.isJailed()){
			//kaster med terning
			dc.RollDices();

			//saetter ternings oejne paa GUI
			gc.setDices(dc);
			//hvis player slaar to ens = ekstra tur
			if(dc.getDice(1) == dc.getDice(2))
				p.setDoubleTurn(true);
			// tilfoejer slaget til spillerens totale sum
			p.getPiece().addPlacement(dc.getSum()); 
			p.getPiece().setLastDiceSum(dc.getSum());
			//rykker spillerens brik, saa langt som spilleren har saaet
			movePiece(p,p.getPiece().getPlacement());
		}

		//test runde
		else if (testingmode&& !p.isJailed()){
			int num =  askFieldNum("**TEST MODE**, CHOOSE A FIELD");
			movePiece(p,num);
			p.getPiece().setPlacement(num); 
		}

		//hvis du er i faengsel bliver dette udf�rt
		prisonMode(p);

		if(!p.isJailed()){
			//tjekker om spiller er passeret start
			if ( p.getPiece().isPassStart()) {
				p.updateBalance(4000);
				System.out.println("passere start");
				p.getPiece().setPassStart(false);
				updateScores();
			}

			showMessage(p.getPiece().getPlayerName()+" landed on " + bs.getGb().getField(p.getPiece().getPlacement()-1).getFieldName());

			//afgoerer hvad der sker naar du lander p� et felt
			bs.getGb().getField(p.getPiece().getPlacement()-1).landOnField(p);

			//chekcer om player lander p� chance kort
			gc.showChance(bs.chanceDraw(p, p.getPiece().getPlacement()-1));

			removePiece(p);
			movePiece(p,p.getPiece().getPlacement());
			updateScores();

			// tjekker om du kan koebe huse 
			if(!p.isJailed()&& bs.houseChecker(p) )
				houseProcess(p);
		}
		updateScores();

		//tjekker om nogle er g�et bankerot og t�lkler 1 om hvis de er
		bankruptChecker(p);
	}
	//flytter en spillers brik
	public  void movePiece(Player p, int field){
		gc.placePiece(p, field);
	}
	// fjerner en spillers brik
	public  void removePiece(Player p){
		gc.remooveCar(p);
	}
	public int askFieldNum(String text){
		return	gc.NumberAsk(text);
	}

	//Spoeger om nuvaerende spiller vil koebe huse
	public void houseProcess(Player p){
		String answer;

		//Bliver ved med at spoeger indtil man siger no
		do{
			answer = gc.showMesseageYesNo("Does " + p.getPiece().getPlayerName() + " want a house?", "Yes", "No");

			if(answer.equals("Yes")){
				int number = askFieldNum("Which field do you want to  add a house on " + p.getPiece().getPlayerName())-1;
				System.out.println(number);

				Field[] f = bs.getGb().getFields();
				Field currentField = f[number];

				//Checker om du ejer feltet du vil koebe huse p�
				if(bs.buyHouse(p, number)&& bs.houseChecker(p)&& currentField instanceof Houseable){
					Houseable h = ((Houseable) currentField);
					//houseAmount er antal huse du koeber i denne runde 
					int houseAmount = gc.setHouse(p,number+1,h.getHouseCount())-h.getHouseCount();

					//adder saa feltet ved hvor mange huse der er derpaa
					h.addHouseCount(houseAmount);

					if(h.getHouseCount()>5){
						h.addHouseCount(-houseAmount);
						showMessage("You can't buy that amount of houses!");
					}

					//Du betaler for de huse du koeber i denne runde
					p.updateBalance(-h.getHousePrice()*houseAmount);
					System.out.println(" houses"+h.getHouseCount());
				}
				//Hvis man ikke ejer feltet
				else{
					showMessage("You can't do that!");
					System.out.println(bs.getGb().getField(number));
				}
			}
		}while(answer.equals("Yes"));
	}
	public void showMessage(String text){
		gc.showMessage(text);
	}

	//tjekker om  spilleren er gaaet bankerot og tjekker om der kun er 1 spiller tilbage = game over
	public void bankruptChecker(Player p){

		//hvis player har negativ balance = bankrupt
		if(p.getBalance()<0){
			p.setBankrupt(true);
			showMessage(p.getPiece().getPlayerName() + "is dead");
			bankruptCounter++;
			gc.remooveCar(p);
		}
		//hvis der kun er en spiller tilbage sluttes spillet. der er fundet vinder
		if(bankruptCounter>=(playerArray.length-1)){
			winner =  true;
			showMessage("Game over!");
			gc.closeGame();
		}
	}
	//Naar spiller er i faengsel ser runden saadan ud
	public void prisonMode(Player p){
		if(p.isJailed()) {
			showMessage("You're in jail and have to get 2 of the same to get out - click OK to roll!");

			dc.RollDices();
			gc.setDices(dc);
			p.addJailrounds();
		}

		//hvis der slaaes to ens, kommer man ud af faengsel
		if (p.isJailed() && dc.getDice(1) == dc.getDice(2)) {
			showMessage("You got out!");
			p.getPiece().setPlacement(p.getPiece().getPlacement()+dc.getSum());
			removePiece(p);
			movePiece(p,p.getPiece().getPlacement());
			p.setJailed(false);
		}

		//hvis han ikke kan komme ud efter 3 fors�g
		if(p.getJailrounds()==3){
			showMessage("You couldnt get out after 3 tries, so you have to pay 1000$");
			p.updateBalance(-1000);
			p.setJailed(false);

			p.getPiece().setPlacement(p.getPiece().getPlacement()+dc.getSum());
			p.setailrounds(0);
			removePiece(p);
			movePiece(p,p.getPiece().getPlacement());
		}

		//Hvis player ikke slaar to ens i faengsel
		else if(p.isJailed()){
			showMessage("Better luck next time!");
		}
	}

	//updater player score for alle spiller
	public void updateScores () {
		for(int j=0;j<playerArray.length;j++){
			gc.updatesPlayerScore(playerArray[j]);
		}
	}
}

