package threads;

import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Java program to demonstrate How to use CountDownLatch in Java. CountDownLatch is
 * useful if you want to start main processing thread once its dependency is completed
 * as illustrated in this CountDownLatch Example
 * 
 * @author SimhaChalam Pydana
 */
/**
 * Service class which will be executed by Thread using CountDownLatch synchronizer.
 */
class Service implements Runnable{
    private final String name;
    private final int timeToStart;
    private final CountDownLatch latch;
    public Service(String name, int timeToStart, CountDownLatch latch){
        this.name = name;
        this.timeToStart = timeToStart;
        this.latch = latch;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(timeToStart);
        } catch (InterruptedException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println( name + " is Up");
        latch.countDown(); //reduce count of CountDownLatch by 1
    }
}

public class CountDownLatchDemo {
    public static void main(String args[]) throws InterruptedException {
       final CountDownLatch latch = new CountDownLatch(4);
       Thread cacheService = new Thread(new Service("CacheService", 1000, latch)); //Runnable threads initialized
       Thread alertService = new Thread(new Service("AlertService", 1000, latch)); //Runnable threads initialized
       Thread validationService = new Thread(new Service("ValidationService", 1000, latch)); //Runnable threads initialized
       Thread travellingService = new Thread(new Service("TravellingService", 1000, latch)); //Runnable threads initialized
       cacheService.start(); //CacheService thread started
       alertService.start(); //AlertService thread started
       validationService.start(); //validationService thread started
       validationService.join();  //validationService thread with join
       travellingService.start();
       
       // application should not start processing any thread until all service is up
       // and ready to do there job.
       // Countdown latch is idle choice here, main thread will start with count 3
       // and wait until count reaches zero. each thread once up and read will do
       // a count down. this will ensure that main thread is not started processing
       // until all services is up.
       // count is 3 since we have 3 Threads (Services)
       try{
            latch.await();  //main thread is waiting on CountDownLatch to finish(count = 0)
            System.out.println("All services are up, Application is starting now");
       }catch(InterruptedException ie){
           ie.printStackTrace();
       }
    }
}
