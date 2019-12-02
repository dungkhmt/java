package studentpractice.tranvanthang.dictionary;

public class Node {
	private String enWord;
	private String vnMeaning;
	private Node leftChid;
	private Node rightChild;
	public Node() {
		super();
	}
	public Node(String enWord) {
		super();
		this.enWord = enWord;
		this.vnMeaning=null;
		this.leftChid=null;
		this.rightChild=null;
	}
	public Node(String enWord, String vnMeaning, Node leftChid, Node rightChild) {
		super();
		this.enWord = enWord;
		this.vnMeaning = vnMeaning;
		this.leftChid = leftChid;
		this.rightChild = rightChild;
	}
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
	public Node getLeftChid() {
		return leftChid;
	}
	public void setLeftChid(Node leftChid) {
		this.leftChid = leftChid;
	}
	public Node getRightChild() {
		return rightChild;
	}
	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}
}
