package uebung08;

/**
 * CoinSorter: Maintains a bunch of Coins with the ability to count them
 * 
 * Known Problems: int[] validValues may not contain 0 (insertCoins will give wrong transactionCount else)
 * 
 * @author prauscher
 */
public class CoinSorter {
	/**
	 * validValues - int[], which Values are allowed by that CoinSorter
	 */
	private int[] validValues;
	/**
	 * coinCoint - int[], how many valid Coins we have, uses same indeces like validValues
	 */
	private int[] coinCount;
	/**
	 * transactionCount - int, how often insertCoins() got called with at least one valid Coin
	 */
	private int transactionCount = 0;
	
	/**
	 * unknownCoinsValue - int, what value in unknown Coins we have
	 */
	private int unknownCoinsValue = 0;
	/**
	 * unknownCoinsCount - int, how many unknown Coins we have
	 */
	private int unknownCoinsCount = 0;
	
	/**
	 * Constructor: Prepares Value-Counter and stores valid Values
	 * 
	 * @param validValues - int[], which Values (in Cent) we'll accept
	 * @throws Exception 
	 */
	public CoinSorter (int[] validValues) throws Exception {
		if (validValues == null) {
			throw new Exception("Erwarte einen int-Array ;o");
		}
		this.validValues = validValues;
		this.coinCount = new int[validValues.length];
	}
	
	/**
	 * findValue: search in validValues for the Index of a given value
	 * 
	 * @param value - int, which Value to search for
	 * @return index - int, where in validValues the given Value was found
	 * @throws Exception - if value was not found
	 */
	protected int findValue(int value) throws Exception {
		for (int i=0; i<validValues.length && validValues[i] <= value; i++) {
			if (value == validValues[i]) {
				return i;
			}
		}
		throw new Exception("Could not find value " + value);
	}
	
	/**
	 * insertCoin: Add the coinCounter for that given Coin
	 * 
	 * @param coin - Coin, which Coin to insert
	 * @return int, coin-value if sucessfull, 0 if not.
	 */
	protected int insertCoin(Coin coin) {
		try {
			// Try to find the valid counter
			coinCount[findValue(coin.getValue())]++;
			return coin.getValue();
		} catch (Exception e) {
			// If none found, we have not added any Value
			return 0;
		}
	}
	
	/**
	 * insertCoins: Insert a Bunch of coins and increase transactionCounter if needed
	 * 
	 * @param coins - Coin[], Array of Coins to insert
	 * @return int, Sum of Values of valid Coins
	 */
	public int insertCoins(Coin[] coins) {
		if (coins == null) {
			return 0;
		}
		int countedSum = 0;
		for (int i=0; i<coins.length; i++) {
			countedSum += insertCoin(coins[i]);
		}
		// If any Coin was counted, we now have a sum >0 (if no 0-Coin was contained)
		if (countedSum > 0) {
			transactionCount++;
		}
		return countedSum;
	}
	
	/**
	 * getNumberOfCoinsWithValue: return how many Coins we have with the given Value
	 * 
	 * @param value - int, which Value we query for
	 * @return int, how many Coins we have of that sort
	 * @throws Exception - if the value was invalid
	 */
	public int getNumberOfCoinsWithValue(int value) throws Exception {
		return coinCount[findValue(value)];
		/*
		 * Another possibilities instead of throwing an Exception:
		 * - return 0 (invalid, as we may have unknownCoins with that Value
		 */
	}
	
	/**
	 * getNumberOfUnknownCoins: return how many Coins were unknown 
	 * 
	 * @return int, how many Coins were unknown
	 */
	public int getNumberOfUnknownCoins() {
		return unknownCoinsCount;
	}
	
	/**
	 * getSum: Aggregate all Coins (unknown and known) and give the total-Value
	 * 
	 * @return total Value stored in this CoinSorter
	 */
	public int getSum() {
		int sum = unknownCoinsValue;
		for (int i=0; i<validValues.length; i++) {
			sum += validValues[i] * coinCount[i];
		}
		return sum;
	}
	
	/**
	 * getTransactionCount: How many transactions this CoinSorter did
	 * 
	 * @return How many transaction this CoinSorter did
	 */
	public int getTransactionCount() {
		return transactionCount;
	}
	
	/**
	 * toString: Represent the CoinSorter as a String by giving all Known and Unknown Coins
	 * 
	 * @return String, List of all Known Coins plus unknown Coins
	 */
	public String toString() {
		String representation = "";
		for (int i=0; i < validValues.length; i++) {
			try {
				representation = representation + getNumberOfCoinsWithValue(validValues[i]) + "x " + validValues[i] + "\n";
			} catch (Exception e) {
				/*
				 * If this ever happens, something _really_ terrible happend *G*,
				 * as we getNumberOfCoinsWithValue() gets only called with validValues
				 */
			}
		}
		representation = representation + getNumberOfUnknownCoins() + " unknown coins\n";
		representation = representation + "Total value: " + getSum();
		return representation;
	}
}
