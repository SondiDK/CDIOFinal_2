package test_of_fields;

import java.awt.Color;

import org.junit.*;

import entity.Houseable;
import entity.Player;


public class HouseableTest {

	private Player p1;
	private Player p2;
	private Houseable testProperty1;
	private Houseable testProperty2;



	@Before
	public void setUp() throws Exception {

		this.p1 = new Player("Bo", 1, 30000);
		this.p2 = new Player("Elmar", 2, 30000);
		this.testProperty1 = new Houseable("Rødovrevej",Color.blue,"f",1200, null, 50, false,7, 1000, 250, 750, 2250, 4000, 6000,2);
		this.testProperty2 = new Houseable("Hvidovrevej",Color.blue,"f",1200, null, 50, false,7, 1000, 250, 750, 2250, 4000, 6000,2);


	}
	@Test
	//Tester at alle Entities er blevet lavet.
	public void testEntities() {
		Assert.assertNotNull(this.p1);
		Assert.assertNotNull(this.p2);
		Assert.assertNotNull(this.testProperty1);
		Assert.assertNotNull(this.testProperty2);
		Assert.assertTrue(this.testProperty1 instanceof Houseable);
		Assert.assertTrue(this.testProperty2 instanceof Houseable);
		Assert.assertTrue(this.p1 instanceof Player);
		Assert.assertTrue(this.p2 instanceof Player);
	}
	// Tester om feltet kan købes
	public void testLandOnFieldTestProperty1Buy(){
		// Tjekker at Balance for p1 er de forventede 30000
		int expected = 30000;
		int actual = this.p1.getBalance();
		Assert.assertEquals(expected, actual);

		// TRYK PÅ KNAPPEN "JA" I GUI'EN.
		System.out.println("TRYK JA FOR AT FORTSÆTTE TESTEN KORREKT");
		testProperty1.landOnField(p1);

		//checks if the balance is updated correct
		expected -= 1200;
		actual = this.p1.getBalance();
		Assert.assertEquals(expected, actual);

		//check is the owner is now p1
		Player owner = testProperty1.getOwner();
		Assert.assertEquals(p1,owner );


	}
	@Test
	public void testLandOnRent100(){

		// Tjekker at Balance for p2 er de forventede 30000
		int expected = 30000;
		int actual = this.p2.getBalance();
		Assert.assertEquals(expected, actual);



		//Tester at p2 betaler for at lande på feltet, når der er 0 huse og ikke fuld serie
		this.testProperty1.landOnField(p1);
		this.testProperty1.landOnField(p2);
		expected -= 50;
		actual = this.p2.getBalance();
		Assert.assertEquals(expected, actual);



		// TRYK PÅ KNAPPEN "JA" I GUI'EN.
		System.out.println("TRYK JA FOR AT FORTSÆTTE TESTEN KORREKT");
		this.testProperty2.landOnField(p1);

		//Tester at p2 betaler for at lande på feltet, når der er 0 huse og fuld serie
		this.testProperty2.landOnField(p2);
		expected -= 100;
		actual = this.p2.getBalance();
		Assert.assertEquals(expected, actual);



		//Tester at p2 betaler for at lande på feltet, når der er 1 huse og fuld serie
		//Placere 1 hus ved testProperty1, hvor der nu er 1
		this.testProperty1.addHouseCount(1);
		this.testProperty1.landOnField(p2);
		expected -= 250;
		actual = this.p2.getBalance();
		Assert.assertEquals(expected, actual);


		//Tester at p2 betaler for at lande på feltet, når der er 0 huse, men andet felt i serien har 1 hus
		this.testProperty2.landOnField(p2);
		expected -= 100;
		actual = this.p2.getBalance();
		Assert.assertEquals(expected, actual);


		//Tester at p2 betaler for at lande på feltet, når der er 2 huse og fuld serie
		//Placere 1 hus til ved testProperty1, hvor der nu er 2
		this.testProperty1.addHouseCount(1);
		this.testProperty1.landOnField(p2);
		expected -= 750;
		actual = this.p2.getBalance();
		Assert.assertEquals(expected, actual);


		//Tester at p2 betaler for at lande på feltet, når der er 5 huse og fuld serie
		//Placere 3 hus til ved testProperty1, hvor der nu er 5
		this.testProperty1.addHouseCount(3);
		this.testProperty1.landOnField(p2);
		expected -= 6000;
		actual = this.p2.getBalance();
		Assert.assertEquals(expected, actual);
	}

	@After
	public void tearDown() throws Exception {
	}


}
