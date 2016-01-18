package entity;

public class Deck {

	private  Cards[] deck;
	
	//konstruktor
	public Deck () {
		
		//array der indeholder alle forskellige kort
		this.deck = new Cards[] {
				new Cards("Du har vundet 500 kr. i klasselotteriet, gz", 500, 1),
				new Cards("Du har vundet 500 kr. i klasselotteriet, gz", 500, 1),
				new Cards("Dine hjemmeplantede grøntsager er blevet solgt, modtag 200 af banken", 200, 1),
				new Cards("Tillykke! Du har fået 1000 kr. af staten", 1000, 1),
				new Cards("Tillykke! Du har fået 1000 kr. af staten", 1000, 1),
				new Cards("Endelig fik du solgt dine gamle møbler, modtag 1000 kr.", 1000, 1),
				new Cards("Kommunen havde regnet forkert, modtag 3000 kr.", 3000, 1),
				new Cards("Dine aktier har givet gevinst, 1000 kr.", 1000, 1),
				new Cards("Dine aktier har givet gevinst, 1000 kr.", 1000, 1),
				new Cards("Dine aktier har givet gevinst, 1000 kr.", 1000, 1),
				new Cards("Dyrtiden er forbi, modtag 1000 kr.", 1000, 1),
				new Cards("Dine tips gik hjem, du har vundet 1000 kr.", 1000, 1),
				new Cards("Du købte øl for 200kr.", -200, 1),
				new Cards("Du skal have nye dæk på din bil, betal 1000", -1000, 1),
				new Cards("Du kører al al for hurtig, det koster dig 1000 kr. i bøde", -1000, 1),
				new Cards("Din bil er blevet beskidt og skal vaskes, det koster 300 kr.", -1000, 1),
				new Cards("Du kørte galt og din bil skal repareres, betal 3000 kr.", -3000, 1),
				new Cards("Du kørte ind i en hjort og nu skal din bil repareres, betal 3000 kr.", -3000, 1),
				new Cards("Din bilforsikring skal betales, betal 1000 kr.", -1000, 1),
				new Cards("Du har parkeret din bil ulovligt, betal 200 kr.", -200, 1),
				new Cards("Din cigaretsmulig gik ikke, betal 200 kr. i told", -200, 1),
				new Cards("Din tandlægeregning er kommet, betal 2000 kr.", -2000, 1),				
				
				new Cards("Ryk til start", 1, 2),
				new Cards("Ryk til start", 1, 2),
				new Cards("Ryk til Rådhuspladsen", 40, 2),
				new Cards("Ryk til mols-linen", 16, 2),
				new Cards("Ryk til Frederiksberg", 38, 2),
				new Cards("Ryk til Grønningen", 25, 2),
				new Cards("Ryk til Vimmelskaftet", 33, 2),
				new Cards("Ryk til Strandvejen", 20, 2),
				
				new Cards("Ryk 3 felter tilbage", -3, 3),
				new Cards("Ryk 3 felter tilbage", -3, 3),
				new Cards("Ryk 3 felter frem", 3, 3),
		};
		
	}

	
	//get & set metoder
	public int getDeckLength () {
		return deck.length;
	}
		
	public Cards getCard  (int deckNum){
		return  deck[deckNum];
	}
	
}
