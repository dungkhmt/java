package studentpractice.phamducdat.MaxflowNetwork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class GraphNetwork {
	private Network N;
	private ArrayList<Node> A = new ArrayList<Node>(); 
	private HashMap<Integer, Node> B = new HashMap<Integer, Node>();
	private HashMap<Node, ArrayList<Arc>> C = new HashMap<Node, ArrayList<Arc>>();
	public int d;
	public int e;
	private Node k = new Node(2000);

	public GraphNetwork(Network N) {
		this.N = N;

	}

	public ArrayList<Arc> getAdjacent(Node u) {
		return C.get(u);
	}

	public Node getNodeById(int i) {
		return B.get(i);
	}

	private void buildGraphNetwork(Network N) {
		if(N.check() == 0) {
			return;
		}
		d = N.d;
		e = N.e;
		for(int i = 1; i <= d; i++) {
			Node nod = new Node(i);
			A.add(nod);
			B.put(i, nod);
			C.put(nod, new ArrayList<Arc>());
		}
		
		for(Node i : C.keySet()) {
			for(Arc a : N.getAdjacent(N.getNodeById(i.getId()))) {
				int v = a.end.getId();
				Node nv = B.get(v);
				Arc b = new Arc(i, nv, a.d, a.w);
				C.get(i).add(b);
				Arc c = new Arc(i, k, 8, 0);
				C.get(i).add(c);
			}
		}
		
		for (Node u : C.keySet()) {
			for (int i = 0; i < C.get(u).size(); i++) {
				Arc a = C.get(u).get(i);
				if (a.d != 1000 && a.end.getId() != 2000) {
					if (a.w == a.d) {
						Arc b = new Arc(a.end, a.begin, 1000, a.w);
						C.get(b.begin).add(b);
						remove(u);
					} else {
						a.w = a.w - a.d;
					}
				}
			}
		}
	}

	private void remove(Node u) {
		for (int i = 0; i < C.get(u).size(); i++) {
			Arc a = C.get(u).get(i);
			if (a.w == a.d) {
				C.get(u).remove(i);
			}
		}
		return;
	}
	
	public void buildGraphNetwork() {
		buildGraphNetwork(N);
	}

	public void print() {
		if(N.check() == 0) {
			System.out.println("No max flow");
			return;
		}
		System.out.println("Graph network: ");
		System.out.print("V = ");
		for (Node i : A) {
			System.out.print(i.getId() + " , ");
		}
		System.out.println();
		for (Node i : A) {
			System.out.print("A[" + i.getId() + "] = ");
			for (Arc a : C.get(i)) {
				System.out.println(a.toString());
			}
		}
		System.out.println();
	}
	

	public static void main(String[] args) {
		Network N = new Network();
		N.loadData("src/studentpractice/phamducdat/data/network.txt");
		N.print();

		GraphNetwork G = new GraphNetwork(N);
		G.buildGraphNetwork();
		G.print();
	}

}
