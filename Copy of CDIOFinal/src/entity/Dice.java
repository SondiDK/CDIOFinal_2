package entity;

public class Dice {

	private int DiceEyes;
	private int DiceSides;

	public Dice(){
		DiceSides= 6;
	}

	public int rollDie(){
		DiceEyes= (int) (Math.random()*DiceSides+1);
		return DiceEyes;
	}

	public int getDiceEyes(){
		return DiceEyes;
	}
}