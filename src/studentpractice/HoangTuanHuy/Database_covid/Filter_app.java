package studentpractice.HoangTuanHuy.Database_covid;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Filter_app 
{
	public void run(String filename_in,String filename_out) throws IOException
	{
		File file_in = new File(filename_in) ,
			 file_out = new File(filename_out);
		
		Scanner scan = new Scanner(file_in);
		String code = scan.nextLine();
		
		PrintStream print = new PrintStream(file_out);
		filter(code,print);
		scan.close();
	}
	private void filter(String code,PrintStream print) throws IOException
	{
		int n = code.length();
		boolean td_ok=false;
		boolean comment_ok=false;
		for(int i=0;i<n;i++)
		{
			if(i+2<n && code.charAt(i)=='<' && code.charAt(i+1)=='t' && code.charAt(i+2)=='d' ) td_ok=true;
			if(i+2<n && code.charAt(i)=='<' && code.charAt(i+1)=='!') comment_ok=true;
			if(i-2>0 && code.charAt(i)=='>' && code.charAt(i-1)=='-' && code.charAt(i-2)=='-') comment_ok=false;
			if(i+3<n && code.charAt(i)=='<' && code.charAt(i+1)=='/' && code.charAt(i+2)=='t' && code.charAt(i+3)=='d')
			{
				td_ok=false;
				if(comment_ok==false) print.print("</td> ");
			}
			if(td_ok==true && comment_ok==false) print.print(code.charAt(i));
		}
	}
}
