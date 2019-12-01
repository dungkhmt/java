package studentpractice.phamquangdung.dictionary;

public class Dictionary {
	private BST[] bst;
	
	public Dictionary(int sz){
		bst = new BST[sz];
		for(int i = 0; i < sz; i++)
			bst[i] = new BST();
		
	}
	private int h(String key){
		return Math.abs(key.hashCode()) %bst.length;
	}
	public String find(String enWord){
		int idx = h(enWord);
		return bst[idx].find(enWord);
	}
	public void set(String enWord, String vnMeaning){
		int idx = h(enWord);
		bst[idx].set(enWord, vnMeaning);
	}
	public void insert(String enWord){
		int idx = h(enWord);
		bst[idx].insert(enWord);
	}
}
