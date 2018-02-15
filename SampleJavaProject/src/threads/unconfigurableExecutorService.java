package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*
Returns an object that delegates all defined ExecutorService methods to the given executor, but not any other methods that might otherwise be accessible using casts. 
This provides a way to safely "freeze" configuration and disallow tuning of a given concrete implementation.
 * */
class WorkerThread8 implements Runnable {

	private String command;

	public WorkerThread8(String s) {
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
public class unconfigurableExecutorService {
	public static void main(String[] args) {
		ExecutorService executor7 = Executors.newWorkStealingPool(6);
		ExecutorService executor8 = Executors.unconfigurableExecutorService(executor7);
		for (int i = 0; i < 5; i++) {
			Runnable worker = new WorkerThread8("" + i);
			executor8.execute(worker);
		}
		executor8.shutdown();
		while (!executor8.isTerminated()) {
		}
		System.out.println("Finished all threads");
	}
}
