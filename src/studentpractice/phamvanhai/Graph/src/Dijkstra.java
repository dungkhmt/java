import java.util.LinkedList;

public class Dijkstra {
	private Graph G = new Graph();
	public LinkedList<Node> V = new LinkedList<Node>();
	
	public Dijkstra(Graph G) {
		this.G = G;
	}
	
	public void makeV(Graph G) {
		for()
	}
	
	public void findPath(Node s, Node t) {
		
	}
	public static void main(String[] args) {
		Graph G = new Graph();
		G.loadData("Data/info_graph");
		G.print();
		
		Dijkstra D = new Dijkstra(G);
		D.findPath(s, t);
	}
}
