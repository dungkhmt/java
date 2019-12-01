package studentpractice.Ngodinhsang;

import java.util.*;

public class TSP {
	public  int Max=10001;
	public  int n;
	public  int f=0;
	public  int fmin=10000;
	public  int cmin=10000;
	public  int a[][]= new int [Max][Max];
	public  int x[]=new int [Max];
	public  int xmin[]=new int [Max];
	
	public boolean check(int k, int i)
	{
		for(int j=2;j<k;j++)
			if(x[j]==i) return false;
		return true;
	}
	public void BK(int k)
	{
		for(int i=2;i<=n;i++)
		{
			if(check(k,i))
			{
				x[k]=i;
				f+=a[x[k-1]][x[k]];
				if(k==n)
				{
					if(f+a[x[k]][1]<fmin)
					{
						fmin=f+a[x[k]][1];
						for(int j=1;j<=n;j++)
							xmin[j]=x[j];
					}
				}
				else 
					if(f+(n-k+1)*cmin<fmin)
						BK(k+1);
				f-=a[x[k-1]][i];
			}
		}
	}
	public static void main(String[] args)
	{
		Scanner so=new Scanner (System.in);
		n=so.nextInt();
		x[1]=1;
		for(int i=1;i<=n;i++)
			for(int j=1;j<=n;j++)
			{
				a[i][j]=so.nextInt();
				cmin=Math.min(cmin, a[i][j]);
			}
		BK(2);
		//for(int i=1;i<=n;i++)
			//System.out.print(x[i]+" ");
		System.out.println();
		System.out.println(fmin);
		so.close();
	}

}
