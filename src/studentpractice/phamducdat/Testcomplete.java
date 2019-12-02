package studentpractice.phamducdat;

public class Testcomplete extends Tree {

	public int completeNode(Node r) {
		if (r == null)
			return 0;
		if (r.lefChild == null && r.rightChild == null)
			return 1;
		int com;
		if (r.lefChild != null && r.rightChild != null) {
			com = completeNode(r.lefChild) * completeNode(r.rightChild);
			return com;
		} else
			return 0;
	}

	public static void main(String[] args) {
		Testcomplete D =  new Testcomplete();
		D.inputData("src/studentpractice/phamducdat/data/dayso.txt");
		D.init();
		System.out.print("Complete: " + D.completeNode(root));
	}

}
