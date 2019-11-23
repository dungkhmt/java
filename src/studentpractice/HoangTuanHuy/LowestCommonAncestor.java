package studentpractice.HoangTuanHuy;
import java.io.*;
import java.util.*;
public class LowestCommonAncestor 
{
	/// O(nlogn);
	/// unDirected graph = Directed graph 
	/// Directed graph
	/// Circle doen't exist
	private int n,m;  /// n : the number of nodes ,  m : the number of edges
	private ArrayList<Integer>[] X = new ArrayList[1001];
	private int[][] P = new int[21][1001]; /// p[i][j] : The 2^i ancestor
	private int[] dd = new int[1001];
	private int[] steps_inp = new int[1001];
	private int[] dep = new int[1001];
	public void inp(String filename) throws IOException
	{
		File file = new File(filename);
		Scanner scan = new Scanner(file);
		n=scan.nextInt();
		m=scan.nextInt();
		for(int i=1;i<=n;i++) X[i]=new ArrayList <> ();
		for(int i=1;i<=m;i++)
		{
			int u,v;
			u=scan.nextInt();
			v=scan.nextInt();
			X[u].add(v);
		}
		scan.close();
	}
	public int find_root()
	{
		int root=0;
		for(int i=1;i<=n;i++)
			if(steps_inp[i]==0) root=i; 
		return root;
	}
	private void DFS(int u)
	{
		dd[u]=1;
		for(int i=0;i<X[u].size();i++)
		{
			int v=X[u].get(i);
			if(dd[v]==0)
			{
				P[0][v]=u; /// the first ancestor of v.
				steps_inp[v]++;
				DFS(v);
			}
		}
	}
	private void make_Directed_graph()
	{
		for(int i=1;i<=n;i++) if(dd[i]==0) DFS(i);
	}
	private int find_depth(int i)
	{
		if(steps_inp[i]==0) return dep[i]=1;
		if(dep[i]==0) dep[i]=find_depth(P[0][i])+1;
		return dep[i];
		
	}
	public int find_LCA(int x,int y)
	{
		for(int log=20;log>=0;log--)
			if(dep[P[log][x]]>=dep[y]) x=P[log][x]; /// find  the NEAREST ancestor of x to y
		for(int log=20;log>=0;log--)
			if(dep[P[log][y]]>=dep[x]) y=P[log][y]; /// find the NEAREST ancestor of y to x
		
		for(int log=20;log>=0;log--)  /// Replace x, y by the lowest ancestor as much as we can
		{
			/// Now if x == y  it's definitely not the LCA , because i've only found the 2^log common ancestor .
			if(P[log][x]!=P[log][y])  
			{
				x=P[log][x];
				y=P[log][y];
			}
		}
		/// correct ancestor.
		while(x!=y) /// just a few more steps
		{
			x=P[0][x];
			y=P[0][y];
		}
		return x;
	}
	private void solve()
	{
		make_Directed_graph();
		int root = find_root();
		/* Make Ancestor of i =  1... n */
		/* P[log][i] : the 2^log ancestor of which node names i */
		for( int log=1;log<=20;log++)
			for(int i=1;i<=n;i++)
				P[log][i]=P[log-1][P[log-1][i]];
		for(int i=1;i<=n;i++) find_depth(i);
	}
	public void out(String filename) throws IOException
	{
		File file = new File(filename);
		PrintStream printf = new PrintStream(filename);
		printf.println("The number of nodes is : " + n);
		solve();
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=n;j++)
			{
				printf.println("The Lowest Common Ancestor between "+ i + " and "+ j + " is: "+find_LCA(i,j));
			}
			printf.println();
		}
		printf.close();
	}
	public static void main(String[] args) throws IOException
	{
		LowestCommonAncestor T = new LowestCommonAncestor();
		T.inp("data/Huysfiletest/LCA.inp");
		T.out("data/Huysfiletest/LCA.out");
	}
}
