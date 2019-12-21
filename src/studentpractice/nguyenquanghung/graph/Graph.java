package studentpractice.nguyenquanghung.graph;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Graph {
	public ArrayList<Node> V;
	public HashMap<Node, ArrayList<Arc>> A; // Anh xa 1 doi tuong kieu Node sang 1 arraylist cac cung ke voi no
	HashMap<Integer, Node> mID2Node = new HashMap<Integer, Node>();
	
	public Node getNodeById(int id){
		return mID2Node.get(id);
	}
	public ArrayList<Arc> getAdjacent(Node u){
		return A.get(u);
	} 
	
	public void inputData(String filename) {
		try {
			Scanner in = new Scanner(new File(filename));
			int n = in.nextInt();
			int m = in.nextInt();
			V = new ArrayList<Node>();
			A = new HashMap<Node, ArrayList<Arc>>();


			for (int i = 1; i <= n; i++) {
				Node node = new Node(i);
				V.add(node);
				mID2Node.put(i, node);
				A.put(node, new ArrayList<Arc>());
			}

			for (int i = 1; i <= m; i++) {
				int u = in.nextInt();
				int v = in.nextInt();
				int w = in.nextInt();

				Node nu = mID2Node.get(u);
				Node nv = mID2Node.get(v);
				Arc a = new Arc(i, nu, nv);
				a.w = w;
				A.get(nu).add(a);
			}
			in.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void print() {
		for (Node u: V) {
			System.out.print(u.getId());
			ArrayList<Arc> Au = A.get(u);
			for (Arc a: Au) System.out.print(a.toString());
			System.out.println();
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph G = new Graph();
		G.inputData("src/studentpractice/nguyenquanghung/graph/Graph.txt");
		// G.printAdjacencyList();
		G.print();
	}

}
