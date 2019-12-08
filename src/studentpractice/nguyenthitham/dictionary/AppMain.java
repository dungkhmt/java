package studentpractice.nguyenthitham.dictionary;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class AppMain {
	private String[] words;
	public Dictionary D;
	public void loadData(String filename){
		try{
			Scanner in = new Scanner(new File(filename));
			ArrayList<String>L = new ArrayList<String>();
			while(in.hasNext()){
				String line= in.nextLine();
				L.add(line);
				if(L.size()%10000==0)
					System.out.println(line);
			}
			in.close();
			
			words = new String[L.size()];
			for(int i=0; i<L.size(); i++){
				words[i]=L.get(i);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public void buildDictionary(){
		D= new Dictionary(1000);
		for(int i=0; i<words.length; i++){
			D.insert(words[i]);
			System.out.println("insert words "+i+"/" + words.length);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AppMain app= new AppMain();
		app.loadData("data/words.txt");
		app.buildDictionary();
		System.out.println("------------");
		app.D.set("hello", "xin chao");
		System.out.println(app.D.find("hello"));
		
	}
	
	

}
