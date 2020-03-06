package studentpractice.NguyenPhiTruong.String;

import java.util.Scanner;
import java.io.File;
public class KMP {
	public SuperString spS;
	public SubString sbS;
	public int[] pi;
	
	public void loadData(String filename) {
		try {
			Scanner scan = new Scanner(new File(filename));
			spS = new SuperString();
			sbS = new SubString();
			
			String input = scan.nextLine();
			spS.setSuperString(input);
			
			input = scan.nextLine();
			sbS.setSubString(input);
			
			pi = new int[sbS.subString.length() + 1];
			scan.close();
		} catch(Exception e) {
			System.out.println("File not found");
		}
	}
	
	public void countPi() {
		pi[1] = 0;
		int k = 0;
		for (int i = 2; i <= sbS.subString.length(); i++) {
			while (k > 0 && sbS.getCharAt(k+1) != sbS.getCharAt(i)) {
				k = pi[k];
//				System.out.println("step " + i + ": k = " + k);
			}
			if (sbS.getCharAt(k+1) == sbS.getCharAt(i)) k++;
			pi[i] = k;
			System.out.println("pi[" + i + "] = " + pi[i]);
		}
		
	}
	
	public void kmp() {
		System.out.println("superString: " + spS.superString);
		System.out.println("subString: " + sbS.subString);
		System.out.println("Find SubString at ");
		int k = 0;
		for (int i = 1; i <= spS.superString.length(); i++) {
			while (k > 0 && sbS.getCharAt(k+1) != spS.getCharAt(i)) {
				k = pi[k];
//				System.out.println("step " + i + ": k = " + k);
			}
//			System.out.println(sbS.getCharAt(k+1));
//			System.out.println(spS.getCharAt(i));
			if (sbS.getCharAt(k+1) == spS.getCharAt(i)) k++;
			
			if (k == sbS.subString.length()) {
				System.out.println((i-sbS.subString.length() +1 ) + " ");
				k = pi[k];
			}
//			System.out.println("step " + i + ": k = " + k);
		}
		
	}
	
	public static void main(String[] args) {
		KMP K = new KMP();
		K.loadData("data\\TruongTest\\KMP.txt");
		K.countPi();
		K.kmp();
	}
}
