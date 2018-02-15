package threads;
/*
Creates a thread pool that reuses a fixed number of threads operating off a shared unbounded queue, using the provided ThreadFactory to create new threads when needed. 
At any point, at most nThreads threads will be active processing tasks. 
If additional tasks are submitted when all threads are active, they will wait in the queue until a thread is available. 
If any thread terminates due to a failure during execution prior to shutdown, a new one will take its place if needed to execute subsequent tasks. 
The threads in the pool will exist until it is explicitly shutdown.
 * */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

class WorkerThread3 implements Runnable {

	private String command;

	public WorkerThread3(String s) {
		this.command = s;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()
				+ " Start. Command = " + command);
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
public class FixedThreadPool1 {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(5, new ThreadFactory() {
			@Override
			public Thread newThread(Runnable r) {
				Thread t1 = new Thread(r);
				return t1;
			}
		});

		for (int i = 0; i < 5; i++) {
			Runnable worker = new WorkerThread3("" + i);
			executor.execute(worker);
		}
		executor.shutdown();
	 
		while (!executor.isTerminated()) {
		}
		System.out.println("Finished all threads");
	}
}
