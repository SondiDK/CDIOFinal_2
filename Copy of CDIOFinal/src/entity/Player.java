package entity;

public class Player {

	// Initialiserer attributter
			private static int maxPlayers = 0;
			private Account account = new Account();
			private Piece playerPiece;
			private boolean isBankrupt;
			private int ferryCount;
			private int sodaCount;
			private boolean isJailed;
			private int jailrounds;
			private int [] serialChecker = new int[8];
			private boolean doubleTurn; 			
		
			// Konstruktoer tae�ller maxspillere 1 op og en brik bliver tildelt med et spillernummer
			public Player(){
				++maxPlayers;
				playerPiece = new Piece(maxPlayers);
				setBalance(account.getBalance());
			}
			// Constructor for testing purposes
			public Player(String name, int playernumber, int startfunds) {
				playerPiece = new Piece(playernumber);
				account.setBalance(startfunds);
			}
			
	
			public Piece getPiece(){ return this.playerPiece; }
			public int getFerryCount() { return ferryCount;	}
			public int getSodaCount() { return sodaCount;	}
			public int getBalance(){ return account.getBalance(); }
			public int updateBalance(int updating){	return account.addBalance(updating); }
			public boolean isBankrupt() { return isBankrupt; }
			public void setBankrupt(boolean isBankrupt) { this.isBankrupt = isBankrupt;	}
			public void setBalance(int value){ account.setBalance(value); }
			public void addSodaOwned() { this.sodaCount++; }
			public void addFerriesOwned() { this.ferryCount++; }
			public boolean isJailed() {return isJailed;}
			public void setJailed(boolean isJailed) {this.isJailed = isJailed;}
			
			public int getSpecificSerialChecker(int number) {
				return serialChecker[number];
			}
			
			public int[] getserialChecker() {
				
				return serialChecker;
			}
			public void addSpecificSerialChecker(int number) {
				 serialChecker[number]++;
			}
			public int getJailrounds() {
				return jailrounds;
			}
			public void addJailrounds() {
				this.jailrounds ++;
			}
			public void setailrounds(int jailrounds) {
				this.jailrounds = jailrounds;
			}
			public boolean isDoubleTurn() {
				return doubleTurn;
			}
			public void setDoubleTurn(boolean doubleTurn) {
				this.doubleTurn = doubleTurn;
			}
}
