package studentpractice.phamducdat.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	private Graph G;
	
	public BFS(Graph G){
		this.G = G;
	}
	public void findPath(Node s, Node t){
		Queue<Node> Q = new LinkedList<>();
		HashMap<Node, Integer> d = new HashMap<Node, Integer>();
		d.put(s, 0);
		Q.add(s);
		while(Q.size() > 0){
			Node u = Q.remove();
			if(u == t) break;
			for(Arc a: G.getAdjacent(u)){
				Node v = a.end;
				if(d.get(v) == null){
					d.put(v, d.get(u) + 1); // d[v] = d[u] + 1
					Q.add(v); // Q.push(v)
				}
				
			}
		}
		System.out.println("path from " + s.getId() + " to " + t.getId() + " = " + d.get(t));
	}
	
	public static void main(String[] args) {
			Graph G = new Graph();
			G.loadData("src/studentpractice/phamducdat/data/Graph.txt");
			G.print();
			
			BFS app = new BFS(G);
			Node s = G.getNodeById(6);
			Node t = G.getNodeById(7);
			app.findPath(s, t);
		}
	}