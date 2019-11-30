package studentpractice.nguyenquanghung;

import java.io.File;
import java.util.Scanner;

public class Sort {
	private static int[] a;

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
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void print() {
		// System.out.println(a.length);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public void insertionSort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int last = a[i];
			int j = i;
			while (j > 0 && a[j - 1] >= last) {
				a[j] = a[j - 1];
				j--;
			}
			a[j] = last;
		}
	}

	public void selectionSort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] > a[j]) {
					int tmp = a[i];
					a[i] = a[j];
					a[j] = tmp;
				}
			}
		}
	}

	public void BubbleSort(int a[]) {
		int flag;
		do {
			flag = 0;
			for (int i = 0; i < a.length - 1; i++) {
				if (a[i] > a[i + 1]) {
					int tmp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = tmp;
					flag = 1;
				}
			}
		} while (flag == 1);

	}

	public void quickSort(int[] a, int l, int r) {
		int i = l;
		int j = r;
		int x = a[(l + r) / 2];

		while (i <= j) {
			while (a[i] < x)
				i++;
			while (a[j] > x)
				j--;
			if (i <= j) {
				int tmp = a[i];
				a[i] = a[j];
				a[j] = tmp;
				i++;
				j--;
			}
		}
		if (i < r)
			quickSort(a, i, r);
		if (j > l)
			quickSort(a, l, j);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sort app = new Sort();
		app.inputData("data\\hungtestfile\\Sort.txt");
		app.print();
		app.BubbleSort(a);
		//app.insertionSort(a);
		//app.selectionSort(a);
		//app.quickSort(a, 0, a.length - 1);
		app.print();
	}

}
