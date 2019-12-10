package studentpractice.phamducdat.graph;

public class Arc extends Base {

	public Node begin;
	public Node end;
	public int w;

	public Arc(int id) {
		super(id);
	}

	public Arc(int id, Node begin, Node end) {
		super(id);
		this.begin = begin;
		this.end = end;
	}

	public String toString() {
		return "(" + begin.getId() + "," + end.getId() + "," + w + ")";
	}
}
