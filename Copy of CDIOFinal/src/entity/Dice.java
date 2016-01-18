package entity;

public class Dice {

	//atributter
	private int DiceEyes;
	private int DiceSides;

	//konstruktor
	public Dice(){
		DiceSides= 6;
	}

	//ruller med en terning
	public int rollDie(){
		DiceEyes= (int) (Math.random()*DiceSides+1);
		return DiceEyes;
	}

	public int getDiceEyes(){
		return DiceEyes;
	}
}