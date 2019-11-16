package studentpractice.NguyenPhiTruong;

import java.io.File;
import java.util.Scanner;

public class sort {
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

	public void insertionSort() {
		for (int i = 1; i < a.length; i++) {
			int last = a[i];
			int j = i;
			while (j > 0 && a[j - 1] > last) {
				a[j] = a[j - 1];
				j--;
			}
			a[j] = last;
		}

	}

	public void selectionSort() {
		for (int i = 0; i < a.length; i++) {
			int min = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[min] > a[j])
					min = j;
			}
			int tmp = a[i];
			a[i] = a[min];
			a[min] = tmp;
		}
	}
	public void print() {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		sort app = new sort();
		app.inputData("C:\\Users\\Admin\\Desktop\\Java\\Java\\src\\studentpractice\\NguyenPhiTruong\\dayso.txt");
		app.print();

		System.out.println("After insertionSort: ");
		app.insertionSort();
		app.print();

		System.out.println("After selectionSort: ");
		app.selectionSort();
		app.print();
		
//		System.out.println("After quicksort: ");
//		app.quicksort(0,a.length()-1);
		
	}
}
