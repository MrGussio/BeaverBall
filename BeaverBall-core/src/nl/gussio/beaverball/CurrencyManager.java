package nl.gussio.beaverball;

public class CurrencyManager {

	private int coins = 0;
	
	public void addCoin(){
		coins++;
	}
	
	public void addCoins(int amount){
		coins+=amount;
	}
	
	public int getCoins(){
		return coins;
	}
	
	public void removeCoins(int amount){
		coins-= amount;
	}
	
}
