package studentpractice.phamducdat.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class Prim {
	private Graph G;
	private HashMap<Node, Arc> A = new HashMap<Node, Arc>();
	private ArrayList<Arc> C = new ArrayList<Arc>();
	private int[] v = new int[100];

	public Prim(Graph G) {
		this.G = G;
	}

	public void init() {
		for (int i = 1; i <= G.n; i++) {
			Arc a = new Arc(G.getNodebyId(i), G.getNodebyId(i), 1000);
			A.put(G.getNodebyId(i), a);
		}
	}

	public void minTree(Node u) {
		if(C.size() == G.n - 1) {
			return;
		}
		ArrayList<Arc> B = new ArrayList<Arc>();
		for(Arc a : G.getAdjacent(u)) {
			if(v[a.end.getId()] != 1 && a.w < A.get(a.end).w) {
				A.put(a.end, a);
			}
		}
		
		for(Node i : A.keySet()) {
			Arc a = A.get(i);
			B.add(a);
		}
		
		Collections.sort(B);
		Arc b = B.remove(0);
		C.add(b);
		v[u.getId()] = 1;
		A.remove(b.end);
		minTree(b.end);
	}

	public void print() {
		System.out.println("Min Tree: ");
		for (Arc a : C) {
			System.out.println("( " + a.begin.getId() + " , " + a.end.getId() + " )");
		}
	}

	public static void main(String[] args) {
		Graph G = new Graph();
		G.loadData("src/studentpractice/phamducdat/data/graph2.txt");
		G.print();

		Prim P = new Prim(G);
		Node u = G.getNodebyId(1);
		P.init();
		P.minTree(u);
		P.print();
	}
}
