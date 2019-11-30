package studentpractice.phamducdat;

public class Node {
	 int id;
	 Node lefChild;
	 Node rightChild;
	
	public Node(int v){
		this.id = v;
		lefChild = null;
		rightChild = null;
	}
	@Override
	public String toString(){
		return id+"";
	}
	
	
}
