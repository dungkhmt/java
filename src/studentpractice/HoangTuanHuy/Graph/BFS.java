package studentpractice.HoangTuanHuy.Graph;
import java.util.Queue;
import java.io.IOException;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.ArrayList;
public class BFS 
{
	Graph T;
	Queue <Node> qu = new LinkedList<>();
	private HashMap<Node,Integer> d = new HashMap<>();
	private HashMap<Node,Node> Trace = new HashMap<>();
	public BFS(Graph T)
	{
		this.T=T;
	}
	private Node get_node(int u)
	{
		return T.id2node(u);
	}
	public int run(int start,int finish)
	{
		Node U=get_node(start);
		d.put(U,0);
		qu.add(U);
		while(!qu.isEmpty())
		{
			Node u= qu.remove();
			int du=d.get(u);
			ArrayList<Arc> Xu = new ArrayList<>();
			Xu=T.get_AdjacentList(u);
			for(Arc arc:Xu)
			{
				Node nv=arc.end;
				int w=arc.w;
				if(d.get(nv)==null)
				{
					d.put(nv,du+1);
					qu.add(nv);
				}
			
			}
		}
		Node V=get_node(finish);
		if(d.get(V)==null) return 0;
		return d.get(V);
	}
}
