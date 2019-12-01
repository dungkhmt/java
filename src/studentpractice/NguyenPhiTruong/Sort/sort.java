package studentpractice.NguyenPhiTruong.Sort;

import java.io.File;
import java.util.Scanner;

public class sort extends QuickSort {
	public static int[] a;

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

	public void swap(int[] a, int x, int y) {
		int tmp = a[x];
		a[x] = a[y];
		a[y] = tmp;
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

	public void selectionSort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int min = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[min] > a[j])
					min = j;
			}
			swap(a, i, min);
		}
	}

	public int partition(int[] a, int L, int R, int indexPivot) {
		int pivot = a[indexPivot];
		swap(a, indexPivot, R);
		int storeIndex = L;
		for (int i = L; i < R; i++) {
			if (a[i] < pivot) {
				swap(a, storeIndex, i);
				storeIndex++;
			}
		}
		swap(a, storeIndex, R);
		return storeIndex;
	}

//	public void quicksort(int[] a, int L, int R) {
//		if (L < R) {
//			int index = (L + R) / 2;
//			index = partition(a, L, R, index);
//			if (L < index)
//				quicksort(a, L, index - 1);
//			if (index < R)
//				quicksort(a, index + 1, R);
//		}
//		System.out.print("-");
//	}

	public void print() {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		sort app = new sort();
		app.inputData("data\\TruongTest\\dayso.txt");
		System.out.println("Before: ");
		app.print();

		System.out.println("After insertionSort: ");
		app.insertionSort();
		app.print();
//
//		System.out.println("After selectionSort: ");
//		app.selectionSort(a);
//		app.print();

		System.out.println("After quicksort: ");
		app.quicksort(a, 0, a.length - 1);
		app.print();
	}
}
