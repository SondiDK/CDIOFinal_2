package test_of_fields;

import java.awt.Color;

import org.junit.*;

import entity.Ferry;
import entity.Player;

public class FerryTest {
	
	//Entities
	private Player p1;
	private Player p2;
	private Ferry ferryBuy4000;
	private Ferry ferryRent1000;
	@Before
	public void setUp() throws Exception {
		this.p1 = new Player("Hans", 1, 30000);
		this.p2 = new Player("Svend", 2, 30000);
		this.ferryBuy4000 = new Ferry("Ferry1", Color.blue, "Ferry costs 4000", 4000, null, false,500);
		this.ferryRent1000 = new Ferry("Ferry2", Color.cyan, "Ferry costs 4000", 4000, null, false,500);
		new Ferry("Ferry3", Color.green, "Ferry costs 4000", 4000, null, false,500);
	}
	
	@Test
	public void testEntities() {
		Assert.assertNotNull(this.p1);
		Assert.assertNotNull(this.p2);
		Assert.assertNotNull(this.ferryBuy4000);
		Assert.assertNotNull(this.ferryRent1000);
		Assert.assertTrue(this.ferryBuy4000 instanceof Ferry);
		Assert.assertTrue(this.ferryRent1000 instanceof Ferry);
	}
	
	@Test
	public void testLandOnFieldBuy4000(){
		int expected = 30000;
		int actual = this.p1.getBalance();
		Assert.assertEquals(expected, actual);
		
		this.ferryBuy4000.landOnField(p1);
		
		expected = 30000 - 4000;
		actual = this.p1.getBalance();
		Assert.assertEquals(expected, actual);
		Player owner = this.ferryBuy4000.getOwner();
		//check is the owner is now p1
		Assert.assertEquals(p1,owner );
	}
	
	@Test
	public void testLandOnRent1000(){
		int expected = 30000;
		int actual = this.p2.getBalance();
		Assert.assertEquals(expected, actual);
		
		//1 ferry
		this.ferryBuy4000.landOnField(p1);
		// one more
		this.ferryRent1000.landOnField(p1);
			
		// player 2 lands on player 1's ferry, while he has 2 ferries (1000 rent)
		this.ferryBuy4000.landOnField(p2);
		
		expected = 30000 - 1000;
		actual = this.p2.getBalance();
		System.out.println(actual);
		Assert.assertEquals(expected, actual);
		
		
	}
}
