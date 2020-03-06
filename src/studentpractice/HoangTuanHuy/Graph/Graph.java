package studentpractice.HoangTuanHuy.Graph;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.PrintStream;
public class Graph 
{
	public ArrayList<Node> V;
	public HashMap<Node, ArrayList<Arc>> X;
	HashMap<Integer,Node> int2node = new HashMap<>();
	public Node id2node(int id)
	{
		return int2node.get(id);
	}
	public ArrayList<Arc> get_AdjacentList(Node u)
	{
		return X.get(u);
	}
	public void inp(String filename) throws IOException
	{
		Scanner scan = new Scanner(new File(filename));
		int n=scan.nextInt();
		int m=scan.nextInt();
		V = new ArrayList<>();
		X = new HashMap<>(); 
		
		for(int i=1;i<=n;i++)
		{
			Node node=new Node(i);
			V.add(node);
			int2node.put(i,node);
			X.put(node,new ArrayList<>());
		}
		for(int i=1;i<=m;i++)
		{
			int u=scan.nextInt();
			int v=scan.nextInt();
			int w=scan.nextInt();
			Node nu=int2node.get(u);
			Node nv=int2node.get(v);
			Arc a = new Arc(i,nu,nv);
			a.w=w;
			X.get(nu).add(a);
		}
		scan.close();
	}
	public void out(String filename) throws IOException
	{
		PrintStream printf = new PrintStream(new File(filename));
		printf.print("V = ");
		for(Node node:V)
			printf.print(node.getId()+" ");
		printf.println();
		for(Node node:V)
		{
			printf.print("A["+node.getId()+"]=");
			ArrayList<Arc> A = new ArrayList<>();
			A=X.get(node);
			for(Arc arc:A)
				printf.print(arc.toString()+",");
			printf.println();
		}
		printf.close();
	}
	/*public static void main(String[] args) throws IOException
	{
		Graph G = new Graph();
		G.inp("src/studentpractice/HoangTuanHuy/Graph/Graph.inp");
		G.out("src/studentpractice/HoangTuanHuy/Graph/Graph.out");
	}*/
}
