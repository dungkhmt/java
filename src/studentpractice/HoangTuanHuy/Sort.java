package studentpractice.HoangTuanHuy;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Sort 
{

	private int[] a = new int[1001];
	private int n;
	public void inp(String filename) throws IOException
	{
		File file = new File(filename);
		Scanner scan = new Scanner(file);
		n = scan.nextInt();
		for(int i=1;i<=n;i++) a[i]=scan.nextInt();
		/*try
		{
			Scanner scan = new Scanner(file);
			scan.close();
		} catch(Exception e)
		{
			e.printStackTrace();
		}*/ ///Finding mistakes making errors
		scan.close();
		
	}
	public void out(String filename) throws IOException
	{
		File file = new File(filename);
		PrintStream my_print = new PrintStream(filename);
		my_print.println(n);
		for(int i=1;i<=n;i++) my_print.print(a[i]+" ");
		my_print.close();
	}
	private void swap(int i,int j)
	{
		int tg=a[i];
		a[i]=a[j];
		a[j]=tg;
	}
	public void quick_sort(int l,int r)
	{
		if(l>=r) return;
		int mid=(l+r)/2;
		int target=a[mid];
		swap(mid,r);
		int index=l;
		for(int i=l;i<=r-1;i++)
		{
			if(a[i]<=target)
			{
				swap(i,index);
				index++;
			}
		}
		swap(index,r);
		if (index>l) quick_sort(l,index-1);
		if (index<r) quick_sort(index+1,r);
	
	}
	public void merge_sort(int l,int r)
	{
		if(l>=r) return ;
		int mid=(l+r)/2;
		merge_sort(l,mid);
		merge_sort(mid+1,r);
		
		
		
	}
	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		Sort A = new Sort();
		Sort B = new Sort();
		A.inp("data/Sorting.inp");
		B=A;
		A.quick_sort(1, A.n);
		A.out("data/Sorting.out"); 
		//System.out.print(1+"\n"+2);

	}
}