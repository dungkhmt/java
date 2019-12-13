package studentpractice.TranBinhMinh;

public class Dictionary {
	private BST[] bst;
	
	public Dictionary(int sz)
	{
		bst = new BST[sz];
		for(int i=0;i < sz;++i)
		{
			bst[i]=new BST();
		}
	}
	private int h(String key)
	{
		return key.hashCode()%bst.length;
	}
	public String find(String enWord)
	{
		int index= h(enWord);
		return bst[index].find(enWord);
	}
	public void set(String enWord,String vnMeaning)
	{
		int index = h(enWord);
		bst[index].set(enWord, vnMeaning);
	}
	
}
