package studentpractice.nguyentiendung.graph;

public class Arc extends Bases {
	public Node begin;
	public Node end;

	public Arc(int id) {
		super(id);
	}

	public Arc(int id, Node begin, Node end) {
		super(id);
		this.begin = begin;
		this.end = end;
	}

	public int w;// weight of arc

	public String toString() {
		return "(" + begin.getId() + "," + end.getId() + "," + w + ")";
	}
}
