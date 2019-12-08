package bfs_dfs;

import java.util.Scanner;

public class BFS {
	public static final int MAX = 100;
	int[] visited = new int[MAX];
	int[][] a = new int[MAX][MAX];
	int[] queue = new int[MAX];
	int key = -1, last = 0;
	
	public void enQueue(int val) {
		queue[++ key] = val;
	}
	
	public int deQueue() {
		int q = queue[0];
		key --;
		for(int i = 1; i < MAX; i ++ ) {
			queue[i - 1] = queue[i];
		}
		System.out.print(q + "\t");
		return q;
	}
	public int emptyQueue() {
		if(key == -1) return 1; 
		else return 0;
	}
	
	public void bfs(int start, int n) {
		enQueue(start);
		visited[start] = 1;
		while(emptyQueue() != 1) {
			int q = deQueue();
			for(int i = 1; i <= n; i ++) {
				if(a[q][i] != 0 && visited[i] != 1) {
					enQueue(i);
					visited[i] = 1;
				}
			}
		}
	}
	public static void main(String[] args) {
		int n, start;
		BFS b = new BFS();
		
		System.out.println("Nhap so dinh: ");
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		
		for(int i = 1; i <= n; i ++)
			b.visited[i] = 0;
		
		for(int i = 1; i <= n; i ++)
			for(int j = 1; j <= n; j ++) {
				b.a[i][j] = in.nextInt();
			}
		
		for(int i = 1; i <= n; i ++) {
			for(int j = 1; j <= n; j ++) {
				System.out.print(b.a[i][j] + "\t");
			}
			System.out.print("\n");
		}
				
		System.out.println("Nhap vao dinh xuat phat: ");
		start = in.nextInt();
		b.bfs(start, n);
		
		in.close();
	}
	
}
