package studentpractice.NguyenPhiTruong.Graph;

import java.io.File;
import java.util.Scanner;

public class DirectedGraph {
	public int[][] G;
	public void inputGraph(String filename) {
		try {
			Scanner input = new Scanner(new File(filename));
			int n = input.nextInt();
			G = new int[n+1][n+1];
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					G[i][j] = input.nextInt();
				}
			}
			input.close();
		} catch (Exception e) {
			System.out.print("Cannot find File");
		}
	}
}
