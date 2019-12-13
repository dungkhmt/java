package studentpractice.HoangTuanHuy.Dictionary;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
public class AppMain 
{
	private String[] words;
	private Dictionary D;
	///private int n;
	public void loadData(String filename)
	{
		
		try
		{
			Scanner scan= new Scanner(new File(filename));
			ArrayList<String> L = new ArrayList<String>();
			while(scan.hasNext())
			{
				String line = scan.nextLine();
				L.add(line);
			}
			//n=L.size();
			Collections.sort(L);
			scan.close();
			words = new String[L.size()];
			for(int i=0;i<L.size();i++)
				words[i] = L.get(i);
		} 
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	public void outData(String filename) throws IOException
	{
		PrintStream printf = new PrintStream(new File(filename));
		for(int i=0;i<words.length;i++)
			printf.println(words[i]);
		printf.close();
	}
	public void buildDictionary()
	{
		Dictionary D = new Dictionary(1000);
		D.insert(words);
	}
	public static void main(String[] args) throws IOException
	{
		AppMain app = new AppMain();
		app.loadData("data/words.txt");
		app.outData("data/Huysfiletest/words.out");
	}
}
