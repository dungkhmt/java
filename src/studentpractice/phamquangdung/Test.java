package studentpractice.phamquangdung;

import java.io.File;
import java.util.Scanner;

public class Test {
	public void readWords(String filename){
		try{
			Scanner in = new Scanner(new File(filename));
			int cnt = 0;
			while(in.hasNext()){
				String w = in.nextLine();
				cnt++;
				System.out.println(cnt + ": " + w);
			}
			in.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Test app = new Test();
		//app.readWords("data/words.txt");
		String s = "abc";
		System.out.println(s.hashCode());
	}

}
