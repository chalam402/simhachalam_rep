package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*
Creates a work-stealing thread pool using all available processors as its target parallelism level.
 **/
class WorkerThread6 implements Runnable {

	private String command;

	public WorkerThread6(String s) {
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
public class WorkStealingPool {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newWorkStealingPool();
		for (int i = 0; i < 5; i++) {
			Runnable worker = new WorkerThread6("" + i);
			executor.execute(worker);
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
		}
		System.out.println("Finished all threads");
	}

}
