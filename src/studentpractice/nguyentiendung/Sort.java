package studentpractice.nguyentiendung;

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
			e.printStackTrace();
		}
	}

	public void print() {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.print("\n");
	}
	public void insertionSort() {
		// k: 1->n
		for (int k = 1; k < a.length; k++) {
			int last = a[k];
			int j = k;
			while (j > 0 && a[j - 1] > last) {
				a[j] = a[j - 1];
				j--;
			}
			a[j] = last;
		}
	}

	public void selectionSort() {
		for (int k = 0; k <= a.length - 1; k++) {
			for (int j = k + 1; j < a.length; j++) {
				if (a[k] > a[j]) {
					int tmp= a[k];
					a[k]=a[j];
					a[j]=tmp;
				}
			}
		}
	}

	public void bubbleSort() {
		int check =1;
		while (check == 1){
			check=0;
			for (int k = 0; k < a.length-1; k++) {
				if (a[k] > a[k + 1]) {
					int tmp= a[k];
					a[k]=a[k+1];
					a[k+1]=tmp;
					check = 1;
				}
			}
		} 
	}
	/*Merge Sort
		public void merge(int l, int m, int r) {
		int i = l;
		int j = m + 1;
		for (int k = l; k < a.length; k++) {
			if (i > m) {
				AR[k] = a[j];
				j++;
			} else if (j > r) {
				AR[k] = a[i];
				i++;
			} else {
				if (a[i] < a[j]) {
					AR[k] = a[i];
					i++;
				} else
					AR[k] = a[j];
			}
		}
		for (int k = 0; k < a.length; k++)
			a[k] = AR[k];
	}

	public void mergeSort(int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;
			mergeSort(l, m);
			mergeSort(m + 1, r);
			merge(l, m, r);
		}
	}   
	Quick Sort...
		public int partition(int L, int R) {
		int pivot= a[R];
		int storeIndex=L;
		int tmp = a[storeIndex];
		a[storeIndex]=a[R];
		a[R]=tmp;
		for(int k=0;k<R;k++) {
			if(a[k]<pivot) {storeIndex++;
				int tmp1=a[storeIndex];
				a[storeIndex]=a[k];
				a[k]=tmp1;
			}
		}
		int tmp2=a[storeIndex];
		a[storeIndex]=a[R];
		a[R]=tmp2;
		return storeIndex;}
		public void quickSort(int L, int R) {
			if(L<R) {
			int index=partition(L,R);
			quickSort(L,index-1);
			quickSort(index+1,R);
			}
	}*/
	 /*public void quickSort(int L, int R) {
			 int I=partition(L,R,(L+R)/2);
			 if(L<I)
			 quickSort(L,I-1);
			 if(I<R)
			 quickSort(I+1,R);
		 }
	
	 public int partition(int L, int R, int Ip) {
		 int pivot=a[Ip];
		 int tmp= a[R];
		 a[R]=a[Ip];
		 a[Ip]=tmp;
		 int sI=L;
		 for(int k=L;k<=R-1;k++) {
			 if(a[k]<pivot) {
				
				 int tmp0=a[k];
				 a[k]=a[sI];
				 a[sI]=tmp0;
				 sI++;
			 }
			 int tmp1=a[sI];
			 a[sI]=a[R];
			 a[R]=tmp1;
		 }
		 print();
		return sI; 
	 }/*public  int partition(int L, int R) {
	        int pivot = a[R];
	        int i = L-1;
	        for (int j = L; j <= R-1; j++) {
	            if (a[j] < pivot) {
	                i++;
	                int tmp0=a[i];
					 a[i]=a[j];
					 a[j]=tmp0;
	            }
	        }
	        int tmp=a[i+1];
			 a[i+1]=a[R];
			 a[R]=tmp;
	        return i+1;
	    }*/
	public void swap(int[] a, int x, int y) {
		int tmp = a[x];
		a[x] = a[y];
		a[y] = tmp;
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

	public void quicksort(int[] a, int L, int R) {
		if (L < R) {
			int index = (L + R) / 2;
			index = partition(a, L, R, index);
			if (L < index)
				quicksort(a, L, index - 1);
			if (index < R)
				quicksort(a, index + 1, R);
		}
		System.out.print("-");
	}

	   	   


	public static void main(String[] args) {
		Sort app = new Sort();
		app.inputData("data\\dayso.txt");
		app.print();
		/*app.insertionSort();
		app.print();
		app.selectionSort();
		app.print();
		app.bubbleSort();
		app.print();*/
		app.quicksort(a,0, 4);
		app.print();
	}

}