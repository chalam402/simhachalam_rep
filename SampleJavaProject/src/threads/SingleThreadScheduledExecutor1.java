package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
/*
Creates a single-threaded executor that can schedule commands to run after a given delay, or to execute periodically. 
(Note however that if this single thread terminates due to a failure during execution prior to shutdown, a new one will take its place if needed to execute subsequent tasks.) 
Tasks are guaranteed to execute sequentially, and no more than one task will be active at any given time. 
Unlike the otherwise equivalent newScheduledThreadPool(1, threadFactory) the returned executor is guaranteed not to be reconfigurable to use additional threads.
 */
class WorkerThread12 implements Runnable {

	private String command;

	public WorkerThread12(String s) {
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

public class SingleThreadScheduledExecutor1 {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() {
			@Override
			public Thread newThread(Runnable r) {
				Thread t1 = new Thread(r);
				return t1;
			}
		});
		
		for(int i = 0; i < 5; i++) {
			Runnable worker = new WorkerThread11("" + i);
			executor.execute(worker);
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
		}
		System.out.println("Finished all threads");
	}
}
