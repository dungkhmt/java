package studentpractice.TranBinhMinh;

import java.io.*;
import java.util.Scanner;

public class sort {
	private int[] a;
	private int n;
	public void inputData(String filename) {
		try {
			Scanner in = new Scanner(new File(filename));
			n = in.nextInt(); // scan gia tri int
			a = new int[n];
			for (int i = 0; i < a.length; i++)
				a[i] = in.nextInt();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void swap(int x,int y)
	{
		int temp=a[x];
		a[x]=a[y];
		a[y]=temp;
	}
	public void insertionSort()
	{
		for(int i=1;i<a.length;++i)
		{
			int j=i;
			while(j>0 && a[j]<a[j-1])
				swap(j,j-1);
		}
	}
	public void selectionSort()
	{
		for(int i=0;i<a.length-1;++i)
		{
			int Min=a[i];
			int id=i;
			for(int j=i+1;j<a.length;++j)
			{
				if(a[j]<Min)
				{
					id=j;
					Min=a[j];
				}
			}
			swap(i,id);
		}
	}
	public void bubblesort()
	{
		boolean unsorted = false;
		do
		{
			unsorted = false;
			for(int i=0;i<a.length - 1;++i)
			{
				if(a[i]>a[i+1])
				{
					unsorted = true;
					int temp = a[i];
					a[i]= a[i+1];
					a[i+1] = temp;
				}
			}
		}while(unsorted == true);
	}
	public void mergesort(int l,int r)
	{
		if(l==r) return ;
		int mid = (l+r)/2;
		mergesort(l,mid);
		mergesort(mid+1,r);
		int x=l,y=mid+1,k=0;
		int[] b = new int[r-l+1];
		while(k<=r-l)
		{
			if(x>mid)
			{
				b[k]=a[y];
				k++;
				y++;
				continue;
			}
			if(y>r)
			{
				b[k]=a[x];
				k++;
				x++;
				continue;
			}
			if(a[x]<a[y])
			{
				b[k]=a[x];
				k++;
				x++;
			}
			else
			{
				b[k]=a[y];
				k++;
				y++;
			}
		}
		for(int i=0;i<=r-l;++i)
		{
			a[l+i]=b[i];
			//System.out.print(b[i] + " ");
		}
		//System.out.println("/" + l + " " + r + "/" + x + " " + y);
	}
	public void quicksort (int l,int r)
	{
		if(l>=r) return ;
		int pivot = (l+r)/2;
		int value = a[pivot];
		swap(pivot,r);
		int id=l;
		for(int i=l;i<r;++i)
		{
			if(a[i]<value)
			{
				swap(id,i);
				id++;
			}
		}
		swap(r,id);
		quicksort(l,id-1);
		quicksort(id+1,r);
	}
	public void heapify(int s,int limit)
	{
		if(s*2+1>limit) return ;
		heapify(s*2+1,limit);
		if(a[s]<a[s*2+1])
		{
			swap(s,s*2+1);
			heapify(s*2+1,limit);
		}
		if(s*2+2<=limit)
		{
			heapify(s*2+2,limit);
			if(a[s]<a[s*2+2])
			{
				swap(s,s*2+2);
				heapify(s*2+2,limit);
			}
		}
	}
	public void heapsort()
	{
		for(int i=a.length-1;i>=0;--i)
		{
			heapify(0,i);
			swap(i,0);
		}
	}
	public void print() {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	public static void main(String[] Args) {
		sort app = new sort();
		app.inputData("data/Sequence.txt");
		app.heapsort();
		app.print();
	}
}
