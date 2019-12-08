import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.util.Scanner;

public class Graph {
    public ArrayList<Node_1> V;
    public HashMap<Node_1, ArrayList<Arc>> A;
    HashMap<Integer, Node_1> mId2Node = new HashMap<Integer, Node_1>();

    public Node_1 getNodeById(int id) {
        return mId2Node.get(id);
    }

    public ArrayList<Arc> getAdjacent(Node_1 u) {
        return A.get(u);
    }
    public void loadData() throws Exception {
        File file = new File("data/DirectedGraph.txt");
        Scanner sc = new Scanner(file);
        int n = sc.nextInt();
        int m = sc.nextInt();

        V = new ArrayList<Node_1>();
        A = new HashMap<Node_1, ArrayList<Arc>>();

        for (int i = 1; i <= n; i++) {
            Node_1 node = new Node_1(i);
            V.add(node);
            mId2Node.put(i, node);
            A.put(node, new ArrayList<Arc>());
        }
        for (int i = 1; i <= m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            Node_1 nu = mId2Node.get(u);
            Node_1 nv = mId2Node.get(v);

            Arc a = new Arc(i, nu, nv);
            a.weight = w;
            A.get(nu).add(a);
        }
    }
    public void print() {
        System.out.print("V = ");
        for (Node_1 u : V) {
            System.out.print(u.getId() + " ");
        }
        System.out.println();
        for (Node_1 u : V) {
            ArrayList<Arc> Au = A.get(u);
            System.out.print("A[" + u.getId() + "] = ");
            for (Arc a : Au) {
                System.out.print(a.toString());
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        Graph G = new Graph();
        G.loadData();
        G.print();
    }
}
