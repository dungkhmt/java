package studentpractice.nguyentiendung.dictionary;

public class Node {
	public String getEnword() {
		return enword;
	}
	public void setEnword(String enword) {
		this.enword = enword;
	}
	public String getVimeaning() {
		return vimeaning;
	}
	public void setVimeaning(String vimeaning) {
		this.vimeaning = vimeaning;
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
	private String enword;
	private String vimeaning;
	private Node leftChild;
	private Node rightChild;
	public Node(String enword, String vimeaning, Node leftChild, Node rightChild) {
		super();
		this.enword = enword;
		this.vimeaning = vimeaning;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
	public Node(String enword) {
		this.enword = enword;
		this.vimeaning= null;
		this.leftChild=null;
		this.rightChild=null;
	}
	public Node() {
		super();
		// TODO Auto-generated constructor stub
	}
}
