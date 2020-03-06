package studentpractice.phamvanhai;

import java.util.Scanner;

public class DFS {
	public static final int MAX = 100;
	
	int[] visited = new int[MAX];
	int[][] a = new int[MAX][MAX]; 
	int[] stack = new int[MAX]; 
	int top = -1;
	
	public void push(int val) {
		stack[++ top] = val;
	}

	public int pop() {
		int p = stack[top];
		top --;
		System.out.print(p + "\t");
		return p;
	}
	
	public int emptyStack() {
		if(top == -1) return 1;
		else return 0;
	}
	
	public void dfs(int s, int n) {
		push(s);
		visited[s] = 1;
		while(emptyStack() != 1) {
			int p = pop();
			for(int i = n; i >= 1; i --) {
				if((a[p][i] != 0) && (visited[i] != 1)){
					push(i);
					visited[i] = 1;
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DFS d = new DFS();
		int n, start;
		System.out.println("Nhap n = ");
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		
		for(int i = 1; i <= n; i ++) {
			d.visited[i] = 0;
		}
		
		for(int i = 1; i <= n; i ++)
			for(int j = 1; j <= n; j ++) {
				d.a[i][j] = in.nextInt();
			}
		
		for(int i = 1; i <= n; i ++) {
			for(int j = 1; j <= n; j ++) {
				System.out.print(d.a[i][j] + "\t");
			}
			System.out.print("\n");
		}
		
		System.out.println("Nhap vi tri bat dau: ");
		start = in.nextInt();
		
		d.dfs(start, n);	
		in.close();
	}

}
