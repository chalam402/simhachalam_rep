package threads;

class MySingleton{
	private static MySingleton mySingleton = null;
	
	private MySingleton(){
		
	}
	public static MySingleton getInstance(){
		if(mySingleton == null){
			mySingleton = new MySingleton();
		}
		return mySingleton;
	}
}
class MySingletonThread extends Thread{
	private static MySingletonThread mySingletonThread = null;
	
	private MySingletonThread(){
		
	}
	public static MySingletonThread getInstance(){
		if(mySingletonThread == null){
			mySingletonThread = new MySingletonThread();
		}
		return mySingletonThread;
	}
	
	@Override
	public void run() {
		System.out.println("Thread_"+Thread.currentThread().getName()+"Started ");
		for(int i=0;i<100;i++){
			System.out.println("Thread_"+Thread.currentThread().getName()+"_"+i);
		}
		System.out.println("Thread_"+Thread.currentThread().getName()+"End ");
	}
}
public class ThreadSafeSingletonImplementation {
	
}
