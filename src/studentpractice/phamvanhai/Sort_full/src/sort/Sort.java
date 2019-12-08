package sort;

import java.io.File;
import java.util.Scanner;

public class Sort {
	private int[] a;
	public void inputData(String filename) {
		try {
			Scanner input = new Scanner(new File(filename));
			int n = input.nextInt();
			a = new int[n];
			for(int i = 0; i < a.length; i ++) {
				a[i] = input.nextInt();
			}
			input.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void print() {
		System.out.println("The arrray is: ");
		for(int i = 0; i < a.length; i ++) {
			System.out.print(a[i] + " ");
		}
		System.out.print("\n");
	}
	
	public void selectionSort() {
		for(int i = 0; i < a.length; i ++) {
			int min = a[i];
			int index = i;
			for(int j = i; j < a.length; j ++) {
				if(a[j] < min) {
					min = a[j];
					index = j;
				}
			}
			int tmp = a[i];
			a[i] = min;
			a[index] = tmp;
			for(int k = 0; k < a.length; k ++) {
				System.out.print(a[k] + " ");
			}
			System.out.print("\n");
		}
	}
	
	public void bubbleSort() {
		for(int i = 0; i < a.length; i ++) {
			for(int j = 0; j < a.length - 1; j ++) {
				if(a[j] > a[j + 1]) {
					int tmp = a[j];
					a[j] = a[j + 1];
					a[j + 1 ] = tmp;
				}
			}
			for(int k = 0; k < a.length; k ++) {
				System.out.print(a[k] + " ");
			}
			System.out.print("\n");
		}
	}
	
	public void insertionSort() {
		for(int i = 1; i < a.length; i ++) {
			for(int j = i - 1; j >= 0; j --) {
				if(a[j] > a[i]) {
					int tmp = a[j];
					a[j] = a[i];
					a[i] = tmp;
				}
			}
			for(int k = 0; k < a.length; k ++) {
				System.out.print(a[k] + " ");
			}
			System.out.print("\n");
		}
	}
	
	public int partition(int left, int right) {
		int pivot = right;
		int low = left;
		int high = right - 1;
		while(true) {
			while(low <= high && a[low] < a[pivot]) low ++;
			while(low <= high && a[high] > a[pivot]) high --;
			if(low >= high) break;
			int tmp = a[low];
			a[low] = a[high];
			a[high] = tmp;
			low ++;
			high --;
		}
		int swap = a[low];
		a[low] = a[pivot];
		a[pivot] = swap;
		for(int k = 0; k < a.length; k ++) {
			System.out.print(a[k] + " ");
		}
		System.out.print("\n");
		return low;
	}
	
	public void quickSort(int left, int right) {
		if(left < right) {
			int pi = partition(left, right);
			quickSort(left, pi - 1);
			quickSort(pi + 1, right);
		}
	}
	
	public void merge(int l, int m, int r) {
		int sz1 = m - l + 1;
		int sz2 = r - m;
		
		int[] arr1 = new int[sz1];
		int[] arr2 = new int[sz2];
		
		for(int i = 0; i < sz1; i ++) {
			arr1[i] = a[l + i];
		}
		
		for(int i = 0; i < sz2; i ++) {
			arr2[i] = a[m + i + 1];
		}
		
		int i1 = 0, i2 = 0;
		int k = l;
		while(i1 < sz1 && i2 < sz2) {
			if(arr1[i1] < arr2[i2]) {
				a[k] = arr1[i1];
				i1 ++;
				k ++;
			}
			else {
				a[k] = arr2[i2];
				i2 ++;
				k ++;
			}
		}
		
		while(i1 < sz1) {
			a[k] = arr1[i1];
			i1 ++;
			k ++;
		}
		while(i2 < sz2) {
			a[k] = arr2[i2];
			i2 ++;
			k ++;
		}
		
		for(int i = 0; i < a.length; i ++) {
			System.out.print(a[i] + " ");
		}
		System.out.print("\n");
	}
	
	public void mergeSort(int l, int r) {
		if(l < r) {
			int m = l + (r - l)/2;
			mergeSort(l, m);
			mergeSort(m + 1, r);
			merge(l, m, r);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sort app = new Sort();
		app.inputData("Data/dayso.txt");
		app.print();
		
		System.out.println("Merge sort:");
		app.mergeSort(0, app.a.length - 1);		
		app.print();
	}
}


