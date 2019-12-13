package studentpractice.TranMinhCong.dictionary;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class AppMain {
	private String[] words;
	public Dictionary D;
	public void loadData(String fileName) {
		try {
			Scanner in = new Scanner(new File(fileName));
			ArrayList<String> L = new ArrayList<String>();
			while(in.hasNext()) {
				String line = in.nextLine();
				L.add(line);
			}
			in.close();
			Collections.sort(L);
			words = new String[L.size()];
			System.out.println(L.size());
			for(int i = 0 ;  i < L.size(); i++) {
				words[i] = L.get(i);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	public void out()
	{
		try {
			PrintStream out = new PrintStream(new File("out.txt"));
			for(int i = 0 ; i < words.length ; i++) {
				out.println(words[i]);
			}
			out.close();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	public void buildDictionary() {
		D = new Dictionary(1000);
		for(int i = 0 ; i <words.length ; i++) {
			D.insert(words[i]);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AppMain app = new AppMain();
		app.loadData("data/words.txt");
		app.buildDictionary();
		app.out();
		app.D.set("computer", "may_vi_tinh");
		System.out.println(app.D.find("computer"));
	}

}
