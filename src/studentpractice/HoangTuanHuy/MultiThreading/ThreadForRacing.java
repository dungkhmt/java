package studentpractice.HoangTuanHuy.MultiThreading;
import java.util.Random;
public class ThreadForRacing implements Runnable
{
	int metre_per_second;
	int limit_metre;
	int achieve;
	int aim;
	int Time=0;
	String ThreadName;
	ThreadForRacing(int limit_metre,int aim,String Name)
	{
		this.limit_metre=limit_metre;
		this.aim=aim;
		this.ThreadName=Name;
	}
	public void run()
	{
		Random rd = new Random();
		try
		{
			while(achieve<=aim)
			{
				
				metre_per_second=rd.nextInt(limit_metre)+1; /// set value in [1,4]
				achieve+=metre_per_second;
				System.out.println(ThreadName+" : " + metre_per_second+" - "+achieve+"/"+aim);
				Time++;
				Thread.sleep(1000);
			}
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
}
