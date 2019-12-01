package studentpractice.nguyenthitham.dictionary;

public class BST {
	private Node root;
	
	public BST(){
		
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
}
