package studentpractice.nguyentiendung.graph;

public class Bases {
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public void print() {
		System.out.print("Bases("+ id +")");
		
	}
	public Bases(int id) {
		this.id= id;
	}
	
}
