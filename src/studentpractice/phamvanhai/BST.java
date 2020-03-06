package studentpractice.phamvanhai;

public class BST {	
	public class Node {
		int key;
		Node leftChild;
		Node rightChild;
		
		public Node(int value) {
			key = value;
			leftChild = null;
			rightChild = null;
		}
	}
	Node r;
	public BST() {
		r = null;
	}
	
	public void insert(int value) {
		r = insertNode(r, value);
	}
	
	public Node insertNode(Node r, int value) {
			if(r == null) {
				r = new Node(value);
				return r;
			}
			if(r.key > value) 
				r.leftChild = insertNode(r.leftChild, value);
			else r.rightChild = insertNode(r.rightChild, value);
			return r;
		}
	
	public int height(Node r) {
		if(r == null) return 0;
		int hl = height(r.leftChild);
		int hr = height(r.rightChild);
		return (hl > hr) ? (hl + 1) : (hr + 1);
	}
	
	public Node findMin(Node r) {
		if(r == null) return null;
		if(r.leftChild == null) return r;
		return findMin(r.leftChild);
	}
	
	public Node findNode(Node r, int value){
		if(r == null) return null;
		if(r.key == value) return r;
		if(r.key > value) return findNode(r.leftChild, value);
		else return findNode(r.rightChild, value);
	}
	
	public void freeNode(Node r) {
		if(r == null) return;
		else r = null;
	}
	
	public Node delNode(Node r, int value) {
		if(r == null) return null;
		if(r.key > value) r.leftChild = delNode(r.leftChild, value);
		if(r.key < value) r.rightChild = delNode(r.rightChild, value);
		else {
			if(r.leftChild == null) {
				Node tmp = r.rightChild;
				freeNode(r.rightChild);
				return tmp;
			}
			if(r.rightChild == null) {
				Node tmp = r.leftChild;
				freeNode(r.leftChild);
				return tmp;
			}
			Node find = findMin(r.rightChild);
			r.key = find.key;
			r.rightChild = delNode(r.rightChild, find.key);
		}
		return r;
	}

	public void printTree(Node r) {
			if( r == null) return;
			System.out.print(r.key + ": ");
			if(r.leftChild != null) System.out.print(r.leftChild.key + ",");
			if(r.rightChild != null) System.out.print(r.rightChild.key);
			System.out.print("\n");
			printTree(r.leftChild);
			printTree(r.rightChild);
		}
	
public static void main(String[] args) {
		BST r = new BST();
		r.insert(12);
		r.insert(5);
		r.insert(16);
		r.insert(3);
		r.insert(6);
		r.insert(1);
		r.insert(4);
		r.insert(16);
		r.insert(14);
		r.insert(20);
		r.insert(13);
		r.insert(15);
		r.printTree(r.r);
		
		System.out.println("Height of tree is : " + r.height(r.r));
		Node tmp = r.findMin(r.r);
		System.out.println("The minimum value of tree is: " + tmp.key);
		System.out.print("\n");
		
		r.delNode(r.r, 14);
		System.out.println("After delete the value 14:");
		r.printTree(r.r);
	}
}
