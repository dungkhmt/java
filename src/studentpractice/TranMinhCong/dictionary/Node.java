package studentpractice.TranMinhCong.dictionary;

public class Node {
	private String enWord;
	private String viWord;
	private Node leftChild;
	private Node rightChild;
	
	public String getEnWord() {
		return enWord;
	}
	public void setEnWord(String enWord) {
		this.enWord = enWord;
	}
	public String getViWord() {
		return viWord;
	}
	public void setViWord(String viWord) {
		this.viWord = viWord;
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
	public Node(String enWord, String viWord, Node leftChild, Node rightChild) {
		super();
		this.enWord = enWord;
		this.viWord = viWord;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
	
	public Node() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Node(String enWord)
	{
		this.enWord = enWord;
		this.viWord = null;
		this.leftChild = null;
		this.rightChild = null;
		
	}
	
	
}
