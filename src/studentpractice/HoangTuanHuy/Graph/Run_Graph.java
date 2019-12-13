package studentpractice.HoangTuanHuy.Graph;
import java.io.IOException;
import java.io.PrintStream;
import java.io.File;
public class Run_Graph 
{
	private Graph T;
	private BFS T_BFS;
	private Dijkstra T_Dijkstra;
	private String ans;
	private void make_Graph() throws IOException
	{
		T= new Graph();
		T.inp("src/studentpractice/HoangTuanHuy/Graph/Graph.inp");
		T_BFS = new BFS(T);
		T_Dijkstra = new Dijkstra(T);
	}
	private String run_bfs(int start,int finish)
	{
		return "Distance from " +start+" to "+finish+" : " + T_BFS.run(start, finish);
	}
	private String run_dijkstra(int start,int finish)
	{
		return "Distance from " +start+" to "+finish+" : " + T_Dijkstra.run(start, finish);
	}
	public void out_answer(String filename) throws IOException
	{
		PrintStream printf = new PrintStream(new File(filename));
		printf.println(ans);
		printf.close();
	}
	public static void  main(String[] args) throws IOException
	{
		Run_Graph RG = new Run_Graph();
		RG.make_Graph();
		int start =6,finish =7;
		RG.ans = RG.run_dijkstra(start,finish);
		RG.out_answer("src/studentpractice/HoangTuanHuy/Graph/Graph.out");
		
	}
}
