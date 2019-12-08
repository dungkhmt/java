package studentpractice.HoangTuanHuy.Graph;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.HashMap;
public class Dijkstra 
{
	private Graph T;
	public Dijkstra(Graph T)
	{
		this.T=T;
	}
	private Node get_node(int id)
	{
		return T.id2node(id);
	}
	private ArrayList<Arc> get_AdjacentNode(Node u)
	{
		return T.get_AdjacentList(u);
	}
	class pair implements Comparable<pair>
	{
		private int dis;
		private Node node;
		
		
		public int getDis() {
			return dis;
		}
		public void setDis(int dis) {
			this.dis = dis;
		}
		public Node getNode() {
			return node;
		}
		public void setNode(Node node) {
			this.node = node;
		}
		public pair(int dis,Node node)
		{
			this.dis=dis;
			this.node=node;
		}
		public int compareTo(pair a)
		{
			return dis-a.dis;
		}
	}
	private Queue <pair> pri = new PriorityQueue<>();
	private HashMap<Node,Integer> d = new HashMap<>();
	public int run(int start,int finish)
	{
		Node U= get_node(start);
		Node V= get_node(finish);
		d.put(U,0);
		pri.add(new pair(0,U));
		while(!pri.isEmpty())
		{
			pair x= pri.remove();
			int du=x.getDis();
			Node u =x.getNode();
			if(du!=d.get(u)) continue;
			if(u==V) break;
			ArrayList<Arc> Xu = new ArrayList<>();
			Xu=get_AdjacentNode(u);
			for(Arc arc:Xu)
			{
				Node v=arc.end;
				int w=arc.w;
				if(d.get(v)==null || d.get(v)>du+w)
				{
					int dv=du+w;
					d.put(v,dv);
					pri.add(new pair(dv,v));
				}
			}
		}
		if(d.get(V)==null) return 0;
		return d.get(V);
	}
}
