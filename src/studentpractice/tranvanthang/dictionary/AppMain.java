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
		D.buidDictionary(words);
	}

	public static void main(String[] args) {
		
		AppMain app=new AppMain();
		
		app.loadData("data/words.txt");
		app.buidDictionary();
		app.D.set("computer","mayvitinh");
		System.out.println(app.D.find("computer"));
		app.D.set("teacher","giaovien");
		System.out.println(app.D.find("teacher"));
		while(true){
			System.out.println("Write your command:");
			Scanner scanner=new Scanner(System.in);
			String line=scanner.nextLine();
			String[] sub_word=line.split(" ");
			String cmd=sub_word[0];
			if(cmd.equals("find")){
				String enWord=sub_word[1];
				System.out.println("VN meaning of"+enWord+" is :"+app.D.find(enWord));
			}else if(cmd.equals("set")){
				String enWord=sub_word[1];
				String vnMeaning=sub_word[2];
				app.D.set(enWord, vnMeaning);
			}else if(cmd.equals("quit")){
				break;
			}else{
				System.out.println("Must be: \"find something\" or \"set enWord vnWord\" or \"quit\"");
			}
		}
		

	}

}
