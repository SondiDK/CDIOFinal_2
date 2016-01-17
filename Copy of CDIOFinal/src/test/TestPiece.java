package test;

import static org.junit.Assert.*;

import org.junit.Test;

import entity.Player;

public class TestPiece {

	@Test
	public void test() {
		Player p1 = new Player();
		Player p2 = new Player();
		Player p3 = new Player();
		
		assertEquals(1, p1.getPiece().getPlayerNumber());
		assertEquals(2, p2.getPiece().getPlayerNumber());
		assertEquals(3, p3.getPiece().getPlayerNumber());
		
		assertEquals("Player 1", p1.getPiece().getPlayerName());
		assertEquals("Player 2", p2.getPiece().getPlayerName());
		assertEquals("Player 3", p3.getPiece().getPlayerName());
		
		
	}

}
