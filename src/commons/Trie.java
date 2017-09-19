package commons;

import java.util.HashMap;


public class Trie {
	
	private class TrieNode {
		HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
		boolean isCompleteWord = false;
		Character letter = null;
		
		public TrieNode(Character letter) {
			this.letter = letter;
		}
		
		@Override
		public String toString() {
			return ""+this.letter+(this.isCompleteWord?"(F)":"");
		}
		
		public TrieNode addChild(Character letter) {
			if (!this.children.containsKey(letter)) {
				TrieNode node = new TrieNode(letter);
				this.children.put(letter, node);
				return node;
			} else
				return this.children.get(letter);
		}
		
		public boolean containsChild(Character letter) {
			return this.children.containsKey(letter);
		}
		
		public TrieNode getChild(Character letter) {
			if (this.children.containsKey(letter)) {
				return this.children.get(letter);
			} else {
				return null;
			}
		}
	}

	
	
	
	TrieNode root = new TrieNode('*');//root node

	
	private TrieNode getLastNode(String word) {
		TrieNode node = this.root;
		int i = 0;
		char curChar = '*';//root
		while (node.letter.equals(curChar)) {
			if (i>=word.length())
				break;
			if (node.containsChild(word.charAt(i)))
				node = node.getChild(word.charAt(i));
			else
				break;
			curChar = word.charAt(i);
			i++;
		}

		if (i>=word.length()) {
			return node;
		} else {
			return null;
		}
	}
	
	public boolean containsWord(String word) {
		TrieNode node = this.getLastNode(word);
		
		return (node!=null && node.isCompleteWord);
	}
	public void add(String word) {
		TrieNode node = this.root;
		int i = 0;
		char curChar = '*';//root
		while (node!=null && node.letter.equals(curChar)) {
			if (i>=word.length())
				break;
			if (node.containsChild(word.charAt(i)))
				node = node.getChild(word.charAt(i));
			else
				break;
			curChar = word.charAt(i);
			i++;
		}
		
		if (i > word.length()) {
			node.isCompleteWord = true;
			return;
		} else {
			while (i<word.length()) {
				node.addChild(word.charAt(i));
				node = node.getChild(word.charAt(i));
				i++;
			}
			node.isCompleteWord = true;
			return;
		}
	}
	
	public int countWordsBegginingWith(String prefix) {
		if ("".equals(prefix))
			return 0;
		
//		TrieNode first = this.root.getChild(prefix.charAt(0));
		
		TrieNode last = this.getLastNode(prefix);
		return getCompleteWordsCount(last, "");
	}
	
	private int getCompleteWordsCount(TrieNode node, String prefix) {
		if (node==null)
			return 0;
		if (prefix.length()==0) {
			int i = node.isCompleteWord?1:0;
			for (Character c : node.children.keySet()) {
				i = i + getCompleteWordsCount(node.getChild(c), "");
			}
			return i;
		} else {
			if (node.letter.equals(prefix.charAt(0))) {
				int i = (prefix.length()==1 && node.isCompleteWord)?1:0;
				for (Character c : node.children.keySet()) {
					i = i + getCompleteWordsCount(node.getChild(c), prefix.substring(1));
				}
				return i;
			} else return 0;
		}
	}
}