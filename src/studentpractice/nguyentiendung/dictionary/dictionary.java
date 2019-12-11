package studentpractice.nguyentiendung.dictionary;

public class dictionary {
	private BST[] bst;
	public dictionary(int sz) {
		bst=new BST[sz];
		for(int i=0; i<sz; i++) {
			bst[i]= new BST();}
	}
	public String find(String enword) {
		int index=h(enword);
		return bst[index].find(enword);
	}
	
	public void set(String enword, String vimeaning) {
		int index=h(enword);
		bst[index].set(enword, vimeaning);
	}
	public int h(String key) {
		return Math.abs(key.hashCode())%bst.length;
	}
	public void insert(String enWord){
		int idx = h(enWord);
		bst[idx].insert(enWord);
	}
	public void buildDictionary(String[] keys){
		for(int i = 0; i <  keys.length; i++){
			int idx = h(keys[i]);
			bst[idx].push_back(keys[i]);
		}
		for(BST b: bst){
			b.buildBST();
		}
		}
	}
