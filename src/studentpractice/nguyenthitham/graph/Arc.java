package studentpractice.nguyenthitham.graph;

public class Arc extends Base {
	public Node begin;// diem bat dau cua do thi
	public Node end; // diem ket thuc
	public int w;

	// de public khong can get & set
	public Arc(int id) {
		super(id);
	}

	public Arc(int id, Node begin, Node end) {
		super(id);// khai
		this.begin = begin;
		this.end = end;
	}

	public String toString() {
		return "(" + begin.getId() + "," + end.getId() + "," + w + ")";
	}

}
