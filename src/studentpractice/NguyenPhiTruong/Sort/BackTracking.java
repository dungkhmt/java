package studentpractice.NguyenPhiTruong.Sort;

import java.util.Scanner;

public class BackTracking {
	public int n;
	public int[] xh;
	public int cnt;
	public int[] x;

	public void nhap() {
		Scanner nhap = new Scanner(System.in);
		n = nhap.nextInt();
		xh = new int[n + 1];
		x = new int[n + 1];
		nhap.close();
		for (int i = 0; i < xh.length; i++)
			xh[i] = 0;
		cnt = 0;
	}

//	Liet ke hoan vi cua n phan tu
	public void solution1() {
		System.out.print(++cnt + ": ");
		for (int i = 1; i <= n; i++)
			System.out.print(x[i] + " ");
		System.out.println();
	}

	public void TRY1(int k) {
		for (int v = 1; v <= n; v++) {
			if (xh[v] != 1) {
				xh[v] = 1;
				x[k] = v;
				if (k == n)
					solution1();
				else
					TRY1(k + 1);
				xh[v] = 0;
			}
		}
	}

	public static void main(String[] args) {
		BackTracking H1 = new BackTracking();
		H1.nhap();
		H1.TRY1(1);
	}
}
