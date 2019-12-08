package studentpractice.DuongTrungHieu.Dictionary;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class Appmain {
	private String[] words;
	public Dictionary D;
	public void loadData(String filename) {
		try {
			Scanner in = new Scanner(new File(filename));
			ArrayList<String> L=new ArrayList<String>();
			while(in.hasNext()) {
				String line = in.nextLine();
				L.add(line);
				System.out.println(line);
			}
			in.close();
			words = new String[L.size()];
			for(int i = 0; i < L.size(); i++)
				words[i] = L.get(i);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	public void buildDictionary() {
		D = new Dictionary(1000);
		for(int i = 0; i < words.length; i++)
			D.insert(words[i]);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Appmain app = new Appmain();
		app.loadData("D:\\javatraining\\java\\data\\words.txt");
		app.buildDictionary();
		System.out.println("--------");
		app.D.set("computer","may vi tinh");
		System.out.println(app.D.find("computer"));
	}

}
