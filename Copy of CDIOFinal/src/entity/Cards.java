package entity;

public class Cards {
	
	//Attributter
	private String description;
	private int amount;
	private int type;
	
	//type 1(+ & - beloeb) & 2(ryk til bestemt felt)
		public Cards(String description, int amount, int type) {
			this.description = description;
			this.amount = amount;
			this.type = type;
		}
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
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
}
