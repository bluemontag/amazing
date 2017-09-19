package hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RamsonNote {
	Map<String, Integer> magazineMap;
	Map<String, Integer> noteMap;

	String magazine, note;

	public RamsonNote(String magazine, String note) {
		this.magazineMap = new HashMap<String, Integer>();
		this.noteMap = new HashMap<String, Integer>();

		this.buildMap(this.magazineMap, magazine);
		this.buildMap(this.noteMap, note);

		this.magazine = magazine;
		this.note = note;
	}

	private void buildMap(Map<String, Integer> map, String words) {
		Scanner wordScanner = new Scanner(words);

		while (wordScanner.hasNext()) {
			String word = (String) wordScanner.next();

			Integer count = 0;
			if (map.containsKey(word)) {
				count = (Integer) map.get(word);
			}
			map.put(word, count + 1);
		}

		wordScanner.close();
	}

	public boolean solve(int m, int n) {
		boolean result = true;

		Scanner noteScanner = new Scanner(this.note);

		while (noteScanner.hasNext()) {
			String word = noteScanner.next();
			Integer count = 0;
			if (this.magazineMap.containsKey(word))
				count = this.magazineMap.get(word);

			count--;
			if (count == -1) {
				noteScanner.close();
				return false;
			} else
				this.magazineMap.put(word, count);// trim word

		}

		noteScanner.close();
		return result;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();

		// Eat whitespace to beginning of next line
		scanner.nextLine();

		RamsonNote s = new RamsonNote(scanner.nextLine(), scanner.nextLine());
		scanner.close();

		boolean answer = s.solve(m, n);
		if (answer)
			System.out.println("Yes");
		else
			System.out.println("No");

	}
}
