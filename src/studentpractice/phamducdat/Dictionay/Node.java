package studentpractice.phamducdat.Dictionay;

public class Node {
	private String enWord;
	private String vnMeaning;
	private Node LeftChild;
	private Node RightChild;
	
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
		return LeftChild;
	}
	public void setLeftChild(Node leftChild) {
		LeftChild = leftChild;
	}
	public Node getRightChild() {
		return RightChild;
	}
	public void setRightChild(Node rightChild) {
		RightChild = rightChild;
	}
	public Node(String enWord, String vnMeaning, Node leftChild, Node rightChild) {
		super();
		this.enWord = enWord;
		this.vnMeaning = vnMeaning;
		LeftChild = leftChild;
		RightChild = rightChild;
	}
	public Node(String enWord) 
	{
		this.enWord=enWord;
		this.vnMeaning=null;
		this.LeftChild=null;
		this.RightChild=null;
	}


}
