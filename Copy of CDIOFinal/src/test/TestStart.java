package test;

import org.junit.*;

import entity.Player;

public class TestStart {
	
	//Entities
	private Player p1;

	@Before
	public void setUp(){	
		this.p1 = new Player("Bent", 1, 30000);
	}
	
	@Test
	public void testPassStart(){
		int expected = 30000;
		int actual = p1.getBalance();
		Assert.assertEquals(expected, actual);

		p1.getPiece().setPlacement(35);
		
		System.out.println(p1.getPiece().getPlacement());
		
		//K�rer getPlacement efterf�lgende for at f� den til at opdatere ens placement, alts� den tr�kker f�rst 40 fra i getPlacement
		// og s�tter herefter ens passStart til true, hvorefter den i GameController checker det, og herefter opdaterer balance og s�tter til false
		p1.getPiece().addPlacement(12);
		p1.getPiece().getPlacement();
		
		
		Assert.assertTrue(p1.getPiece().isPassStart());
		
		}

}
