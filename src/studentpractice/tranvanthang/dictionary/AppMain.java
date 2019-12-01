package studentpractice.tranvanthang.dictionary;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class AppMain {
	private String[] words;
	public Dictionary D;

	public void loadData(String filename) {
		try {
			Scanner in = new Scanner(new File(filename));
			ArrayList<String> L=new ArrayList<String>();
			while (in.hasNext()) {
				String line = in.nextLine();
				L.add(line);
			}
			words=new String[L.size()];
			for (int i=0;i<L.size();i++){
				words[i]=L.get(i);
				
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void buidDictionary(){
		D = new Dictionary(1000);
		for(int i=0;i<words.length;i++){
			D.insert(words[i]);
			System.out.println("insert WOrds"+i+"/"+words.length);
		}
	}

	public static void main(String[] args) {
		
		AppMain app=new AppMain();
		
		app.loadData("data/words.txt");
		app.buidDictionary();
		app.D.set("computer","mayvitinh");
		System.out.println(app.D.find("computer"));
		app.D.set("teacher","giaovien");
		System.out.println(app.D.find("teacher"));
		///////////sai o ham insert; Dictionary and BST nhe, do chua tinh index de nhet vao bst

	}

}
