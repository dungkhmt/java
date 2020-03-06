package studentpractice.NguyenPhiTruong.Graphh;

import java.util.ArrayList;
import java.util.LinkedList;

public class Dijkstra {
	private Graph G;
	public LinkedList<Node> nonFix = new LinkedList<Node>();
	private final int x = -1;
	public int[] p;
	public int[] d;
	public Dijkstra(Graph G) {
		this.G = G;
	}
	
	public void addToNonFix(Node s) {
		for (Node u : G.V) {
			if (u != s) nonFix.add(u);
			p[u.getId()] = s.getId();
			
		}
		ArrayList<Arc> a = G.A.get(s);
		for (Arc i : a) {
			d[i.end.getId()] = i.w;
		}
		for (Node u : G.V) {
			if (u != s) {
				for (Arc a1 : G.A.get(u)) {
					if (a1.end != s) d[a1.end.getId()] = -1;
					
				}
			}
		}
		
		for (Node u : G.V) {
			System.out.println(d[u.getId()] + " ");
		}
	}
	
	public void findPath(Node s, Node t) {
		while (nonFix.size() != 0) {
			
		}
	}
	
	public static void main(String[] args) {
		Graph G = new Graph();
		G.loadData("data\\TruongTest\\Graph.txt");
		G.print();
		Dijkstra D = new Dijkstra(G);
		D.addToNonFix(G.findNode(4));
		
	}
}
