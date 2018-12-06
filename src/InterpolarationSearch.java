/**
 * Implementierung des Interpolerations Search Algorithmus. Findest eine
 * �bergebene Zahl in einem �bergebenen, sortiertem Array, mithilfe einer Formel
 * um den Suchbereich einzuschr�nken bis die Zahl gefunden wurde.
 * 
 * @author Steffen Dworsky
 *
 */
public class InterpolarationSearch extends SSearch {

	/**
	 * Die Search Methode implementiert den Interpolerations Search Algorithmus
	 * mithilfe der Formel start + ((number - intArr[start]) * (end - start) /
	 * (intArr[end] - intArr[start])) wird eine m�gliche Postition der Zahl inerhalb
	 * der Suchgrenzen bestimmt. Ist an pos nicht die gesuchte Zahl, werden die
	 * Grenzen eingeschr�nkt und pos erneut berechnet.
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
			// wurde eingeschr�nkt.
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
	 * Legt die letzte �bergebene Zahl als zu suchende Zahl fest, macht aus String[]
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
