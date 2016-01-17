package test;

import static org.junit.Assert.*;

import org.junit.Test;

import entity.Player;

public class TestPlayer {

	@Test
	public void test() {
		Player p1 = new Player();
		Player p2 = new Player();
		Player p3 = new Player();
		
		p1.updateBalance(10000);
		p2.updateBalance(0);
		p3.updateBalance(-10000);
		
		assertEquals(40000, p1.getBalance());
		assertEquals(30000, p2.getBalance());
		assertEquals(20000, p3.getBalance());
		
	}

}
