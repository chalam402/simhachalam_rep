package threads.Java8;

import java.util.concurrent.TimeUnit;

public class Java8_RunnableThread2 {
	public static void main(String[] args) {
		Runnable runnable = () -> {
		    try {
		        String name = Thread.currentThread().getName();
		        System.out.println("Foo " + name);
		        TimeUnit.SECONDS.sleep(1); //Sleeping a thread  with the help of TimeUnit class and its Enum property SECONDS.
		        System.out.println("Bar " + name);
		    }
		    catch (InterruptedException e) {
		        e.printStackTrace();
		    }
		};
		Thread thread = new Thread(runnable);
		thread.start();
	}
}
