package studentpractice.HoangTuanHuy;
import java.io.*;
import java.util.*;
public class BFS 
{
	private int n,m ; /// n : the number of nodes ,  m : the number of edges
	
	private ArrayList<Integer>[] X = new ArrayList[1001]; // Edges list
	//private int[] dd = new int[1001]; //ticked node.
	private int[] p = new int[1001]; // Parent of u
	
	public void inp(String filename) throws IOException
	{
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
			printf.println("Parent of "+i+" is : "+p[i]);
		printf.close();
	}
	
	private Queue<Integer> qu = new LinkedList<>();
	private void BFS(int start)
	{
		qu.add(start);
		p[start]=start;
		while(!qu.isEmpty())
		{
			int u=qu.poll();
			for(int i=0;i<X[u].size();i++)
			{
				int v=X[u].get(i);
				if(p[v]==0)
				{
					p[v]=u;
					qu.add(v);
				}
			}
		}
	}
	public static void main(String[] args) throws IOException
	{
		BFS T= new BFS();
		T.inp("data/Huysfiletest/BFS.inp");
		for(int i=1;i<=T.n;i++)
			if(T.p[i]==0) T.BFS(i);
		T.out("data/Huysfiletest/BFS.out");
	}
}
