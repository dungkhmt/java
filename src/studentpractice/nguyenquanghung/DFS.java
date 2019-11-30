package studentpractice.nguyenquanghung;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class DFS {

	private int n, m; // n: number of vertices, m: number of edges
	private ArrayList<Integer>[] adj; // Adjacency list
	private int[] b;
	private int[] f;
	private int[] p;
	private boolean[] color;
	private int time = 0;

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
		b = new int[n + 1];
		f = new int[n + 1];
		p = new int[n + 1];
		color = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			b[i] = -1;
			f[i] = -1;
			p[i] = -1;
			color[i] = true;
		}
	}

	public void DFS(int u) { // visit vertice u
		color[u] = false;
		time++;
		b[u] = time;
		for (int i = 0; i < adj[u].size(); i++) {
			int v = adj[u].get(i);
			if (color[v] == true) {
				color[v] = false;
				p[v] = u;
				DFS(v);
			}
		}
		time++;
		f[u] = time;
		color[u] = false;
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

	public void process() {
		int cnt = 0;
		for (int i = 1; i <= n; i++)
			if (color[i] == true) {
				cnt++;
				DFS(i);
			}
		System.out.println("Number of Connected components: " + cnt);
	}

	public void printParent() {
		for (int i = 1; i <= n; i++) {
			System.out.println("Parent of " + i + ": " + p[i]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DFS G = new DFS();
		G.inputData("data\\hungtestfile\\DFS.txt");
		// G.printAdjacencyList();
		G.init();
		G.process();
		G.printParent();
	}
}
