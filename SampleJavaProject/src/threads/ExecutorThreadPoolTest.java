package threads;

class ThreadClass implements Runnable{
	private String name;
	public ThreadClass(String name){
		this.name = name;
	}
	@Override
	public void run() {
		for(int i=0;i<10;i++){
			System.out.println(name+ " is UP : "+i);
			try {
	            Thread.sleep(1000);
	        } catch (InterruptedException ex) {
	            ex.printStackTrace();
	        }
		}
		System.out.println(name + " End.");
	}
}
public class ExecutorThreadPoolTest {
	public static void main(String[] args) {
		Thread run1 = new Thread(new ThreadClass("Thread1"));
		Thread run2= new Thread(new ThreadClass("Thread2"));
		Thread run3= new Thread(new ThreadClass("Thread3"));
		run1.start();
		run2.start();
		try {
			run2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		run3.start();
	}
}
