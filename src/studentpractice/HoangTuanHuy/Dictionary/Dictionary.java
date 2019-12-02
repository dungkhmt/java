package studentpractice.HoangTuanHuy.Dictionary;
import java.util.ArrayList;
public class Dictionary 
{
	private BST[] bst;
	private ArrayList<String>[] bst_words;
	public Dictionary(int size)
	{
		bst = new BST[size];
		bst_words = new ArrayList[size];
		for(int i=0;i<size;i++)
		{
			bst_words[i] = new ArrayList<>();
			bst[i] = new BST();
		}
	}
	private int hash(String key)
	{
		return Math.abs(key.hashCode())%bst.length;
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
	private void insert_bst(int idx,int l,int r)
	{
		if(l>r) return;
		int mid = (l+r)/2;
		bst[idx].insert(bst_words[idx].get(mid));
		insert_bst(idx,l,mid-1);
		insert_bst(idx,mid+1,r);
	}
	public void insert(String[] enwords)
	{
		for(int i=0;i<enwords.length;i++)
		{
			int idx=hash(enwords[i]);
			bst_words[idx].add(enwords[i]);
		}
		for(int i=0;i<bst.length;i++) insert_bst(i,0,bst_words.length);
	}
	public void insert(String enword)
	{
		int idx=hash(enword);
		bst[idx].insert(enword);
	}
	
}
