package studentpractice.HoangTuanHuy;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Sort 
{

	private int[] a = new int[1001];
	private int[] ex = new int[1001];
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
	public void out(String filename,String sorting_type) throws IOException
	{
		File file = new File(filename);
		PrintStream my_print = new PrintStream(filename);
		my_print.println(sorting_type);
		//my_print.println(n);
		for(int i=1;i<=n;i++) my_print.print(a[i]+" ");
		//my_print.close();
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
	private void merge_A_B(int l,int mid,int r)
	{
		int i=l,j=mid+1;
		int cnt=0;
		while(i<=mid && j<=r )
		{
			if(a[i]>=a[j])
			{
				cnt++;
				ex[cnt]=a[j];
				j++;
			}
			else
			{
				cnt++;
				ex[cnt]=a[i];
				i++;
			}

		}
		while(i<=mid)
		{
			cnt++;
			ex[cnt]=a[i];
			i++;
		}
		while(j<=r)
		{
			cnt++;
			ex[cnt]=a[j];
			j++;
		}
		for(int z=1;z<=cnt;z++)
		{
			a[l+z-1]=ex[z];
		}
	}
	public void merge_sort(int l,int r)
	{
		if(l>=r) return ;
		int mid=(l+r)/2;
		merge_sort(l,mid);
		merge_sort(mid+1,r);
		merge_A_B(l,mid,r);		
	}
	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		Sort A = new Sort();
		A.inp("data/HTHSorting.inp");
		//A.quick_sort(1, A.n);
		A.merge_sort(1, A.n);
		//A.out("data/HTHSorting.out","Quick Sort:");
		//B.merge_sort(1, B.n);
		//A.out("data/HTHSorting.out", "Merge Sort:");
		//System.out.print(1+"\n"+2);
		//System.out.print(1+"\n"+2);

	}
}