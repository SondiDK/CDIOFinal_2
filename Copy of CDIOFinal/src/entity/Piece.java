package entity;

public class Piece {

	// Initialiserer attribut
	private int playerNumber;
	private int placement = 1;
	private int lastDiceSum;
	private boolean passStart = false;

	// Konstruktoer giver brikken et spillernummer den hÃ¸rer til
	public Piece(int playerNumber){
		this.playerNumber = playerNumber;
	}

	public int getPlayerNumber(){
		// Returner hvilket spillernummer objektet(brik) hoerer til
		return this.playerNumber;
	}

	public String getPlayerName(){
		// Returner SpillerNavn baseret paa spillernummer
		return "Player " + playerNumber;
	}

	// spilleresns placering, der sikrer han ikke lander på et felt over 40
	public int getPlacement() {
		if(placement>40){
			placement -= 40;
			passStart = true;
		}
		else if (placement <= 0) {
			placement += 40;
		}
		return placement;
	}	
// get og set metoder
	public void addPlacement(int placement) {	this.placement += placement; }	
	
	public void setPlacement ( int placement ) {
		this.placement = placement;
	}
	public void setLastDiceSum(int lastDiceSum){ 
		this.lastDiceSum = lastDiceSum;
	}

	public int getLastDiceSum(){
		return lastDiceSum;
	}
	public boolean isPassStart() {
		return passStart;
	}
	public void setPassStart(boolean passStart) {
		this.passStart = passStart;
	}

}
