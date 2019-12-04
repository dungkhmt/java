package studentpractice.DangMinhDuc;

import java.io.File;
import java.util.Scanner;
public class Sort {
	static int[] a;
	static int n;
	public void input(String filename)
	{
		try 
		{
			Scanner in = new Scanner (new File(filename));
			int n = in.nextInt();
			a = new int[n];
			for (int i=0; i<a.length; i++)
				a[i]=in.nextInt();
		in.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void print ( int low, int high) {
		System.out.println("Mang da sort: ");
		for ( int i = low; i < a.length; i++)
			System.out.println("a[]" + a[i]);
	}
	public static void swap (int t, int p) {
		int tmp; 
		tmp=p;
		p = t;
		t = tmp;
	}

	public static void main(String[] args) {
		Sort app = new Sort ();
		app.input ( "data/dayso.txt" );
		
	for (int i = 0; i <a.length-1 ; i++)
			for (int j = i; j <a.length; j++)
			{
				if (a[i] > a[j]);
				swap (a[i],a[j]);
			}
	app.print (0 , a.length);
		
	}
}

