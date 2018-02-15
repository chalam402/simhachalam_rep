package threads;

class Util1
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
class Shared11
{
	synchronized void test1()
	{
		System.out.println("test1-begin");
		try
		{
			wait();
		}
		catch(InterruptedException ex)
		{
			ex.printStackTrace();
		}
		System.out.println("test1-end");
	}
	synchronized void test2()
	{
		notifyAll();
	}
}
class Thread3 extends Thread
{
	Shared11 s1;
	Thread3(Shared11 s)
	{
		this.s1=s;
	}
	@Override
	public void run()
	{
		s1.test1();
	}
}
class Thread4 extends Thread
{
	Shared11 s1;
	Thread4(Shared11 s)
	{
		this.s1=s;
	}
	@Override
	public void run()
	{
		s1.test1();
	}
}
public class ManagerNotifyAll
{
	public static void main(String[] args)
	{
		Shared11 s1=new Shared11();
		
		Thread3 t1=new Thread3(s1);
		Thread4 t2=new Thread4(s1);
		
		t1.start();
		t2.start();
		
		System.out.println("main-begin");
		try
		{
			Util1.sleep(10000);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		System.out.println("test1 about to release");
		s1.test2();
		System.out.println("main-end");
	}
}


