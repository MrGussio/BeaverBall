package nl.gussio.beaverball;

public class CurrencyManager {

	private static int coins = 0;
	
	public static void addCoin(){
		coins++;
	}
	
	public static void addCoins(int amount){
		coins+=amount;
	}
	
	public static int getCoins(){
		return coins;
	}
	
	public static void removeCoins(int amount){
		coins-= amount;
	}
	
}
