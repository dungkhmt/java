package studentpractice.phamducdat.Dictionary;

public class Node {
	private String enWord;
	private String vnMeaning;
	private Node leftChild;
	private Node rightChild;
	public String getEnWord() {
		return enWord;
	}
	public void setEnWord(String enWord) {
		this.enWord = enWord;
	}
	public String getVnMeaning() {
		return vnMeaning;
	}
	public void setVnMeaning(String vnMeaning) {
		this.vnMeaning = vnMeaning;
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
	public Node(String enWord) {
		super();
		this.enWord = enWord;
		this.vnMeaning = null;
		this.leftChild = null;
		this.rightChild = null;
	}
	

}
