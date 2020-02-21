package studentpractice.phamducdat.Graph;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Graph {
	public ArrayList<Node> V = new ArrayList<Node>();
	public HashMap<Integer, Node> mId2Node = new HashMap<Integer, Node>();
	public HashMap<Node, ArrayList<Arc>> A = new HashMap<Node, ArrayList<Arc>>();
	public int  m, n;
	public Node getNodebyId(int i) {
		return mId2Node.get(i);
	}
	
	public ArrayList<Arc> getAdjacent(Node u) {
		return A.get(u);
	}
	
	public void loadData(String filename) {
		try {
			Scanner in = new Scanner(new File(filename));
			 n = in.nextInt();
			 m = in.nextInt();
			
			for(int i = 1; i <= n; i++) {
				Node nod = new Node(i);
				V.add(nod);
				mId2Node.put(i, nod);
				A.put(nod, new ArrayList<Arc>());
			}
			
			for(int i = 1; i <= m; i++) {
				int u = in.nextInt();
				int v = in.nextInt();
				int w = in.nextInt();
				Node nu = mId2Node.get(u);
				Node nv = mId2Node.get(v);
				Arc a = new Arc(nu, nv, w);
				A.get(nu).add(a);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void print() {
		System.out.print("V = ");
		for(Node u : V) {
			System.out.print(u.getId() + ", ");
		}
		System.out.println();
		for(Node u : V) {
			System.out.print("A[" + u.getId() + "] " + "= " );
			for(Arc a : A.get(u)) {
				System.out.print(a.toString());
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Graph G = new Graph();
		G.loadData("src/studentpractice/phamquangdung/graph.txt");
		G.print();
	}

}
