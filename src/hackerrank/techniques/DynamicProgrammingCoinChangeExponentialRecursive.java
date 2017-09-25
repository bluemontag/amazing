/**
 * Date created: 22 sep. 2017
 */
package hackerrank.techniques;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author igallego
 *
 */
public class DynamicProgrammingCoinChangeExponentialRecursive {

	static HashMap<RecursiveSolution, Long> solutions = new HashMap<RecursiveSolution, Long>();
	
	static class RecursiveSolution {
		Integer[] quantities;
		Integer money;
		public RecursiveSolution(Integer[] q, Integer money) {
			this.quantities = new Integer[q.length];
			
			for (int i=0; i<q.length; i++) {
				this.quantities[i] = q[i];
			}
			
			this.money = money;
		}

		public RecursiveSolution(RecursiveSolution a, int dollars, int addCoin) {
			this(a.quantities, dollars);
			
			this.addCoin(addCoin);
		}
		public int computeValue(int[] coinValues) {
			int res = 0;
			
			for (int i=0; i<coinValues.length; i++) {
				res += coinValues[i]*this.quantities[i];
			}
			return res;
		}
		
		public RecursiveSolution addCoin(int coinValue) {
			this.quantities[coinValue]++;
			return this;
		}
		
		public RecursiveSolution subCoin(int coinValue) {
			this.quantities[coinValue]--;
			return this;
		}
		
		@Override
		public boolean equals(Object obj) {
			RecursiveSolution other = (RecursiveSolution)obj;
			if ((this.quantities.length != other.quantities.length) ||
				(!this.money.equals(other.money)))
				return false;
			for (int i=0; i<quantities.length; i++) {
				if (this.quantities[i]!=other.quantities[i]) {
					return false;
				}
			}
			return true;
		}

		@Override
		public int hashCode() {
			int res = this.money.hashCode();
			for (int i=0; i<quantities.length; i++) {
				res+=(quantities[i].hashCode());
			}
			
			return res;
		}
		
		@Override
		public String toString() {
			StringBuffer res = new StringBuffer("Money "+this.money+" (");
			for (int i=0; i<quantities.length; i++) {
				res.append(this.quantities[i]+"-");
			}
			
			res.append(")");
			return res.toString();
		}
	}
	
	public static long makeChange(int[] coinValues, int dollars) {
		if (dollars==0)
			return 0;
		
		Integer[] solution = new Integer[coinValues.length];
		
		for (int i=0; i<solution.length; i++) {
			solution[i] = 0;//initial quantity
		}
		
		RecursiveSolution initial = new RecursiveSolution(solution, dollars);
		
		return coinChange(coinValues, dollars, dollars, initial);
	}

	private static Long coinChange(int[] coinValues, int originalAmount, int dollars, RecursiveSolution partial) {
//		Long cpv = (long)partial.computeValue(coinValues);
//		if (cpv>originalAmount) {
//			return 0L;
//		}
		
		if (dollars==0) {
			return 1L;
		}
		
		Long tot = 0L;
		
		for (int i =0; i< coinValues.length; i++) {
			if (dollars >= coinValues[i]) {
				
				int newMoney = dollars-coinValues[i];
				RecursiveSolution newSol = new RecursiveSolution(partial, newMoney, i);
				
				Long recSol;
				if (solutions.containsKey(newSol)) {
					//recSol = solutions.get(newSol);
					recSol = 0L; //i've already counted that option
				} else {
					
					recSol = coinChange(coinValues, originalAmount, newMoney, newSol);
					solutions.put(newSol, recSol);

//					System.out.print("Money "+newMoney+" Solucion:"+newSol);
//					System.out.println("="+recSol);
				}
				tot += recSol;
			}
		}
		
		return tot;
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















