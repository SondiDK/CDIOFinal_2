package entity;

public class Cards {
	
	//Attributter
	private String description;
	private int amount;
	private int type;
	
	//konstruktor
		public Cards(String description, int amount, int type) {
			this.description = description;
			this.amount = amount;
			this.type = type;
		}
		
		//bestemmer hvilket salgs kort vi har fat i
		public void chance ( Player player) {
			
			//forskellige typer kort
			switch ( type ) {
			//faa eller betal penge
			case 1: 
				player.updateBalance(amount);
				break;
			//ryk brik til felt x
			case 2:
				player.getPiece().setPlacement(amount);
				break;
			//ryk brik x felter 
			case 3:
				player.getPiece().addPlacement(amount);
			}
		}
		
		//get & set metoder
		public String getDescription() {return description;}
		public void setDescription(String description) {this.description = description;}
}
