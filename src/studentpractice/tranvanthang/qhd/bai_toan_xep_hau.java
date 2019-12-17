package studentpractice.tranvanthang.qhd;

import java.io.File;
import java.io.FileWriter;

public class bai_toan_xep_hau {
	public static int[][] mark = new int[8][8];
	public static int[] hau = new int[8];
	public static int[] markN = new int[8];

	// hau[1]=2 tuong ung la con hau cot 1 no o hang 2
	public static void init() {
		for (int i = 0; i < 8; i++) {
			hau[i] = -5;
			markN[i] = 0;
			for (int j = 0; j < 8; j++) {
				mark[i][j] = 0;
			}
		}

	}

	// //// mark hang cheo phai, chi so phu thuoc =1 khi danh dau, bang -1 khi muon bo danh dau
	public static void mark_right(int a, int b, int chisophuthuoc) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if ((i + j) == (a + b)) {
					if (chisophuthuoc == 1) {
						mark[i][j] += 1;
					} else
						mark[i][j] -= 1;
				}
			}
		}
	}

	// //// mark hang cheo trai
	public static void mark_left(int a, int b, int chisophuthuoc) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if ((i - j) == (a - b)) {
					if (chisophuthuoc == 1)
						mark[i][j] += 1;
					else
						mark[i][j] -= 1;
				}
			}
		}

	}

	// /// de quy chinh
	public static void result() {
		System.out.println("  0 1 2 3 4 5 6 7");
		System.out.println("--------------------------");
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (hau[j] == i) {
					System.out.print(i);
					for (int temp = 0; temp <= j; temp++) {
						if (temp < j)
							System.out.print("  ");
						else
							System.out.print("X");

					}
					System.out.println();

				}
			}
		}
	}

	public static void Try(int k) {

		for (int i = 0; i < 8; i++) {

			if (mark[i][k] == 0 && markN[i] == 0) {
				hau[k] = i;
				markN[i] = 1;
				mark_left(i, k, 1);
				mark_right(i, k, 1);
				if (k == 7) {
					// result();

					for (int temp = 0; temp < 8; temp++) {
						System.out.println("xep hau cot thu " + (temp + 1)
								+ "vao hang thu " + (hau[temp] + 1));
					}
					System.out.println("-----------------");
					markN[i] = 0;
					mark_left(i, k, -1);
					mark_right(i, k, -1);
					continue;
				}
				Try(k + 1);
				markN[i] = 0;
				mark_left(i, k, -1);
				mark_right(i, k, -1);

			}
		}
	}

	public static void main(String[] args) {
		init();
		Try(0);

	}

}
