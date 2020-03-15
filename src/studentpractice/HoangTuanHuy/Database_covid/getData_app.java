package studentpractice.HoangTuanHuy.Database_covid;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class getData_app 
{
	ArrayList<String> Listname = new ArrayList<>();
	ArrayList<String> Total_cases = new ArrayList<>();
	ArrayList<String> Total_deaths = new ArrayList<>();
	ArrayList<String> Data = new ArrayList<>();
	
	private String access_file(String filename) throws IOException
	{
		File file = new File(filename);
		Scanner scan = new Scanner(file);
		String code = scan.nextLine();
		scan.close();
		return code;
	}
	private void get_data(String code)
	{
		int n = code.length();
		int i=0;
		while(i<n) /// >?< -> ?
		{
			int id1 = code.indexOf("<td", i);
			int id2 = code.indexOf("</td>",i);
			int id3 = code.indexOf("<a",id1);
			int id4 = code.indexOf("</a>",id1);
			
			if(id1==-1 || id2==-1) break;
			
			i=id2+1;
			if(id3>id2 || id4>id2 || id3==-1 || id4==-1)
			{
				id3 = code.indexOf("<span",id1);
				id4 = code.indexOf("</span>", id1);
			}
			
			if(id3!=-1 && id4!=-1 && id3<id4 && id3<id2 && id4<id2)
			{
				int id5 = code.indexOf(">", id3);
				int id6 = code.indexOf("<", id3+1);
				
				if(id5>id6) continue;
				
				while(id5<=id6 && (code.charAt(id5)==' ' || code.charAt(id5)=='>')) id5++;
				while(id5<=id6 && (code.charAt(id6)==' ' || code.charAt(id6)=='<')) id6--;
				
				if(id5>=id6) Data.add("0");
				else Data.add(code.substring(id5, id6+1));
				continue;
			}
			
			int id5 = code.indexOf(">", id1);
			int id6 = code.indexOf("<", id1+1);
			
			if(id5>id6) continue;
			
			while(id5<=id6 && (code.charAt(id5)==' ' || code.charAt(id5)=='>')) id5++;
			while(id5<=id6 && (code.charAt(id6)==' ' || code.charAt(id6)=='<')) id6--;
			
			if(id5>=id6) Data.add("0");
			else Data.add(code.substring(id5, id6+1));
		}
		int _n = Data.size();
		int type=1;
		for(int j=0;j<_n;j++)
		{
			if(type==1) Listname.add(Data.get(j));
			if(type==2) Total_cases.add(Data.get(j));
			if(type==4) Total_deaths.add(Data.get(j));
			type = ((type==9) ? 1 : type+1);
		}
	}
	public ArrayList<String> getListname()
	{
		return Listname;
	}
	public ArrayList<String> getTotal_cases()
	{
		return Total_cases;
	}
	public ArrayList<String> getTotal_deaths()
	{
		return Total_deaths;
	}
	public void run(String filename_inp, String filename_out) throws IOException
	{
		String code = access_file(filename_inp);
		get_data(code);
	}
	public static void run(String[] args) throws IOException
	{
		getData_app app = new getData_app();
		app.run("data/Huysfiletest/Table_distributed.html", "data/Huysfiletest/ListCountryName.out");
	}
}
