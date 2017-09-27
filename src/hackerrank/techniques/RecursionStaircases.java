package hackerrank.techniques;

import java.util.HashMap;
import java.util.Scanner;

public class RecursionStaircases {
	
	static HashMap<Integer, Long> memo = new HashMap<Integer, Long>();
	
	public static long computeStaircaseOf(int n) {
		//base case
		if (n==0) {
			return 1L;
		}
		if (n<0) {
			return 0L;
		}
		if (memo.containsKey(n)) {
			return memo.get(n);
		}
		
		Long ways = 0L;
		
		for (int step=1; step<=3; step++) {
			
			int newSteps = n - step;//advance one step
			
			ways += computeStaircaseOf(newSteps);
		}
		
		memo.put(n, ways);
		return ways;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		for (int a0 = 0; a0 < s; a0++) {
			int n = in.nextInt();
			
			System.out.println(computeStaircaseOf(n));
		}
		in.close();
	}
}
