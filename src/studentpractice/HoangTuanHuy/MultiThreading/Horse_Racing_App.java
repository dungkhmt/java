package studentpractice.HoangTuanHuy.MultiThreading;

import java.util.Scanner;
import java.util.Random;
public class Horse_Racing_App 
{
	private static int Horse_num; 
	private static int Id;
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		//System.out.println("Number of horses : ");
		//Horse_num= scan.nextInt();
		int len = ran.nextInt(11)+20; /// set length in [20,30];
		System.out.println("Length of race : "+len);
		int metre = ran.nextInt(5)+2;
		
		//Thread[] Horse = new Thread(new ThreadForRacing())[20];
		Thread h1 = new Thread(new ThreadForRacing(metre,len,"Horse 1"));	h1.setName("Horse 1");
		Thread h2 = new Thread(new ThreadForRacing(metre,len,"Horse 2"));	h2.setName("Horse 2");
		h1.start();
		h2.start();
		while(true)
		{
			if(h1.isAlive() && !h2.isAlive())
			{
				System.out.println(h2.getName()+" won");
				h2.stop();
				return;
			}
			if(!h1.isAlive() && h2.isAlive())
			{
				System.out.println(h1.getName()+" won");
				h1.stop();
				return;
			}
		}
	}
}
