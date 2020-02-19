package studentpractice.HoangTuanHuy.MultiThreading;

import java.util.Scanner;

public class App 
{
	private static int ok;
	private static Scanner scan = new Scanner(System.in);
	private static int ID = 0;
	public static void main(String[] Args)
	{
		System.out.println("Write 0 to end the process , 1 to continue the process");
		while(true)
		{
			ok= scan.nextInt();
			if(ok==0)
			{
				System.out.println("Exiting");
				break;
			}
			System.out.println("Continue creating ID");
			ID++;
			Thread next_thread = new Thread( new ThreadDemo(ID));
			next_thread.start();
		}
	}
}
