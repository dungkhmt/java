package studentpractice.nguyenquanghung;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Haminton {
	private int n, m; // n: number of vertices, m: number of edges
	private ArrayList<Integer>[] adj; // Adjacency list
	private int[] x;
	private boolean[] mark;

	public void inputData(String filename) {
		try {
			Scanner in = new Scanner(new File(filename));
			n = in.nextInt();
			m = in.nextInt();
			adj = new ArrayList[n + 1];
			for (int i = 1; i <= n; i++)
				adj[i] = new ArrayList<>();
			for (int i = 1; i <= m; i++) {
				int x, y;
				x = in.nextInt();
				y = in.nextInt();
				adj[x].add(y);
				adj[y].add(x);
			}
			in.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void init() {
		x = new int[n + 2];
		mark = new boolean[n + 2];
		for (int i = 1; i <= n + 1; i++)
			mark[i] = true;
		x[1] = 1;
		mark[1]=false;
	}

	public void printAdjacencyList() {
		for (int i = 1; i <= n; i++) {
			System.out.print(i + ": ");
			for (int j = 0; j < adj[i].size(); j++) {
				System.out.print(adj[i].get(j) + " ");
			}
			System.out.println();
		}
	}

	void Haminton(int k) {
		for (int i = 0; i < adj[x[k - 1]].size(); i++) {
			int v = adj[x[k - 1]].get(i);
			if (mark[v] == true) {
				x[k] = v;
				mark[v] = false;
				if (k==n) {
					boolean check = false;
					for (int j = 0; j < adj[v].size(); j++){
						if (adj[v].get(j)==x[1]) { check=true; break; }
					}
					
					if (check==true) 
					{
						for (int j=1; j<=n; j++) System.out.print(x[j]+"->");
						System.out.println(x[1]);
					}
				}
				else Haminton(k+1);
				mark[v]=true;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Haminton H = new Haminton();
		H.inputData("data\\hungtestfile\\Haminton.txt");
		//H.printAdjacencyList();
		H.init();
		H.Haminton(2);
	}

}
