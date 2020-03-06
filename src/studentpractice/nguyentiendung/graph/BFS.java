package studentpractice.nguyentiendung.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	private Graph G;
	public BFS(Graph G) {
		this.G=G;
	}
	public void findPath(Node s, Node t) {
		Queue <Node> Q= new LinkedList<>();
		HashMap<Node, Integer> d= new HashMap<Node, Integer>();
		d.put(s, 0);
		Q.add(s);
		while(Q.size()>0) {
			Node u= Q.remove();
			if(u==t) { break;}
			for(Arc a: G.getAdjacent(u)) {
				Node v=a.end;
				if(d.get(v)==null) {
					d.put(v, d.get(u)+1);
					Q.add(v);
				}
			}
			}
		System.out.println("Path from "+ s.getId() + " to " + t.getId()+ ": " + d.get(t));
	}
	public static void main(String[] args) {
		Graph G= new Graph();
		G.input("D:\\Javaoop\\java\\src\\studentpractice\\nguyentiendung\\graph\\graph");
		G.print();
		BFS app= new BFS(G);
		Node s= G.getNodeId(6);
		Node t= G.getNodeId(7);
		app.findPath(s, t);
		
	}
}
