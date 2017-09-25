/**
 * Date created: 25 sep. 2017
 */
package hackerrank.techniques;

/**
 * @author igallego
 *
 */
public class DPFibonacciNumbers {

	final static int n = 7;
	
	static long[] fib = new long[n];
	
	public static long fib(int n) {
		long f =1;
		for (int k=0; k<n; k++) {
			if (k<=2) {
				f = 1;
				fib[k] = 1;
			} else {
				f = fib[k-1]+fib[k-2];
				fib[k] = f;
			}
		}
		
		
		return f;
	}
	
	
	public static void main(String[] args) {
		System.out.println(fib(n));
	}
}
