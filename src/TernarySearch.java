/**
 * Implementierung des Ternary Search Algorithmus. �hnlich wie der Binary Search
 * Algorithmus wird der Suchbereich immer weiter unterteilt, jedoch nicht in 2
 * sondern in 3 Teile.
 * 
 * @author Steffen Dworsky
 *
 */
public class TernarySearch extends SSearch {

	/**
	 * Die search Methode implementiert den Ternary Search algortimus. Hierf�r wird
	 * das �bergebene Array in 3 Teile unterteilt und festgestellt in welchem der 3
	 * sich dei Zahl befindet. Dieser Bereich wird dann immer weiter eingeschr�nkt,
	 * bis die Zahl gefunden wurde.
	 * 
	 * @param intArr
	 * @param number
	 */
	public static void search(int[] intArr, int number) {
		int start = 0;
		int end = intArr.length - 1;

		while (start <= end) {
			int m1 = start + (end - start) / 3; // erstes drittel
			int m2 = end - (end - start) / 3; // letztes drittel
			if (intArr[m1] == number) {
				System.out.println(number + " ist im Array an Index " + m1);
				return;
			}
			if (intArr[m2] == number) {
				System.out.println(number + " ist im Array an Index " + m2);
				return;
			}
			if (intArr[m1] > number) { // befindet sich die gesuchte Zahl im ersten drittel, wird dieses eingeschr�nkt.
				end = m1 - 1;
			} else if (intArr[m2] < number) { // befindet es sich im letzten drittel, wird dieses eingeschr�nkt.
				start = m2 + 1;
			} else { // befindet sich die gesuchte zahl im mittleren drittel wird dieses
						// eingeschr�nkt.
				start = m1 + 1;
				end = m2 - 1;
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
