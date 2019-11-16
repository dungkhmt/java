package studentpractice.HoangTuanHuy;
import java.io.*;
import java.util.*;

import studentpractice.HoangTuanHuy.MinimumSpanningTree_Kruskal.pair;
public class Dijkstra 
{
	/// O((n+m)log2(m))
	/// Use heap-sort technic =  priority_queue.
	/// Can use priority_queue to find MST with Prim algorith
	/// unDirected graph = Directed graph 
	private int n,m,S,F;
	class pair implements Comparable<pair>
	{
		long fi;
		int se;
		public pair(long fi,int se)
		{
			this.fi=fi;
			this.se=se;
		}
		public int compareTo(pair a)
		{
			if(fi<a.fi) return -1;
			if(fi==a.fi) return 0;
			return 1;
		}
	}
	private ArrayList <pair>[] X = new ArrayList[1001];
	private long[] d = new long[1001]; // d[u] : The Smallest way from start? to  U
	private static long res;
	public void inp(String filename) throws IOException
	{
		File file = new File(filename);
		Scanner scan = new Scanner(file);
		n=scan.nextInt();
		m=scan.nextInt();
		for(int i=1;i<=m;i++)
		{
			int u,v;
			long z; /// (u,v,z) edge u - v has distance z.
			u=scan.nextInt();
			v=scan.nextInt();
			z=scan.nextLong();
			X[u].add(new pair(z,v)); 
			X[v].add(new pair(z,u));
		}
		S=scan.nextInt();
		F=scan.nextInt();   
		/// Find the smallest way from S -> F.
		scan.close();	
	}
	public void out(String filename) throws IOException
	{
		File file= new File(filename);
		PrintStream printf = new PrintStream(file);
		printf.println(res); /// The smallest way from Start to Finish = res.
		printf.close();
	}
	private Queue <pair> pri = new PriorityQueue<>();
	public long Find_the_smallest_way_from_S_to_F(int start,int finish)
	{
		for(int i=1;i<=n;i++) d[i]=(long)(1e12);
		d[start]=0;
		pri.add(new pair(0,start));
		while(!pri.isEmpty())
		{
			pair ex=pri.remove();
			int u=ex.se;
			long du=ex.fi;
			if(du!=d[u]) continue;
			if(u==finish) break; /// d[finish] is the best result now.
			for(int i=0;i<X[u].size();i++)
			{
				int v=X[u].get(i).se;
				long dis=X[u].get(i).fi;
				if(d[v]>du+dis) /// Can find other way better from Start to V through U.
				{
					d[v]=du+dis;
					pri.add(new pair(d[v],v));
				}
			}
		}
		return d[finish];
	}
	public static void main(String[] args) throws IOException
	{
		Dijkstra T = new Dijkstra();
		T.inp("data/Huysfiletest/Dijkstra.inp");
		res=T.Find_the_smallest_way_from_S_to_F(T.S, T.F);
		T.out("data/Huysfiletest/Dijkstra.out");
	}
}
