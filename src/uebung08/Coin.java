package uebung08;

/**
 * Coin: Modelliert eine Münze
 * 
 * @author prauscher
 */
public class Coin {
	/**
	 * Wert der Münze in Cent
	 */
	private int value;

	/**
	 * Coin: speichert den übergebenen Wert ein
	 * 
	 * @param value
	 */
	public Coin(int value) {
		this.value = value;
	}
	
	/**
	 * getValue: Liefert den Wert der Münze
	 * 
	 * @return Wert der Münze
	 */
	public int getValue() {
		return value;
	}
}
