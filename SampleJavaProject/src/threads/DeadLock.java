package threads;
class Util2
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
class SharedClass
{
	synchronized void test1(SharedClass s)//s2=s,this=s1
	{
		System.out.println("test1-begin");
		s.test2(this); //s2.test2(s1); //this.test2(s1);
		System.out.println("test1-end");
	}
	synchronized void test2(SharedClass s) //s=s1,this=s2
	{
		System.out.println("test2-begin");
		s.test1(this); //s1.test1(s2); //this.test1(s2)
		System.out.println("test2-end");
	}
}
class Thread1 extends Thread
{
	SharedClass s1,s2;
	
	Thread1(SharedClass s1, SharedClass s2)
	{ 
		this.s1=s1;
		this.s2=s2;
	}
	@Override
	public void run()
	{
		System.out.println("Thread1-begin");
		s1.test1(s2); //this.test1(s2);
		System.out.println("Thread1-end");
	}
}
class Thread2 extends Thread
{
SharedClass s1,s2;
	
	Thread2(SharedClass s1,SharedClass s2)
	{ 
		this.s1=s1;
		this.s2=s2;
	}
	@Override
	public void run()
	{
		System.out.println("Thread1-begin");
		s2.test2(s1); //this.test2(s1);
		System.out.println("Thread1-end");
	}
}
public class DeadLock
{
	public static void main(String[] args)
	{
		SharedClass s1=new SharedClass();
		SharedClass s2=new SharedClass();
		
		Thread1 t1=new Thread1(s1 , s2);
		Thread2 t2=new Thread2(s1, s2);
		
		System.out.println("main-begin");
		t1.start();
		t2.start();
		
		Util2.sleep(10000);
		System.out.println("main-end");
	}
	
	
}
