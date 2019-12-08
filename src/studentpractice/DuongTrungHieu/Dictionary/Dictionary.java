package studentpractice.DuongTrungHieu.Dictionary;

public class Dictionary 
{
	private BST[] bst;
	private Node root;
	public Dictionary(int size)
	{
		bst = new BST[size];
		for(int i=0;i<size;i++) bst[i] = new BST();
	}
	private int hash(String key)
	{
		return key.hashCode()%bst.length;
	}
	public String find(String enword)
	{
		int idx=hash(enword);
		return bst[idx].find(enword);
	}
	public void set(String enword, String vnmeaning)
	{
		int idx = hash(enword);
		bst[idx].set(enword, vnmeaning);
	}
	private Node insert(Node r, String enWord) {
		if( r == null) return new Node(enWord);
		int c = r.getEnword().compareTo(enWord);
		if(c<0) r.setRight(insert(r.getRight(),enWord));
		else r.setLeft(insert(r.getLeft(),enWord));
		return r;
}
	public void insert(String enWord) {
		root = insert(root,enWord);
	
	}
	}
