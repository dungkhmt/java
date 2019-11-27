package studentpractice.HoangTuanHuy;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
public class SegmentTree 
{
	/// Manage a feature of subsequence
	/// For example :
	/// Given a sequence of n numbers A[1],..., A[n] , and K queries , A K-queries is a triple (x,i,j), for each 
	/// k-query (1,i,j) return the maximum(minimum,....) value of subsequence A[i],...,A[j].
	/// k-quere (2,i,j) increase value of each element in subsequence A[i] , ... , A[j] by 1.
	/// The complexity of each k-query would be logn
	/// O(nlogn).
	private int n;
	private int k_queries;
	public int inf =  (int)(1e9);
	private int[] A;
	private class query
	{
		int type;
		int i;
		int j;
		int res; /// if type = 2 , res = 0 else type = 1  res !=0 
	}
	private query[] k;
	public class Tree /// Manage maximum value of sequence A.
	{
		int num;
		int value; 
		int lazy;
		int begin,end; /// The subsequence which node Num manages
		Tree left; /// this is going to be 2*num
		Tree right; /// this is going to be 2*num+1
		public Tree build(int s,int l,int r,int[] a) 
		{
			this.num=s;
			this.begin=l;
			this.end=r;
			if(l==r) /// Meet leaves
			{
				this.value=a[l];
				return this;
			}
			int mid=(l+r)>>1;
			this.left=this.build(2*s,l,mid,a); /// go to child 2s
			this.right=this.build(2*s+1,mid+1,r,a); /// go to child 2*s+1
			this.value=((this.left.value<this.right.value) ? this.right.value:this.left.value); /// update node
			return this;
		}
		public void down() /// node S increase by x , its child also increase by x.
		{
			int t=this.lazy;
			if(t==0) return;
			Tree L= this.left;
			L.lazy+=t; L.value+=t;
			Tree R= this.right;
			R.lazy+=t; R.value+=t;
			this.lazy=0;
		}
		public void enhance(int u,int v,int w) /// increase/decrease value from A[u] -> A[v] by w
		{
			if(this.end<u || this.begin>u) return ; /// (u,v) is not the subsequence that THIS node manages 
			if(this.begin<=u && v<= this.end) /// THIS node includes subsequence (u,v).
			{
				/// Increase the value of node.
				this.value+=w; 
				this.lazy+=w;
				return ;
			}
			/// Decrease the lazy of Node to 0.
			this.down(); 
			/// Update child of this node.
			this.left.enhance(u, v, w);
			this.right.enhance(u, v, w);
			this.value=(this.left.value<this.right.value) ? this.right.value:this.left.value;
			return ;
		}
		public int get_value(int u,int v) /// Get maximum value fromt A[u] to A[v]
		{
			/// Decrease the lazy of Node to 0, if its not.
			this.down();
			if(this.end<u && this.begin > v) return -inf; /// (u,v) is not the subsequence that THIS node manages 
			if(this.begin<=u && v<= this.end) return this.value; /// THIS node includes subsequence (u,v).
			/// The maximum value of sequence L ->  R is the greater compare of L -> (L+R)/2 and (L+R)/2 +1 -> R .
			int left_value = this.left.get_value(u, v);
			int right_value = this.right.get_value(u, v);
			return (left_value<right_value) ? right_value :  left_value;
		}
	}
	Tree root;
	private void init(int a)
	{
		A = new int[a+1];
		root = new Tree();
	}
	public void inp(String filename) throws IOException
	{
		File file = new File(filename);
		Scanner scan = new Scanner(file);
		
		n=scan.nextInt();
		init(n);
		for(int i=1;i<=n;i++)
			A[i]=scan.nextInt();
		
		k_queries = scan.nextInt();
		k= new query[k_queries+1];
		for(int i=1;i<=k_queries;i++)
		{
			k[i] = new query();
			k[i].type=scan.nextInt();
			k[i].i=scan.nextInt();
			k[i].j=scan.nextInt();
		}
		scan.close();
	}
	public void out(String filename) throws IOException
	{
		File file = new File(filename);
		PrintStream printf= new PrintStream(file);
		for(int i=1;i<=k_queries;i++)
			if(k[i].type!=2) printf.println(k[i].res);
		printf.close();
	}
	public void solve()
	{
		root.build(1 , 1, n, A);
		for(int i=1;i<=k_queries;i++)
		{
			if(k[i].type==1) k[i].res=root.get_value(k[i].i, k[i].j);
			else root.enhance(k[i].i, k[i].j, 1);
		}
	}
	public static void main(String[] args) throws IOException
	{
		SegmentTree T = new SegmentTree(); 
		T.inp("data/Huysfiletest/ST.inp");
		T.solve();
		T.out("data/Huysfiletest/ST.out"); 
	}
}
