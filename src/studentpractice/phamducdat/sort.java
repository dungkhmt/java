package studentpractice.phamducdat;

import java.io.File;
import java.util.Scanner;

public class sort {
	private int[] a;

	public void inputData(String filename) {
		try {
			Scanner in = new Scanner(new File(filename));
			int n = in.nextInt();
			a = new int[n];
			for (int i = 0; i < a.length; i++)
				a[i] = in.nextInt();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void print() {
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}
	
	public void bubleSort(){
		int swapped;
		do{
			swapped = 0;
			for( int i = 0; i < a.length; i++){
				if( a[i] > a[i+1]){
					int tmp = a[i];
					a[i] = a[i+1];
					a[i+1] = tmp;
					swapped =1;
				}
			}
		}while( swapped == 1);
	}
	
	public void insertionSort(){
		for( int k = 1; k < a.length; k++){
			int last = a[k];
			int j = k;
			while( j > 0 && a[j-1] > last ){
				a[j] = a[j-1];
				j--;
			}
			a[j] = last;
		}
	}

	public void selectionSort() {
		for (int i = 0; i < a.length; i++) {
			int min = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[min] < a[j])
					min = j;
			}
			int tmp = a[min];
			a[min] = a[i];
			a[i] = tmp;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          sort app = new sort();
          app.inputData("src/studentpractice/phamducdat/data/dayso.txt");
          //System.out.print("selectionSort: ");
          //app.selectionSort();
          ///app.print();
          //app.bubleSort();
          //System.out.print("bubleSort: ");
          //app.bubleSort();
          app.insertionSort();
          app.print();
	}

}
