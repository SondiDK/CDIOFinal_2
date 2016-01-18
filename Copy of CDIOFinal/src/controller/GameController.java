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

	public void RunGame(){

		bs = new BoardSupport();
		gc = new GUIController(bs.getGb());
		dc = new DiceCup();

		gc.startGame();	
		showMessage("Welcome to the monopoly!");
		// Finder ud af hvor mange spillere der er, og returnere det som en int
		int numberOfPlayers = gc.GUIbuttons5("How  many players?", "2", "3", "4", "5", "6");

		// Placere spillere ind i et array, og laver spillere tilsvarende til antallet Bruger har angivet
		playerArray = new Player[numberOfPlayers];
		for (int i = 0 ; i <= numberOfPlayers - 1 ; i++) {
			playerArray[i] = new Player();
		}

		//kører spilrunden for hver spiller så længe, der ikke er en vinder og springer dig over hvis du bankerot
		while(!winner){
			for(int j=0;j<playerArray.length;j++){
				if(playerArray[j].isBankrupt())
					continue;
				if(!winner){
					showMessage("Player " + (j+1) +  " click OK to roll");	
					playRound(playerArray[j]);
					if ( playerArray[j].isDoubleTurn() )
						j--;
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

			//saetter ternings ï¿½jne pï¿½ GUI
			gc.setDices(dc);
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

		//hvis du er i faengsel bliver dette udført
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

			//afgoerer hvad der sker nåt du lander på et felt
			bs.getGb().getField(p.getPiece().getPlacement()-1).landOnField(p);

			//chekcer om player lander på chance kort
			gc.showChance(bs.chanceDraw(p, p.getPiece().getPlacement()-1));

			removePiece(p);
			movePiece(p,p.getPiece().getPlacement());
			updateScores();

			// tjekker om du kan koebe huse 
			if(!p.isJailed()&& bs.houseChecker(p) )
				houseProcess(p);
		}
		updateScores();

		//tjekker om nogle er gï¿½et bankerot og tï¿½lkler 1 om hvis de er
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
			answer = gc.showMesseageYesNo("Does" + p.getPiece().getPlayerName() + "want a house?", "Yes", "No");

			if(answer.equals("Yes")){
				int number = askFieldNum("Which field do you want to  add a house on " + p.getPiece().getPlayerName())-1;
				System.out.println(number);

				Field[] f = bs.getGb().getFields();
				Field currentField = f[number];
				Houseable h = ((Houseable) currentField);
				//Checker om du ejer feltet du vil koebe huse på
				if(bs.buyHouse(p, number)){

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
					showMessage("You dont own the complete series!");
					System.out.println(bs.getGb().getField(number));
				}
			}
		}while(answer.equals("yes"));
	}
	public void showMessage(String text){
		gc.showMessage(text);
	}
	//tjekker om  spilleren er gået bankerot og tjekker om der kun er 1 spiller tilbage = game over
	public void bankruptChecker(Player p){

		if(p.getBalance()<0){
			p.setBankrupt(true);
			showMessage(p.getPiece().getPlayerName() + "is dead");
			bankruptCounter++;
			gc.remooveCar(p);
		}

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

		if (p.isJailed() && dc.getDice(1) == dc.getDice(2)) {
			showMessage("You got out!");
			p.getPiece().setPlacement(p.getPiece().getPlacement()+dc.getSum());
			removePiece(p);
			movePiece(p,p.getPiece().getPlacement());
			p.setJailed(false);
		}


		if(p.getJailrounds()==3){
			showMessage("You couldnt get out after 3 tries, so you have to pay 1000$");
			p.updateBalance(-1000);
			p.setJailed(false);
			removePiece(p);
			movePiece(p,p.getPiece().getPlacement());
			p.getPiece().setPlacement(p.getPiece().getPlacement()+dc.getSum());
			p.setailrounds(0);
		}

		else if(p.isJailed()){
			showMessage("Try again");

		}
	}


	//updater player score for alle spiller
	public void updateScores () {
		for(int j=0;j<playerArray.length;j++){
			gc.updatesPlayerScore(playerArray[j]);
		}
	}
}