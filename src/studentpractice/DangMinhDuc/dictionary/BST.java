package studentpractice.DangMinhDuc.dictionary;

public class BST {
	private Node root;
	public BST() {
		root = null;
	}
	private Node find(Node r,String enWord) {
		if (r==null) return null;
		int c = r.getEnWord().compareTo(enWord);
		if (c == 0) return r;
		if (c < 0) return find(r.getRightChild(),enWord);
		return find(r.getLeftChild(),enWord);
	}
	public String find(String enWord) {
		Node p = find(root, enWord);
		return p.getVnMeaning();
			
	}
	public void set(String enWord, String vnMeaning) {
		Node p = find(root, enWord);
		if ( p == null ) return;
		p.setVnMeaning(vnMeaning);
	}
	private Node insert(Node r,String enWord) {
		if ( r == null) return new Node (enWord);
		int c = r.getEnWord().compareTo(enWord);
		if (c < 0) r.setRightChild(insert(r.getLeftChild(),enWord));
		else r.setLeftChild(insert(r.getLeftChild(),enWord));
		return r;
	}
	
}