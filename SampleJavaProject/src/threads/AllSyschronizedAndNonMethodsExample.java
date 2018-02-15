package threads;
class Util4
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
class Shared23
{
	synchronized static void test1()
	{
		System.out.println("test1-begin");
		
		try
		{	Util3.sleep(1000); }
		catch(Exception ex)
		{	ex.printStackTrace();	}
		
		System.out.println("test1-end");
	}
	
	synchronized static void test2()
	{
		System.out.println("test2-begin");
		
		try
		{	Util3.sleep(1000); }
		catch(Exception ex)
		{	ex.printStackTrace();	}
		
		System.out.println("test2-end");
	}
	
	synchronized void test3()
	{
		System.out.println("test3-begin");
		
		try
		{	Util3.sleep(1000); }
		catch(Exception ex)
		{	ex.printStackTrace();	}
		
		System.out.println("test3-end");
	}
	synchronized void test4()
	{
		System.out.println("test4-begin");
		
		try
		{	Util3.sleep(1000); }
		catch(Exception ex)
		{	ex.printStackTrace();	}
		
		System.out.println("test4-end");
	}
	
	void test5()
	{
		System.out.println("test5-begin");
		
		try
		{	Util3.sleep(1000); }
		catch(Exception ex)
		{	ex.printStackTrace();	}
		
		System.out.println("test5-end");
	}
	void test6()
	{
		System.out.println("test6-begin");
		
		try
		{	Util3.sleep(1000); }
		catch(Exception ex)
		{	ex.printStackTrace();	}
		
		System.out.println("test6-end");
	}
}
class Thread24 extends Thread
{
	Shared23 s1;
	Thread24(Shared23 s)
	{
		this.s1=s;
	}
	@Override
	public void run()
	{
		s1.test1();   //synchronized static method.
		//s1.test3();      //synchronized non-static method.
		//s1.test5();     //non-static method.
	}
}
class Thread25 extends Thread
{
	Shared23 s1;
	Thread25(Shared23 s)
	{
		this.s1=s;
	}
	@Override
	public void run()
	{
		s1.test2();   //synchronized static method.
		//s1.test4();      //synchronized non-static method.
		//s1.test6();     //non-static method.
	}
}

class Thread26 extends Thread
{
	Shared23 s1;
	Thread26(Shared23 s)
	{
		this.s1=s;
	}
	@Override
	public void run()
	{
		//s1.test1(); //synchronized static method.
		//s1.test4();        //synchronized non-static method.
		s1.test5();     //non-static method.
	}
}
public class AllSyschronizedAndNonMethodsExample {
	public static void main(String[] args)
	{
		System.out.println("main-begin");
		Shared23 s1=new Shared23();
		
		Thread24 t1=new Thread24(s1);//class lock = s1
		Thread25 t2=new Thread25(s1);
		Thread26 t3=new Thread26(s1);
		
		t1.start();
		t2.start();
		t3.start();
		
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
/*
Case 1: Output for two synchronized static methods
main-begin
test1-begin
test1-end
test2-begin
test2-end
main-end

Case 2: Output for two synchronized non-static methods
main-begin
test3-begin
test3-end
test4-begin
test4-end
main-end

Case 3: Output for two non-static methods
main-begin
test6-begin
test5-begin
test5-end
test6-end
main-end

*/