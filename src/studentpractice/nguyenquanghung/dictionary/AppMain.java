package studentpractice.nguyenquanghung.dictionary;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AppMain {
	private String[] words;
	public Dictionary D;

	public void loadData(String filename) {
		try {
			Scanner in = new Scanner(new File(filename));
			ArrayList<String> L = new ArrayList<String>();
			while (in.hasNext()) {
				String line = in.nextLine();
				L.add(line);
			}
			Collections.sort(L);
			in.close();
			words = new String[L.size()];
			for (int i = 0; i < L.size(); i++)
				words[i] = L.get(i);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void builDictionary() {
		D = new Dictionary(1000);
		for (int i = 0; i < words.length; i++) {
			D.insert(words[i]);
		}
	}
	/*
	public void printFile(String filename) {
		FileWriter writer= new FileWriter(filename);
		for (int i = 0; i < words.length; i++) {
			writer.write(words[i] + "\n");
		}
		writer.close();
	}
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AppMain app = new AppMain();
		app.loadData("data\\words.txt");
		app.builDictionary();
		System.out.println("Starting ...");
		//app.D.set("a", "chu a");
		//System.out.println(app.D.find("a"));
		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter the command (find/set/quit): ");
			String cmd = scanner.nextLine();
			if (cmd.equals("find")==true) {
				System.out.println("Enter the word: ");
				String s = scanner.next();
				System.out.println("Vietnamese meaning of " + s + " is " + app.D.find(s));
			}
			else if (cmd.equals("set")==true) {
				System.out.print("EnWord: ");
				String s1 = scanner.next();
				System.out.print("VnMeaning: ");
				String s2 = scanner.next();
				app.D.set(s1, s2);
			}
			else if (cmd.equals("quit")) {
				System.out.println("Exit !");
				break;
			}
		}
	}
}
