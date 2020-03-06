package studentpractice.nguyentiendung.graph;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;



public class Graph {
	public ArrayList<Node> V;
	public HashMap<Node, ArrayList<Arc>> A;
	public ArrayList<Arc> getAdjacent(Node u) {
		return A.get(u);
	}

	public Node getNodeId(int id) {
		return int2Node.get(id);
	}

	HashMap<Integer, Node> int2Node = new HashMap<Integer, Node>();

	public void input(String filename) {
		try {
			Scanner in = new Scanner(new File(filename));
			int n = in.nextInt();
			int m = in.nextInt()-1;
			V = new ArrayList<Node>();
			A = new HashMap<Node, ArrayList<Arc>>();

			for (int i = 1; i <= n; i++) {
				Node nod = new Node(i);
				V.add(nod);
				int2Node.put(i, nod);
				A.put(nod, new ArrayList<Arc>());
			}
			System.out.println("m = " + m);
			for (int k = 1; k <= m; k++) {
				
				int u = in.nextInt();
				int v = in.nextInt();
				int w = in.nextInt();

				System.out.println(u + " " + v + " " + w);
				Node nu = int2Node.get(u);
				Node nv = int2Node.get(v);
				Arc a = new Arc(k, nu, nv);
				a.w = w;
				A.get(nu).add(a);
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void print() {
		for (Node u : V) {
			System.out.println(u.getId() + " ");
		}
		for (Node u : V) {
			ArrayList<Arc> Au = A.get(u);
			System.out.print("A[" + u.getId() + "] = ");
			for (Arc a : Au) {
				System.out.print(a.toString());
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		Graph G = new Graph();
		G.input("src/studentpractice/nguyentiendung/graph/graph");
		G.print();
	}

}
