package studentpractice.phamducdat.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	private Graph G;
	
	public BFS(Graph G) {
		this.G = G;
	}

	public void findPath(Node u, Node v) {
		Queue<Node> Q = new LinkedList<Node>();
		HashMap<Node, Integer> D = new HashMap<Node, Integer>();
		Q.add(u);
		D.put(u, 0);
		
		while (Q.size() > 0) {
			Node nu = Q.remove();
			if (nu == v)
				break;
			for(Arc a : G.getAdjacent(nu)) {
				Node m = a.end;
				if(D.get(m) == null) {
					D.put(m, D.get(nu) + a.w);
					Q.add(m);
					m.setFather(nu);
				}
			}
		}
		System.out.println("Find path form " + u.getId() + " to " + v.getId() + " = " + D.get(v));
		
	}
	
	public void pint(Node u, Node v) {
		System.out.print("Road: " + u.getId() + " -> ");
		Node p = v;
		while(p.getFather().getFather() != null) {
			System.out.print(p.getFather().getId() + " -> ");
			p = p.getFather();
		}
		System.out.print(v.getId());
	}
	
	public static void main(String[] args) {
		Graph G = new Graph();
		G.loadData("src/studentpractice/phamducdat/data/graph4.txt");
		G.print();
		
		BFS b = new BFS(G);
		Node u = G.getNodebyId(1);
		Node v = G.getNodebyId(7);
		b.findPath(u, v);
		b.pint(u, v);
	}
}
