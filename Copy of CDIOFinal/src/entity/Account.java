package entity;

public class Account {

	//atributter
	private int startAmount = 30000;
	private int balance;
	
	//konstruktor
	public Account () { this.balance = startAmount; }
	
	//get & set metoder
	public int getBalance () { return this.balance;	}
	public void setBalance (int balance) { this.balance = balance; }
	public int addBalance ( int change) { return balance += change;	}
	public int subBalance ( int change) { return balance -= change;	}
	
}
