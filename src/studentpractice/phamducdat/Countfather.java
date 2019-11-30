package studentpractice.phamducdat;

public class Countfather extends Tree {

	public int countFather(Node r) {
		if (r == null)
			return 0;
		if (r.lefChild == null && r.rightChild == null)
			return 0;
		int cnt;
		if (r.lefChild != null && r.rightChild != null)
			cnt = 1 + countFather(r.lefChild) + countFather(r.rightChild);
		else
			cnt = countFather(r.lefChild) + countFather(r.rightChild);
		return cnt;
	}

	public static void main(String[] args) {
		Countfather S = new Countfather();
		S.inputData("src/studentpractice/phamducdat/data/dayso.txt");
		S.init();
		System.out.print("Count father: " + S.countFather(root));
	}

}
