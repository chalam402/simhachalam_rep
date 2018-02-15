package threads;

class Util
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
class Shared12
{
	synchronized void test1()
	{
		System.out.println("test1-begin");
		for(int i=0;i<=100;i++)
		{
			System.out.println(i);
		}
		System.out.println("test1-end");
	}
	synchronized void test2()
	{
		System.out.println("test2-begin");
		for(int i=100;i<=200;i++)
		{
			System.out.println(i);
		}
		System.out.println("test2-end");
	}
}
class Thread12 extends Thread
{
	Shared12 s1;
	Thread12(Shared12 s)
	{
		this.s1=s;
	}
	@Override
	public void run()
	{
		s1.test1();
	}
}
class Thread21 extends Thread
{
	Shared12 s1;
	Thread21(Shared12 s)
	{
		this.s1=s;
	}
	@Override
	public void run()
	{
		s1.test2();
	}
}
public class SynchronizedObjectLock
{
	public static void main(String[] args)
	{
		Shared12 s1=new Shared12();
		//Shared12 s2=new Shared12();
		
		Thread12 t1=new Thread12(s1);//object lock = s1
		Thread21 t2=new Thread21(s1);
		//Thread21 t2=new Thread21(s2);
		
		t1.start();
		t2.start();
		
		System.out.println("main-begin");
		try
		{
			//Util.sleep(10000);
			Thread.sleep(10000);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		System.out.println("main-end");
	}
}
