package studentpractice.TranMinhCong.graph;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Graph {
	public ArrayList<Node> V;
	public HashMap<Node , ArrayList<Arc>> A;
	HashMap<Integer, Node> mId2Node = new HashMap<Integer , Node>();
	
	public Node getNodeById(int id) {
		return mId2Node.get(id);
	}
	public void loadData(String filename) {
		try {
			Scanner in = new Scanner(new File(filename));
			int m , n ;
			n = in.nextInt();
			m = in.nextInt();
			V = new ArrayList<Node>();
			A = new HashMap<Node , ArrayList<Arc>>();
			
			
			for(int i = 1 ; i <= n ; i++) {
				Node node = new Node(i);
				V.add(node);
				A.put(node , new ArrayList<Arc>());
				mId2Node.put(i , node);
				
			}
			
			for(int i = 1 ; i <= m ; i++) {
				int u , v , w;
				u = in.nextInt();
				v = in.nextInt();
				w = in.nextInt();
				
				Node nu = mId2Node.get(u);
				Node nv = mId2Node.get(v);
				Arc a = new Arc(i,nu , nv);
				a.w = w;
				
				
				A.get(nu).add(a);
			}
			
			
			in.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<Arc> getAdjacent(Node u){
		return A.get(u);
	}
	public void print() {
		System.out.print("V = ");
		for(Node node : V) {
			System.out.print(node.getId() +",");
			
		}
		System.out.println();
		
		for(Node node : V) {
			System.out.print("A[" + node.getId() + "] = " );
			for(Arc edge : A.get(node)) {
				System.out.print(edge.toString());	
			}
			System.out.println();
			
		}
	}
	
	public static void main(String[] args) {
		Graph G = new Graph();
		G.loadData("src/studentpractice/TranMinhCong/graph/data.txt");
		G.print();
	}
}
