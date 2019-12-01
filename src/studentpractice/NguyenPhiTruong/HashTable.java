package studentpractice.NguyenPhiTruong;

import java.io.File;
import java.util.Scanner;
import java.util.Hashtable;
//import java.util.Set;
import java.util.LinkedList;

public class HashTable {
	public static Hashtable<Integer, LinkedList<Word>> Dictionary = new Hashtable<Integer, LinkedList<Word>>();

	public void addToDic(int key, String w) {
		if (Dictionary.containsKey(key) == false) {
			LinkedList<Word> W = new LinkedList<Word>();
			Word word = new Word(w);
			W.addLast(word);
			Dictionary.put(key, W);
//			System.out.print("add\n");
		} else {
			LinkedList<Word> W = Dictionary.get(key);
			Word word = new Word(w);
			W.addLast(word);

		}
	}

	public int cal(String word) { // them tu moi vao hashtable
		double sum = 0;
		for (int i = 0; i < word.length(); i++) {
			sum = sum + ((int) (word.charAt(i))) * (Math.pow(10, word.length() - i - 1));
		}
		int key = (int) (sum % 500009);
		return key;
	}

	public void build(String filename) {
		try {
			Scanner input = new Scanner(new File(filename));
			while (input.hasNextLine()) {
				String w = input.nextLine();
				int key = cal(w);
				addToDic(key, w);
			}
			input.close();
		} catch (Exception e) {
			System.out.print("File not found");
		}
	}

	public void find() {
		String word;
		Scanner input = new Scanner(System.in);
		word = input.nextLine();
		input.close();
		int key = cal(word);
		boolean check = Dictionary.containsKey(key);
		if (check == false)
			System.out.print("NOT FOUND THIS WORDD");
		else {
			LinkedList<Word> W = Dictionary.get(key);
			for (Word i : W) {
				if (word.equalsIgnoreCase(i.en)) {
					System.out.print("FOUND");
					return;
				}
			}
			System.out.print("NOT FOUND THIS WORD");
		}
	}

	public static void main(String[] args) {
		HashTable S = new HashTable();
		S.build("data\\TruongTest\\words.txt");
		S.find();
	}

}
