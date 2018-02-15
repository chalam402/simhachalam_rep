package threads;
class MyRunnable implements Runnable{
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" - Started");
		for(int i=0;i<50;i++){
			System.out.println(Thread.currentThread().getName()+" - "+i);
		}
		System.out.println(Thread.currentThread().getName()+" - Ends");
	}
}
public class RunnableThread {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName()+" - Started");
		MyRunnable mr = new MyRunnable();
		Thread t1 = new Thread(mr, "FirstThread");
		Thread t2 = new Thread(mr, "SecondThread");
		Thread t3 = new Thread(mr, "ThirdThread");
		
		t1.start();
		t2.start();
		t3.start();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" - Ends");
	}
}
