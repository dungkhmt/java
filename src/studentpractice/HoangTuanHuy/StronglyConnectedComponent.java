package studentpractice.HoangTuanHuy;
import java.io.*;
import java.util.*;

public class StronglyConnectedComponent 
{
	//O(n+m);
	// Finding Strongly Connected Component with Tarjan type
	private int n,m; /// n : the number of nodes ,  m : the number of edges
	/// Directed graph version 
	/// Need an parent for unDirected graph 
	
	private ArrayList<Integer>[] X = new ArrayList[1001]; // Edges list
	private int[] begin_topo = new int[1001];
	private int[] low = new int[1001];
	private int cnt;
	private int count_scc;
	private int[] scc_of_ = new int[1001];
	private ArrayList<Integer>[] scc = new ArrayList[1001];
	
	private static int min(int a,int b)
	{
		if(a<b) return a;
		return b;
	}
	
	public void inp(String filename) throws IOException
	{
		//System.out.print(1);
		File file = new File(filename);
		Scanner scan = new Scanner(file);
		n= scan.nextInt();
		m= scan.nextInt();
		for(int i=1;i<=n;i++) X[i] = new ArrayList<>();
		for(int i=1;i<=m;i++)
		{
			int u,v;
			u=scan.nextInt();
			v=scan.nextInt();
			X[u].add(v);
		}
		scan.close();
	}
	public void out(String filename) throws IOException
	{
		File file = new File(filename);
		PrintStream printf = new PrintStream(filename);
		printf.println("The number of nodes is : " + n);
		printf.println("The number of SSC is : "+count_scc);
		for(int i=1;i<=count_scc;i++)
		{
			printf.print("SCC "+i+" includes : ");
			for(int j=0;j<scc[i].size();j++)
				printf.print(scc[i].get(j)+" ");
			printf.println();
		}
		printf.println();
		printf.close();
	}
	
	Stack<Integer> st = new Stack<>();
	public void DFS(int u) //DFS
	{
		low[u]=begin_topo[u]=++cnt;
		//System.out.print(1);
		st.push(u);
		for(int i=0;i<X[u].size();i++)
		{
			int v=X[u].get(i);
			if(begin_topo[v]!=0)
				low[u]=min(low[u],begin_topo[v]);
			else
			{
				DFS(v);
				low[u]=min(low[u],low[v]);
			}
		}
		//System.out.print(low[u]+" "+begin_topo[u]);
		if(low[u]==begin_topo[u])
		{
			//System.out.print(1);
			count_scc++;
			int v=0;
			do
			{
				v=st.pop();
				scc_of_[v]=count_scc;
				low[v]=begin_topo[v]=(int) 1e9;
			}while(u!=v);
		}
	}
	
	private void make_answer()
	{
		for(int i=1;i<=count_scc;i++) scc[i]=new ArrayList<>();
		for(int i=1;i<=n;i++)
			scc[scc_of_[i]].add(i);
	}
	public static void main(String[] args) throws IOException
	{
		StronglyConnectedComponent T= new StronglyConnectedComponent();
		T.inp("data/Huysfiletest/SCC.inp");
		for(int i=1;i<=T.n;i++)
			if(T.begin_topo[i]==0) T.DFS(i);
		//System.out.print(1);
		T.make_answer();
		T.out("data/Huysfiletest/SCC.out");
	}
}
