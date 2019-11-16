package studentpractice.phamquangdung;

import java.io.File;
import java.util.Scanner;


public class Sort {
	private int[] a;
	
	public void inputData(String filename){
		try{
			Scanner in = new Scanner(new File(filename));
			int n = in.nextInt();// scan gia tri int
			a = new int[n];
			for(int i = 0; i < a.length; i++)
				a[i] = in.nextInt();
			in.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void print(){
		for(int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}
	
	public void selectionSort(){
		
	}
	public void insertionSort(){
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sort app = new Sort();
		app.inputData("data/dayso.txt");
		app.print();
	}

}
