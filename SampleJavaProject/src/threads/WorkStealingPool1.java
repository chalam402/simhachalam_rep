package threads;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*
Creates a thread pool that maintains enough threads to support the given parallelism level, and may use multiple queues to reduce contention. 
The parallelism level corresponds to the maximum number of threads actively engaged in, or available to engage in, task processing. 
The actual number of threads may grow and shrink dynamically. A work-stealing pool makes no guarantees about the order in which submitted tasks are executed.
 * */
class WorkerThread7 implements Runnable {

	private String command;

	public WorkerThread7(String s) {
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
public class WorkStealingPool1 {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newWorkStealingPool(5);
		for (int i = 0; i < 5; i++) {
			Runnable worker = new WorkerThread7("" + i);
			executor.execute(worker);
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
		}
		System.out.println("Finished all threads");
	}
}
