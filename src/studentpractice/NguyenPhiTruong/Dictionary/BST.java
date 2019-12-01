package studentpractice.NguyenPhiTruong.Dictionary;

public class BST {
	private Node root;

	public BST() {

	}

	private Node findNode(Node r, String key) {
		if (r == null)
			return null;
		int check = r.getEn().compareTo(key);
		if (check == 0)
			return r;
		if (check < 0)
			return findNode(r.getRightChild(), key);
		return findNode(r.getLeftChild(), key);
	}

	public String find(String en) {
		Node p = findNode(root, en);
		if (p == null)
			return null;
		return p.getVi();
	}

	public void set(String en, String vi) {
		Node p = findNode(root, en);
		if (p == null)
			return;
		p.setVi(vi);
	}
	
	private Node insert(Node r, String word) {
		if (r==null) return new Node(word);
		int c = r.getEn().compareTo(word);
		if (c < 0) r.setRightChild(insert(r.getRightChild(),word));
		else r.setLeftChild(insert(r.getLeftChild(),word));
		return r;
		
	}
	
	public void insert(String word) {
		root = insert(root,word);
	}
}
