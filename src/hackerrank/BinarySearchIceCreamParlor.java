package hackerrank;
import java.util.Arrays;
import java.util.Scanner;

class IceCream implements Comparable<IceCream> {
	int flavor_cost;
	int index;

	public IceCream(int cost, int index) {
		this.flavor_cost = cost;
		this.index = index;
	}

	@Override
	public int compareTo(IceCream o) {
		Integer sub = this.flavor_cost - o.flavor_cost;
		return sub.compareTo(new Integer(0));
	}

	@Override
	public boolean equals(Object o) {
		return (this.compareTo((IceCream)o)==0);
	}

}

public class BinarySearchIceCreamParlor {

	public static int binarySearch(int first, int last, IceCream[] arr, int search_cost) {
		if (first>last) 
			return -1;
		
		int mid = (first + last) / 2;
		
		if (arr[mid].flavor_cost==search_cost) {
			return arr[mid].index;
		}
		if (search_cost < arr[mid].flavor_cost)
			return binarySearch(first, mid-1, arr, search_cost);
		else
			return binarySearch(mid+1, last, arr, search_cost);
	}

	public static void main(String[] args) {

		int t;
		int n_flavors, money;

		Scanner in = new Scanner(System.in);
		t = in.nextInt();
		for (int test = 0; test < t; test++) {

			money = in.nextInt();
			n_flavors = in.nextInt();
			IceCream[] arr = new IceCream[n_flavors];

			for (int i = 0; i < n_flavors; i++)
				arr[i] = new IceCream(in.nextInt(), i + 1);

			Arrays.sort(arr);
//			int firstIndex = 100000, secondIndex = 100000;
			for (int i = 0; i < n_flavors - 1; i++) {
				int search_cost = money - arr[i].flavor_cost;
				if (search_cost >= arr[i].flavor_cost) {//this is because it can only be greater than arr[i] because of problems constants i<j
					int index = binarySearch(i + 1, n_flavors - 1, arr, search_cost);
					if (index != -1) {
						System.out.println(Math.min(arr[i].index, index) + " " + Math.max(arr[i].index, index));
						break;

					}
				}
			}

		}
		in.close();

	}

}

// public class Solution {
//
// public static void main(String[] args) {
// Scanner in = new Scanner(System.in);
// int t = in.nextInt();
// for (int a0 = 0; a0 < t; a0++) {
// int money = in.nextInt();
// int flavors = in.nextInt();
//
// int cost[] = new int[flavors];
//
// for (int i = 0; i < flavors; i++) {
// cost[i] = in.nextInt();
//
// if (cost[i] < money) {
// map.put(new Integer(cost[i]), new Integer(i));
//
// }
// }
// }
// in.close();
// }
// }
