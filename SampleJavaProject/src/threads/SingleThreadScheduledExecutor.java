package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*
Creates a single-threaded executor that can schedule commands to run after a given delay, or to execute periodically. 
(Note however that if this single thread terminates due to a failure during execution prior to shutdown, a new one will take its place if needed to execute subsequent tasks.) 
Tasks are guaranteed to execute sequentially, and no more than one task will be active at any given time. 
Unlike the otherwise equivalent newScheduledThreadPool(1) the returned executor is guaranteed not to be reconfigurable to use additional threads.
*/
class WorkerThread11 implements Runnable {

	private String command;

	public WorkerThread11(String s) {
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

public class SingleThreadScheduledExecutor {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newSingleThreadScheduledExecutor();
		
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
