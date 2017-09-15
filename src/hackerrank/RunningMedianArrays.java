package hackerrank;
import java.math.BigDecimal;
import java.util.Scanner;

public class RunningMedianArrays {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];

		for (int i = 0; i < n; i++) {
			insertSort(a, i, in.nextInt());

			System.out.println(median(a, i + 1));
		}
		in.close();
	}

	private static int findPlaceFor(int[] a, int left, int right, int elem) {
		int curSize = right-left;
		if (right==left)
			return left;
		int pos = left + (curSize / 2);
		
		
		int i = checkPlace(a, elem, pos);
		
		if (i==0)
			return pos;
		else if (i==-1) {
			int r = pos;
			return findPlaceFor(a, left, r, elem);
		} else {
			int l = pos+1;
			return findPlaceFor(a, l, right, elem);
		}
	}
	
	private static int checkPlace(int[] a, int elem, int pos) {
		//if the element is in place, then return 0
		if (a[pos]==elem || // if it is the same number, we are in position 
			(elem<a[pos] && // if elem is correct for the larger index 
			((pos==0) || (pos>=1 && a[pos-1]<=elem)))) {
			return  0;
		}
		if (elem<a[pos]) {//need to search for leftmost elements
			return -1;
		} else {
			return 1;
		}
	}

	private static void makeRoomForElem(int[] a, int curSize, int pos) {
		// pos is the position in which to insert elem
		// make room for elem
		for (int i = curSize; i > pos; i--) {
			a[i] = a[i - 1];
		}
	}

	public static void insertSort(int[] a, int curSize, int elem) {
		int pos = findPlaceFor(a, 0, curSize, elem);

		makeRoomForElem(a, curSize, pos);

		a[pos] = elem;
	}

	public static String median(int[] list, int size) {
		Double result = null;

		if (size % 2 == 1) {
			Integer index = (int) (Math.floor((double) size) / ((double) 2));
			Double elem1 = new Double(list[index]);
			result = elem1;
		} else {
			Integer index = (size / 2) - 1;
			Double elem1 = new Double(list[index]);
			Double elem2 = new Double(list[index + 1]);

			result = (elem1.doubleValue() + elem2.doubleValue()) / (double) 2;
		}

		BigDecimal resBD = BigDecimal.valueOf(result);
		resBD = resBD.setScale(1, BigDecimal.ROUND_HALF_UP);
		return resBD.toString();
	}
}