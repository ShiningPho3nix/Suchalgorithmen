import java.util.Arrays;

/**
 * Eine einfache Implementierung der Binär Suche. Man kann eine beliebige Menge
 * an Zahlen übergeben. Die Letzte Zahl in den übergebenen Zahlen ist die nach
 * der gesucht wird. Kommt eine Zahl mehrfach vor, so wird das erste gefundene
 * ergebniss zurückgegeben.
 * 
 * @author Steffen Dworsky
 *
 */
public class BinarySearch extends SSearch {

	/**
	 * mithilfe des inizialen start und enddpunktes wird des mittelpunkt berechnet.
	 * Anschließend wird geschaut ob die gesuchte zahl größer oder kleiner als die
	 * zahl welche an dem errechneten mittelpunkt steht ist. Der Mittelpunkt wird
	 * dementsprechend erhöht oder erniedrigt, bis die Zahl gefunden wurde.
	 * 
	 * @param intArr
	 * @param start
	 * @param end
	 * @param number
	 */
	public static void search(int[] intArr, int start, int end, int number) {
		int newStart = start;
		int newEnd = end - 1;
		int m = 0;
		while (newStart <= newEnd) {
			m = (newStart + newEnd) / 2;
			if (intArr[m] < number) {
				newStart = ++m;
			} else if (intArr[m] > number) {
				newEnd = --m;
			} else if (intArr[m] == number) {
				System.out.println(number + " wurde gesucht und an Index " + m + " im Array gefunden");
				return;
			}
		}
		System.out.println(number + " konnte nicht gefunden werden. Der nächstbeste gefundene Wert ist " + intArr[m]
				+ " bei Index " + m);
	}

	/**
	 * In der main Methode wird zunächst das letzte Zeichen aus dem Array entfernt
	 * und mit parseInt zu einem integer gemacht. Dies ist die zahl nach der geuscht
	 * werden soll. Durch die Funktion start wird das Array args in ein int[]
	 * umgewandelt und dieses dann zur Suche übergeben.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int number = 0;
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
		int[] intArr = start(args);
		search(intArr, 0, intArr.length, number);
	}
}
