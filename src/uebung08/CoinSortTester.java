package uebung08;
import static junit.framework.Assert.assertEquals;
import junit.framework.JUnit4TestAdapter;
import junit.textui.TestRunner;

import org.junit.Before;
import org.junit.Test;

public class CoinSortTester {
	private CoinSorter sorter;
	private int[] euroCoinValues = new int[]{1, 2, 5, 10, 20, 50, 100, 200};
	private Coin[] eachOne = new Coin[] {
      new Coin(1), new Coin(2), new Coin(5), new Coin(10),
      new Coin(20), new Coin(50), new Coin(100), new Coin(200)
  };

	@Before
	public void setUp() {
	    sorter = new CoinSorter(euroCoinValues);
	}
	
	@Test
	public void testInsertCoins() {
		int sum = sorter.insertCoins(eachOne);
		assertEquals("Transaction count should be 388", 388, sum);
	}


	@Test
	public void testInsertCoinsEmpty() {
		Coin[] inserted = new Coin[0];
		int sum = sorter.insertCoins(inserted);
		assertEquals("Sum must be 0 if no coins are inserted", 0, sum);
	}

	@Test
	public void testInsertCoinsInvalidCoin() {
		Coin[] inserted = new Coin[] {
				new Coin(3)
		};
		int sum = sorter.insertCoins(inserted);
		assertEquals("Sum must be 0 if a single invalid coin was inserted", 0, sum);
	}
	
	/**
   * Create a test suite for testing from the shell
   *
   * @return a junit.framework.Test instance containing
   * all tests of this class
   */
  public static junit.framework.Test suite() {
    return new JUnit4TestAdapter(CoinSortTester.class);
  }

  /**
   * Main method, used to create a junit.textui.TestRunner
   *
   * @param args ignored for this test
   */
   public static void main(String[] args) {
     TestRunner.runAndWait(suite());
   }
}