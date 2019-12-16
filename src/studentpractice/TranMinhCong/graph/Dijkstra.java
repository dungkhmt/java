package studentpractice.TranMinhCong.graph;

import java.util.Comparator;

public class Dijkstra {
	private Graph G;
	
	
	int[] dist;
	public Dijkstra (Graph G) {
		this.G = G;
	}
	public void shortestPath(Node s , Node t)
	{
		int n = G.V.size();
		dist = new int[n];
		for(int i = 0 ; i <= n ; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[s.getId()] = 0;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph G = new Graph();
		G.loadData("src/studentpractice/TranMinhCong/graph/data.txt");
		G.print();
	}
}
class Pair implements Comparator<Pair>{
	public int node;
	public int cost;
	public Pair() {};
	public Pair(int node ,int cost) {
		this.node = node;
		this.cost = cost;
	}
	
}
