package studentpractice.tranvanthang.qhd;

public class baitoancaitui {

	public static void main(String[] args) {
		int[] giatri = { 0, 15, 4, 2, 1, 2, 10 };
		int[] weight = { 100, 5, 12, 2, 1, 1, 4 };
		int[][] max = new int[7][16];
		for (int a = 0; a <= 15; a++) {
			max[0][a] = 0;
		}
		System.out.println("gia tri max can tim la " + max[0][15]);
//////////////////max[i][j] la max cua gtri khi cho vào khoi luong j khi chi xet cac vat tu 1 den i
		for (int i = 1; i <= 6; i++) {
			for (int j = 0; j <= 15; j++) {
				////neu khong chon vat i
				if (j - weight[i] < 0) {
					max[i][j] = max[i - 1][j];
					System.out.println("gia tri " + i + "  " + j + " la:  "
							+ max[i][j]);
				} else if ((giatri[i] + max[i][j - weight[i]]) > max[i - 1][j])//neu chon vat i
					max[i][j] = giatri[i] + max[i][j - weight[i]];
				else
					max[i][j] = max[i - 1][j];
				System.out.println("gia tri " + i + "  " + j + " la:  "
						+ max[i][j]);

			}

		}
		System.out.println("gia tri max can tim la " + max[6][15]);

	}
}
