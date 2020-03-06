package studentpractice.phamducdat.MaxflowNetwork;


public class Node {
	
	private int id;
	private Node father;

	public Node getFather() {
		return father;
	}

	public void setFather(Node father) {
		this.father = father;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Node(int id) {
		super();
		this.id = id;
		this.father = null;
	}

	public Node() {
		super();
	}
	
	

}
