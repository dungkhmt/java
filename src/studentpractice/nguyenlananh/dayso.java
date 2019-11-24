package studentpractice.nguyenlananh;

import java.io.File;
import java.util.Scanner;

public class dayso {
	private int[] dayso;
	private int[] a;
	
	public void inputData(String filename) {
		try {
			Scanner a = new Scanner( new File (filename));
			int n = a.nextInt();
			dayso = new int[n];
			for ( int i=0; i<n; i++) {
				dayso[i]= a.nextInt();
			}
			a.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	
		
	}
	
	
	public void Print() {
		for(int i=0; i<dayso.length; i++) {
			System.out.print(dayso[i]+" ");
		}
	}
	
	
	public void insertionSort() {
		for(int i=1; i<dayso.length; i++) {
			int last= dayso[i];
			int j=i;
			while(j>0 && dayso[j-1] > last) {
				dayso[j]=dayso[j-1];
				j--;
			}
			dayso[j]=last;
		}
		
	}
	
	public void selectionSort() {
		for(int i=0; i<dayso.length; i++) {
			int min=i;
			for(int j=i+1; j<dayso.length; j++) {
				if(dayso[j]<dayso[i]) min=j;
			}
			int t=dayso[min];
			dayso[min]=dayso[i];
			dayso[i]=t;
		}
	}
	
	
	public void bubbleSort() {
		int s;
		do {
			s=0;
			for(int i=0; i<dayso.length-1; i++) {
				if(dayso[i]>dayso[i+1]) {
					int t=dayso[i];
					dayso[i]=dayso[i+1];
					dayso[i+1]=t;
					s=1;
				}
			}
		} while(s==1);
	}
	
	
	public void mergeSort(int L, int R) {
		if(L<R) {
			int m=(L+R)/2;
			mergeSort(L,m);
			mergeSort(m+1,R);
			merge(L,m+1,R);
		}
		
	}
	
	
	public void merge(int L, int m, int R) {
		int i=L; int j=m+1;
		a=new int[R-L+1];
		for(int k=L; k<=R; k++) {
			if(i>m) {
				a[k]=dayso[j]; 
				j++;
			}
			if(j>R) {
				a[k]=dayso[i];
				i++;
			}
			if(dayso[i]<dayso[j]) {
				a[k]=dayso[i]; i++;
			}
			else {
				a[k]=dayso[j]; j++;
			}
		}
		for(int k=0; k < dayso.length; k++) {
			dayso[k]=a[k];
		}
	}
	
	
	public static void main(String[] args) {
		dayso p = new dayso();
		p.inputData("D:/dayso.txt");
		p.Print();
		p.insertionSort();
		System.out.println("-sap xep chen");
		p.Print();
		p.selectionSort();
		System.out.println("-sap xep lua chon");
		p.Print();
		p.bubbleSort();
		System.out.println("-sap xep noi bot");
		p.Print();
		p.mergeSort(0, p.dayso.length);
		System.out.println("-sap xep tron");
		p.Print();
	}
}
