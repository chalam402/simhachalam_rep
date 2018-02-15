package threads;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/*
Returns an object that delegates all defined ScheduledExecutorService methods to the given executor, but not any other methods that might otherwise be accessible using casts. 
This provides a way to safely "freeze" configuration and disallow tuning of a given concrete implementation.
*/
class WorkerThread13 implements Runnable {

	private String command;

	public WorkerThread13(String s) {
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

public class unconfigurableScheduledExecutorService {
	public static void main(String[] args) {
		ExecutorService executor = Executors.unconfigurableScheduledExecutorService(new ScheduledExecutorService() {
				@Override
				public void execute(Runnable command) {
				}
				@Override
				public <T> Future<T> submit(Runnable task, T result) {
				return null;
				}	
				@Override
				public Future<?> submit(Runnable task) {
					return null;
				}	
				@Override
				public <T> Future<T> submit(Callable<T> task) {
					return null;
				}	
				@Override
				public List<Runnable> shutdownNow() {
					return null;
				}
				@Override
				public void shutdown() {
				}
				@Override
				public boolean isTerminated() {
					return false;
				}
				@Override
				public boolean isShutdown() {
					return false;
				}
				@Override
				public <T> T invokeAny(Collection<? extends Callable<T>> tasks,
							long timeout, TimeUnit unit) throws InterruptedException,
							ExecutionException, TimeoutException {
					return null;
				}
				@Override
				public <T> T invokeAny(Collection<? extends Callable<T>> tasks)
							throws InterruptedException, ExecutionException {
					return null;
				}
				@Override
				public <T> List<Future<T>> invokeAll(
					Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit)
							throws InterruptedException {
					return null;
				}
				@Override
				public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks)
							throws InterruptedException {
					return null;
				}
				@Override
				public boolean awaitTermination(long timeout, TimeUnit unit)
							throws InterruptedException {
					return false;
				}
				@Override
				public ScheduledFuture<?> scheduleWithFixedDelay(Runnable command,
							long initialDelay, long delay, TimeUnit unit) {
					return null;
				}
				@Override
				public ScheduledFuture<?> scheduleAtFixedRate(Runnable command,
							long initialDelay, long period, TimeUnit unit) {
					return null;
				}
				@Override
				public <V> ScheduledFuture<V> schedule(Callable<V> callable, long delay,
							TimeUnit unit) {
					return null;
				}
				@Override
				public ScheduledFuture<?> schedule(Runnable command, long delay,
							TimeUnit unit) {
					return null;
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
