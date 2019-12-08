package studentpractice.DangMinhDuc.Graph;

public class Bases {
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void print()
	{
		System.out.print("Base(" + id + ")");
	}
	public Bases(int id) {
		this.id = id;
	}
}
