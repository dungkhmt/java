package studentpractice.NguyenPhiTruong.String;

import java.io.File;
import java.util.Scanner;

public class Z_Algorithms {
	public SuperString spS;
	public SubString sbS;
	public int[] Z;
	public String S;

	public void computeZ() {
		int L = 0, R = 0;
		int N = Z.length;
		for (int i = 1; i < N; i++) {
			if (i > R) {
				L = i;
				R = i;
				while (R < N && S.charAt(R) == S.charAt(R - L))
					R++;
				Z[i] = R - L;
				R--;
			} else {
				int k = i - L;
				if (Z[k] < R - i + 1)
					Z[i] = Z[k];
				else {
					L = i;
					while (R < N && S.charAt(R) == S.charAt(R - L))
						R++;
					Z[i] = R - L;
					R--;
				}
			}
		}
	}

	public void loadData(String filename) {
		try {
			Scanner scan = new Scanner(new File(filename));
			spS = new SuperString();
			sbS = new SubString();
			spS.superString = scan.nextLine();
			sbS.subString = scan.nextLine();
			// compute Z[]
			S = sbS.subString + "." + spS.superString;
			Z = new int[spS.superString.length() + sbS.subString.length() + 1];
			computeZ();

			scan.close();
		} catch (Exception e) {
			System.out.println("File not found");
		}
	}

	public void Z_Algo() {
		System.out.println("Find at: ");
		for (int i = sbS.subString.length(); i < Z.length; i++) {
			if (Z[i] == sbS.subString.length())
				System.out.println(i - sbS.subString.length() + " ");
		}
	}

	public static void main(String[] args) {
		Z_Algorithms ZA = new Z_Algorithms();
		ZA.loadData("data\\TruongTest\\KMP.txt");
		ZA.Z_Algo();

	}
}
