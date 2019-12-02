package studentpractice.Ngodinhsang.dictionary;

public class Dictionary {
	private BinarysSearchTree[] bst;
	public Dictionary(int sz)
	{
		bst = new BinarysSearchTree[sz];
		for(int i=0;i<sz;i++)
			bst[i]= new BinarysSearchTree();
		
	}
	private int h(String key)
	{
		return key.hashCode()%bst.length;	}
	public String find(String enWord)
	{
		int idx = h(enWord);
		return bst[idx].find(enWord);
		
	}
	public void set(String enWord, String viWord)
	{
		int idx = h(enWord);
		bst[idx].set(enWord,viWord);
	}

}
