package threads;
class Shared1{
	public synchronized  void sharedTest(String threadName, int noOfIterations){
		for(int i=1;i<=noOfIterations;i++){  
		     System.out.println(threadName+" - sharedTest - "+i);  
		}
	}
}
class ThreadS1 extends Thread{
	
	private Shared1 shared1;
	
	public ThreadS1(Shared1 theShared1){
		this.shared1 = theShared1;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" - ThreadS1 - Started");
		shared1.sharedTest(Thread.currentThread().getName(), 100);
		System.out.println(Thread.currentThread().getName()+" - ThreadS1 - Ended");
	}
}
class ThreadS2 extends Thread{

	private Shared1 shared2;
	
	public ThreadS2(Shared1 theShared2){
		this.shared2 = theShared2;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" - ThreadS2 - Started");
		shared2.sharedTest(Thread.currentThread().getName(), 100);
		System.out.println(Thread.currentThread().getName()+" - ThreadS2 - Ended");
	}
}
public class ObjectLockClass {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName()+" - Main - Started");
		Shared1 s1 = new Shared1();
		 
		ThreadS1 ts1 = new ThreadS1(s1);
		ThreadS2 ts2 = new ThreadS2(s1);
		
		ts1.start();
		ts2.start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" - Main - Ended");
	}
}
