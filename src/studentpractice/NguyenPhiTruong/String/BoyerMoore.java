package studentpractice.NguyenPhiTruong.String;

import java.io.File;
import java.util.Scanner;

public class BoyerMoore {
	public SuperString spS;
	public SubString sbS;
	public int[] last;

	public void loadData(String filename) {
		try {
			Scanner scan = new Scanner(new File(filename));
			spS = new SuperString();
			sbS = new SubString();
			// input String
			spS.superString = scan.nextLine();
			sbS.subString = scan.nextLine();
			last = new int[256];
			// compute Last[]
			for (int i = 0; i <= 255; i++)
				last[i] = 0;
			for (int i = sbS.subString.length() - 1; i >= 0; i--) {
				int k = (int) (sbS.subString.charAt(i));
				if (last[k] == 0) {
					last[k] = i + 1;
					System.out.println("Last[" + sbS.subString.charAt(i) + "] = " + last[k]);
				}
			}

			scan.close();
		} catch (Exception e) {
			System.out.println("File not found");
		}
	}

	public void boyerMoore() {
		System.out.println("Find at: ");
		int s = 0;
		while (s <= spS.superString.length() - sbS.subString.length()) {
			int j = sbS.subString.length();
			while (j > 0 && spS.superString.charAt(j + s - 1) == sbS.subString.charAt(j - 1))
				j--;
			if (j == 0) {
				System.out.println(" " + (s + 1));
				s = s + 1;
			} else {
				int k = last[(int) (spS.superString.charAt(j + s - 1))];
				s = s + Math.max(j - k - 1, 1);
			}
		}
	}

	public static void main(String[] args) {
		BoyerMoore B = new BoyerMoore();
		B.loadData("data\\TruongTest\\KMP.txt");
		B.boyerMoore();
	}
}
