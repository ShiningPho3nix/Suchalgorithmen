/**
 * Bei dem Exponential Search Algorithmus wird der suchbereich zun�chst
 * eingeschr�nkt, indem der Suchbereich exponeneziell vergr��ert wird und
 * geschaut wird ob die Obergrenze gr��er oder kleiner ist als die gescuhte
 * Zahl. Danach wird in dem verkleinertem bereich nach der zahl gesucht.
 * 
 * @author Steffen Dworsky
 *
 */
public class ExponentialSearch extends SSearch {

	/**
	 * Pr�ft ob die gesuchte Zahl am anfang ist, wenn nicht wird geschaut ob die
	 * zahl an stelle 1 im Array ist. Danach wird der Bereich immer exponenziert,
	 * bis der eintrag an der stelle der exponenzierten zahl gr��er oder gleich der
	 * gesuchten Zahl ist. Danach wird in dem eingeschr�nktem bereich eine
	 * bin�rsuche ausgef�hrt.
	 * 
	 * @param intArr
	 * @param number
	 */
	public static void search(int[] intArr, int number) {
		if (intArr[0] == number) {
			System.out.println(number + " ist im Array an Index " + 0);
		}
		int i = 1;
		while (i < intArr.length && intArr[i] <= number) {
			i = i * 2;
		}
		BinarySearch.search(intArr, i / 2, Math.min(i, intArr.length - 1), number);
		// Gesucht wird mit der Bin�r Suche. Der Startbereich wird ebenfalls angehoben,
		// da wir aufgrund der exponentialrechnung und abfragen f�r die while schleife
		// wissen das bei i/2 der gesuchte wert noch gr��er war und daher nicht darunter
		// sein kann. Sollte aufgrund der exponentialrechnung i gr��er als das Array
		// sein wird das min der beiden werte als endpunkt der Suche �bergeben.
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
