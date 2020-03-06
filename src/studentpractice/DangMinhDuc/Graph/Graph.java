package studentpractice.DangMinhDuc.Graph;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Graph {
	public ArrayList<Node> V;
	public HashMap<Node, ArrayList<Arc>> A; // anh xa moi Node voi mot danh sach cung (Arc) ke voi no
	HashMap<Integer, Node> mId2Node = new HashMap<Integer, Node>();
	public Node getNodebyId(int id) {
		return mId2Node.get(id);
	}
	public ArrayList<Arc> getAdjacent(Node u){
		return A.get(u);
	}
	public void loadData(String filename) {
		try {
			Scanner in = new Scanner(new File(filename));
			int n = in.nextInt();
			int m = in.nextInt();
			V = new ArrayList<Node>();
			A = new HashMap<Node, ArrayList<Arc>>();
			for (int i = 1; i <= n; i++) {
				Node nod = new Node(i);
				V.add(nod); // chen nod vao sau V
				A.put(nod, new ArrayList<Arc>());
				mId2Node.put(i, nod);
			}
			for (int k = 1; k <= m; k++) {
				int u = in.nextInt();
				int v = in.nextInt();
				int w = in.nextInt();

				Node nu = mId2Node.get(u);
				Node nv = mId2Node.get(v);
				Arc a = new Arc(k, nu, nv);
				a.w = w;
				A.get(nu).add(a);
			}
			in.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void print() {
		System.out.print("V = ");
		for (Node nod : V) {
			System.out.print(nod.getId() + " ");
		}
		System.out.println();
			for (Node u : V) {
				ArrayList<Arc> Au = A.get(u);
				System.out.print("A[" + u.getId() + "] = ");
				for (Arc a : Au) {
					System.out.print(a.toString());
				}
				System.out.println();

			}
		}
	
	public static void main(String[] args) {
		Graph G = new Graph();
		G.loadData("E:/Java/java/src/studentpractice/DangMinhDuc/Graph/Graph.txt");
		G.print();
	}
}
