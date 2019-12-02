package studentpractice.Ngodinhsang.dictionary;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class AppMain {
	private String[] words;
	public void loadData(String filename)
	{
		try 
		{
			Scanner in =new Scanner (new File(filename));
			ArrayList<String> L=new ArrayList<String>();
			while(in.hasNext())
			{
				String line=in.nextLine();
				L.add(line);
			}
			in.close();
			words = new String[L.size()];
			for(int i=0; i<L.size();i++)
			{
				words[i]= L.get(i);
			}
		}catch(Exception 
				ex) {
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		AppMain app=new AppMain();
		app.loadData("data/words.txt");
		
	}

}
