package studentpractice.phamducdat;

import java.io.File;
import java.util.Scanner;

public class Tree {
	private int[] a;
	static Node root = null;

	public Node creatNode(int v) {
		return new Node(v);
	}

	public Node makeNode(int v) {
		return new Node(v);
	}

	public Node insertNode(Node r, int v) {
		if (r == null)
			return makeNode(v);
		if (v > r.id) {
			r.rightChild = insertNode(r.rightChild, v);
			return r;
		} else {
			r.lefChild = insertNode(r.lefChild, v);
			return r;
		}
	}

	public void printNode(Node r) {
		///System.out.print(r.id);
		if (r == null)
			return;
		System.out.print(r.id + ":");
		if (r.lefChild == null && r.rightChild == null) {
			return;
		} else {
			if (r.lefChild == null) {
				System.out.print(r.rightChild.id);
			} else {
				if (r.rightChild == null)
					System.out.print(r.lefChild.id);
				else
					System.out.print(r.lefChild.id + " " + r.rightChild.id
							+ " ");
			}
		}
		System.out.println();
		printNode(r.lefChild);
		System.out.println();
		printNode(r.rightChild);
		return;
	}

	public Node findNode(Node r) {
		if (r == null)
			return null;
		if (r.lefChild == null)
			return r;
		else
			return (r.lefChild);
	}

	public Node delNode(Node r, int v) {
		if (r == null)
			return null;
		if (v > r.id) {
			r.rightChild = delNode(r.rightChild, v);
			return r;
		}
		if (v < r.id) {
			r.lefChild = delNode(r.lefChild, v);
			return r;
		}
		if (r.lefChild == null && r.rightChild == null) {
			return null;
		} else {
			Node p = findNode(r.rightChild);
			r.rightChild = delNode(r.rightChild, p.id);
			p.lefChild = r.lefChild;
			p.rightChild = r.rightChild;
			r = p;
			//System.out.print(r.id);
		}
		return r;
	}

	public void inputData(String filename) {
		try {
			Scanner in = new Scanner(new File(filename));
			int n = in.nextInt();
			a = new int[n];
			for (int i = 0; i < a.length; i++) {
				a[i] = in.nextInt();
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void init() {
		for (int i = 0; i < a.length; i++)
			root = insertNode(root, a[i]);
		return;
	}

	public static void main(String[] args) {
		Tree doom = new Tree();
		doom.inputData("src/studentpractice/phamducdat/data/dayso.txt");
		doom.init();
		 System.out.print("Input: "); System.out.println();
		 doom.printNode(root); System.out.println();
		root = doom.delNode(root, 20);
		System.out.print("After Del: ");
		System.out.println();
		doom.printNode(root);
	}
}
