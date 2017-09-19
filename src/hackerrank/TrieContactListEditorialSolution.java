package hackerrank;
import java.util.HashMap;
import java.util.Scanner;

public class TrieContactListEditorialSolution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		TrieNode t = new TrieNode();
		for (int i = 0; i < n; i++) {
			String op = in.next();
			String contact = in.next();
			if (op.equalsIgnoreCase("add"))
				t.add(contact);
			else
				System.out.println(t.findCount(contact, 0));
		}
		in.close();
	}
}

class TrieNode {
	HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
	int numWords = 0;
	
	public TrieNode getNode(Character c) {
		return children.get(c);
	}
	
	public void add(String word) {
		this.add(word, 0);
	}
	
	public void add(String word, int index) {
		this.numWords++;
		if (index == word.length()) {
			return;
		}
		Character c = word.charAt(index);
		TrieNode node = this.getNode(c);
		if (node==null) {
			node = new TrieNode();
			children.put(c, node);
		}
		
		node.add(word, index+1);
	}
	
	public int findCount(String prefix, int index) {
		if (index == prefix.length()) {
			return this.numWords;
		}
		TrieNode node = this.getNode(prefix.charAt(index));
		
		if (node==null) {
			return 0;
		}
		return node.findCount(prefix, index+1);
//		for (int i=1; i<prefix.length(); i++) {
//			char c = prefix.charAt(i);
////			if (i!=prefix.length()-1)
//				node = node.getNode(c);
//		}
//		if (node!=null)
//			return node.numWords;
//		else
//			return 0;
	}
}




