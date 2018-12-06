import java.util.Arrays;

public class SSearch {

	static int number = 0;

	/**
	 * Methode um aus den in der Main Methode übergebenen Strings, ein int[] zu
	 * machen. Zeichen welche keine Zahlen sind werden hierbei ignoriert.
	 * 
	 * @param s
	 * @return
	 */
	public static int[] stringArrToIntArr(String[] s) {
		int[] result = new int[s.length];
		for (int i = 0; i < result.length; i++) {
			try {
				result[i] = Integer.parseInt(s[i]);
			} catch (NumberFormatException e) { // Sollte einer der Werte keine Zahl sein, so wird eine Exception
												// geworfen. Würde man diese einfach ignorieren, so wird im int[] der
												// Platz durch eine 0 ausgefüllt. Da der Algorithmus nicht für Zahlen
												// die mehr als einmal vorkommen ausgelegt ist, kann dies zu Fehlern
												// führen.
				e.printStackTrace();
				System.out.println("");
				System.out.println(s[i] + " is not a Number. The program has been stopped!");
				System.exit(42);
			}
		}
		return result;
	}

	/**
	 * Funktion zum Austauschen zweier Werte an den Indexen i und j in dem Array
	 * intArr.
	 * 
	 * @param i
	 * @param j
	 * @param intArr
	 * @return
	 */
	public static int[] swap(int i, int j, int[] intArr) {
		int temp = intArr[i];
		intArr[i] = intArr[j];
		intArr[j] = temp;
		return intArr;
	}

	/**
	 * Implementierung von Simple Sort.
	 * 
	 * @param intArr
	 * @return
	 */
	public static int[] sort(int[] intArr) {
		for (int i = intArr.length - 1; i >= 1; i--) {
			for (int j = 0; j <= i - 1; j++) {
				if (intArr[j] > intArr[i]) {
					swap(i, j, intArr);
				}
			}
		}
		return intArr;
	}

	public static int[] start(String[] args) {
		int[] intArr = stringArrToIntArr(args);
		int[] sortArr = sort(intArr);
		return sortArr;
	}

	public static String[] findSearchedNumber(String[] args) {
		if (args.length <= 1) {
			System.out.println("Array ist leer!");
			System.exit(-1);
		}
		try {
			number = Integer.parseInt(args[args.length - 1]);
			args = Arrays.copyOf(args, args.length - 1);
		} catch (NumberFormatException e) {
			System.out.println("Letztes Zeichen ist keine Zahl");
			e.printStackTrace();
			System.exit(-2);
		}
		return args;
	}
}
