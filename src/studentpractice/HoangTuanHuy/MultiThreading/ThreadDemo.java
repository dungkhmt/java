package studentpractice.HoangTuanHuy.MultiThreading;

import java.util.Scanner;

public class ThreadDemo implements Runnable
{
	private Thread t;
	private String ThreadName;
	private int ID;
	private String PassWord;
	private Scanner scan = new Scanner(System.in);
	ThreadDemo(int id)
	{
		this.ID=id;
	}
	public void run()
	{
		//System.out.println("Running " + ThreadName);
		try
		{
			System.out.println("Username : ");
			ThreadName = scan.nextLine();
			System.out.println("PassWord : ");
			PassWord =  scan.nextLine();
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("Registered");
		System.out.println("Your ID : " + ID);
		t.suspend();
	}
	/*public void start()
	{
		System.out.println("Prepare to creat your ID");
		if(t==null)
		{
			t=new Thread(this);
			t.run();
		}
	}*/
}
