package studentpractice.Ngodinhsang;

import java.io.File;
import java.util.*;

public class Sort 
{
private int[] a;
	
	public void inputData(String filename)
	{
		try
		{
			Scanner in=new Scanner(new File(filename));
			int n=in.nextInt();
			a=new int[n];
			for(int i=0;i<a.length;i++)
			{
				a[i]=in.nextInt();
			}
			in.close();	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void selectionsort()
	{
		for(int k=0;k<a.length;k++)
		{
			int min=k;
			for(int j=k+1;j<a.length;j++)
				if(a[j]<a[min]) min=j;
			int tg=a[k];
			a[k]=a[min];
			a[min]=tg;
		}
	}
	public void print()
	{
		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]+ " ");
		}
		System.out.println();
	}
	public static void main(String[] args)
	{
		Sort app=new Sort();
		app.inputData("data/dayso.txt");
		app.print();
		app.selectionsort();
		app.print();
	}
}
