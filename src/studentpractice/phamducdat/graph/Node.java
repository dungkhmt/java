package studentpractice.phamducdat.Graph;

public class Node {
	private int id;
	private Node child;
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
		this.child = null;
		this.father = null;
	}

	public Node getChild() {
		return child;
	}

	public void setChild(Node child) {
		this.child = child;
	}
	
	

}
