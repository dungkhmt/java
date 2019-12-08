package studentpractice.TranBinhMinh.Graph;

import java.io.*;
import java.util.*;

public class BFS {

	private Graph G;
	
	public BFS(Graph G)
	{
		this.G=G;
	}

	public void findPath(Node s,Node t)
	{
		Queue<Node> Q = new LinkedList<> ();
		HashMap<Node,Integer> d = new HashMap <Node,Integer> ();
		Q.add(s);
		d.put(s,0);
		while(Q.size()>0)
		{
			Node u = Q.remove();
			if(u==t)
				break;
			for(Arc a:G.getAdjacent(u))
			{
				Node v=a.end;
				if(d.get(v) == null)
				{
					d.put(v,d.get(u)+1); //d(v)=d(u)+1;
					Q.add(v);
				}
			}
		}
		System.out.println("Path from " + s.getId() + " to " + t.getId() + " = " + d.get(t));
	}
	
	
	
	public static void main(String[] args) throws IOException 
	{	
		Graph G = new Graph();
		G.loadData("data/TranBinhMinh.Test/graph.txt");
		G.print();
		
		BFS app = new BFS(G);
		Node s = G.getNodeById(6);
		Node t = G.getNodeById(7);
		app.findPath(s, t);
	}

}
