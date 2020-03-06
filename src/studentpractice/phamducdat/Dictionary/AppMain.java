package studentpractice.phamducdat.Dictionary;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;

public class AppMain {
	private Dictionary D;
	private String[] words;
	
	public void loadData(String filename) {
		try {
			Scanner in = new Scanner(new File(filename));
			ArrayList<String> L = new ArrayList<String>();
			
			while(in.hasNext()) {
				String line = in.nextLine();
				L.add(line);
				if(L.size() % 10000 == 0)
					System.out.println(line);
				
			}
			in.close();
			Collections.sort(L);
			words = new String[L.size()];
			for(int i = 0; i < L.size(); i++) {
				words[i] = L.get(i);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void buildDictionary() {
		D = new Dictionary(100000);
		D.buildDictionary(words);
	}
	
	public static void main(String[] args) {
		AppMain app = new AppMain();
		app.loadData("data/words.txt");
		app.buildDictionary();
		System.out.println("--------------");
		System.out.println("Enter command: ");
		while(true) {
			Scanner in = new Scanner(System.in);
			String line = in.nextLine();
			String[] s = line.split(" ");
			String cmd = s[0];
			if(cmd.equals("find")){
				String enWord = s[1];
				System.out.println("Vn Meaning = " + app.D.find(enWord));
			}if(cmd.equals("set")) {
				String enWord = s[1];
				String vnMeaning = s[2];
				app.D.set(enWord, vnMeaning);
			}if(cmd.equals("quit"))
				break;
		}
	}

}
