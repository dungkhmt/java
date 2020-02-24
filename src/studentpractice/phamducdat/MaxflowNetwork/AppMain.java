package studentpractice.phamducdat.MaxflowNetwork;

import java.util.ArrayList;
import java.util.Collections;

import studentpractice.phamducdat.Graph.Graph;

public class AppMain {
	private GraphNetwork G;
	private BFSGN B;
	private Network N;
	
	public AppMain(Network N) {
		this.N = N;
	}
	
 	private int maxFlow(int nu, int nv, Network N) {
		int o = 0;
		ArrayList<Arc> A = new ArrayList<Arc>();
		ArrayList<Arc> C = new ArrayList<Arc>();
		G = new GraphNetwork(N);
		G.buildGraphNetwork();
		B = new BFSGN(G);
		Node u = G.getNodeById(nu);
		Node v = G.getNodeById(nv);
		A = C = B.getMinRoad(u, v);
		if(A == null) {
			int i = 0;
			for(Arc a : N.getAdjacent(N.getNodeById(nu))) {
				i = i + a.d;
			}
			System.out.println("After maxflow : ");
			N.print();
			return i;
		}
		Collections.sort(A);
		Arc b = A.remove(0);
		for(Arc a : B.getMinRoad(u, v)) {
			N.putArc(a.begin.getId(), a.end.getId(), b.w);
		}
		return maxFlow(nu, nv, N);
	}
	
	public int maxFlow(int u, int v) {
		return maxFlow(u, v, N);
	}

	
	
	public static void main(String[] args) {
		Network N = new Network();
		N.loadData("src/studentpractice/phamducdat/data/network2.txt");
		System.out.println("Input: ");
		N.print();
		
		AppMain app = new AppMain(N);
		if(N.check() == 0) {
			System.out.println("No max flow");
			return;
		}
		int u = N.findBegin();
		int v = N.findEnd();
		System.out.println("Begin = " + u + " , end = " + v);
		System.out.println();
		System.out.println("Max flow = " + app.maxFlow(u, v));
	}
}
