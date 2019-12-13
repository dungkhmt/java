package studentpractice.TranMinhCong.dictionary;

public class Dictionary {
	private BinarySearchTree[] bst;
	public Dictionary(int size) {
		bst = new BinarySearchTree[size];
		for(int i = 0 ; i < size ; i++) {
			bst[i] = new BinarySearchTree();
		}
	}
	private int h(String key) {
		return Math.abs(key.hashCode()) % bst.length;
	}
	public String find(String enWord) {
		int idx = h(enWord);
		return bst[idx].find(enWord);
	}
	public void set(String enWord , String viWord) {
		int idx = h(enWord);
		bst[idx].set(enWord, viWord);
	}
	public void insert(String enWord) {
		int idx = h(enWord);
		bst[idx].insert(enWord);
	}
}
