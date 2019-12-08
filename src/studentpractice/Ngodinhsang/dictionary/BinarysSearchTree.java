package studentpractice.Ngodinhsang.dictionary;

public class BinarysSearchTree {
	private Node root;
	
	public  BinarysSearchTree()
	{
		root=null;
	}
	public Node find(Node r,String enWord)
	{
		 if(r==null) return null;
		 int c=r.getEnWord().compareTo(enWord);
		 if(c==0) return r;
		 if(c<0) return find(r.getRightChild(),enWord);
		 else return find(r.getLeftChild(),enWord);
		 
	}
	public String find(String enWord)
	{
		Node p=find(root,enWord);
		if(p==null) return null;
		return p.getViWord();
	}
	public void set(String enWord, String viWord)
	{
		Node p=find(root,enWord);
		if(p==null) return;
		p.setViWord(viWord);
	}
}
