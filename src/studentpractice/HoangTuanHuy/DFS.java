package studentpractice.HoangTuanHuy;
import java.io.*;
import java.util.*;
public class DFS 
{
	// O(n+m);
	private int n,m; /// n : the number of nodes ,  m : the number of edges
	
	private ArrayList<Integer>[] X = new ArrayList[1001]; // Edges list
	private int[] dd = new int[1001]; //ticked node.
	private int[] p = new int[1001]; // Parent of u
	private int[] begin_topo = new int[1001];
	private int[] end_topo = new int[1001];
	private int cnt ; // time
	
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
			X[v].add(u);
		}
		scan.close();
	}
	
	public void out(String filename) throws IOException
	{
		File file = new File(filename);
		PrintStream printf = new PrintStream(filename);
		printf.println("The number of nodes is : " + n);
		for(int i=1;i<=n;i++)
		{
			printf.print("Adjacent node "+ i+" : ");
			for(int j=0;j<X[i].size();j++) printf.print(X[i].get(j)+" ");
			printf.println();
		}
		printf.println();
		for(int i=1;i<=n;i++)
			printf.println("Parent of "+i+" is : "+p[i]+" ; "+"Begin topo["+ i + "] : " + begin_topo[i]+" ; "+ "End topo["+ i+"] : "+end_topo[i]);
		printf.close();
	}
	public void DFS(int u)
	{
		dd[u]=1;
		begin_topo[u]=++cnt;
		for(int j=0;j<X[u].size();j++)
		{
			int v=X[u].get(j);
			if(dd[v]==0)
			{
				p[v]=u;
				DFS(v);
			}
		}
		end_topo[u]=cnt;
	}
	public static void main (String[] args) throws IOException
	{
		DFS T= new DFS() ;
		T.inp("data/Huysfiletest/DFS.inp");
		for(int i=1;i<=T.n;i++)
			if(T.dd[i]==0) T.DFS(i);
		T.out("data/Huysfiletest/DFS.out");
		
	}
}
