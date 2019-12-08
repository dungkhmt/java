package studentpractice.TranBinhMinh;
import java.io.*;
import java.util.*;
public class AppMain {
	private String[] words;
	public Dictionary D;
	public void loadData(String filename)
	{
		try
		{
		File f = new File(filename);
		Scanner inp = new Scanner (f);
		ArrayList<String> L = new ArrayList<String>();
		while(inp.hasNext())
		{
			String line = inp.nextLine();
			L.add(line);
		}
		words = new String[L.size()];
		for(int i=0;i<L.size();++i)
		{
			words[i]=L.get(i);
			//if(i%10000==0)
				//System.out.println(words[i]);
		}
		inp.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void buildDictionary()
	{
		D=new Dictionary(1000);
		for(int i=0;i<words.length;++i)
		{
			D.insert(words[i]);
			//System.out.println("insert words " + i + "/" + words.length);
		}
	}
	public static void main(String[] args)
	{
		AppMain app = new AppMain();
		app.loadData("data/words.txt");
		app.buildDictionary();
		app.D.set("computer", "may_vi_tinh");
		System.out.println(app.D.find("computer"));
	}

}
