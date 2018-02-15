package threads;

class Util3
{
	public static void sleep(long i)
	{
		try
		{
			Thread.sleep(i);  //static method
		}
		catch(InterruptedException ex)
		{
			ex.printStackTrace();
		}
	}
}
class Shared22
{
	synchronized static void test1()
	{
		System.out.println("test1-begin");
		for(int i=0;i<=100;i++)
		{
			System.out.println(i);
		}
		System.out.println("test1-end");
	}
	synchronized static void test2()
	{
		System.out.println("test2-begin");
		for(int i=100;i<=200;i++)
		{
			System.out.println(i);
		}
		System.out.println("test2-end");
	}
	
	
}
class Thread22 extends Thread
{
	Shared22 s1;
	Thread22(Shared22 s)
	{
		this.s1=s;
	}
	@Override
	public void run()
	{
		s1.test1();
	}
}
class Thread23 extends Thread
{
	Shared22 s1;
	Thread23(Shared22 s)
	{
		this.s1=s;
	}
	@Override
	public void run()
	{
		s1.test2();
	}
}
public class SynchronizedClassLock
{
	public static void main(String[] args)
	{
		Shared22 s1=new Shared22();
		
		Thread22 t1=new Thread22(s1);//class lock = s1
		Thread23 t2=new Thread23(s1);
		
		t1.start();
		t2.start();
		
		System.out.println("main-begin");
		try
		{
			Util3.sleep(10000);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		System.out.println("main-end");
	}
}
