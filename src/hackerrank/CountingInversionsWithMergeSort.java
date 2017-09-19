package hackerrank;
public class CountingInversionsWithMergeSort {

	// EDITORIAL SOLUTION:
	// public static long countInversions(int[] a) {
	// int n = a.length;
	//
	// // Base Case
	// if (n <= 1) {
	// return 0;
	// }
	//
	// // Recursive Case
	// int mid = n >> 1;
	// int[] left = Arrays.copyOfRange(a, 0, mid);
	// int[] right = Arrays.copyOfRange(a, mid, n);
	// long inversions = countInversions(left) + countInversions(right);
	//
	// int range = n - mid;
	// int iLeft = 0;
	// int iRight = 0;
	// for (int i = 0; i < n; i++) {
	// if (iLeft < mid && (iRight >= range || left[iLeft] <= right[iRight])) {
	// a[i] = left[iLeft++];
	// inversions += iRight;
	// } else if (iRight < range) {
	// a[i] = right[iRight++];
	// }
	// }
	//
	// return inversions;
	// }

	//My version
	public static long countInversions(int[] arr) {
		return countInv(arr, new int[arr.length], 0, arr.length - 1);
	}

	private static long countInv(int[] a, int[] temp, int left, int right) {
		if (left >= right) {
			return 0;
		} // else

		int mid = (left + right) / 2;

		long invL = countInv(a, temp, left, mid);
		long invR = countInv(a, temp, mid + 1, right);
		long merI = mergeInv(a, temp, left, right);

		return invL + invR + merI;
	}

	private static long mergeInv(int[] a, int[] temp, int leftStart, int rightEnd) {
		long invs = 0;
		int size = rightEnd - leftStart + 1;
		int leftEnd = (rightEnd + leftStart) / 2;
		int rightStart = leftEnd + 1;

		int iLeft = leftStart;
		int iRight = rightStart;
		int iTemp = leftStart;

		// this step is order O(size)
		for (int i=0; i<size ; i++) {
			if (iLeft <= leftEnd && (iRight > rightEnd || a[iLeft] <= a[iRight])) {
				temp[iTemp] = a[iLeft];
				invs+=(iRight-leftEnd-1);
				iTemp++;
				iLeft++;
			} else
				if (iRight <= rightEnd) {
					temp[iTemp] = a[iRight];
					iTemp++;
					iRight++;
				}
		}
		// This steps of the original mergeSort algorithm don't count the inversions... so we have to make it by hand
		// System.arraycopy(a, iLeft, temp, iTemp, leftEnd - iLeft + 1);
		// System.arraycopy(a, iRight, temp, iTemp, rightEnd - iRight +1);

		System.arraycopy(temp, leftStart, a, leftStart, size);

		return invs;
	}

	public static void main(String[] args) {
		// Scanner s = new Scanner(System.in);
		// int n = s.nextInt();

		// int[] a = new int[n];
		// 2 1 3 1 2
		int[] a = { 5, 4, 3, 2, 1 };
		for (int i = 0; i < a.length; i++) {
			// a[i] = (int) Math.floor(Math.random()*((double)n));
			System.out.print(a[i] + " ");
		}

		// s.close();

		System.out.println("\n" + countInversions(a));
	}
}
