package studentpractice.HoangTuanHuy.Dictionary;

public class Node 
{
	private String enword;
	private String vnmeaning;
	private Node left;
	private Node right;
	public String getEnword() 
	{
		return enword;
	}
	public void setEnword(String enword) 
	{
		this.enword = enword;
	}
	public String getVnmeaning() 
	{
		return vnmeaning;
	}
	public void setVnmeaning(String vnmeaning) 
	{
		this.vnmeaning = vnmeaning;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) 
	{
		this.left = left;
	}
	public Node getRight() 
	{
		return right;
	}
	public void setRight(Node right) 
	{
		this.right = right;
	}
	
	public Node(String enword, String vnmeaning)
	{
		this.enword=enword;
		this.vnmeaning=vnmeaning;
		this.left=null;
		this.right=null;
	}
	public Node(String enword) 
	{
		this.enword = enword;
		this.vnmeaning = null;
		this.left=null;
		this.right=null;
	}
	
	
}
