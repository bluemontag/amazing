/**
 * Date created: 26 sep. 2017
 */
package hackerrank.algorithms.dynamicprogramming;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * @author igallego
 *
 */
public class Solution {

	/**
	 * Subproblem: given a sbstr n[i:j] i<=j, calculate the sum of that candy
	 * 
	 * Recurrence relation: DP(n) = DP(input[1:k]) + DP(input[k+1:n]) for All 0 < k < n
	 * 
	 */
	static HashMap<String, BigDecimal> memo = new HashMap<String, BigDecimal>();
	static BigDecimal divisor = new BigDecimal(1000000007);
	public static BigDecimal calculateCandies(String input, int n) {
		
		if (n==0) {
			return new BigDecimal(0);
		}
		
		if (memo.containsKey(input)) {
			return new BigDecimal(0);//already counted
		}
		
		BigDecimal sum = new BigDecimal(input).remainder(divisor);// % 1000000007L;
		System.out.println("Processing:"+input);
		
		for (int k=1; k<n; k++) {
			String s1 = input.substring(0,k);
			String s2 = input.substring(k, n);
			
			BigDecimal recSol1 = calculateCandies(s1, s1.length()).remainder(divisor);//% 1000000007L ;
			BigDecimal recSol2= calculateCandies(s2, s2.length()).remainder(divisor);//% 1000000007L ;
			
			sum = (sum.add(recSol1)).remainder(divisor);
			sum = (sum.add(recSol2)).remainder(divisor);
		}
		memo.put(input, sum);
		return sum;
	}
	
	public static void main(String args[]) throws Exception {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */
		
		
//		Scanner in = new Scanner(System.in);
		
		String inputStr = "972698438521";//in.next();
		
//		String inputStr = "5312";
		
		BigDecimal calc = calculateCandies(inputStr, inputStr.length());
		System.out.println(calc);
		
//		System.out.println("MAXLONG"+Long.MAX_VALUE);
//		assert(445677619L==(calc.longValue()));
		
//		in.close();
		
	}
}
