package studentpractice.HoangTuanHuy.Graph;

public class Base 
{
	private int id;

	public int getId() 
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}
	
	public void printf()
	{
		System.out.println("Base +("+id+")");
	}
	public Base(int id)
	{
		this.id=id;
	}
}
