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
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class WorkerThread implements Runnable {

	private String command;

	public WorkerThread(String s) {
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

public class ExecutorThreadPool {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(5);

		/*ExecutorService executor1 = Executors
				.newCachedThreadPool(new ThreadFactory() {
					@Override
					public Thread newThread(Runnable r) {
						Thread t1 = new Thread(r);
						return t1;
					}
				});

		ExecutorService executor2 = Executors.newFixedThreadPool(6);
		ExecutorService executor3 = Executors.newFixedThreadPool(5,
				new ThreadFactory() {
					@Override
					public Thread newThread(Runnable r) {
						Thread t1 = new Thread(r);
						return t1;
					}
				});

		ExecutorService executor4 = Executors.newSingleThreadExecutor();
		ExecutorService executor5 = Executors
				.newSingleThreadExecutor(new ThreadFactory() {
					@Override
					public Thread newThread(Runnable r) {
						Thread t1 = new Thread(r);
						return t1;
					}
				});
		ExecutorService executor6 = Executors.newWorkStealingPool();
		ExecutorService executor7 = Executors.newWorkStealingPool(6);
		ExecutorService executor8 = Executors
				.unconfigurableExecutorService(executor7);
		ExecutorService executor9 = Executors.newScheduledThreadPool(10);
		ExecutorService executor10 = Executors.newScheduledThreadPool(10,
				new ThreadFactory() {
					@Override
					public Thread newThread(Runnable r) {
						Thread t1 = new Thread(r);
						return t1;
					}
				});
		ExecutorService executor11 = Executors
				.newSingleThreadScheduledExecutor();
		ExecutorService executor12 = Executors
				.newSingleThreadScheduledExecutor(new ThreadFactory() {
					@Override
					public Thread newThread(Runnable r) {
						Thread t1 = new Thread(r);
						return t1;
					}
				});
		ExecutorService executor13 = Executors
				.unconfigurableScheduledExecutorService(new ScheduledExecutorService() {
					@Override
					public void execute(Runnable command) {

					}

					@Override
					public <T> Future<T> submit(Runnable task, T result) {
						// TODO Auto-generated method stub
						return null;
					}

					@Override
					public Future<?> submit(Runnable task) {
						// TODO Auto-generated method stub
						return null;
					}

					@Override
					public <T> Future<T> submit(Callable<T> task) {
						// TODO Auto-generated method stub
						return null;
					}

					@Override
					public List<Runnable> shutdownNow() {
						// TODO Auto-generated method stub
						return null;
					}

					@Override
					public void shutdown() {
						// TODO Auto-generated method stub

					}

					@Override
					public boolean isTerminated() {
						// TODO Auto-generated method stub
						return false;
					}

					@Override
					public boolean isShutdown() {
						// TODO Auto-generated method stub
						return false;
					}

					@Override
					public <T> T invokeAny(
							Collection<? extends Callable<T>> tasks,
							long timeout, TimeUnit unit)
							throws InterruptedException, ExecutionException,
							TimeoutException {
						// TODO Auto-generated method stub
						return null;
					}

					@Override
					public <T> T invokeAny(
							Collection<? extends Callable<T>> tasks)
							throws InterruptedException, ExecutionException {
						// TODO Auto-generated method stub
						return null;
					}

					@Override
					public <T> List<Future<T>> invokeAll(
							Collection<? extends Callable<T>> tasks,
							long timeout, TimeUnit unit)
							throws InterruptedException {
						// TODO Auto-generated method stub
						return null;
					}

					@Override
					public <T> List<Future<T>> invokeAll(
							Collection<? extends Callable<T>> tasks)
							throws InterruptedException {
						// TODO Auto-generated method stub
						return null;
					}

					@Override
					public boolean awaitTermination(long timeout, TimeUnit unit)
							throws InterruptedException {
						// TODO Auto-generated method stub
						return false;
					}

					@Override
					public ScheduledFuture<?> scheduleWithFixedDelay(
							Runnable command, long initialDelay, long delay,
							TimeUnit unit) {
						// TODO Auto-generated method stub
						return null;
					}

					@Override
					public ScheduledFuture<?> scheduleAtFixedRate(
							Runnable command, long initialDelay, long period,
							TimeUnit unit) {
						// TODO Auto-generated method stub
						return null;
					}

					@Override
					public <V> ScheduledFuture<V> schedule(
							Callable<V> callable, long delay, TimeUnit unit) {
						// TODO Auto-generated method stub
						return null;
					}

					@Override
					public ScheduledFuture<?> schedule(Runnable command,
							long delay, TimeUnit unit) {
						// TODO Auto-generated method stub
						return null;
					}
				});*/
		for (int i = 0; i < 10; i++) {
			Runnable worker = new WorkerThread("" + i);
			executor.execute(worker);
		}
		executor.shutdown();
	 
		
		while (!executor.isTerminated()) {
		}
		System.out.println("Finished all threads");
	}
	// The output confirms that there are five threads in the pool named from
	// "pool-1-thread-1" to "pool-1-thread-5" and they are responsible to
	// execute the submitted tasks to the pool.
}