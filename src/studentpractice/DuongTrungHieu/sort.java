package sort;

import java.io.File;
import java.util.Scanner;
public class sort {
	private int[] a;
	private int n;
	public void inputData(String filename) {
		try {
			Scanner in = new Scanner(new File(filename));
			n = in.nextInt();
			a = new int[n];
			for(int i=0; i< a.length; i++) 
				a[i]=in.nextInt();
			in.close();
			}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	private void swap(int i , int j) {
		int x = a[i];
		a[i] = a[j];
		a[j] = x;
	}
	public void print(int low , int high) {
		for(int i = low ; i <= high ; i++) System.out.print(a[i] + " ");
		System.out.println();
	}
	private int partition(int low ,int high) {
		int pivot = a[high];
		int i = low - 1;
		for(int j = low ; j < high ; j++) {
			if(a[j] < pivot)
			{
				i++;
				swap(i,j);
			}
		}
		swap(i + 1 , high);
		return i + 1;
	}
	public void bubbleSort(int low ,int high) {
		int swap;
		do {
			swap=0;
			for(int i=low;i<high-1;i++) {
				if( a[i] > a[i+1]) {
					int tmp = a[i];
					a[i]=a[i+1];
					a[i+1]=tmp;
					swap=1;
				}
			}
		}while(swap==1);
	}
	public void quickSort(int low , int high) {
		if(low >= high) return ;
		int mid = partition(low , high);
		quickSort(low , mid - 1);
		quickSort(mid + 1, high);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sort arr = new sort();
		arr.inputData("data/data.txt");
		arr.quickSort(0, arr.a.length - 1);
		arr.print(0 , arr.a.length -1 );
		arr.bubbleSort(0, arr.a.length -1);
		arr.print(0, arr.a.length -1);
	}

}
