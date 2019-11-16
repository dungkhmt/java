package studentpractice.trantanminh;

import java.io.File;
import java.util.Scanner;

public class Sort {
    private int[] a;

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
    public void print() {
        System.out.println("Your ordered array is: ");
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
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
        print();
    }
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
        print();
    }
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
    public void swap(int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
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
    public void quickSort(int L, int R) {
        if (L < R) {
            int pi = partition(L, R);       /* pi is partitioning index, a[pi] is now at right place*/

            quickSort(L, pi-1);
            quickSort(pi+1, R);
        }
    }
    public static void main(String[] args) {
        Sort app = new Sort();
        app.inputData("data/dayso.txt");
        app.quickSort(0, 4);
        app.print();
    }
}



