package studentpractice.NguyenPhiTruong.Graphh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	private Graph G;
	
	
	public BFS(Graph G) {
		this.G = G;
	}
	
	public void findPath(Node s, Node t) {
		Queue<Node> Q = new LinkedList<Node>();
		
		HashMap<Node,Integer> D = new HashMap<Node,Integer>();
		D.put(s,0);
		Q.add(s);
		while (Q.size() > 0) {
			Node u = Q.remove();
//			if(u == null) System.out.println("BUG");
//			System.out.println("POP " + u.getId());
			if (u == t) break;
			for (Arc a : G.getArc(u)) {
				Node v = a.end;
				if (D.get(v) == null) {
					D.put(v, D.get(u) + 1);   // d[v] = d[u] + 1
					Q.add(v);
//					System.out.println("PUSH " + v.getId() + ", d = " + D.get(v));
				}
			}
		}
		System.out.print("Path from " + s.getId() + " to " + t.getId() + " = " + D.get(t));
	}
	
	public static void main(String[] args) {
		Graph G = new Graph();
		G.loadData("data\\TruongTest\\Graph.txt");
		G.print();
		BFS app = new BFS(G);
		app.findPath(G.findNode(6), G.findNode(7));
		
	}
}
