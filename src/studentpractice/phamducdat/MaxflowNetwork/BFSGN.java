package studentpractice.phamducdat.MaxflowNetwork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BFSGN {
	private GraphNetwork G;

	public BFSGN(GraphNetwork G) {
		this.G = G;
	}

	private ArrayList<Arc> getMinRoad(Node u, Node v, GraphNetwork G) {

		ArrayList<Arc> S = new ArrayList<Arc>();
		Queue<Node> Q = new LinkedList<Node>();
		HashMap<Node, Integer> D = new HashMap<Node, Integer>();
		Q.add(u);
		D.put(u, 0);

		while (Q.size() > 0) {
			Node nu = Q.remove();
			if (nu == v)
				break;
			for (Arc a : G.getAdjacent(nu)) {
				if(a.end.getId() != 2000) {
				Node m = a.end;
				if (D.get(m) == null) {
					D.put(m, D.get(nu) + a.w);
					Q.add(m);
					m.setFather(nu);
				}
				}
			}
		}

		Node p = v;
		if (p.getFather() == null) {
			S = null;
			return S;
		}
		while (p.getFather() != null) {
			for (Arc a : G.getAdjacent(p.getFather())) {
				if (a.end == p) {
					S.add(a);
					p = p.getFather();
				}
			}
		}
		return S;

	}

	public ArrayList<Arc> getMinRoad(Node u, Node v) {
		return getMinRoad(u, v, G);
	}

	public static void main(String[] args) {
		Network N = new Network();
		N.loadData("src/studentpractice/phamducdat/data/network.txt");
		N.print();

		GraphNetwork G = new GraphNetwork(N);
		G.buildGraphNetwork();

		BFSGN B = new BFSGN(G);
		if(N.check() == 0) {
			System.out.println("No max flow");
			return;
		}
		Node u = G.getNodeById(N.findBegin());
		Node v = G.getNodeById(N.findEnd());
		System.out.println("Min road from " + u.getId() + " to " + v.getId() + " = ");
		for (Arc a : B.getMinRoad(u, v)) {
			System.out.println(a.toString());
		}
	}
}
