package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/*
Creates a thread pool that creates new threads as needed, but will reuse previously constructed threads when they are available. 
These pools will typically improve the performance of programs that execute many short-lived asynchronous tasks. 
Calls to execute will reuse previously constructed threads if available. If no existing thread is available, a new thread will be created and added to the pool. 
Threads that have not been used for sixty seconds are terminated and removed from the cache. Thus, a pool that remains idle for long enough will not consume any resources. 
Note that pools with similar properties but different details (for example, timeout parameters) may be created using ThreadPoolExecutor constructors.
*/
class WorkerThread2 implements Runnable {

	private String command;

	public WorkerThread2(String s) {
		this.command = s;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+ " Start. Command = " + command);
		processCommand();
		System.out.println(Thread.currentThread().getName() + " End.");
	}

	private void processCommand() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return this.command;
	}
}
public class CachedThreadPool {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool(new ThreadFactory() {
			public Thread newThread(Runnable r) {
				Thread t1 = new Thread(r);
				return t1;
			}
		});
		
		ExecutorService executor1 = Executors.newCachedThreadPool();
		
		for (int i = 0; i < 5; i++) {
			Runnable worker = new WorkerThread2("" + i);
			executor.execute(worker);
		}
		executor.shutdown();
	 
		while (!executor.isTerminated()) {
		}
		System.out.println("Finished all threads");
	}
}
