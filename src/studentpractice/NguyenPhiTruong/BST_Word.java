package studentpractice.NguyenPhiTruong;

import java.io.File;
import java.util.Scanner;

public class BST_Word extends QuickSortStringArray {
	public static Node root;
	private final int MAX = 500001;

	public String[] words = new String[MAX];

	public BST_Word() {
		root = null;
	}

	public Node makeNode(String word) {
		Node r = new Node(word);
		r.leftChild = null;
		r.rightChild = null;
		return r;
	}

	public Node insert(int L, int R) {
		if (L > R) return null;
		if (L == R) return makeNode(words[L]);
		int index = (L+R)/2;
		Node r = new Node(words[index]);
		r.leftChild = insert(L,index-1);
		r.rightChild = insert(index+1,R);
		return r;
	}

	public void buildBST(String filename) {
		int tmp = 0;
		try {
			Scanner input = new Scanner(new File(filename));
			while (input.hasNextLine()) {
				words[tmp] = input.nextLine();
				tmp++;
			}
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		quickSort(words, 0, tmp - 1);
		root = insert(0,tmp-1);
	}
	
	public Node findBST(Node r,String w) {
		if (r == null) return null;
		int index = r.word.compareTo(w);
		if (index == 0) return r;
		if (index < 0) return findBST(r.rightChild,w);
		return findBST(r.leftChild,w);
		
	}
	public void find() {
		Scanner input = new Scanner(System.in);
		String w = input.nextLine();
		input.close();
		Node p = findBST(BST_Word.root,w);
		if (p == null) System.out.print("NOT FOUND\n");
		else System.out.print("FOUND\n");
	}
	public static void main(String[] args) {
		BST_Word S = new BST_Word();
		S.buildBST("data\\TruongTest\\words.txt");
		S.find();
		
		
	}
}
