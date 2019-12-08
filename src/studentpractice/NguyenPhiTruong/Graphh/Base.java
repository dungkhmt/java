package studentpractice.NguyenPhiTruong.Graphh;

public class Base {
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void print() {
		System.out.print("Base(" + this.id + ")");
	}
	
	public Base(int id) {
		this.id = id;
	}
}
