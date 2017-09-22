package hackerrank.datastructures;

public class DeletionToAnagrams {

//	public static int numberNeeded(String first, String second) {
//	      int count = 0;
//		// char[] a = first.toCharArray();
//		// char[] b = second.toCharArray();
//	      
//	      for (int i=0; i < first.length(); i++) {
////	          for (int j=0; j < second.length(); j++) {
//	        	  
//	              if (first.indexOf(second.charAt(i))==-1) {
//					count++;
//	              }
//
//				  if (second.indexOf(first.charAt(i))==-1) {
//					count++;
////				  }
//	          }
//	      }
//	      Math.abs(0.0);
//	      return count;
//	    }

	public static int numberNeeded(String first, String second) {
		int[] letter_diffs = new int[26];
		
		for (char x : first.toCharArray()) {
			letter_diffs[x-'a']++;
		}
		for (char y : second.toCharArray()) {
			letter_diffs[y-'a']--;
		}
		int res = 0;
		for (int i=0; i < 26; i++) {
			res += Math.abs(letter_diffs[i]);
		}
		return res;
	}
	
	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		String a = in.next();
//		String b = in.next();
		String a = "cdecba";
		String b = "abccedx";
		System.out.println(numberNeeded(a, b));
	}
}
