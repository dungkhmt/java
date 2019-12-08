package studentpractice.NguyenPhiTruong.Graph;

public class DeepFirstSearch extends Graph {
	public int sz; // So dinh
	public boolean[] color;
	public int[] d; // thoi diem tham
	public int[] f; // thoi diem ket thuc tham
	public int[] p; // dinh ke truoc
	public int t = 0;

	public void DFS(int k) {
		t++;
		d[k] = t;
		color[k] = true;
		for (int i = 1; i <= sz; i++) {
			if (G[k][i] != 0)
				if (color[i] == false) {
					p[i] = k;
					System.out.print("(" + k + "," + i + ")\n");
					DFS(i);
				}
		}
		t++;
		f[k] = t;
	}

	public void print() {

	}

	public void DFS() {
		sz = inputGraph("data\\TruongTest\\ScalarGraph");
		color = new boolean[sz + 1];
		d = new int[sz + 1];
		f = new int[sz + 1];
		p = new int[sz + 1];
		for (int i = 1; i <= sz; i++) {
			color[i] = false;
		}
		for (int i = 1; i <= sz; i++) {
			if (color[i] == false)
				DFS(i);
		}
	}

	public static void main(String[] args) {
		DeepFirstSearch S = new DeepFirstSearch();
		S.DFS();

	}
}
