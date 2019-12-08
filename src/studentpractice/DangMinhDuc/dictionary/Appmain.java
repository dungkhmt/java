package studentpractice.DangMinhDuc.dictionary;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Appmain {
	private final String D = null;
	private String[] words;
	public void loadData(String filename) 
	{
		try 
		{
			Scanner in = new Scanner(new File(filename));
			ArrayList<String> L = new ArrayList<String>();
			while(in.hasNext()) 
			{
				String line = in.nextLine();
				L.add(line);
				if(L.size()%10000 == 0)
					System.out.println(line);
			}
			in.close(); 
			words = new String[L.size()];
			for (int i = 0; i < L.size(); i++)
				words[i] = L.get(i);	
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
		}
	}
	public void buildDictionary()
	{
		Dictionary D = new Dictionary(10000);
		for (int i =0; i < words.length; i ++ ) 
		{ 
			D.insert(words[i]);
			System.out.println("insert world"+ i + "/" + words.length);	
		}
	}
	public static void main(String[] args)
	{
		Appmain app = new Appmain();
		app.loadData("E:/Java/java/data/words.txt");
		app.buildDictionary();
		System.out.println("----------");
		
	}

}
