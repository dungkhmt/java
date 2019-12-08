public class Arc extends Base {
    public Node_1 begin;
    public Node_1 end;
    public int weight;

    public Arc(int id) {
        super(id);
    }
    public Arc(int id, Node_1 begin, Node_1 end) {
        super(id);
        this.begin = begin;
        this.end = end;
    }
    public String toString() {
        return "(" + begin.getId() + "," + end.getId() + "," + weight + ")" + "; ";
    }
}
