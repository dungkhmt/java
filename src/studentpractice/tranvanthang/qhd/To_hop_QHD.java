package studentpractice.tranvanthang.qhd;

public class To_hop_QHD {
	public static long[][] C = new long[66][66];

	public static void init() {
		for (int i = 0; i <= 65; i++) {
			for (int j = i; j <= 65; j++) {
				if (i == 0 || i == j) {
					C[i][j] = 1;
				} else if (i > j)
					C[i][j] = -50;
				else
					C[i][j] = 0;

			}
		}

	}

	public static long Try(int k, int n) {
		if (C[k][n] == 0) {
			C[k][n] = Try(k - 1, n - 1) + Try(k, n - 1);
		}
		return C[k][n];
	}

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		init();
		System.out.println(Try(8, 65));
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println((float)totalTime/1000000);//////don vi :mili giay
	}

}
