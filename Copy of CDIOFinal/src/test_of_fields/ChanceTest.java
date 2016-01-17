package test_of_fields;


import org.junit.*;
import entity.Player;
import entity.Deck;

public class ChanceTest {
	
	//Attributter
	private Player p1;
	private Deck d1;

	@Before
	public void setUp() throws Exception {
		this.p1 = new Player("Hans", 1, 30000);
		this.d1 = new Deck();
	}



	//Tests when you draw a card the correct amount gets added/subtracted
	@Test
	public void testAddAndSub() {
			//Test the balance is the same as given
			int actual = p1.getBalance();
			int expected = 30000;
			Assert.assertEquals(expected, actual);
			
			//Tests that after he drew a card the correct amount gets added(500 in this case)
			d1.getCard(1).chance(p1);
			
			expected = 30000 + 500;
			actual = p1.getBalance();
			Assert.assertEquals(expected, actual);
		
		//Test that after he drew a card 1000 gets subtracted
			d1.getCard(13).chance(p1);
			
			expected = 29500;
			actual = p1.getBalance();
			Assert.assertEquals(expected, actual);
	}
	
	//Tests that players gets the right placement after a chance card is drawed with a "move" comment
	@Test
	public void testMovesBackForwardAndFieldx(){
		//A test testing the piece moving forward
		//Set players car at field 2
		p1.getPiece().setPlacement(2);
		//Moves 3 fields forward
		d1.getCard(32).chance(p1);
		//Expected to be at field 5 after the card is drawed
		int expectedPlacement = 5;
		Assert.assertEquals(expectedPlacement, p1.getPiece().getPlacement());
		
		//A test testing the piece moving backwards
		p1.getPiece().setPlacement(20);
		//Moves 3 fields backwards
		d1.getCard(31).chance(p1);
		//Expected to be at place 17
		expectedPlacement = 17;
		Assert.assertEquals(expectedPlacement, p1.getPiece().getPlacement());
		
		//A test testing the piece moving to a selected field
		//Random place
		p1.getPiece().setPlacement(23);
		//Moves to Start
		d1.getCard(23).chance(p1);
		//expected to be at 1(start)
		expectedPlacement = 1;
		Assert.assertEquals(expectedPlacement, p1.getPiece().getPlacement());
	}
	
	@After
	public void tearDown() throws Exception {
	}

}
