package entity;

public class Account {

	private int startAmount = 30000;
	private int balance;
	
	public Account () { this.balance = startAmount; }
	public int getBalance () { return this.balance;	}
	public void setBalance (int balance) { this.balance = balance; }
	public int addBalance ( int change) { return balance += change;	}
	public int subBalance ( int change) { return balance -= change;	}
	
}
