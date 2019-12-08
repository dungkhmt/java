package studentpractice.DuongTrungHieu.graph;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Graph {
	public ArrayList<Node> V;
	public HashMap<Node, ArrayList<Art>> A;
	HashMap<Integer, Node> mId2Node = new HashMap<Integer, Node>();
	public Node getNodeById(int id) {
		return mId2Node.get(id);
	}
	public ArrayList<Art> getAdjacent(Node u){
		return A.get(u);
	}
	public void loadData(String filename) {
		try {
			Scanner in=new Scanner(new File(filename));
			int n = in.nextInt();
			int m = in.nextInt();
			V = new ArrayList<Node>();//danh sach cac node
			A = new HashMap<Node, ArrayList<Art>>();//danh sach cac canh
			
			for(int i =1;i<=n;i++) {
				Node nod=new Node(i);
				V.add(nod);
				mId2Node.put(i, nod);
				A.put(nod, new ArrayList<Art>());
			}
			for(int k = 1; k <= m; k++) {
				int u = in.nextInt();
				int v = in.nextInt();
				int w = in.nextInt();
				
				Node nu = mId2Node.get(u);
				Node nv = mId2Node.get(v);
				Art a = new Art(k,nu,nv); //chen vao danh sach ke cua nut k, nu la diem den, nv la trong so
				a.w = w;
				A.get(nu).add(a);
			}
			
			in.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	public void print() {
		System.out.print("V = ");
		for(Node u: V) {
			System.out.print(u.getId() + ", ");
			}
		System.out.print("\n");
	for(Node u: V) {
		ArrayList<Art> Au = A.get(u);
		System.out.print("A[" + u.getId() + "] = ");
		for(Art a: Au) {
			System.out.print(a.toString());
		}
		System.out.println();
	}
	}
	public static void main(String[] args) {
		Graph G = new Graph();
		G.loadData("src/studentpractice/DuongTrungHieu/graph/Note.txt");
		G.print();
	}
}








