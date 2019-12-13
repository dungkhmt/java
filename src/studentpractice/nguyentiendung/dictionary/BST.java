package studentpractice.nguyentiendung.dictionary;
import java.util.ArrayList;
public class BST {
	private Node root;
	private ArrayList<String> keys;
	
	public void push_back(String k){
		keys.add(k);
	}
	
	public BST() {
		root = null;
		keys = new ArrayList<String>();
		
	}
	private Node findNode( Node r, String enword) {
		if(r==null) return null;
		int check=r.getEnword().compareTo(enword);
		if(check==0) return r;
		if(check<0) return findNode(r.getRightChild(), enword);
		return findNode(r.getLeftChild(), enword);
	}
	public void set(String enword, String vimeaning) {
		Node p= findNode(root, enword);
		if(p==null) return;
		p.setVimeaning(vimeaning);
		
	}
	public String find(String enword) {
		Node p=findNode(root, enword);
		if(p==null) return null;
		return p.getVimeaning();
	}
	private Node insert(Node r, String enword) {
		if(r==null) return new Node(enword);
		int check = r.getEnword().compareTo(enword);
		if(check<0) r.setRightChild(insert(r.getRightChild(),enword));
		else r.setLeftChild(insert(r.getLeftChild(),enword));
		return r;
	}
	public void insert(String enword) {
		root=insert(root, enword);
	}
	public void buildBST(){
		root = buildBST(0,keys.size()-1);
	}
	private Node buildBST(int L, int R){
		if(L > R) return null;
		int m = (L+R)/2;
		Node r = new Node(keys.get(m));
		r.setLeftChild(buildBST(L,m-1));
		r.setRightChild(buildBST(m+1,R));
		return r;
	}

	
}
