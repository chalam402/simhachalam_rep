package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/*
Creates a thread pool that can schedule commands to run after a given delay, or to execute periodically.
*/
class WorkerThread10 implements Runnable {

	private String command;

	public WorkerThread10(String s) {
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

public class ScheduledThreadPool1 {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newScheduledThreadPool(10, new ThreadFactory() {
			@Override
			public Thread newThread(Runnable r) {
				Thread t1 = new Thread(r);
				return t1;
			}
		});

		for(int i = 0; i < 5; i++) {
			Runnable worker = new WorkerThread9("" + i);
			executor.execute(worker);
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
		}
		System.out.println("Finished all threads");
	}
}
