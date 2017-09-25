/**
 * Date created: 25 sep. 2017
 */
package hackerrank.techniques;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author igallego
 *
 */
public class DPCoinChangeEditorialSolution {

	public static long makeChange(int[] coins, int dollars) {
		return makeChange(coins, dollars, 0, new HashMap<String, Long>());
	}
	
	public static long makeChange(int[] coins, int dollars, int index, HashMap<String, Long> memo) {
		if (dollars==0) {
			return 1L;
		}
		
		if (index>=coins.length) {
			return 0L;
		}
		String key = dollars+"-"+index;
		
		if (memo.containsKey(key)) {
			return memo.get(key);
		}
		
		long ways = 0L;
		int amountWithCoin = 0;
		
		while (dollars >= amountWithCoin) {
			int moneyLeft = dollars - amountWithCoin;
			ways += makeChange(coins, moneyLeft, index+1, memo);
			amountWithCoin += coins[index];
		}
		memo.put(key, ways);
		return ways;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int dollars = in.nextInt();
		int n_of_coins = in.nextInt();
		int coins[] = new int[n_of_coins];
		for (int coins_i = 0; coins_i < n_of_coins; coins_i++) {
			coins[coins_i] = in.nextInt();
		}
		
		System.out.println(makeChange(coins, dollars));
		in.close();
	}
}
