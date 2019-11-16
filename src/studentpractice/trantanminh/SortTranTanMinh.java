import java.io.File;
import java.util.Scanner;

public class SortTranTanMinh {
    private int[] a;

    public void inputData(String filename){
        try {
            Scanner in = new Scanner(new File(filename));
            int n = in.nextInt();       /* Scan value int */
            a = new int[n];
            for (int i = 0; i < a.length; i++) {
                a[i] = in.nextInt();
            }
            in.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void print(){
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
    public void selectionSort(){
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[min] > a[j]) min = j;
            }
            int tmp = a[min];
            a[min] = a[i];
            a[i] = tmp;
        }
        System.out.println("Your ordered array is: ");
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
    public void insertionSort(){
        for (int i = 1; i < a.length; i++) {
            int last = a[i];
            int j = i;
            while (j > 0 && a[j-1] > last){
                a[j] = a[j-1];
                j--;
            }
            a[j] = last;
        }
        System.out.println("Your ordered array is: ");
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
    public static void main(String[] args){
        SortTranTanMinh app = new SortTranTanMinh();
        app.inputData("src/Random.txt");
        app.print();
        app.insertionSort();
    }
}

