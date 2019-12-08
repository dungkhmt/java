package studentpractice.TranThiHongNhung.graph;

public class base {
	private int id;
	public int getid() {
		return id;
	}
	public void setid(int id) {
		this.id= id;
	}
	public void print() {
		System.out.print("base("+id+")");
	}
	public base(int id) {
		this.id= id;
	}
}
