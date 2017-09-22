/**
 * Date created: 22 sep. 2017
 */
package hackerrank.techniques;

import java.util.Scanner;

/**
 * @author igallego
 *
 */
public class DynamicProgrammingCoinChange {

	public static long makeChange(int[] coins, int dollars) {
		if (dollars<=0) {
			return 0;
		}
		if (coins.length==0) {
			return 0;
		}
		return 1;
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
