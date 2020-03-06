package studentpractice.phamvanhai;

import java.io.File;
import java.util.Scanner;

public class Sort {
	private int[] a;
	public void inputData(String filename) {
		try {
			Scanner in = new Scanner(new File(filename));
			int n = in.nextInt();
			a = new int[n];
			for(int i = 0; i < a.length; i ++ ) {
				a[i] = in.nextInt();
			}
			in.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void print() {
		for(int i = 0; i < a.length; i ++) {
		System.out.print(a[i] + " ");
		}
		System.out.print("\n");
	}
	
	public void selectionSort() {
		for(int i =  0; i < a.length; i ++) {
			for(int j = i; j < a.length - 1; j ++) {
			if(a[i] > a[j + 1]) { 
				int tmp;
				tmp = a[i];
				a[i] = a[j + 1];
				a[j + 1] = tmp;
				}
			}
		}
	}
	
	public void insertionSort() {
		for(int i = 1; i < a.length - 1; i ++) {
			int key = a[i];
			int j = i - 1;
			while(j >= 0 && a[j] > key) {
				a[j + 1] = a[j];
				j = j - 1;
			} 
			a[j + 1] = key;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sort app = new Sort();
		app.inputData("data/dayso.txt");
		app.print();
		System.out.println("Selection Sort:");
		app.selectionSort();
		app.print();
		System.out.println("Insertion Sort:");
		app.insertionSort();
		app.print();
	}

}
