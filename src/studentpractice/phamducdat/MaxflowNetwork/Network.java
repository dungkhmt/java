package studentpractice.phamducdat.MaxflowNetwork;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Network {
	private ArrayList<Node> A = new ArrayList<Node>();
	private HashMap<Integer, Node> B = new HashMap<Integer, Node>();
	private HashMap<Node, ArrayList<Arc>> C = new HashMap<Node, ArrayList<Arc>>();
	public int d;
	public int e;

	public ArrayList<Arc> getAdjacent(Node u) {
		return C.get(u);
	}

	public Node getNodeById(int i) {
		return B.get(i);
	}

	public void loadData(String filename) {
		try {
			Scanner in = new Scanner(new File(filename));
			d = in.nextInt();
			e = in.nextInt();

			while (in.hasNext()) {
				for (int i = 1; i <= d; i++) {
					Node nod = new Node(i);
					A.add(nod);
					B.put(i, nod);
					C.put(nod, new ArrayList<Arc>());
				}

				for (int i = 1; i <= e; i++) {
					int u = in.nextInt();
					int v = in.nextInt();
					int f = in.nextInt();
					int g = in.nextInt();
					Node nu = B.get(u);
					Node nv = B.get(v);
					Arc a = new Arc(nu, nv, f, g);
					C.get(nu).add(a);
				}
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Arc find(int u, int v) {
		Node nu = B.get(u);
		Node nv = B.get(v);

		for (Arc a : C.get(nu)) {
			if (a.end == nv) {
				return a;
			}
		}
		return null;

	}

	public int findBegin() {
		int[] v = new int[100];
		for (int i = 1; i <= d; i++) {
			Node u = B.get(i);
			for (Arc a : C.get(u)) {
				v[a.end.getId()] = 1;
			}
		}

		for (int i = 1; i <= d; i++) {
			if (v[i] != 1)
				return i;
		}
		return 0;
	}

	public int findEnd() {
		int[] v = new int[100];
		for (int i = 1; i <= d; i++) {
			Node u = B.get(i);
			for (Arc a : C.get(u)) {
				v[a.begin.getId()] = 1;
			}
		}

		for (int i = 1; i <= d; i++) {
			if (v[i] != 1)
				return i;
		}
		return 0;
	}

	public void putArc(int u, int v, int w) {
		Node nu = B.get(u);
		Node nv = B.get(v);
		Arc a = find(u, v);
		Arc b = new Arc(a.begin, a.end, a.d + w, a.w);
		C.get(nu).remove(a);
		C.get(nu).add(b);
	}

	public int check() {
		Node s = B.get(findBegin());
		Node t = B.get(findEnd());
		int o = 0;
		int e = 0;
		for (Arc a : C.get(s)) {
			o = o + a.d;
		}

		for (Node i : C.keySet()) {
			for (Arc a : C.get(i)) {
				if (a.end == t) {
					e = e + a.d;
				}
			}
		}

		if (o == e)
			return 1;
		else
			return 0;
	}

	public void print() {
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

		System.out.println("Begin = " + N.findBegin());
		System.out.println("End = " + N.findEnd());

	}

}
