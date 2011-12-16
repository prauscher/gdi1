package uebung08;

/**
 * ArraySort
 * 
 * @author Herr Chaos, prauscher
 */
public class ArraySort {
	/**
	 * isSorted: Check if an int-Array is sorted 
	 * 
	 * @param testArray - Array to be tested
	 * @return Wherever the given Array is sorted or not
	 */
	protected boolean isSorted(int[] testArray) {
		if (testArray == null || testArray.length == 0)
			return true;
		int i = 0;
		while (i < testArray.length - 1) {
			if (testArray[i] > testArray[++i])
				return false;
		}
		return true;
	}

	/**
	 * sortArray: Sort an int-Array by int-Value (increasing)
	 * 
	 * @param sortArray - Array to sort
	 * @return sorted Array (not the same Reference as sortArray !)
	 */
	protected int[] sortArray(int[] sortArray) {
		if (isSorted(sortArray))
			return sortArray;
		int[] sortedArray = new int[sortArray.length];
		int i, j, v;
		for (i = 0; i < sortedArray.length; i++) {
			sortedArray[i] = sortArray[i];
		}
		for (i = 1; i < sortedArray.length; i++) {
			v = sortedArray[i];
			for (j = i; j > 0 && v < sortedArray[j - 1]; j--)
				sortedArray[j] = sortedArray[j - 1];
			sortedArray[j] = v;
		}
		return sortedArray;
	}

	/**
	 * print: Generate a String from an int-Array
	 * 
	 * @param printArray - Array to generate String-representation of
	 * @return generated String
	 */
	public String print(int[] printArray) {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < printArray.length; i++) {
			buf.append(printArray[i]);
			buf.append(" ");
		}
		return buf.toString();
	}

	/**
	 * main: Startpoint for the Program 
	 * 
	 * @param args - Command-Line-Arguments
	 */
	public static void main(String[] args) {
		ArraySort a = new ArraySort();
		int[] c = new int[] { 91, 82, 73, 64, 55, 46, 34, 28, 12, 8 };
		System.out.println("Test " + a.isSorted(c) + " - " + a.print(a.sortArray(c)) + " => "
				+ a.isSorted(a.sortArray(c)));
	}
}// END!!