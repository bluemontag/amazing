package hackerrank.algorithms;
import java.util.Scanner;

public class BubbleSortSwapProblem {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */

		Scanner s = new Scanner(System.in);

		int n = s.nextInt();
		int[] a = new int[n];

		for (int i = 0; i < n; i++) {
			int num = s.nextInt();

			a[i] = num;
		}

		int numSwaps = bubbleSort(a, n);

		System.out.println("Array is sorted in "+numSwaps+" swaps.");
		System.out.println("First Element: "+a[0]);
		System.out.println("Last Element: "+a[n-1]);

		s.close();
	}

	public static int bubbleSort(int[] a, int n) {
		int totalSwaps = 0;
		for (int i = 0; i < n; i++) {
			// Track number of elements swapped during a single array traversal
			int numberOfSwaps = 0;

			for (int j = 0; j < n - 1; j++) {
				// Swap adjacent elements if they are in decreasing order
				if (a[j] > a[j + 1]) {
					swap(a, j, j + 1);
					numberOfSwaps++;
				}
			}

//			for (int k=0; k<n; k++) {
//				System.out.print(a[k]+" ");
//			}
//			System.out.println("");
			
			totalSwaps = totalSwaps + numberOfSwaps;
			
			// If no elements were swapped during a traversal, array is sorted
			if (numberOfSwaps == 0) {
				break;
			}
		}
		return totalSwaps;
	}
	
	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}