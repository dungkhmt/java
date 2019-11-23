package studentpractice.trantanminh;

import java.io.File;
import java.util.Scanner;

public class Sort {
    private int[] a;

    /* Input data from a text file */
    public void inputData(String filename) {
        try {
            Scanner in = new Scanner(new File(filename));
            int n = in.nextInt();       /* Scan value int */
            a = new int[n];
            for (int i = 0; i < a.length; i++) {
                a[i] = in.nextInt();
            }
            in.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    /* Print the ordered array*/
    public void print() {
        System.out.println("Your ordered array is: ");
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    /* Swap two elements in the array using its index*/
    public void swap(int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    /* Arrange the array using selection sort algorithm*/
    public void selectionSort() {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[min] > a[j]) min = j;
            }
            int tmp = a[min];
            a[min] = a[i];
            a[i] = tmp;
        }
    }

    /* Arrange the array using insertion sort algorithm*/
    public void insertionSort() {
        for (int i = 1; i < a.length; i++) {
            int last = a[i];
            int j = i;
            while (j > 0 && a[j-1] > last) {
                a[j] = a[j-1];
                j--;
            }
            a[j] = last;
        }
    }

    /* Arrange the array using bubble sort algorithm*/
    public void bubbleSort() {
        int swapped;
        do {
            swapped = 0;
            for (int i = 0; i < a.length-1; i++) {
                if (a[i] > a[i+1]) {
                    swap(i, i+1);
                    swapped = 1;
                }
            }
        } while (swapped == 1);
    }
    public  int partition(int L, int R) {
        int pivot = a[R];
        int i = L-1;
        for (int j = L; j <= R-1; j++) {
            if (a[j] < pivot) {
                i++;
                swap(i, j);
            }
        }
        swap(i+1, R);
        return i+1;
    }

    /* Arrange the array using quick sort algorithm*/
    public void quickSort(int L, int R) {
        if (L < R) {
            int pi = partition(L, R);       /* pi is partitioning index, a[pi] is now at right place*/

            quickSort(L, pi-1);
            quickSort(pi+1, R);
        }
    }

    /* Arrange the array using heap sort algorithm*/
    public void heapSort(int n) {
        buildHeap(n);
        for (int i = n-1; i >= 0; i--) {
            swap(0, i);
            heapify(0, i);
        }
    }
    public void heapify(int i, int n) {
        int L = 2*i+1;
        int R = 2*i+2;
        int max = i;
        if (L < n && a[L] > a[max])
            max = L;
        if (R < n && a[R] > a[max])
            max = R;
        if (max != i) {
            swap(i, max);
            heapify(max, n);
        }
    }
    public void buildHeap(int n) {
        for (int i = n/2-1; i >= 0; i--) {
            heapify(i, n);
        }
    }
	
	/* Arrange the array using merge sort algorithm */
	public void mergeArray(int L, int M, int R) {
        //Find the size of 2 sub-arrays to be merged
        int n1 = M-L+1;
        int n2 = R-M;

        /*Create left array and right sub-array */
        int LeftArray[] = new int[n1];
        int RightArray[] = new int[n2];

        /*Copy data to left and right sub-arrays*/
        for (int i = 0; i < n1; i++) {
            LeftArray[i] = a[L+i];
        }
        for (int i = 0; i < n2; i++) {
            RightArray[i] = a[M+1+i];
        }

        /*Merge the left array and right array*/

        //Initial indexes of left and right sub-arrays
        int i = 0, j = 0;

        //Initial index of the merged array
        int k = L;

        //Merge elements in 2 sub-arrays in ascending order
        while (i < n1 && j < n2) {
            if (LeftArray[i] <= RightArray[j]) {
                a[k] = LeftArray[i];
                i++;
            }
            else {
                a[k] = RightArray[j];
                j++;
            }
            k++;
        }

        //Copy remaining elements of left and right sub-array if any
        while (i < n1) {
            a[k] = LeftArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            a[k] = RightArray[j];
            j++;
            k++;
        }
    }

    /*Merge sort function*/
    public void mergeSort(int L, int R) {
        if (L < R) {
            int M = (L+R)/2;
            mergeSort(L, M);
            mergeSort(M+1, R);
            mergeArray(L, M, R);
        }
    }
	
    /* Main function*/
    public static void main(String[] args) {
        Sort app = new Sort();
        app.inputData("JavaLaboratoryProject/java/data/dayso.txt");
        app.heapSort(11);
        app.print();
		app.mergeSort(0, 9);
		app.print();
    }
}




