package test_of_fields;

import java.awt.Color;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import entity.Jail;
import entity.Player;

public class TestJail {
	private Player p1;
	private Jail jail;
	
	@Before
	public void setUp() throws Exception {
		this.p1 = new Player("Hans", 1, 30000);
		this.jail = new Jail("Go to prison", Color.green.brighter(), "The cops got you, enjoy your stay in prison");
		
	}




	@Test
	public void testPlayerLandsOnPrisJail() {
	this.jail.landOnField(p1);
	boolean expected = true;
	boolean actual = p1.isJailed();
	
	Assert.assertEquals(expected, actual);
	
}

	
	@After
	public void tearDown() throws Exception {
	}
	
	
}