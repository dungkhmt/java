package studentpractice.phamquangdung.dictionary;

import java.util.ArrayList;

public class BST {
	private Node root;
	private ArrayList<String> keys;
	
	public void push_back(String k){
		keys.add(k);
	}
	public BST(){
		root = null;
		keys = new ArrayList<String>();
	}
	private Node find(Node r, String enWord){
		if(r == null) return null;
		int c = r.getEnWord().compareTo(enWord);
		if(c == 0) return r;
		if(c < 0) return find(r.getRightChild(),enWord);
		return find(r.getLeftChild(),enWord);
	}
	public String find(String enWord){
		Node p = find(root, enWord);
		if(p == null) return null;
		return p.getVnMeaning();
	}
	public void set(String enWord, String vnMeaning){
		Node p = find(root, enWord);
		if(p == null){
			root = insert(root, enWord);
			p = find(root,enWord);
			p.setVnMeaning(vnMeaning);
			return;
		}else
			p.setVnMeaning(vnMeaning); 
	}
	private Node insert(Node r, String enWord){
		if(r == null) return new Node(enWord);
		int c = r.getEnWord().compareTo(enWord);
		if(c < 0) r.setRightChild(insert(r.getRightChild(),enWord));
		else r.setLeftChild(insert(r.getLeftChild(),enWord));
		return r; 
	}
	public void insert(String enWord){
		root = insert(root,enWord);
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
