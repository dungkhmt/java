package studentpractice.NguyenPhiTruong.Graphh;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Graph {
	public ArrayList<Node> V;
	public HashMap<Node, ArrayList<Arc>> A;
	HashMap<Integer,Node> mId2Node = new HashMap<Integer,Node>();
	
	public Node findNode(int id) {
		return mId2Node.get(id);
	}
	
	public ArrayList<Arc> getArc(Node u){
		return A.get(u);
	}
	
	public void loadData(String filename) {
		try {
			Scanner scan = new Scanner(new File(filename));
			int n,m;
			n = scan.nextInt();
			m = scan.nextInt();
			V = new ArrayList<Node>();
			A = new HashMap<Node, ArrayList<Arc>>();
//			HashMap<Integer,Node> mId2Node = new HashMap<Integer,Node>();
			for (int i =1; i <= n; i++) {
				Node nod = new Node(i);
				V.add(nod);
				mId2Node.put(i,nod);
				A.put(nod, new ArrayList<Arc>());
			}
			
			for (int k = 1; k <= m; k++) {
				int u = scan.nextInt();
				int v = scan.nextInt();
				int w = scan.nextInt();
				
				Node nu = mId2Node.get(u);
				Node nv = mId2Node.get(v);
				
				Arc a = new Arc(k,nu,nv);
				a.w = w;
				A.get(nu).add(a);
				
			}
			
			scan.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void print() {
		System.out.print("V= ");
		for (Node nod : V) {
			System.out.print(nod.getId() + " ");
		}
		System.out.print("\n");
		for (Node nod : V) {
			int id = nod.getId();
			System.out.print("A[" + id + "] = ");
			ArrayList<Arc> B = A.get(nod);
			for (Arc a : B) {
//				System.out.print("(" + a.begin.getId() + "," + a.end.getId() + "," + a.w + ")");
				System.out.print(a.toString() + ", ");
				
			}
			System.out.print("\n");
		}
		
	}
	public static void main(String[] args) {
		Graph G = new Graph();
		G.loadData("data\\TruongTest\\Graph.txt");
		G.print();
	}
}
