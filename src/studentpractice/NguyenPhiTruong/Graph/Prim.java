package studentpractice.NguyenPhiTruong.Graph;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class Prim {
	private int[][] G;
	private int[] d;
	private int[] p;
	private final int vc = 999;
	LinkedList<Integer> nonFixed = new LinkedList<Integer>();

	private void loadGraph(String filename) {
		int n;
		try {
			Scanner scan = new Scanner(new File(filename));
			n = scan.nextInt();
			G = new int[n + 1][n + 1];
			d = new int[n + 1];
			p = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				nonFixed.add(i);
				for (int j = 1; j <= n; j++)
					G[i][j] = scan.nextInt();
			}
			scan.close();
		} catch (Exception e) {
			System.out.print("File not found\n");
		}
	}

	private void start(String filename) {
		//--------------------------------------- Khoi tao
		loadGraph(filename);
		int start = nonFixed.getFirst();
		nonFixed.removeFirst();
		for (int i = 1; i < G.length; i++) {
			d[i] = G[start][i];
			p[i] = start;
		}
		// -------------------------------------- thuc hien
		System.out.print("Cay khung nho nhat la: \n" );
		while (nonFixed.size() != 0) {
			int findMin = d[nonFixed.getFirst()];
			int min = nonFixed.getFirst();
			for (Integer i : nonFixed)
				if (d[i] < findMin) {
					findMin = d[i];
					min = i;
				}
			nonFixed.remove((Integer) min);
			System.out.print("(" + p[min] + "," + min + ")\n");
			for (Integer u : nonFixed) {
				if (G[min][u] == vc) continue;
				if (d[u] == vc) {
					d[u] = G[min][u];
					p[u] = min;
					continue;
				}
				if (d[u] > G[min][u]) {
					d[u] = G[min][u];
					p[u] = min;
				}
			}
			
			
		}
	}
	
	public static void main(String[] args) {
		Prim P = new Prim();
		P.start("data\\TruongTest\\DirectedGraph2");
	}
}
