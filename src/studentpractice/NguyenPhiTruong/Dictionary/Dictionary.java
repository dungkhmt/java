package studentpractice.NguyenPhiTruong.Dictionary;

public class Dictionary {
	private BST[] bst;

	public Dictionary(int sz) {
		bst = new BST[sz];
		for (int i = 0; i < sz; i++) {
			bst[i] = new BST();
		}
	}

	private int h(String key) {
		return Math.abs(key.hashCode()) % bst.length;
	}

	public String find(String en) {
		int idx = h(en);
		return bst[idx].find(en);
	}

	public void set(String en, String vi) {
		int idx = h(en);
		bst[idx].set(en, vi);
	}
	
	public void insert(String en) {
		int idx = h(en);
		bst[idx].insert(en);
	}
	
}
