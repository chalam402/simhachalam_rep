package threads;
class Shared
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
class SynchronizedThread1 extends Thread
{
	Shared s1;
	SynchronizedThread1(Shared s)
	{
		this.s1=s;
	}
	@Override
	public void run()
	{
		s1.test1();
	}
}
class SynchronizedThread2 extends Thread
{
	Shared s1;
	SynchronizedThread2(Shared s)
	{
		this.s1=s;
	}
	@Override
	public void run()
	{
		s1.test2();
	}
}

public class SynchronizedMethodExample {
	public static void main(String[] args)
	{
		Shared s1=new Shared();
		Shared s2=new Shared();
		
		SynchronizedThread1 t1=new SynchronizedThread1(s1);//object lock = s1
		SynchronizedThread2 t2=new SynchronizedThread2(s1);
		//Thread2 t2=new Thread2(s2);
		
		t1.start();
		t2.start();
		
		System.out.println("main-begin");
		try
		{
			Thread.sleep(10000);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		System.out.println("main-end");
	}
}
