package studentpractice.nguyenthitham.dictionary;

public class BST {
	private Node root;
	
	public BST(){
		root=null;
	}
	
	private Node find(Node r, String enWord){
		if (r==null) return null;
		int c=r.getEnWord().compareTo(enWord);
		if(c==0) return r;
		if(c<0) return find(r.getRightChild(), enWord);
		return find(r.getLeftChild(), enWord);
	}
	public String find(String enWord){
		Node p=find(root, enWord);
		if(p==null) return null;
		return p.getVnMeaning();
	}
	
	public void set(String enWord, String vnMeaning){
		Node p=find(root, enWord);
		if(p==null) return;
		p.setVnMeaning(vnMeaning);
	}
	private Node insert(Node r, String enWord){
		if(r==null) return new Node(enWord);
		int c=r.getEnWord().compareTo(enWord);
		if(c<0) r.setRightChild(insert(r.getRightChild(), enWord));
		else r.setLeftChild(insert(r.getLeftChild(), enWord));
		return r;
		
	}
	public void insert(String enWord){
		root= insert(root, enWord);
	}
}
