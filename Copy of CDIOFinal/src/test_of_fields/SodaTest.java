package test_of_fields;

import java.awt.Color;

import org.junit.*;

import org.junit.Assert;
import org.junit.Test;

import entity.DiceCup;
import entity.Player;
import entity.Soda;

public class SodaTest {

	private Player player1test;
	private Player player2test;
	private Soda soda1;
	private Soda soda2;
	private DiceCup dctest;

	@Before
	public void setUpSoda() throws Exception {
		this.player1test = new Player("Player 1", 1, 30000);
		this.player2test = new Player("Player 2", 2, 30000);
		this.soda1 = new Soda("Soda1", Color.magenta, "Rip in pep(si)", 3000, null, 100, false);
		this.soda2 = new Soda("Soda2", Color.magenta, "Rip in pep(si)", 3000, null, 100, false);
		this.dctest = new DiceCup();
	}
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEntities() {

		//Tester at alle Entities er blevet lavet.
		Assert.assertNotNull(this.player1test);
		Assert.assertNotNull(this.player2test);
		Assert.assertNotNull(this.soda1);
		Assert.assertNotNull(this.soda2);
		Assert.assertTrue(this.soda1 instanceof Soda);
		Assert.assertTrue(this.soda2 instanceof Soda);
		Assert.assertTrue(this.player1test instanceof Player);
		Assert.assertTrue(this.player2test instanceof Player);
	}
	@Test
	public void testLandOnSoda() {

		//Starter med en grund balance for begge spillere, som testes ud fra.
		int expected1 = 30000;
		int expected2 = 30000;
		int actual1 = this.player1test.getBalance();
		int actual2 = this.player2test.getBalance();
		Assert.assertEquals(expected1, actual1);
		Assert.assertEquals(expected2, actual2);
		
		//Kører landOnField for soda1 som spiller 1, for at sætte ham som ejer.
		// TRYK PÅ KNAPPEN "JA" I GUI'EN HELE VEJEN GENNEM TESTEN
		System.out.println("TRYK JA FOR AT FORTSÆTTE TESTEN KORREKT");
		this.soda1.landOnField(player1test);

		//Tjekker at Spiller 1 har betalt for feltet.
		expected1 -= 3000;
		actual1 = this.player1test.getBalance();
		Assert.assertEquals(expected1, actual1);

		//Sikre at player1test er ejer af soda1, og at han kun ejer 1.
		Assert.assertTrue(soda1.getOwned());
		Player owner1 = this.soda1.getOwner();
		Assert.assertEquals(player1test,owner1);
		Assert.assertNotEquals(player2test,owner1);
		Assert.assertEquals(player1test.getSodaCount(), 1);		
		
		//Kører landOnField for soda1 som spiller 2, for at teste ham lande.
		dctest.RollDices();
		System.out.println("Terningerne rollede tilsammen: " + dctest.getSum());
		player2test.getPiece().setLastDiceSum(dctest.getSum());
		this.soda1.landOnField(player2test);

		//Tjek om player1test har tjent penge, men ikke mere end 1200
		expected1 = (27000 + (player2test.getPiece().getLastDiceSum()*100));
		actual1 = this.player1test.getBalance();
		Assert.assertEquals(expected1, actual1);
		Assert.assertTrue(player1test.getBalance() >= 27200);
		Assert.assertTrue(player1test.getBalance() <= 28200);

		//Tjek om player2test har brugt penge, men ikke mere end 1200
		expected2 = (30000 - (player2test.getPiece().getLastDiceSum()*100));
		actual2 = this.player2test.getBalance();
		Assert.assertEquals(expected1, actual1);
		Assert.assertTrue(player2test.getBalance() <= 29800);
		Assert.assertTrue(player2test.getBalance() >= 28800);
		
		//Kører landOnField for soda2 som spiller 1, for at sætte ham som ejer af begge.
		// TRYK PÅ KNAPPEN "JA" I GUI'EN HELE VEJEN GENNEM TESTEN
		System.out.println("TRYK JA FOR AT FORTSÆTTE TESTEN KORREKT");
		this.soda2.landOnField(player1test);

		//Tjekker at Spiller 1 har betalt for feltet.
		expected1 -= 3000;
		actual1 = this.player1test.getBalance();
		Assert.assertEquals(expected1, actual1);

		//Sikre at player1test er ejer af soda2, og at han ejer begge.
		Assert.assertTrue(soda2.getOwned());
		Player owner2 = this.soda2.getOwner();
		Assert.assertEquals(player1test,owner2);
		Assert.assertNotEquals(player2test,owner2);
		Assert.assertEquals(player1test.getSodaCount(), 2);

		//Kører landOnField for soda2 som spiller 2, for at teste ham lande.
		dctest.RollDices();
		System.out.println("Terningerne rollede tilsammen: " + dctest.getSum());
		player2test.getPiece().setLastDiceSum(dctest.getSum());
		this.soda2.landOnField(player2test);

		//Tjek om player1test har tjent penge, men ikke mere end 2400
		int expected3 = (expected1 + (player2test.getPiece().getLastDiceSum()*200));
		int actual3 = this.player1test.getBalance();
		Assert.assertEquals(expected3, actual3);
		Assert.assertTrue(player1test.getBalance() >= 24600);
		Assert.assertTrue(player1test.getBalance() <= 27600);

		//Tjek om player2test har brugt penge, men ikke mere end 2400
		int expected4 = (expected2 - (player2test.getPiece().getLastDiceSum()*200));
		int actual4 = this.player2test.getBalance();
		Assert.assertEquals(expected4, actual4);
		Assert.assertTrue(player2test.getBalance() <= 29400);
		Assert.assertTrue(player2test.getBalance() >= 26400);
	}
}
