package studentpractice.TranMinhCong.dictionary;

public class BinarySearchTree {
	private Node root;
	public BinarySearchTree() {
		root = null;
	}
	private Node find(Node r , String enWord) {
		if(r == null) return null;
		int c = r.getEnWord().compareTo(enWord);
		if(c == 0) return r;
		if(c < 0) return find(r.getRightChild(), enWord);
		return find(r.getLeftChild(),enWord);
	}
	public String find(String enWord) {
		Node p = find(root , enWord);
		if(p == null) return null;
		return p.getViWord();
	}
	public void set(String enWord , String viWord) {
		Node p = find(root , enWord);
		if(p == null) return;
		p.setViWord(viWord);
	}
	private Node insert(Node r , String enWord) {
		if(r == null) return new Node(enWord);
		int c = r.getEnWord().compareTo(enWord);
		if(c < 0) r.setRightChild(insert(r.getRightChild(),enWord));
		else r.setLeftChild(insert(r.getLeftChild(),enWord));
		return r;
	}
	public void insert(String enWord) {
		root = insert(root,enWord);
	}
}
	