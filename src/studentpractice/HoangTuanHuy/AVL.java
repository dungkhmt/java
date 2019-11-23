package studentpractice.HoangTuanHuy;
import java.io.*;
import java.util.*;
public class AVL 
{
	/// Problem : http://vnoi.info/problems/CPPSET/ 
	/// Was accpepted with C++ file
	/// Use AVL algorithm
	/// O(nlogn)
	private int n;
	private int[] queries = new int[1001];
	private int max(int a,int b) {return (a<b)?b:a;}
	class tree
	{
		int key;
		int hei;
		tree parent;
		tree left;
		tree right;
		public tree(int key,int hei,tree parent,tree left,tree right)
		{
			this.key=key;
			this.hei=hei;
			this.parent=parent;
			this.left=left;
			this.right=right;
		}
	}
	tree root;
	public int height(tree r)
	{
		if(r==null) return 0;
		if(r.hei!=0) return r.hei;
		return r.hei= max(height(r.left)+1,height(r.right)+1);
	}
	public void reset_height(tree r)
	{
		while(r!=null)
		{
			if(r.hei==0) return;
			r.hei=0;
			r=r.parent;
		}
	}
	private int check_height(tree r)
	{
		if(r==null) return 0;
		int le=height(r.left);
		int ri=height(r.right);
		return (le<ri? ri-le :  le-ri);
	}
	public tree r_most(tree r)
	{
		if(r==null) return null;
		if(r.right==null) return r;
		return r.right;
	}
	public tree l_most(tree r)
	{
		if(r==null) return null;
		if(r.left==null) return r;
		return r.left;
	}
	private void r_join(tree a,tree b)
	{
		if(a!=null) a.parent=b;
		if(b!=null) b.right=a;
		else root=a;
		reset_height(a);reset_height(b);
	}
	private void l_join(tree a,tree b)
	{
		if(a!=null) a.parent=b;
		if(b!=null) b.left=a;
		reset_height(a);reset_height(b);
	}
	private void r_r_rotate(tree a,tree b)
	{
		if(b==null)
		{
			r_join(a,b);
			return;
		}
		tree p=b.parent;
		r_join(a.left,b);
		l_join(b,a);
		if(p==null) r_join(a,p);
		else
		{
			if(p.right==b) r_join(a,p);
			else l_join(a,p);
		}
	}
	private void l_l_rotate(tree a,tree b)
	{
		if(b==null)
		{
			r_join(a,b);
			return;
		}
		tree p = b.parent;
		l_join(a.right,b);
		r_join(b,a);
		if(p==null) r_join(a,p);
		else
		{
			if(p.left==b) l_join(a,p);
			else r_join(a,p);
		}
	}
	public void balance(tree r)
	{
		if(r==null) return ;
		if(check_height(r)<=1) return;
		balance(r.left);
		balance(r.right);
		int le=height(r.left);
		int ri=height(r.right);
		if(le==ri) return;
		if(le>ri)
		{ 
			if(height(r.left.left)<height(r.left.right)) r_r_rotate(r.left.right,r.left);
			l_l_rotate(r.left,r);
		}
		if(le<ri)
		{
			if(height(r.right.right)<height(r.right.left)) l_l_rotate(r.right.left,r.right);
			r_r_rotate(r.right,r);
		}
	}
	public void insert(tree r,int k)
	{
		if(r==null) 
		{
			tree h= new tree(k,0,null,null,null);
			r_join(h,r);
			return ;
		}
		if(r.key==k) return ;
		if(r.key>k)
		{
			if(r.left!=null) insert(r.left,k);
			else
			{
				tree h= new tree(k,0,null,null,null);
				l_join(h,r);
			}
		}
		if(r.key<k)
		{
			if(r.right!=null) insert(r.right,k);
			else
			{
				tree h= new tree(k,0,null,null,null);
				r_join(h,r);
			}
		}
		balance(r);
		return ;
	}
	public tree get_node(tree r,int k)
	{
		if(r==null) return null;
		if(r.key==k) return r;
		if(k<r.key) return get_node(r.left,k);
		return get_node(r.right,k);
	}
	public void delete(tree a)
	{
		if(a==null) return ;
		if(a.left==null)
		{
			if(a.parent==null || a.parent.left==a) l_join(a.right,a.parent);
			else r_join(a.right,a.parent);
		}
		else
			if(a.right==null)
			{
				if(a.parent==null || a.parent.left==a) l_join(a.left,a.parent);
				else r_join(a.left,a.parent);
			}
			else
			{
				tree ex=r_most(a.left);
				int tg=a.key;
				a.key=ex.key;
				ex.key=tg;
				delete(ex);
			}
	}
	
	public void inp(String filename) throws IOException
	{
		File file= new File(filename);
		Scanner scan= new Scanner(file);
		n=scan.nextInt();
		for(int i=1;i<=n;i++)
		{
			int a=scan.nextInt();
			queries[i]=a;
			insert(root,a);
		}
		scan.close();
	}
	public void out_avl(PrintStream printf,tree r) throws IOException
	{
		if(r==null) return;
		printf.print("Node "+r.key+" : ");
		printf.println("Left : " + ((r.left!=null) ? r.left.key : "") +" , Right : " + ((r.right!=null) ? r.right.key : ""));
		out_avl(printf,r.left);
		out_avl(printf,r.right);
		//printf.close();
	}
	public void out(String filename) throws IOException
	{
		File file = new File(filename);
		PrintStream printf = new PrintStream(file);
		printf.println("There are " + n + " nodes");
		printf.println("Root node is "+ root.key);
		
		out_avl(printf,root);
		printf.close();
		
	}
	public static void main(String[] args) throws IOException
	{
		AVL T= new AVL();
		T.inp("data/Huysfiletest/AVL.inp");
		T.out("data/Huysfiletest/AVL.out");
	}
}
