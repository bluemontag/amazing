package hackerrank.datastructures;
import java.util.Scanner;

import commons.Trie;

public class TrieContactListFailed {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Trie t = new Trie();
		for (int i = 0; i < n; i++) {
			String op = in.next();
			String contact = in.next();
			if (op.equalsIgnoreCase("add"))
				t.add(contact);
			else
				System.out.println(t.countWordsBegginingWith(contact));
		}
		in.close();
//		Trie t = new Trie();
//		t.add("carpa");
//		
//		TrieNode n = t.getLastNode("car");
//		
//		System.out.println(n);
//		
//		n = t.getLastNode("carp");
//		
//		System.out.println(n);
//		
//		n = t.getLastNode("aarpe");
//		
//		System.out.println(n);
	}
}

