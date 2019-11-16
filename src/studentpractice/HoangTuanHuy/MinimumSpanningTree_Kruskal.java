package studentpractice.HoangTuanHuy;
import java.io.*;
import java.util.*;
import java.lang.*;
public class MinimumSpanningTree_Kruskal 
{
	/// O(nlogn)
	/// Use disjoint sets technic
	private int n,m; /// n: the number of nodes , m : the number of edges
	private long MST;
	private int[] p = new int[1001]; // The representative node
	private int[] h = new int[1001]; // the height of tree
	class pair implements Comparable<pair> /// fi = distance between u and v ,(u,v) is an edges
	{ 
		long fi;
		int U,V;
		public pair(long fi,int U,int V)
		{
			this.fi=fi;
			this.U=U;
			this.V=V;
		}
		public int compareTo(pair a) 
		{
			if(fi<a.fi) return -1;
			if(fi==a.fi) return 0;
			return 1;
			//return fi-a.fi;
		}
	}
	private ArrayList<pair> Edges = new ArrayList<>(); /// Edges list
	public void inp(String filename) throws IOException
	{
		File file = new File(filename);
		Scanner scan = new Scanner(file);
		n=scan.nextInt();
		m=scan.nextInt();
		for(int i=1;i<=m;i++)
		{
			int u,v;
			long z;
			u=scan.nextInt();
			v=scan.nextInt();
			z=scan.nextLong();
			Edges.add(new pair(z,u,v));
		}
		scan.close();
	}
	public void out(String filename) throws IOException
	{
		File file= new File(filename);
		PrintStream printf = new PrintStream(file);
		printf.println(MST);
		printf.close();
	}
	//Disjoint Sets
	private void make_empty(int u)
	{
		p[u]=u;
		h[u]=0;
	}
	private int find_renode(int u)
	{
		while(p[u]!=u) u=p[u];
		return u;
	}
	private int union(int u,int v)
	{
		int x=find_renode(u),y=find_renode(v);
		if(x==y) return 0;
		if(h[x]<h[y])
		{
			p[x]=p[y];
		}
		else
		{
			p[y]=p[x];
			if(h[x]==h[y]) h[x]++;
		}
		return 1;
	}
	public long find_MST()
	{
		for(int i=1;i<=n;i++) make_empty(i);
		Collections.sort(Edges);
		for(int i=0;i<Edges.size();i++)
		{
			int u=Edges.get(i).U;
			int v=Edges.get(i).V;
			long len=Edges.get(i).fi;
			if(union(u,v)==1) MST+=len;
		}
		return MST;
	}
	public static void main(String[] args) throws IOException
	{
		MinimumSpanningTree_Kruskal T= new MinimumSpanningTree_Kruskal ();
		T.inp("data/Huysfiletest/MSTK.inp");
		T.find_MST();
		T.out("data/Huysfiletest/MSTK.out");
	}
}
