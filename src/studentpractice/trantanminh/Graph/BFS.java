import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    private Graph G;

    public BFS(Graph G) {
        this.G = G;
    }

    public void findPath(Node_1 s, Node_1 t) {
        Queue<Node_1> Q = new LinkedList<>();
        HashMap<Node_1, Integer> d = new HashMap<Node_1, Integer>();
        d.put(s, 0);
        Q.add(s);
        while(Q.size() > 0) {
            Node_1 u = Q.remove();
            if (u == t) break;
            for (Arc a: G.getAdjacent(u)) {
                Node_1 v = a.end;
                if (d.get(v) == null) {
                    d.put(v, d.get(u) + 1); // d(v) = d(u) + 1
                    Q.add(v); // Q.push(v)
                }
            }
        }
        System.out.println("Distance between node " + s.getId() + " to node " + t.getId() + " is " + d.get(t));
    }
    public static void main(String[] args) throws Exception{
        Graph G = new Graph();
        G.loadData();
        G.print();

        BFS app = new BFS(G);
        Node_1 s = G.getNodeById(6);
        Node_1 t = G.getNodeById(7);
        app.findPath(s, t);
    }
}
