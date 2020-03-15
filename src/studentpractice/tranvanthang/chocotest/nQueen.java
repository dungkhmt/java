package studentpractice.tranvanthang.chocotest;
import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.variables.IntVar;

public class nQueen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=8;
		Model model=new Model("nQueen");
		IntVar[] queens=model.intVarArray(n, 0, n-1);
		model.allDifferent(queens).post();
		
		
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				IntVar a=queens[i];
				IntVar b =queens[j];
				int temp=i-j;
				model.arithm(a,"-",b, "!=",temp ).post();
				model.arithm(b,"-",a, "!=",temp ).post();
			}
		}
		
		model.getSolver().solve();
		for(int i=0;i<n;i++){
			System.out.println(queens[i]);
		}
	}

}
