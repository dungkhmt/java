package studentpractice.TranMinhCong;

import java.io.File;
import java.util.Scanner;

public class Sort {
	private int[] a;
	public void inputData(String filename) {
		try {
			Scanner in = new Scanner(new File(filename));
			int n = in.nextInt();
			a = new int[n];
			for (int i = 0; i < a.length; i++) {
				a[i] = in.nextInt();
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void print() {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	private void swap(int i , int j) {
		int c = a[i];
		a[i] = a[j];
		a[j] = c;
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
	private void quickSort(int low , int high) {
		if(low >= high) return ;
		int pivot = partition(low , high);
		quickSort(low , pivot - 1);
		quickSort(pivot + 1, high);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sort app = new Sort();
		app.inputData("data/dayso.txt");
		app.quickSort(0,app.a.length - 1);
		//app.print();
		
	}
}
