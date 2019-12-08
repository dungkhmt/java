package studentpractice.nguyenquanghung;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import com.sun.java_cup.internal.runtime.virtual_parse_stack;

public class TopoSort {
	private int n, m; // n: number of vertices, m: number of edges
	private ArrayList<Integer>[] adj; // Adjacency list
	private int[] d;

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
			}
			in.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void TopoSort() {
		d = new int[n + 1];
		for (int i = 1; i <= n; i++)
			d[i] = 0;
		for (int u=1; u<=n; u++) {
			for (int v=0; v<adj[u].size(); v++)
				d[adj[u].get(v)]++;
		}
		System.out.print("The Topological Sorting is:  ");
		Queue<Integer> queue=new LinkedList<Integer>();
		for (int u=1; u<=n; u++)
			if (d[u]==0) queue.add(u);
		while (!queue.isEmpty()) {
			int v = queue.remove();
			System.out.print(v + "  ");
			for (int x=0; x< adj[v].size(); x++) {
				d[adj[v].get(x)]--;
				if (d[adj[v].get(x)]==0) queue.add(adj[v].get(x));
			}
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TopoSort G = new TopoSort();
		G.inputData("data\\hungtestfile\\TopoSort.txt");
		G.printAdjacencyList();
		G.TopoSort();
	}

}
