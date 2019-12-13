package studentpractice.TranThiHongNhung.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	public Graph G;
	
	public BFS(Graph G) {
		this.G= G;
	}
	public void findPath(Node s, Node t){
		Queue<Node> Q= new LinkedList<>();
		HashMap<Node, Integer> d= new HashMap<Node, Integer>();
		d.put(s,0);
		Q.add(s);//push
		while(Q.size()>0) {
			Node u= Q.remove();// pop 
			if(u ==t ) break;
			for(Arc a: G.getAdj(u)) {
				Node v=a.end;
				if(d.get(v)==null) {
					d.put(v,d.get(u)+1);//d[v]=d[u]+1
					Q.add(v);	//q push v
				}
			}
		}
		System.out.print("path from "+ s.getid() + " to " +t.getid()+ " = "+ d.get(t));
	}
	public static void main(String[] args) {
		Graph G= new Graph();
		G.loadData("src/studentpractice/TranThiHongNhung/graph/graph.txt");
		G.print();
		
		BFS app= new BFS(G);
		Node s= G.getNodebyid(6);
		Node t=G.getNodebyid(7);
		app.findPath(s,t);
	}
	
		// TODO Auto-generated method stub
		
}
