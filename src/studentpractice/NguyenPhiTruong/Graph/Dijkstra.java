package studentpractice.NguyenPhiTruong.Graph;

import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Dijkstra {
	private int[][] G;
	private int[] d;
	private int[] p;
	private int start;
	private int end;
	private final int vc = 999;
	LinkedList<Integer> nonFixed = new LinkedList<Integer>();
	LinkedList<Integer> stack = new LinkedList<Integer>();

	private int loadGraph(String filename) {
		int n = 0;
		try {
			Scanner input = new Scanner(new File(filename));
			n = input.nextInt();
			G = new int[n + 1][n + 1];
			d = new int[n + 1];
			p = new int[n + 1];
			for (int i = 1; i <= n; i++)
				for (int j = 1; j <= n; j++)
					G[i][j] = input.nextInt();

			input.close();
		} catch (FileNotFoundException e) {
			System.out.print("File not found");
		}
		return n;
	}

	private void getStart() {
		System.out.print("Diem xuat phat: ");
		Scanner input = new Scanner(System.in);
		this.start = input.nextInt();
		System.out.print("Diem ket thuc: ");
		this.end = input.nextInt();
		input.close();
	}

	private void init(String filename) {
		int n = loadGraph(filename);
		getStart();
		for (int i = 1; i <= n; i++) {
			d[i] = G[start][i];
			p[i] = start;
			if (i != start)
				nonFixed.add(i);
		}

		while (nonFixed.size() != 0) {
//			Collections.sort(nonFixed);
//			int u = nonFixed.getFirst();
//			nonFixed.removeFirst();
			int u = nonFixed.getFirst();
//			System.out.println("Step: " + nonFixed);
			for (Integer i : nonFixed) {
				if (d[i] < d[u]) u = i;
			}
			nonFixed.remove((Integer)u); 
//			System.out.println("Step: " + nonFixed);
			
			//-------------------------------
			for (Integer v : nonFixed) {
				if (G[u][v] == vc)
					continue;
				if (d[v] == vc) {
					d[v] = d[u] + G[u][v];
					p[v] = u;
					continue;
				}
				if (d[v] > d[u] + G[u][v]) {
					d[v] = d[u] + G[u][v];
					p[v] = u;
				}
			}
		}
		
		System.out.print("Duong di ngan nhat tu " + start + " den " + end + ": \n");
		int idx = p[end];
		stack.add(idx);
		while (idx != start) {
			idx = p[idx];
			stack.add(idx);
		}
		while (stack.size() != 0) {
			System.out.print(stack.getLast() + " -> ");
			stack.removeLast();
		}
		System.out.print(end);
	}
	
	public static void main(String[] args) {
		Dijkstra D = new Dijkstra();
		D.init("data\\TruongTest\\ScalarGraph");
	}
}
