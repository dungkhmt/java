package studentpractice.HoangTuanHuy;

public class test 
{
	private static void swap(Integer a,Integer b)
	{
		int tg=a.intValue();
		a=b.intValue();
		b=tg;
	}
	private static Integer n=1,g=2;
	public static void main(String[] args)
	{
		swap(n,g);
		System.out.print(n+" "+g);
	}
}
