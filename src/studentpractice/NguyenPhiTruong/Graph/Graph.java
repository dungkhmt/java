package studentpractice.NguyenPhiTruong.Graph;
import java.util.Scanner;
import java.io.File;
public class Graph {
	public int[][] G;
	
	public int inputGraph(String filename) {
		int n = 0;
		try {
			Scanner input = new Scanner(new File(filename));
			n = input.nextInt();
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
//		System.out.print(n);
		return n;
	}
}
