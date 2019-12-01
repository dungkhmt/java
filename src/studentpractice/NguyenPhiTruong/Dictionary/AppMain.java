package studentpractice.NguyenPhiTruong.Dictionary;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class AppMain {
	private String[] words;
	public Dictionary D;

	public void inputData(String filename) {
		try {
			Scanner input = new Scanner(new File(filename));
			ArrayList<String> L = new ArrayList<String>();
			while (input.hasNextLine()) {
				String line = input.nextLine();
				L.add(line);
			}
			input.close();
			words = new String[L.size()];
			for (int i = 0; i < L.size(); i++) {
				words[i] = L.get(i);
//				if (i % 1000 == 0)
////					System.out.print(L.get(i) + "\n");
			}
		} catch (Exception e) {
			System.out.print("File not found");
		}
	}

	public void buidDictionary() {
		D = new Dictionary(1000);
		for (int i = 0; i < words.length; i++) {
			D.insert(words[i]);
		}
	}

	public static void main(String[] args) {
//		Dictionary D = new Dictionary(1000);
		AppMain app = new AppMain();
		app.inputData("data\\words.txt");
		app.buidDictionary();
		app.D.set("computer", "may_tinh");
		System.out.print(app.D.find("computer"));
	}
}
