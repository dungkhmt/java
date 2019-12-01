package studentpractice.HoangTuanHuy.Dictionary;

public class Dictionary 
{
	private BST[] bst;
	
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
}
