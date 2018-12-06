/**
 * Eingentlich irrelevant zu implementieren, der vollständigkeit halber und da
 * andere Suchalgorithmen diese Klasse eventuell verwenden werden, dennoch
 * implementiert. Durchläuft das Array von vorne nach hinten und prüft für jeden
 * Index ob es der gesuchte Wert ist.
 * 
 * @author Steffen Dworsky
 *
 */
public class LinearSearch extends SSearch {

	/**
	 * Die search Funktion durchläuft das übergebene Array von vorne nach hinten und
	 * sucht nach der übergebenen Nummer.
	 * 
	 * @param intArr
	 * @param number
	 */
	private static void search(int[] intArr, int number) {
		if (intArr[0] == number) {
			System.out.println(number + " ist im Array an Index " + 0);
		}

		for (int i = 1; i < intArr.length - 1; i++) {
			if (intArr[i] == number) {
				System.out.println(number + " ist im Array an Index " + i);
				return;
			}
		}
		System.out.println(number + " konnte nicht im Array gefunden werden!");
	}

	/**
	 * Nimmt die letzte Zahl als zu suchende Zahl und entfernt die letzte Zahl.
	 * Macht aus dem String[] ein int[] und startet die Suche.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		args = findSearchedNumber(args);
		int[] intArr = start(args);
		search(intArr, number);
	}
}
