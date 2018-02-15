package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*
Creates an Executor that uses a single worker thread operating off an unbounded queue. 
(Note however that if this single thread terminates due to a failure during execution prior to shutdown, a new one will take its place if needed to execute subsequent tasks.) 
Tasks are guaranteed to execute sequentially, and no more than one task will be active at any given time. 
Unlike the otherwise equivalent newFixedThreadPool(1) the returned executor is guaranteed not to be reconfigurable to use additional threads.
 * */

class WorkerThread4 implements Runnable {

	private String command;

	public WorkerThread4(String s) {
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
public class SingleThreadExecutor {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newSingleThreadExecutor(); //At a time only one thread can run/create in this pool
		for (int i = 0; i < 5; i++) {
			Runnable worker = new WorkerThread4("" + i);
			executor.execute(worker);
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
		}
		System.out.println("Finished all threads");
	}
}
