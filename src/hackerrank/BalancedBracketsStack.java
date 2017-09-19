package hackerrank;
//

import java.util.Scanner;
//import java.io.*;
//import java.util.*;
//import java.text.*;
//import java.math.*;
//import java.util.regex.*;
import java.util.Stack;

public class BalancedBracketsStack {

	public static Stack<Character> stack = new Stack<Character>();
	
	public static boolean isBalanced(String expression) {

		if (expression==null  || expression.equals(""))
			return true;//an empty expression is balanced

		stack = new Stack<Character>();
		
		for (int pos=0; pos < expression.length(); pos++) {
			char c = expression.charAt(pos);
			
			switch (c) {
				case '{': 
					stack.push(c);
					break;
				case '(': 
					stack.push(c);
					break;
				case '[': 
					stack.push(c);
					break;
				case '}':
					if (stack.isEmpty() || '{'!=stack.pop())
						return false;
					break;
				case ')':
					if (stack.isEmpty() || '('!=stack.pop())
						return false;
					break;
				case ']':
					if (stack.isEmpty() || '['!=stack.pop())
						return false;
					break;
				default:
					break;
			}
		}
		
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			String expression = in.next();
			System.out.println((isBalanced(expression)) ? "YES" : "NO");
		}
		in.close();
	}
}