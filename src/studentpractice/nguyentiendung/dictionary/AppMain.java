package studentpractice.nguyentiendung.dictionary;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class AppMain {
	private String[] words;
	public dictionary Dty;
	public void inputData(String filename) {
		try {
			Scanner input= new Scanner(new File(filename));
			ArrayList<String> L= new ArrayList<String>();
			while(input.hasNextLine()) {
				String line=input.nextLine();
				L.add(line);
			}
			input.close();
			words= new String[L.size()];
			for(int i=0; i<L.size();i++) {
				words[i]=L.get(i);
			}
		}catch (Exception e) {
		  e.printStackTrace();
		}
	}
	public void buildDictionary(){ 
		Dty= new dictionary(1000);
		Dty.buildDictionary(words);
	}
	public static void main(String[] args) {
	//	dictionary Dty= new dictionary(1000);
		AppMain app= new AppMain();
		app.inputData("data/words.txt");
		app.buildDictionary();
		while(true){
			System.out.print("enter command: ");
			Scanner in = new Scanner(System.in);
			String line = in.nextLine();
			String[] s = line.split(" ");
			String cmd = s[0];
			if(cmd.equals("find")){
				String enWord = s[1];
				System.out.println("vn meaning of " + enWord + " = " + app.Dty.find(enWord));
			}else if(cmd.equals("set")){
				String enWord = s[1];
				String vnMeaning = s[2];
				app.Dty.set(enWord, vnMeaning);
			}else if(cmd.equals("quit")){
				break;
			}
	}

	}}
