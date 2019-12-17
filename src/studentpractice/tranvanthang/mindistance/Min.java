package studentpractice.tranvanthang.mindistance;

import java.io.File;
import java.util.Scanner;

public class Min {
	//////// thuat toan O(n^2)
	private int[][] g = new int[8][8];
	private int[] p = new int[8];
	private int[] mark = new int[8];
	private int[] d = new int[8];
	private int n, a, b;
	int max = 100;

	public void getData(String filename) {
		try {
			Scanner scanner = new Scanner(new File(filename));
			n = scanner.nextInt();
			a = scanner.nextInt();
			b = scanner.nextInt();
			for (int i = 0; i <= 7; i++) {
				for (int j = 0; j <= 7; j++) {
					g[i][j] = scanner.nextInt();
					if (i != j && g[i][j] == 0) {
						g[i][j] = max;
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void init() {
		for (int i = 0; i <= 7; i++) {
			mark[i] = 0;
			p[i] = a - 1;// /gan cac dinh trc no deu la dinh dau tien
			d[i] = max;
		}
		// ////// danh dau cac dinh da duyet
		d[a - 1] = 0;// /tu dinh a den dinh a 
	}

	public void minDistance() {

		while (mark[b - 1] == 0) {

			int temp = b - 1;
			for (int j = 0; j < n; j++) {
				if (mark[j] == 0 && d[temp] > d[j]) {
					temp = j;
				}
			}
			mark[temp] = 1;
			for (int j = 0; j < n; j++) {
				if (mark[j] == 0 && d[j] > d[temp] + g[temp][j]) {
					d[j] = d[temp] + g[temp][j];
					p[j] = temp;
				}
			}

		}
	}

	public static void main(String[] args) {
		Min min = new Min();
		min.getData("data/minDistance.txt");
		min.init();
		min.minDistance();
		System.out.println("khoang canh ngan nhat"+min.a+" den"+min.b+" : "+min.d[7]);
	
	}
}
