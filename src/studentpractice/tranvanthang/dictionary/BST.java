package studentpractice.tranvanthang.dictionary;

import java.util.ArrayList;

public class BST {
	private Node root;
	private ArrayList<String> list_word;
	public BST() {
		root=null;
		list_word=new ArrayList<String>();
	}

	private Node find(Node r, String enWord) {
		if (r == null)
			return null;
		int c = r.getEnWord().compareTo(enWord);
		if (c == 0)
			return r;
		if (c < 0)
			return find(r.getRightChild(), enWord);
		else
			return find(r.getLeftChid(), enWord);

	}
	private Node insert(Node r,String enWord){
		if(r==null) return new Node(enWord);
		int c=r.getEnWord().compareTo(enWord);
		if(c<0) r.setRightChild(insert(r.getRightChild(),enWord));
		else r.setLeftChid(insert(r.getLeftChid(),enWord));
		return r;
		
	}
	public void insert(String enWord){
		root=insert(root,enWord);
	}

	public String find(String enWord) {
		Node p = find(root, enWord);
		if (p == null)
			return null;
		return p.getVnMeaning();
	}

	public void set(String enWord, String vnWord) {
		Node p = find(root, enWord);
		if (p == null)
			return;
		p.setVnMeaning(vnWord);
	}
	public void addArray(String key){
		list_word.add(key);
	}
	public void buidBST(){
		root=buidBST(0,list_word.size()-1);
	}
	private Node buidBST(int left,int right){
		if(left>right) return null;
		int mid=(left+right)/2;
		Node r=new Node(list_word.get(mid));
		r.setLeftChid(buidBST(left,mid-1));
		r.setRightChild(buidBST(mid+1,right));
		return r;

	}
}
