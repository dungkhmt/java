package studentpractice.phamducdat.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Dijkstra {

	private Graph G;
	private HashMap<Node, Arc> A = new HashMap<Node, Arc>();
	private ArrayList<Arc> C = new ArrayList<Arc>();
	private int[] m = new int[100];
	private Arc o = new Arc(null, null, 0);

	public Dijkstra(Graph G) {
		this.G = G;
	}

	public void itit() {
		for (int i = 1; i <= G.n; i++) {
			Arc a = new Arc(G.getNodebyId(i), G.getNodebyId(i), 1000);
			A.put(G.getNodebyId(i), a);
		}
	}

	public void minRoad(Node u, Node v) {
		if (u == v)
			return;
		ArrayList<Arc> B = new ArrayList<Arc>();
		for (Arc a : G.getAdjacent(u)) {
			if (m[a.end.getId()] != 1) {
				Arc b = A.get(a.end);
				if (b.w == 1000) {
					A.put(a.end, a);
				} else {
					a.w = o.w + a.w;
					A.put(a.end, a);
				}
			}
		}

		for (Node i : A.keySet()) {
			Arc b = A.get(i);
			B.add(b);
		}

		Collections.sort(B);
		Arc o = B.remove(0);
		C.add(o);
		A.remove(o.end);
		m[u.getId()] = 1;
		minRoad(o.end, v);
	}

	public void print() {
		for (Arc a : C) {
			System.out.println("( " + a.begin.getId() + " , " + a.end.getId() + " )");
		}
	}

	public static void main(String[] args) {
		Graph G = new Graph();
		G.loadData("data\\TruongTest\\Graph.txt");
		G.print();

		System.out.println();
		Dijkstra D = new Dijkstra(G);
		Node u = G.getNodebyId(1);
		Node v = G.getNodebyId(5);
		System.out.println("Min road from " + u.getId() + " to " + v.getId() + " :");
		D.itit();
		D.minRoad(u, v);
		D.print();

	}

}
