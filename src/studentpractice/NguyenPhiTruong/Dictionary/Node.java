package studentpractice.NguyenPhiTruong.Dictionary;

public class Node {
	private String en;
	private String vi;
	private Node leftChild;
	private Node rightChild;
	public String getEn() {
		return en;
	}
	public void setEn(String en) {
		this.en = en;
	}
	public String getVi() {
		return vi;
	}
	public void setVi(String vi) {
		this.vi = vi;
	}
	public Node getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}
	public Node getRightChild() {
		return rightChild;
	}
	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}
	public Node(String en, String vi, Node leftChild, Node rightChild) {
		super();
		this.en = en;
		this.vi = vi;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
	public Node() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Node(String word) {
		this.en = word;
		this.vi = null;
		this.leftChild = null;
		this.rightChild = null;
	}
	
}
