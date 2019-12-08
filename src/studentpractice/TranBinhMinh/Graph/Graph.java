package studentpractice.TranBinhMinh.Graph;

import java.io.*;
import java.util.*;

public class Graph {
	public ArrayList<Node> V;
	public HashMap< Node,ArrayList<Arc> > A; 
	HashMap<Integer,Node> mid2Node = new HashMap<Integer,Node> ();
	public Node getNodeById(int id)
	{
		return mid2Node.get(id);
	}
	public ArrayList<Arc> getAdjacent(Node u)
	{
		return A.get(u);
	}
	public void loadData(String filename) throws IOException
	{
		Scanner inp = new Scanner(new File(filename));
		int n = inp.nextInt();
		int m = inp.nextInt();
		
		V = new ArrayList<Node>();
		A =  new HashMap< Node,ArrayList<Arc>> ();
		
		
		for(int i=1;i<=n;++i)
		{
			Node node = new Node(i);
			V.add(node);
			mid2Node.put(i,node);
			A.put(node, new ArrayList<Arc>() );
		}
		for(int k=1;k<=m;++k)
		{
			int u = inp.nextInt();
			int v = inp.nextInt();
			int w = inp.nextInt();
			
			Node nu=mid2Node.get(u);
			Node nv=mid2Node.get(v);
			Arc a=new Arc(k,nu,nv);
			a.w=w;
			A.get(nu).add(a);
		}
		inp.close();
	}
	public void print()
	{
		
		System.out.print("V = ");
		for(Node s: V)
		{
			System.out.print(s.getId() + " ");
		}	
		System.out.println();
		for(Node s: V)
		{
			ArrayList<Arc> As = A.get(s);
			System.out.print(s.getId()+ " ");
			for(Arc a:As)
			{
				System.out.print(a.toString()+ " ");
			}
			System.out.println();
		}	
	}
	
	public static void main(String[] Args) throws IOException
	{
		Graph G = new Graph();
		G.loadData("data/TranBinhMinh.Test/graph.txt");
		G.print();
	}
}