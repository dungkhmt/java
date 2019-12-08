package studentpractice.DuongTrungHieu.graph;

public class Art extends Base {
	public Node begin;
	public Node end;
	public int w;//weight of the arc	
	public Art(int id) {
		super(id);
	}
	public Art(int id, Node begin, Node end) {
		super(id);
		this.begin = begin;
		this.end = end;
	}
	public String toString() {
		return "(" + begin.getId() + "," + end.getId() + "," + w + ")";
	}
}
