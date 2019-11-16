package studentpractice.tranvanthang;

import java.io.File;
import java.util.Scanner;

public class Sort {
	private int[] a;

	public void inputData(String filename) {
		try {
			Scanner in = new Scanner(new File(filename));
			int n = in.nextInt();
			a = new int[n];
			for (int i = 0; i < n; i++) {
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
	}

	// ///////////
	public void sapxep1() {
		int swap = 0;
		do {
			swap = 0;
			for (int i = 0; i < a.length - 1; i++) {
				if (a[i] > a[i + 1]) {
					int temp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = temp;
					swap = 1;
				}
			}
		} while (swap != 0);

	}

	// /////////////
	public void insertionSort() {
		for (int i = 1; i < a.length; i++) {
			for (int j = 0; j < i; j++) {
				if (a[i] < a[j]) {
					int temp = a[j];
					a[j] = a[i];
					a[i] = temp;
				}
			}
		}
	}

	// ////////
	public void bubbleSort() {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length - 1; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j + 1] = a[j];
					a[j] = temp;

				}
			}
		}
	}

	public static void main(String[] args) {
		Sort a = new Sort();
		a.inputData("data/dayso.txt");
		a.print();
		Sort b=a;

		// ///// sapxep1
		a.sapxep1();
		System.out.println();
		a.print();

		// ////insertionSort
		a.insertionSort();
		System.out.println();
		a.print();

		// ///////////
		b.bubbleSort();
		System.out.println();
		b.print();

	}

}
