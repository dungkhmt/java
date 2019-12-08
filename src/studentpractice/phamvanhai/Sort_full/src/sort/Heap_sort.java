package sort;

import java.io.File;
import java.util.Scanner;

public class Heap_sort {
	private int[] a;
	
	public void inputData(String fileName) {
		try {
			Scanner in = new Scanner(new File(fileName));
			int n = in.nextInt();
			a = new int[n];
			for(int i = 0; i < a.length; i ++) {
				a[i] = in.nextInt();
			}
			in.close();
		}catch(Exception e) {
			e.getStackTrace();
		}
	}
	
	public void print() {
		System.out.println("The arrray is: ");
		for(int i = 0; i < a.length; i ++) {
			System.out.print(a[i] + " ");
		}
		System.out.print("\n");
	}
	
	public void heapify(int[] arr, int n, int i ) {
		int max = i;
		int left = 2*i;
		int right = 2*i + 1;
		if(left < n && a[left] > a[i]) max = left;
		if(right < n && a[right] > a[max]) max = right;
		
		if(max != i) {
			int tmp = a[i];
			a[i] = a[max];
			a[max] = tmp;
			heapify(arr, n, max);
		}
	}
	
	public void buildHeap(int[] arr, int n) {
		for(int i = n/2; i >= 0; i --) {
			heapify(arr, n, i);
		}
	}
	
	public void heapSort(int[] arr, int n) {
		buildHeap(arr, n);
		for(int i = n - 1; i >= 1; i --) {
			int tmp = a[0];
			a[0] = a[i];
			a[i] = tmp;
			for(int k = 0; k < a.length; k ++) {
				System.out.print(a[k] + " ");
			}
			System.out.print("\n");
			heapify(arr, i, 0);
		}
	}
	
	public static void main(String[] args) {
		Heap_sort app = new Heap_sort();
		app.inputData("Data/dayso.txt");
		app.print();
		System.out.println("Heap sort");
		app.heapSort(app.a, app.a.length);
		app.print();
	}
}
