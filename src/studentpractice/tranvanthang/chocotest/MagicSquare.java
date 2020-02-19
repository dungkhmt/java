package studentpractice.tranvanthang.chocotest;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.variables.IntVar;

public class MagicSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		int magicSum = n * (n * n + 1) / 2;
		Model m = new Model();
		IntVar[][] var = new IntVar[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				var[i][j] = m.intVar("var_" + i + "_" + j, 1, n * n);
			}
		}
		// differrent all ////////////////
		/*for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				m.arithm(var[i / n][i % n], "-", var[j / n][j % n], "!=", 0)
						.post();
			}
		}*/
		IntVar[] var_one_line = new IntVar[n * n];
		int temp = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				var_one_line[temp] = var[i][j];
				temp++;
			}
		}
		m.allDifferent(var_one_line).post();;

		// //////tong cac hang///////

		for (int i = 0; i < n; i++) {
			m.sum(var[i], "=", magicSum).post();;
		}
		// ///tong cac cot///////////
		IntVar[][] varCol = new IntVar[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// Copy of var in the column order
				varCol[i][j] = var[j][i];
			}
			m.sum(varCol[i], "=", magicSum).post();;
		}
		/////tong 2 duong cheo chinh////////
		IntVar[] varDiag1=new IntVar[n];
		IntVar[] varDiag2=new IntVar[n];
		for(int i=0;i<n;i++){
			varDiag1[i]=var[i][i];
			varDiag2[i]=var[i][n-1-i];
		}
		m.sum(varDiag1,"=", magicSum).post();;
		m.sum(varDiag2,"=", magicSum).post();;
		///////////solver//////
		Solver solver=m.getSolver();
		solver.solve();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.println(var[i][j]);
			}
			System.out.println();
		}
	}

}
