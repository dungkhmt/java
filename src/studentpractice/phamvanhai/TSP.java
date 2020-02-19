import java.util.Scanner;

public class TSP {
	public final int MAX = 99999;
	public int[][] C = new int[100][100];
	public int[] tryWay = new int[100];
	public int[] tryCost = new int[100];
	public int[] bestWay = new int[100];
	public int[] free = new int[100];
	public int bestCost;
	public int n;
	public int min;
	
	Scanner in = new Scanner(System.in);
	
	public void init() {
		System.out.print("n = ");
		this.n = in.nextInt();		
		tryWay[1] = 1;
		tryCost[1] = 0;
		bestWay[1] = 1;
		free[1] = 0;
		bestCost = MAX;
		min = MAX;
		for(int i = 2; i <= n; i ++) {
			free[i] = 1;
		}
	}
	
	public void buildMatrix() {
		System.out.println("Set the cost-matrix:");
		for(int i = 1; i <= n; i ++) {
			for(int j = 1; j <= n; j ++) {
				if(j == i) C[i][j] = 0;
				else {
					System.out.print("C[" + i + "]" + "[" + j + "] = " );
					this.C[i][j] = in.nextInt();
				}
			}
		}
	}
	
	public void showMatrix() {
		System.out.println("The cost-matrix is: ");
		for(int i = 1; i <= n; i ++) {
			for(int j = 1; j <= n; j ++) {
				System.out.print(C[i][j] + "\t");
			}
			System.out.print("\n");
		}
	}
	
	public int findMin() {
		for(int i = 1; i <= n; i ++) {
			for(int j = 1; j <= n; j ++) {
				if(i != j && C[i][j] <  min) {
					min = C[i][j];
				}
			}
		}
		return min;
	}
	
	public void solution(int k) {
		for(int i = 1; i <= n; i ++) {
			if(free[i] == 1) {
				tryWay[k] = i;
				free[i] = 0;
				tryCost[k] = tryCost[k - 1] + C[tryWay[k - 1]][i];
				int floor = tryCost[k] + findMin() * (n - k + 1);
				if(floor < bestCost) {
					if(k == n) {
						if(tryCost[k] + C[i][1] < bestCost) {
							for(int j = 1; j <= n; j ++) {
								bestWay[j] = tryWay[j];
								bestCost = tryCost[k] + C[i][1];
							}
						}
					}
					else solution(k + 1);
				}
				free[i] = 1;
			}
		}
	}
	
	public static void main(String[] args) {
		TSP app = new TSP();
		app.init();
		app.buildMatrix();
		app.showMatrix();
		app.solution(2);
		System.out.print("The best way is:");
		for(int i = 1; i <= app.n; i ++) {
			System.out.print(app.bestWay[i] + "->");
		}
		System.out.print("1\n");
		System.out.println("The best cost is " + app.bestCost);
	}
}
