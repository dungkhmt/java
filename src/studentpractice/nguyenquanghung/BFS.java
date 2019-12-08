package studentpractice.nguyenquanghung;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {

	private int n, m;
	private ArrayList<Integer>[] adj; // Adjacency list
	private boolean[] color;
	private int[] p;

	public void inputData(String filename) {
		try {
			File file = new File(filename);
			Scanner in = new Scanner(file);
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

	public void printAdjacencyList() {
		for (int i = 1; i <= n; i++) {
			System.out.print(i + ": ");
			for (int j = 0; j < adj[i].size(); j++) {
				System.out.print(adj[i].get(j) + " ");
			}
			System.out.println();
		}
	}

	public void init() {

		color = new boolean[n + 1];
		p = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			color[i] = true;
			p[i] = -1;
		}
	}

	public void BFS(int u) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(u);
		color[u] = false;
		while (!q.isEmpty()) {
			int v = q.remove();
			for (int i = 0; i < adj[v].size(); i++) {
				int x = adj[v].get(i);
				if (color[x] == true) {
					q.add(x);
					color[x] = false;
					p[x] = v;
				}
			}
		}
	}

	public void process() {
		int cnt = 0;
		for (int u = 1; u <= n; u++)
			if (color[u] == true) {
				cnt++;
				BFS(u);
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
		BFS G = new BFS();
		G.inputData("data\\hungtestfile\\DFS.txt");
		// G.printAdjacencyList();
		G.init();
		G.process();
		G.printParent();
	}

}
