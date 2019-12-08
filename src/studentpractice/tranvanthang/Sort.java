package studentpractice.tranvanthang;

import java.io.File;
import java.util.Scanner;

/**
 * @author Administrator
 *
 */
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

	// /////////////////////
	public static void mergingSort(int[] array) {
		sort(array, 0, array.length - 1);

	}

	private static void sort(int[] data, int left, int right) {
		if (left < right) {
			int center = (left + right) / 2;
			sort(data, left, center);
			sort(data, center + 1, right);
			merge(data, left, center, right);
		}
	}

	private static void merge(int[] data, int left, int center, int right) {
		int[] tmpArr = new int[data.length];
		int mid = center + 1;
		int third = left;
		int tmp = left;
		while (left <= center && mid <= right) {
			if (data[left] <= data[mid]) {
				tmpArr[third++] = data[left++];
			} else {
				tmpArr[third++] = data[mid++];
			}
		}

		while (mid <= right) {
			tmpArr[third++] = data[mid++];
		}

		while (left <= center) {
			tmpArr[third++] = data[left++];
		}

		while (tmp <= right) {
			data[tmp] = tmpArr[tmp++];
		}
	}

	// ////////
	public static void quickSort(int[] array) {  
	    _quickSort(array, 0, array.length - 1);  
	      
	}  
	  
	  
	private static int getMiddle(int[] list, int low, int high) {  
	    int tmp = list[low];    
	    while (low < high) {  
	        while (low < high && list[high] >= tmp) {  
	            high--;  
	        }  
	  
	  
	        list[low] = list[high];   
	        while (low < high && list[low] <= tmp) {  
	            low++;  
	        }  
	  
	  
	        list[high] = list[low];   
	    }  
	    list[low] = tmp;              
	    return low;                  
	}  
	  
	  
	private static void _quickSort(int[] list, int low, int high) {  
	    if (low < high) {  
	        int middle = getMiddle(list, low, high);  
	        _quickSort(list, low, middle - 1);      
	        _quickSort(list, middle + 1, high);      
	    }  
	}  
	////////////
	
	public void heapSort(int[] list){
		buidHeap(list);
		for(int i=list.length-1;i>=1;i--){
			swap(i,0,list);
			heapify(list,0,i-1);
		}
		
	}
	public void buidHeap(int[] list){
		for(int i=list.length/2;i>=0;i--){
			heapify(list,i,list.length-1);
		}
	}
	public void heapify(int[] list,int i,int n){
		int right=2*i+2;
		int left=2*i+1;
		int temp=left;
		if(right<=n && left<=n &&list[right]>list[left]){
			temp=right;
		}
		if(left<=n && list[temp]>list[i]){
			swap(temp,i,list);
			heapify(list,temp,n);
		}
	}
	
	///////////
	public void bubbleSort() {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length - 1; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j + 1];
					a[j + 1] = a[j];
					a[j] = temp;

				}
			}
		}
	}

	// /////////
	public void swap(int i, int j, int[] arr) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		Sort a1 = new Sort();
		a1.inputData("src/studentpractice/tranvanthang/dayso.txt");
		a1.print();
		a1.sapxep1();
		System.out.println();
		a1.print();

		// ////insertionSort
		Sort b = new Sort();
		b.inputData("src/studentpractice/tranvanthang/dayso.txt");
		b.insertionSort();
		System.out.println();
		b.print();

		// ///////////
		Sort c = new Sort();
		c.inputData("src/studentpractice/tranvanthang/dayso.txt");
		c.bubbleSort();
		System.out.println();
		c.print();
		// ///////////
		Sort d = new Sort();
		d.inputData("src/studentpractice/tranvanthang/dayso.txt");
		System.out.println();
		d.mergingSort(d.a);
		d.print();
		// /////////
		Sort e = new Sort();
		e.inputData("src/studentpractice/tranvanthang/dayso.txt");
		e.quickSort(e.a);
		System.out.println();
		e.print();
		/////////////
		Sort f = new Sort();
		f.inputData("src/studentpractice/tranvanthang/dayso.txt");
		f.heapSort(f.a);
		System.out.println();
		f.print();

	}

}
