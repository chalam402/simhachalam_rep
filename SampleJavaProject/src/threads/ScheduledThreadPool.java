package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
Creates a thread pool that can schedule commands to run after a given delay, or to execute periodically.
*/
class WorkerThread9 implements Runnable {

	private String command;

	public WorkerThread9(String s) {
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
public class ScheduledThreadPool {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newScheduledThreadPool(10);
		for (int i = 0; i < 5; i++) {
			Runnable worker = new WorkerThread9("" + i);
			executor.execute(worker);
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
		}
		System.out.println("Finished all threads");
	}
}
