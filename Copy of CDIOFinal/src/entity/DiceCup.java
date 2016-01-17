package entity;

public class DiceCup {

	Dice[] cup;

	public DiceCup(){
		this.cup = new Dice[]{new Dice(), new Dice()};
	}

	public int getDice(int DiceNumber){
		return this.cup[DiceNumber-1].getDiceEyes();
	}

	public void RollDices(){
		for(int i = 0; i<cup.length;i++)
			this.cup[i].rollDie();
	}

	public int getSum(){
		int sum = 0;
		for(int i = 0; i<cup.length;i++)
			sum += this.cup[i].getDiceEyes();
		return sum;
	}
}