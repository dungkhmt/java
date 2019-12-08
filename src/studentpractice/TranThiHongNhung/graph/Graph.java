package studentpractice.TranThiHongNhung.graph;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Graph {
	public ArrayList<Node> V;
	public HashMap<Node, ArrayList<Arc>> A;
	HashMap<Integer, Node> mid2Node = new HashMap<Integer, Node>();
	
	public Node getNodebyid(int id) {
		return mid2Node.get(id);
	}
	
	public ArrayList<Arc> getAdj(Node u){
		return A.get(u);
	}
	private void getid(int id) {
		// TODO Auto-generated method stub
		
	}

	public void loadData(String filename) {
		try {
			Scanner in =new Scanner(new File(filename));
			int n =in.nextInt();
			int m=in.nextInt();
			V= new ArrayList<Node>();
			A= new HashMap<Node, ArrayList<Arc>>();
			
			
			for(int i=1;i<=n;i++) {
				Node nod= new Node(i);
				V.add(nod);
				mid2Node.put(i, nod);
				A.put(nod,  new ArrayList<Arc>());
			}
			for(int k=1;k<=m;k++) {
				int u=in.nextInt();
				int v=in.nextInt();
				int w=in.nextInt();
				
				Node nu=mid2Node.get(u);
				Node nv=mid2Node.get(v);
				Arc a= new Arc(k,nu,nv);
				a.w= w;
				A.get(nu).add(a);
			}
			in.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	public void print() {
		System.out.print("V = ");
		for(Node nod: V) {
			System.out.print(nod.getid()+ " ")	;
		}
		System.out.println();
		for(Node u:V) {
			ArrayList<Arc> Au=A.get(u);
			System.out.print("A [" + u.getid() + "] =)" );
			for(Arc a: Au) {
				System.out.print(a.toString());
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Graph G= new Graph();
		G.loadData("src/studentpractice/TranThiHongNhung/graph/graph.txt");
		G.print();
	}
}

