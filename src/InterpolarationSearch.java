/**
 * Implementierung des Interpolerations Search Algorithmus. Findest eine
 * übergebene Zahl in einem übergebenen, sortiertem Array, mithilfe einer Formel
 * um den Suchbereich einzuschränken bis die Zahl gefunden wurde.
 * 
 * @author Steffen Dworsky
 *
 */
public class InterpolarationSearch extends SSearch {

	/**
	 * Die Search Methode implementiert den Interpolerations Search Algorithmus
	 * mithilfe der Formel start + ((number - intArr[start]) * (end - start) /
	 * (intArr[end] - intArr[start])) wird eine mögliche Postition der Zahl inerhalb
	 * der Suchgrenzen bestimmt. Ist an pos nicht die gesuchte Zahl, werden die
	 * Grenzen eingeschränkt und pos erneut berechnet.
	 * 
	 * @param intArr
	 * @param number
	 */
	private static void search(int[] intArr, int number) {
		int start = 0, end = intArr.length - 1;
		int pos = 0;

		while (start <= end) {
			pos = start + ((number - intArr[start]) * (end - start) / (intArr[end] - intArr[start]));
			// Formel um die Position der Zahl mithilfe der Grenzen des Arrays zu bestimmen.
			// Die Grenzen werden in jedem Schritt, in dem die gesuchte Zahl nicht gefunden
			// wurde eingeschränkt.
			if (intArr[pos] == number) {
				System.out.println(number + " ist im Array an Index " + pos);
				return;
			}
			if (intArr[pos] < number) {
				start = pos + 1;
			}
			if (intArr[pos] > number) {
				end = pos - 1;
			}
		}
		System.out.println(number + " konnte nicht im Array gefunden werden!");
	}

	/**
	 * Legt die letzte übergebene Zahl als zu suchende Zahl fest, macht aus String[]
	 * ein int[] und startet die suche.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		args = findSearchedNumber(args);
		int[] intArr = start(args);
		search(intArr, number);
	}
}
