package studentpractice.tranvanthang.qhd;

public class LCS_xau_con_chungmax {
	public static int[][] F = new int[6][9];
	static char[] xau1 = { 'A', 'B', 'C', 'D', 'E', 'a', 'G', 'H', 'J' };
	static char[] xau2 = { 'B', 'c', 'E', 'D', 'F', 'J' };

	public static void init() {
		// Cho ma tran bang 0 het
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 9; j++) {
				F[i][j] = 0;
			}
		}
		// Tao gia tri dong 1
		for (int i = 0; i < 9; i++) {
			if (xau2[0] == xau1[i]) {
				for (int j = i; j < 9; j++)
					F[0][j] = 1;
			}
		}
		// Tao gia tri cot 1
		for (int i = 0; i < 6; i++) {
			if (xau2[i] == xau1[0]) {
				for (int j = i; j < 6; j++)
					F[j][0] = 1;
			}
		}
	}

	public static void F(int i, int j) {
		if (i < 6 && j < 9) {
			if (xau2[i] == xau1[j])
				F[i][j] = F[i - 1][j - 1] + 1;
			else {
				if (F[i][j - 1] > F[i - 1][j])
					F[i][j] = F[i][j - 1];
				else
					F[i][j] = F[i - 1][j];
			}
		}
	}

	public static void main(String[] args) {
		init();
		for (int i = 1; i < 6; i++) {
			for (int j = 1; j < 9; j++) {
				F(i, j);
			}
		}

		System.out.println("xau con lon nhat co do dai la: " + F[5][8]);
	}

}
