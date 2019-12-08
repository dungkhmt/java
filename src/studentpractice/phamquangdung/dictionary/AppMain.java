package studentpractice.phamquangdung.dictionary;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.io.File;

public class AppMain {
	private String[] words;
	public Dictionary D;
	
	public void loadData(String filename){
		try{
			Scanner in = new Scanner(new File(filename));
			ArrayList<String> L = new ArrayList<String>();
			
			while(in.hasNext()){
				String line = in.nextLine();
				L.add(line);
				if(L.size() % 10000 == 0)
					System.out.println(line);
			}
			in.close();
			Collections.sort(L);
			words = new String[L.size()];
			for(int i = 0; i < L.size(); i++)
				words[i] = L.get(i);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public void buildDictionary(){
		D = new Dictionary(1000);
		//for(int i= 0; i < words.length; i++){
		//	D.insert(words[i]);
		//	System.out.println("insert words " + i + "/" + words.length);
		//}
		D.buildDictionary(words);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AppMain app = new AppMain();
		app.loadData("data/words.txt");
		app.buildDictionary();
		System.out.println("---------------");
		
		while(true){
			System.out.print("enter command: ");
			Scanner in = new Scanner(System.in);
			String line = in.nextLine();
			String[] s = line.split(" ");
			String cmd = s[0];
			if(cmd.equals("find")){
				String enWord = s[1];
				System.out.println("vn meaning of " + enWord + " = " + app.D.find(enWord));
			}else if(cmd.equals("set")){
				String enWord = s[1];
				String vnMeaning = s[2];
				app.D.set(enWord, vnMeaning);
			}else if(cmd.equals("quit")){
				break;
			}
		}
	}

}
