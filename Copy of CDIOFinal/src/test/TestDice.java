package test;

import static org.junit.Assert.*;

import org.junit.Test;

import entity.Dice;

public class TestDice {

	@Test
	public void test() {
		Dice d1 = new Dice();
		Dice d2 = new Dice();
		Dice d3 = new Dice();
		
		d1.rollDie();
		d2.rollDie();
		d3.rollDie();
		
		assertTrue(d1.getDiceEyes() >=1 && d1.getDiceEyes() <=6);
		assertTrue(d2.getDiceEyes() >=1 && d2.getDiceEyes() <=6);
		assertTrue(d3.getDiceEyes() >=1 && d3.getDiceEyes() <=6);
		
	}

}
