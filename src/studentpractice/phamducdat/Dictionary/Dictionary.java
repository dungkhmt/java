package studentpractice.phamducdat.Dictionary;

public class Dictionary {
	private BST[] bst;
	
	public Dictionary(int sz) {
		bst = new BST[sz];
		for(int i = 0; i < sz; i++) {
			bst[i] = new BST();
		}
	}
	
	public int h(String k) {
		return Math.abs(k.hashCode()) % bst.length;
	}
	
	public String find(String enWord) {
		int idx = h(enWord);
		return bst[idx].find(enWord);
	}
	
	public void insert(String enWord) {
		int idx = h(enWord);
		bst[idx].find(enWord);
	}
	
	public void set(String enWord, String vnMeaning) {
		int idx = h(enWord);
		bst[idx].set(enWord, vnMeaning);
	}
	
	public void buildDictionary(String[] keys) {
		for(int i = 0; i < keys.length; i++) {
			int idx = h(keys[i]);
			bst[idx].push_back(keys[i]);
		}
		for(BST i : bst) {
			i.buildBST();
		}
	}

}
