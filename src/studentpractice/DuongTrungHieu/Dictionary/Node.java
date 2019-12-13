package studentpractice.DuongTrungHieu.Dictionary;

public class Node 
{
	private String enWord;
	private String vnMeaning;
	private Node leftChild;
	private Node rightChild;
	public String getEnword() 
	{
		return enWord;
	}
	public void setEnword(String enWord) 
	{
		this.enWord = enWord;
	}
	public String getVnmeaning() 
	{
		return vnMeaning;
	}
	public void setVnmeaning(String vnmeaning) 
	{
		this.vnMeaning = vnMeaning;
	}
	public Node getLeft() {
		return leftChild;
	}
	public void setLeft(Node leftChild) 
	{
		this.leftChild = leftChild;
	}
	public Node getRight() 
	{
		return rightChild;
	}
	public void setRight(Node rightChild) 
	{
		this.rightChild = rightChild;
	}
	
	public Node(String enWord, String vnMeaning, Node leftChild, Node rightChild)
	{   super();
		this.enWord=enWord;
		this.vnMeaning=vnMeaning;
		this.leftChild=leftChild;
		this.rightChild=rightChild;
	}
	public Node(String enword) 
	{
		this.enWord = enWord;
		this.vnMeaning = null;
		this.leftChild=null;
		this.rightChild=null;
	}
	
	
}
