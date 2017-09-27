/**
 * Date created: 26 sep. 2017
 */
package hackerrank.algorithms.dynamicprogramming;

import java.util.Scanner;

/**
 * @author igallego
 *
 */
public class SamCandiesAndSubstrings {

	/**
	 * Subproblem: given a sbstr n[i:j] i<=j, calculate the sum of that candy
	 * 
	 * Recurrence relation: DP(n) = DP(input[1:k]) + DP(input[k+1:n]) for All 0 < k < n
	 * 
	 */
	static Long divisor = new Long(1000000007);
	/*static HashMap<String, Long> memo = new HashMap<String, Long>();
	
	public static Long calculateCandiesFailedAttempt(String input, int n) {
		
		if (n==0) {
			return new Long(0);
		}
		
		if (memo.containsKey(input)) {
			return new Long(0);//already counted
		}
		
		Long sum = new Long(input)%(divisor);// % 1000000007L;
		System.out.println("Processing:"+input);
		
		for (int k=1; k<n; k++) {
			String s1 = input.substring(0,k);
			String s2 = input.substring(k, n);
			
			Long recSol1 = calculateCandiesFailedAttempt(s1, s1.length())%divisor;
			Long recSol2= calculateCandiesFailedAttempt(s2, s2.length())%divisor;
			
			sum = (sum+recSol1)%divisor;
			sum = (sum+recSol2)%divisor;
		}
		memo.put(input, sum);
		return sum;
	}*/
	
/*  C++ Editorial solution
 * 
 * int l = str.length();
    LL outp = str[0] - '0'; // output stored in it.
    LL temp = str[0] - '0'; // sum of all strings ending at index i is stored in this string
    for(int i=1 ; i< l ; i++)
    {
        temp = temp*10 + (i+1)*(str[i] - '0');
        temp = temp%MOD7;
        outp = (outp +temp)%MOD7;
    }
        cout<<outp<<endl;
    }
    return 0;
 */
	public static Long calculateCandies(String input, int n) {
		Long out = new Long(input.charAt(0) - '0');
		Long temp= new Long(input.charAt(0) - '0');
		
		/*sd[i+1] = (i + 2) * N[i] + 10 * sd[i]
		  sd[0] = N[0]*/
		
		for (int i=1; i<n; i++) {
//			temp = (temp * 10) + ((i+1)*(input.charAt(i) - '0'));
			temp = (temp *10) + (i+1)*(input.charAt(i) - '0');
			temp = temp % divisor;
			out = (out + temp) % divisor;
		}
		
		return out;
	}
	
	public static void main(String args[]) throws Exception {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */
		
		
		Scanner in = new Scanner(System.in);
		
		String inputStr = in.next();//"972698438521";->assert(445677619L==(calc.longValue()));
		
		Long calc = calculateCandies(inputStr, inputStr.length());
		System.out.println(calc);
		
		in.close();
		
	}
}
